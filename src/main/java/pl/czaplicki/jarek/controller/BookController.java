package pl.czaplicki.jarek.controller;

import pl.czaplicki.jarek.model.Book;
import pl.czaplicki.jarek.service.BookService;

import java.util.Map;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * A class to handle a user's request
 */
public class BookController {

    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }
    /**
     * Adds new book to book repository
     *
     * @param newBook object containing the input data
     * @return book repository with new book
     */
    public Book addNewBook(Book newBook){
        return bookService.addNewBook(newBook);
    }
    /**
     * Removes book with bookID from the book repository
     *
     * @param bookID Unique book identifier
     * @return book repository without a book with the given identifier
     */
    public int removeBook(Long bookID){
       return bookService.removeBook(bookID);
    }
    /**
     * Returns all books from the book repository
     *
     * @return all books as key and value
     */
    public Map<Long, Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    /**
     * Prints the formatted text with the book object's fields
     *
     * @return String with all books from repository as text
     */
    public String printAllBooks(){
        return bookService.printAllBooks();
    }
    /**
     * Finds books by the given title
     *
     * @return A book object that meets the search criteria
     */
    public Book findByTitle(String title){
        return bookService.findByTitle(title);
    }
    /**
     * Finds books by the given title and author
     *
     * @return A book object that meets the search criteria
     */
    public Book findByTitleAndAuthor(String title, String author){
        return bookService.findByTitleAndAuthor(title, author);
    }
    /**
     * Finds books by the given title and author and year
     *
     * @return A book object that meets the search criteria
     */
    public Book findByTitleAndAuthorAndYear(String title, String author, Integer year){
        return bookService.findByTitleAndAuthorAndYear(title, author, year);
    }
    /**
     * Finds books by the given ID
     *
     * @return A book object that meets the search criteria
     */
    public Book findByID(Long bookID){
        return bookService.findByID(bookID);
    }
    /**
     * Finds books by the given ID
     *
     * @return It sets up a book as a loan and adds the name of the borrower
     */
    public boolean lentBook(Long bookID, String whoLendBook){
        return bookService.lendBook(bookID, whoLendBook);
    }
}
