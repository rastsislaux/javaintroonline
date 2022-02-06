package engineer.leepsky.javaintroonline.tasks.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public static void printPersonalFile(PersonalFile personalFile) {
        System.out.println(personalFile.getName() + ", info: " + personalFile.getInfo());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArchiveClient client = new ArchiveClient();

        try {
            client.connect(SRV_ADDR, ArchiveServer.SRV_PORT);
        } catch (ConnectException e) {
            System.out.println("client > Failed to connect. Exiting...");
            return;
        }

        int size = Integer.parseInt(client.request("SIZE"));
        System.out.println("client > Connection established. Size of archive: " + size);

        Scanner in = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {

            try {
                System.out.print("> ");
                command = in.next();
                switch (command) {
                    case "exit" -> System.out.println("client > Exiting...");

                    case "dbg-size" -> System.out.println(client.request("SIZE")); // To be deleted

                    case "srv-shutdown" -> {
                        client.request("SHUTDOWN");
                        command = "exit";
                    }

                    case "view" -> {
                        int index = in.nextInt();
                        if (index < size) {
                            System.out.println(index);
                            PersonalFile resp = (PersonalFile) ObjectString.fromString(
                                    client.request(String.valueOf(index))
                            );
                            System.out.print("view > ");
                            printPersonalFile(resp);
                        } else {
                            System.out.println("view > There's no personal file numbered " + index);
                        }
                    }

                    case "add" -> {

                        System.out.print("add > Enter name: ");
                        in.nextLine();
                        String name = in.nextLine();
                        System.out.print("add > Enter info: ");
                        String info = in.nextLine();

                        PersonalFile personalFile = new PersonalFile(name, info);
                        String response = client.request(ObjectString.toString(personalFile));

                        if (response.equals("OK")) {
                            System.out.println("add > Added successfully.");
                            size++;
                        } else {
                            System.out.println("add > Something went wrong while adding.");
                        }

                    }

                    case "edit" -> {

                        int index = in.nextInt();
                        if (index >= size) {
                            System.out.println("edit > There's no personal file numbered " + index);
                            continue;
                        }

                        PersonalFile personalFile = (PersonalFile) ObjectString.fromString(
                                client.request(String.valueOf(index))
                        );

                        System.out.print("edit > Name (" + personalFile.getName() + "): ");
                        in.nextLine();
                        personalFile.setName(in.nextLine());

                        System.out.print("edit > Info (" + personalFile.getInfo() + "): ");
                        personalFile.setInfo(in.nextLine());

                        System.out.println(client.request("EDIT"));
                        System.out.println(client.request(String.valueOf(index)));
                        System.out.println(client.request(ObjectString.toString(personalFile)));

                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("client > Input mismatches. Try again.");
            }

        }

        in.close();
        client.disconnect();

    }

}
