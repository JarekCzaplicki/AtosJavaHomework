package pl.czaplicki.jarek.service;

import pl.czaplicki.jarek.model.Book;
import pl.czaplicki.jarek.repository.BookRepository;

import java.util.Map;

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

    // Should be possible to remove given book from the library (by ID)
    // (such action should be possible only if the book with such ID exists and it is not currently lent).
    public void removeBook(Long bookID){
        Book book = bookRepository.findByID(bookID);
        if(book != null){
            if(book.isAvailable()== true){
                bookRepository.removeBook(bookID);
                System.out.println("Book " + book.getTitle() + " removed correctly");
            }
            else{
                System.out.println("Book " + book.getTitle() + " is lend so you can't delete it");
            }
        }
        else{
            System.out.println("The book with the given ID does not exist");
        }
    }


    public Map<Long, Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public String printAllBooks(){
        StringBuilder allBooks = new StringBuilder();
        int availableCouner = 0;
        int lendCouner = 0;
        Map<Long,Book>library = getAllBooks();

        for(Map.Entry<Long, Book> entry : library.entrySet() ){
            Long id = entry.getKey();
            Book book = entry.getValue();
            allBooks.append("ID: ").append(id)
                    .append("/nTitle: ").append(book.getTitle())
                    .append("/nYear: ").append(book.getYear())
                    .append("/nAuthor: ").append(book.getAuthor())
                    .append("/nDoes the book is available?: " ).append(book.isAvailable())
                    .append("/nWho lend book?: " + book.getWhoLendBook());

                if(book.isAvailable()){
                    availableCouner++;
                }
                else{
                    lendCouner++;
                }
            }
        return "Available books: " + availableCouner + "/nLend books: " + lendCouner + allBooks.toString();
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

    public Book findByID(Long bookID){
        return bookRepository.findByID(bookID);
    }

    public boolean lentAbook(Long bookID, String whoLendBook){
        return bookRepository.lentAbook(bookID,whoLendBook);
    }
}
