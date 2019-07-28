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

//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = new BookRepository();
//    }

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
