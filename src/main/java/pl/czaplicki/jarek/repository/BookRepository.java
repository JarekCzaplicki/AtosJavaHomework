package pl.czaplicki.jarek.repository;

import pl.czaplicki.jarek.dao.BookDAO;
import pl.czaplicki.jarek.model.Book;

import java.util.List;
import java.util.UUID;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * The class that implements the methods from BookDAO
 */
public class BookRepository implements BookDAO {
    public Book addNewBook(Book book) {
        String bookID = UUID.randomUUID().toString(); //Each book should have unique identifier (ID) across application.
        Book newBook = new Book();
        newBook.setBookID(bookID);
        newBook.setAuthor(book.getAuthor());
        newBook.setAvailable(book.isAvailable());
        newBook.setTitle(book.getTitle());
        newBook.setWhoLendBook(book.getWhoLendBook());
        newBook.setYear(book.getYear());
        return newBook;
    }

    public void removeBook(String bookID) {

    }

    public List<Book> getAllBooks() {
        return null;
    }

    public Book findFirstByTitle(String title) {
        return null;
    }

    public Book findFirstByTitleAndAuthor(String title, String author) {
        return null;
    }

    public Book findFirstById(String bookID) {
        return null;
    }
}
