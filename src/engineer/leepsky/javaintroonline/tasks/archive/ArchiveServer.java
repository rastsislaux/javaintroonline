package engineer.leepsky.javaintroonline.tasks.archive;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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

    public void start(int port) throws IOException {

        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

    }

    public boolean accept() throws IOException, ClassNotFoundException { // Returns true if server needs to be shutdown.

        clientSocket = serverSocket.accept();
        System.out.println("Connection accepted.");

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String msg;

        while (true) {
            msg = in.readLine();

            if (msg == null) break;                  // Client disconnected.
            if (msg.equals("SHUTDOWN")) return true; // Shutdown command received.

            out.println(handle(msg));
        }

        return false;

    }

    public String handle(String msg) throws IOException, ClassNotFoundException {

        switch (msg) {

            case "SIZE" -> {
                System.out.println("Client requested length. Returned: " + archive.size());
                return String.valueOf(archive.size());
            }

            case "EDIT" -> {

                out.println("OK");
                System.out.println("Client wants to edit file. Waiting for index...");
                int index;
                try { index = Integer.parseInt(in.readLine()); out.println("OK"); }
                catch (NumberFormatException e) { return "FAIL"; }

                System.out.println("Client sent index. Waiting for object...");
                PersonalFile personalFile;
                try { personalFile = (PersonalFile) ObjectString.fromString(in.readLine()); }
                catch ( EOFException e ) { return "FAIL"; }

                archive.set(index, personalFile);
                System.out.println("Personal file was edited.");
                return "OK";

            }

        }

        try {

            PersonalFile personalFile = (PersonalFile) ObjectString.fromString(msg);
            archive.add(personalFile);
            return "OK";

        } catch (EOFException | IllegalArgumentException e) { }

        try {

            int index = Integer.parseInt(msg);
            System.out.println("Client requested personal file #" + index);
            return ObjectString.toString(archive.get(index));

        } catch (NumberFormatException | IOException | IndexOutOfBoundsException e) {

            System.out.println("Request failed: " + e.getMessage());
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
        return archive;
    }

    public static void saveArchiveXML(ArrayList<PersonalFile> archive, String path) throws IOException {

        StringBuilder sb = new StringBuilder("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>\n<archive>\n\n");
        for (PersonalFile personalFile : archive) {
            sb.append("\t<person>\n\t\t<name>")
              .append(personalFile.getName())
              .append("</name>\n\t\t<info>")
              .append(personalFile.getInfo())
              .append("</info>\n\t</person>\n\n");
        }
        sb.append("</archive>");

        Files.writeString(Path.of(path), sb.toString(), StandardOpenOption.CREATE);

    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException {

        ArrayList<PersonalFile> archive = parseArchiveXML(ARCHIVE_FILE);
        ArchiveServer server = new ArchiveServer(archive);
        server.start(SRV_PORT);

        while (!server.accept()) {
            System.out.println("Client disconnected.");
        }

        System.out.println("Shutdown command received.");
        saveArchiveXML(archive, ARCHIVE_FILE);
        server.stop();

    }

}
