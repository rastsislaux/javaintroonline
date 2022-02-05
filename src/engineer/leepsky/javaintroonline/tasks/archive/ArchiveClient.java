package engineer.leepsky.javaintroonline.tasks.archive;

import engineer.leepsky.javaintroonline.tasks.notebook.ObjectFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/* Задание 3: создайте клиент-серверное приложение “Архив”.
Общие требования к заданию:
• В архиве хранятся Дела (например, студентов). Архив находится на сервере.
• Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
    него изменения, или создать новое дело.
    Требования к коду лабораторной работы:
• Для реализации сетевого соединения используйте сокеты.
• Формат хранения данных на сервере – xml-файлы. */

public class ArchiveClient {

    private static final String SRV_ADDR = "localhost";

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void connect(String addr, int port) throws IOException {

        clientSocket = new Socket(addr, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }

    public String request(String msg) throws IOException {

        out.println(msg);
        return in.readLine();

    }

    public void disconnect() throws IOException {

        in.close();
        out.close();
        clientSocket.close();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArchiveClient client = new ArchiveClient();
        client.connect(SRV_ADDR, ArchiveServer.SRV_PORT);

        System.out.println("Connection established. Size of archive: " + client.request("LENGTH"));

        PersonalFile requested = (PersonalFile) ObjectString.fromString(client.request("0"));
        System.out.println(requested);

        requested = (PersonalFile) ObjectString.fromString(client.request("1"));
        System.out.println(requested);

        requested = (PersonalFile) ObjectString.fromString(client.request("2"));
        System.out.println(requested);

        client.disconnect();

    }

}
