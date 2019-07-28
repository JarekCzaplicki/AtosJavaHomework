package pl.czaplicki.jarek.model;

import java.util.Objects;

/**
 * @author jarekczaplicki@tlen.pl
 *
 *	This class represents a book in the library,
 *	book consist of title, year and author, and has an extra field to represent the book availability
 */
public class Book {

    private String title, author;
    private String whoLendBook = "";
    private Integer year;
    private boolean available = true;

    public Book() {
    }

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWhoLendBook() {
        return whoLendBook;
    }

    public void setWhoLendBook(String whoLendBook) {
        this.whoLendBook = whoLendBook;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
