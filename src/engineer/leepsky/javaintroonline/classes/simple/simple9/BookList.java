package engineer.leepsky.javaintroonline.classes.simple.simple9;

import java.util.ArrayList;

public class BookList {

    /* Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
    метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
    методами. Задать критерии выбора данных и вывести эти данные на консоль.
    Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
    Найти и вывести:
    a) список книг заданного автора;
    b) список книг, выпущенных заданным издательством;
    c) список книг, выпущенных после заданного года. */

    private int lastID;
    private ArrayList<Book> bookList;

    BookList() {

        lastID = 0;
        bookList = new ArrayList<Book>();

    }

    BookList(BookList original) {

        lastID = original.lastID;
        bookList = new ArrayList<Book>(original.bookList);

    }

    public void add(int year, int pages, int cost, boolean hardCover, ArrayList<String> authors, String name, String publisher) {

        Book newBook = new Book(
            ++lastID,
            year,
            pages,
            cost,
            hardCover,
            authors,
            name,
            publisher
        );

        bookList.add(newBook);

    }

    public void add(Book book) {

        bookList.add(new Book(++lastID, book));

    }

    public Book get(int i) {
        return bookList.get(i);
    }

    public int size() {
        return bookList.size();
    }

    public BookList getBooksByAuthor(String author) {
        var result = new BookList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthors().contains(author))
                result.add(bookList.get(i));
        }
        return result;
    }

    public BookList getBooksAfterYear(int year) {
        var result = new BookList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getYear() >= year)
                result.add(bookList.get(i));
        }
        return result;
    }

    public BookList getBooksByPublisher(String publisher) {
        var result = new BookList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getPublisher() == publisher)
                result.add(bookList.get(i));
        }
        return result;
    }
    
}
