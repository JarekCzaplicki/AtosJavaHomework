package pl.czaplicki.jarek.model;

import java.util.Objects;

/**
 * @author jarekczaplicki@tlen.pl
 *
 *	This class represents a book in the library,
 *	book consist of title, year and author, and has an extra field to represent the book availability
 */
public class Book {

    private String title, author, bookID;
    private String whoLendBook = "";
    private Integer year;
    private boolean available = true;

    public Book() {
    }

    public Book(String title, String author, String whoLendBook, Integer year, boolean available) {
        this.title = title;
        this.author = author;
        this.whoLendBook = whoLendBook;
        this.year = year;
        this.available = available;
    }

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(String title, String author, String whoLendBook,
                String bookID, Integer year, boolean available) {
        this.title = title;
        this.author = author;
        this.whoLendBook = whoLendBook;
        this.bookID = bookID;
        this.year = year;
        this.available = available;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", whoLendBook='" + whoLendBook + '\'' +
                ", bookID='" + bookID + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isAvailable() == book.isAvailable() &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getWhoLendBook(), book.getWhoLendBook()) &&
                Objects.equals(getBookID(), book.getBookID()) &&
                Objects.equals(getYear(), book.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getWhoLendBook(), getBookID(), getYear(), isAvailable());
    }
}
