package pl.czaplicki.jarek.dao;

import pl.czaplicki.jarek.model.Book;

import java.util.List;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * Interface containing abstract methods
 */

public interface BookDAO {
    Book addNewBook(Book newBook);
    void removeBook(String bookID);
    List<Book> getAllBooks();
    Book findByTitle(String title);
    Book findByTitleAndAuthor(String title, String author);
    Book findByTitleAndAuthorAndYear(String title, String author, Integer year);
    Book findByID(String bookID);
}
