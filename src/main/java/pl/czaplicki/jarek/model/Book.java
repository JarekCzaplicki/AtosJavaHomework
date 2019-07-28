package pl.czaplicki.jarek.model;
/**
 * @author jarekczaplicki@tlen.pl
 *
 *	This class represents a book in the library,
 *	book consist of title, year and author, and has an extra field to represent the book availability
 */
public class Book {

    private String title, author, whoLendBook, bookID;
    private int year;
    private boolean available = false;

    public Book() {
    }

    public Book(String title, String author, String whoLendBook,
                String bookID, int year, boolean available) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
}
