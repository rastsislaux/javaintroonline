package engineer.leepsky.javaintroonline.classes.simple.simple9;

import java.util.ArrayList;

public class Simple9 {

    /* Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
       метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
       методами. Задать критерии выбора данных и вывести эти данные на консоль.
       Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
       Найти и вывести:
       a) список книг заданного автора;
       b) список книг, выпущенных заданным издательством;
       c) список книг, выпущенных после заданного года. */

    public static void printBookList(BookList bookList) {
        for (int i = 0; i < bookList.size(); i++)
            System.out.println(bookList.get(i).toString());
    }

    public static void main(String[] args) {

        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Firstman A. A.");
        authors.add("Secondman B. B.");

        var bookList = new BookList();
        bookList.add(2015, 39, 419, true, authors, "Some Cool Book", "GoodPublisher Co.");
        bookList.add(2012, 43, 299, false, authors, "The First Cool Book", "OtherPublisher GmbH");

        System.out.println("Books by Firstman A.A.:");
        BookList byAuthor = bookList.getBooksByAuthor("Firstman A. A.");
        printBookList(byAuthor);

        System.out.println("Books published after 2013:");
        BookList byYear = bookList.getBooksAfterYear(2013);
        printBookList(byYear);

        System.out.println("Books published by OtherPublisher GmbH:");
        BookList byPublisher = bookList.getBooksByPublisher("OtherPublisher GmbH");
        printBookList(byPublisher);

    }
    
}
