package pl.czaplicki.jarek.service;

import pl.czaplicki.jarek.model.Book;
import pl.czaplicki.jarek.repository.BookRepository;

import java.util.List;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * This class represents business logic
 */
// Oprogramować warunki i błędy podczas wywoływania metod z BookReposytory, Zwracać gotowe obiekty
//    lub błędy
public class BookService {
    public BookRepository  bookRepository = createBookRepository();


    public  BookRepository createBookRepository() {
        return BookRepositorySingleton.getInstance();
    }


    public  Book addNewBook(Book newBook){
        return bookRepository.addNewBook(newBook);
    }

    public void removeBook(String bookID){
        bookRepository.removeBook(bookID);
    }


    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public Book findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public Book findByTitleAndAuthor(String title, String author){
        return bookRepository.findByTitleAndAuthor(title, author);
    }

    public Book findByTitleAndAuthorAndYear(String title, String author, Integer year){
        return bookRepository.findByTitleAndAuthorAndYear(title, author, year);
    }

    public Book findByID(String bookID){
        return bookRepository.findByID(bookID);
    }

    public boolean lentAbook(Book book, String whoLendBook){
        return bookRepository.lentAbook(book,whoLendBook);
    }
}
