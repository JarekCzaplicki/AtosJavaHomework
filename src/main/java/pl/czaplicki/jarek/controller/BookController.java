package pl.czaplicki.jarek.controller;

import pl.czaplicki.jarek.model.Book;
import pl.czaplicki.jarek.repository.BookRepository;
import pl.czaplicki.jarek.service.BookService;

import java.util.List;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * A class to handle a user's request
 */
public class BookController {
//    Wywoływać metody BookService z parametrami przekazanymi przez użytkownika lub testy.
//    W testach odwołuję się bezpośrednio i tylko do metod z tej klasy
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = new BookService();
    }

    public BookRepository createBookRepository(){
        return bookService.createBookRepository();
    }

    public Book addNewBook(Book newBook){
        return bookService.addNewBook(newBook);
    }

    public void removeBook(String bookID){
        bookService.removeBook(bookID);

    }


    public List<Book> getAllBooks(){

    }

    public Book findByTitle(String title){

    }

    public Book findByTitleAndAuthor(String title, String author){

    }

    public Book findByTitleAndAuthorAndYear(String title, String author, Integer year){

    }

    public Book findByID(String bookID){

    }

    public boolean lentAbook(Book book, String whoLendBook){

    }
}
