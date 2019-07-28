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
    Book findFirstByTitle(String title);

    Book findFirstByTitleAndAuthor(String title, String author);

    Book findFirstById(String bookID);
}
