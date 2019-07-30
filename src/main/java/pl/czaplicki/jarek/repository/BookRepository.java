package pl.czaplicki.jarek.repository;

import pl.czaplicki.jarek.dao.BookDAO;
import pl.czaplicki.jarek.model.Book;

import java.util.*;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * The class that implements the methods from BookDAO
 */
public class BookRepository implements BookDAO {
    Map<Long, Book> libary = new HashMap<>();
    Long bookID = 0L;

    // 5. Should be possible to add new book to the library. ID should not be passed as argument. ID should be generated inside Library.
    public Book addNewBook(Book book) {
        bookID = setID(bookID);
        Book newBook = new Book();
        newBook.setAuthor(book.getAuthor());
        newBook.setAvailable(book.isAvailable());
        newBook.setTitle(book.getTitle());
        newBook.setWhoLendBook(book.getWhoLendBook());
        newBook.setYear(book.getYear());
        libary.put(bookID, newBook);
        return newBook;
    }

    @Override
    public void removeBook(Long bookID) {
        getAllBooks().remove(bookID);//6. Should be possible to remove given book from the library (by ID)
    }

    @Override
    public Map<Long, Book> getAllBooks() {
        return libary;//7. Should allow to list all books in the library (distinctly).
    }

    @Override
    public Book findByTitle(String title) {
        for (Book book : libary.values()) {
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }

    public Book findByTitleAndAuthor(String title, String author) {
        for (Book book : libary.values()) {
            if (book.getTitle().equals(title)&&book.getAuthor().equals(author))
                return book;
        }
        return null;
    }

    public Book findByTitleAndAuthorAndYear(String title, String author, Integer year) {
        for (Book book : libary.values()) {
            if (book.getTitle().equals(title)&&book.getAuthor().equals(author)&&book.getYear().equals(year))
                return book;
        }
        return null;
    }

    @Override
    public Book findByID(Long bookID) {
        for (Map.Entry<Long, Book> entry : libary.entrySet()) {
            Long id = entry.getKey();
            Book book = entry.getValue();
            if (id.equals(bookID))
                return book;
        }
        return null;
    }

    @Override
    public boolean lendBook(Long bookID, String whoLendBook) {
        for (Map.Entry<Long, Book> entry : libary.entrySet()) {
            Long id = entry.getKey();
            Book book = entry.getValue();
            if (id.equals(bookID)){
                book.setWhoLendBook(whoLendBook);
                book.setAvailable(false);
            }
        }
        return false;
    }

    private static Long setID(Long id) {
        return  ++id;
    }
}
