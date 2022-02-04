package engineer.leepsky.javaintroonline.tasks.library;

/* Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
Общие требования к заданию:
• Система учитывает книги как в электронном, так и в бумажном варианте.
• Существующие роли: пользователь, администратор.
• Пользователь может просматривать книги в каталоге книг, осуществлять поиск
книг в каталоге.
• Администратор может модифицировать каталог.
• *При добавлении описания книги в каталог оповещение о ней рассылается на
e-mail всем пользователям
• **При просмотре каталога желательно реализовать постраничный просмотр
• ***Пользователь может предложить добавить книгу в библиотеку, переслав её
администратору на e-mail.
• Каталог книг хранится в текстовом файле.
• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
не хранится в открытом виде */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryApp {

    final static String WORK_DIR    =   "./src/engineer/leepsky/javaintroonline/tasks/library/";
    final static String USERS_FILE  =   WORK_DIR + "Users.txt";
    final static String BOOKS_FILE  =   WORK_DIR + "Books.txt";
    final static String MSGS_FILE   =   WORK_DIR + "Messages.txt";

    public static HashMap<String, User> readUsersFromFile(String path) throws FileNotFoundException {

        HashMap<String, User> result = new HashMap<>();
        Scanner fin = new Scanner(new File(path));
        while (fin.hasNext()) {

            String  login = fin.next(),
                    password = fin.next();
            boolean isAdministrator = fin.nextBoolean();

            result.put(login, new User(login, password, isAdministrator));

        }

        fin.close();

        // Reading messages
        fin = new Scanner(new File(MSGS_FILE));
        while (fin.hasNext()) {
            String to = fin.next();
            fin.nextLine();
            result.get(to).addMessage(fin.nextLine());
        }

        return result;

    }

    public static ArrayList<Book> readBooksFromFile(String path) throws FileNotFoundException {

        ArrayList<Book> result = new ArrayList<>();

        File booksFile = new File(path);
        Scanner fin = new Scanner(booksFile);

        while (fin.hasNext()) {
            result.add(new Book(fin.next(), fin.next(), fin.nextBoolean()));
        }

        fin.close();

        return result;

    }

    public static void printCommandNotFound(String command) {
        System.out.println('"' +
                command +
                "\" was not recognized as a command. Try \"help\" if you don't know what to do.");
    }

    public static void main(String[] args) {

        HashMap<String, User> users;
        ArrayList<Book> books;

        try {
            users = readUsersFromFile(USERS_FILE);
            books = readBooksFromFile(BOOKS_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Authentication system
        Scanner in = new Scanner(System.in);
        User currentUser = null;

        System.out.println("Home library management system started.\n");
        while (currentUser == null) {

            System.out.print("Login: ");
            String input = in.next();

            if (!users.containsKey(input)) {
                System.out.println("User not found.");
                continue;
            }

            String login = input;

            System.out.print("Password: ");
            input = in.next();

            if (users.get(login).isCorrectPassword(input)) {
                currentUser = users.get(login);
                continue;
            }

            System.out.println("Wrong password.");

        }

        System.out.println("Welcome back, " + currentUser.getLogin() + ".\n");

        String command = "";
        while (!command.equals("exit")) {

            System.out.print(currentUser.getLogin() + " > ");
            command = in.next();

            // Help command
            switch (command) {

                case "help" -> {
                    System.out.println("""
                        This application was created to manage home library.
                                                
                        User commands:
                        \thelp\t\t\tprints this message
                        \tview [page]\t\tprints book list (each page is 5 books)
                        \tsearch [query]\tlooks for books by name
                        \tmail\t\t\tchecks your mail
                        \tbook-pr [name] [author] [isElectronic]\t\t\tpropose book
                        """);

                    if (currentUser.isAdministrator()) {
                        System.out.println("""
                                Admin commands:
                                \tbook-add [name] [author] [isElectronic]\t\t\tadds a book to a list
                                \tuser-add [login] [password] [isAdministrator]\tadds a user
                                """);
                    }

                }

                // View command
                case "view" -> {
                    int page = in.nextInt();
                    if (books.size() < 5 * (page - 1) || page < 1) {
                        System.out.println("view: There's no page numbered " + page + ".");
                        continue;
                    }
                    System.out.println("Page " + page + ":");
                    for (int i = 5 * (page - 1); i < 5 * page && books.size() != i; i++) {
                        System.out.println(i + 1 + ". " + books.get(i).name() + ", " +
                                books.get(i).author() + ", " +
                                (books.get(i).isElectronic() ? "electronic" : "printed"));
                    }
                }

                case "search" -> {
                    Pattern tag = Pattern.compile(in.next());
                    int i = 0;
                    for (Book book : books) {

                        Matcher matcher = tag.matcher(book.author() + " " +
                                                            book.name() + " " +
                                                            (book.isElectronic() ? "electronic " : "printed"));

                        if (matcher.results().findAny().isPresent()) {
                            System.out.println(++i + ". " + book.name() + ", " +
                                    book.author() + ", " +
                                    (book.isElectronic() ? "electronic" : "printed"));
                        }

                    }
                }

                case "book-add" -> {

                    if (!currentUser.isAdministrator()) {
                        printCommandNotFound(command);
                        continue;
                    }

                    Book newBook = new Book(in.next(), in.next(), in.nextBoolean());
                    books.add(newBook);

                    try {

                        Files.writeString(
                                Paths.get(BOOKS_FILE),
                                newBook.name() + " " + newBook.author() + " " + newBook.isElectronic() + '\n',
                                StandardOpenOption.APPEND);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    for (User user : users.values()) {
                        String msg = "New book (" + newBook.name() + ") added to library!";
                        user.addMessage("[" + new Date() + "] " + msg);
                        User.sendMessage(
                                MSGS_FILE,
                                user.getLogin(),
                                msg
                        );
                    }

                }

                case "user-add" -> {

                    if (!currentUser.isAdministrator()) {
                        printCommandNotFound(command);
                        continue;
                    }

                    try {
                        Files.writeString(
                                Paths.get(USERS_FILE),
                                in.next() + " " + Utils.sha256(in.next()) + " " + in.nextBoolean() + '\n',
                                StandardOpenOption.APPEND
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                case "book-pr" -> {

                    String name = in.next(),
                            author = in.next();
                    boolean isElectronic = in.nextBoolean();

                    for (User user : users.values()) {

                        if (user.isAdministrator()) {
                            User.sendMessage(
                                    MSGS_FILE,
                                    user.getLogin(),
                                    "User " + currentUser.getLogin() + " proposes to add a book: " +
                                            name + " by " +
                                            author + ", " +
                                            (isElectronic ? "electronic" : "printed")
                            );
                        }

                    }

                }

                case "mail" -> {

                    for (String msg : currentUser.getMessages()) {
                        System.out.println(msg);
                    }

                }

                // Command not found
                case "exit" -> {
                    System.out.println("Exiting...");
                    in.close();
                }

                default -> printCommandNotFound(command);
            }

        }

    }

}
