package pl.czaplicki.jarek.repository;

import pl.czaplicki.jarek.dao.BookDAO;
import pl.czaplicki.jarek.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * The class that implements the methods from BookDAO
 */
public class BookRepository implements BookDAO {
    List<Book> listOfBooks= new ArrayList<Book>();

    // 5. Should be possible to add new book to the library. ID should not be passed as argument. ID should be generated inside Library.
    public Book addNewBook(Book book) {
        String bookID = UUID.randomUUID().toString(); //4. Each book should have unique identifier (ID) across application.
        Book newBook = new Book();
        newBook.setBookID(bookID);
        newBook.setAuthor(book.getAuthor());
        newBook.setAvailable(book.isAvailable());
        newBook.setTitle(book.getTitle());
        newBook.setWhoLendBook(book.getWhoLendBook());
        newBook.setYear(book.getYear());
        listOfBooks.add(newBook);
        return newBook;
    }

    public void removeBook(String bookID) {
        getAllBooks().remove(findByID(bookID));//6. Should be possible to remove given book from the library (by ID)
    }

    public List<Book> getAllBooks() {
        return listOfBooks;//7. Should allow to list all books in the library (distinctly).
    }

    public Book findByTitle(String title) {
        for (Book book : listOfBooks) {
//            return (Book) listOfBooks.stream().filter((p) -> p.getTitle().equals(title));
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }

    public Book findByTitleAndAuthor(String title, String author) {
        for (Book book : listOfBooks) {
            if (book.getTitle().equals(title)&&book.getAuthor().equals(author))
                return book;
        }
        return null;
    }

    public Book findByTitleAndAuthorAndYear(String title, String author, Integer year) {
        for (Book book : listOfBooks) {
            if (book.getTitle().equals(title)&&book.getAuthor().equals(author)&&book.getYear().equals(year))
                return book;
        }
        return null;
    }


    public Book findByID(String bookID) {
        for (Book book : listOfBooks) {
            if (book.getBookID().equals(bookID))
                return book;
        }
        return null;
    }

    @Override
    public boolean lentAbook(Book book, String whoLendBook) {
        for (Book b : listOfBooks) {
            if (b.getBookID().equals(book.getBookID())) {
                b.setWhoLendBook(whoLendBook);
                b.setAvailable(false);
            }
        }
        return false;
    }
}
