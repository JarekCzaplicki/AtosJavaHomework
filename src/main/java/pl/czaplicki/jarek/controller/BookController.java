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
//    Wywoływać metody BookService z parametrami przekazanymi przez użytkownika lub testy.
//    W testach odwołuję się bezpośrednio i tylko do metod z tej klasy
    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    public Book addNewBook(Book newBook){
        return bookService.addNewBook(newBook);
    }

    public int removeBook(Long bookID){
       return bookService.removeBook(bookID);
    }

    public Map<Long, Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    public String printAllBooks(){
        return bookService.printAllBooks();
    }

    public Book findByTitle(String title){
        return bookService.findByTitle(title);
    }

    public Book findByTitleAndAuthor(String title, String author){
        return bookService.findByTitleAndAuthor(title, author);
    }

    public Book findByTitleAndAuthorAndYear(String title, String author, Integer year){
        return bookService.findByTitleAndAuthorAndYear(title, author, year);
    }

    public Book findByID(Long bookID){
        return bookService.findByID(bookID);
    }

    public boolean lentBook(Long bookID, String whoLendBook){
        return bookService.lendBook(bookID, whoLendBook);
    }
}
