package engineer.leepsky.javaintroonline.classes.simple.simple9;

import java.util.ArrayList;

public class Book {

    /* Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
       метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
       методами. Задать критерии выбора данных и вывести эти данные на консоль.
       Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
       Найти и вывести:
       a) список книг заданного автора;
       b) список книг, выпущенных заданным издательством;
       c) список книг, выпущенных после заданного года. */

    private int id, year, pages, cost;
    private boolean hardCover; // false - мягкий, true - твёрдый 
    private ArrayList<String> authors;
    private String name, publisher;

    Book(int id, int year, int pages, int cost, boolean hardCover, ArrayList<String> authors, String name, String publisher) {

        this.id = id;
        this.year = year;
        this.pages = pages;
        this.cost = cost;
        this.hardCover = hardCover;
        this.authors = new ArrayList<String>(authors);
        this.name = name;
        this.publisher = publisher;

    }

    Book(int id, Book book) {

        this.id = id;
        this.year = book.year;
        this.pages = book.pages;
        this.cost = book.cost;
        this.hardCover = book.hardCover;
        this.authors = new ArrayList<String>(book.authors);
        this.name = book.name;
        this.publisher = book.publisher;

    }

    public int getID() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public int getCost() {
        return cost;
    }

    public boolean hasHardCover() {
        return hardCover;
    }

    public ArrayList<String> getAuthors() {
        return new ArrayList<String>(authors);
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setHardCover(boolean cover) {
        this.hardCover = cover;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = new ArrayList<String>(authors);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        for (String author : authors) {
            build.append(author)
                 .append(", ");
        }
        build.append(name)
             .append(" - ")
             .append(publisher)
             .append(", ")
             .append(year)
             .append(", ")
             .append(cost)
             .append("$, ")
             .append(pages)
             .append(" p., ");
        
        if (hardCover == true)
            build.append("hard cover.");
        else
            build.append("soft cover.");


        return build.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (o == this)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Book book = (Book)o;
        return
            this.name       ==  book.name       &&
            this.year       ==  book.year       &&
            this.hardCover  ==  book.hardCover  &&
            this.authors    ==  book.authors    &&
            this.publisher  ==  book.publisher  &&
            this.pages      ==  book.pages;

    }

    @Override
    public int hashCode() {

        final int prime = 31;

        int result = 1;

        result *= prime * ((this.name       == null)    ? 0 : this.name.hashCode());
        result *= prime * this.year;
        result *= prime * (hardCover ? 2 : 1);
        result *= prime * ((this.authors    == null)    ? 0 : this.authors.hashCode());
        result *= prime * ((this.publisher  == null)    ? 0 : this.publisher.hashCode());
        result *= prime * this.pages;

        return result;

    }
    
}
