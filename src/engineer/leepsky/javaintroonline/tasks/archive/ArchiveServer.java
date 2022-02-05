package engineer.leepsky.javaintroonline.tasks.archive;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ArchiveServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private final ArrayList<PersonalFile> archive;

    ArchiveServer(ArrayList<PersonalFile> archive) {
        this.archive = archive;
    }

    public void accept(int port) throws IOException {

        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        clientSocket = serverSocket.accept();
        System.out.println("Connection accepted.");

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String msg;

        while (true) {
            msg = in.readLine();
            if (msg == null) break;
            out.println(handle(msg));
        }

    }

    public String handle(String msg) {

        switch (msg) {

            case "LENGTH" -> {
                System.out.println("Client requested length. Returned: " + archive.size());
                return String.valueOf(archive.size());
            }

        }

        try {
            int index = Integer.parseInt(msg);
            return ObjectString.toString(archive.get(index));
        } catch (NumberFormatException | IOException e) {
            return "FAIL";
        }

    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static int SRV_PORT = 5000;

    private static final String WORK_DIR = "./src/engineer/leepsky/javaintroonline/tasks/archive/";
    private static final String ARCHIVE_FILE = WORK_DIR + "Archive.xml";

    public static ArrayList<PersonalFile> parseArchiveXML(String path)
                                                                throws ParserConfigurationException,
                                                                       IOException,
                                                                       SAXException {

        ArrayList<PersonalFile> archive = new ArrayList<>();
        NodeList personElements = DocumentBuilderFactory.newInstance()
                                                        .newDocumentBuilder()
                                                        .parse(new File(path))
                                                        .getDocumentElement()
                                                        .getElementsByTagName("person");

        for (int i = 0; i < personElements.getLength(); i++) {
            NodeList nodeList = personElements.item(i).getChildNodes();
            String name = "", info = "";
            for (int j = 0; j < nodeList.getLength(); j++) {
                switch (nodeList.item(j).getNodeName()) {
                    case "#text" -> { }
                    case "name" -> name = nodeList.item(j).getChildNodes().item(0).getNodeValue();
                    case "info" -> info = nodeList.item(j).getChildNodes().item(0).getNodeValue();
                }
            }
            archive.add(new PersonalFile(name, info));
        }
        System.out.println(archive);
        return archive;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        ArrayList<PersonalFile> archive = parseArchiveXML(ARCHIVE_FILE);

        while (true) {
            ArchiveServer server = new ArchiveServer(archive);
            server.accept(SRV_PORT);
            server.stop();
        }

    }

}
