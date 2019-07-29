package pl.czaplicki.jarek.service;

import pl.czaplicki.jarek.model.Book;
import pl.czaplicki.jarek.repository.BookRepository;

import java.util.Map;

/**
 * @author jarekczaplicki@tlen.pl
 *
 * This class represents business logic
 */

public class BookService {
    public BookRepository  bookRepository = createBookRepository();

    public  BookRepository createBookRepository() {
        return BookRepositorySingleton.getInstance();
    }

    public  Book addNewBook(Book newBook){
        if (bookRepository != null){
          System.out.println("Book added ");
        return bookRepository.addNewBook(newBook);
        }else{
          System.out.println("There is no repository of books");
          return null;
        }
    }

    // Should be possible to remove given book from the library (by ID)
    // (such action should be possible only if the book with such ID exists and it is not currently lent).
    public int removeBook(Long bookID){
        Book book = bookRepository.findByID(bookID);
        if(book != null){
            if(book.isAvailable()== true){
                bookRepository.removeBook(bookID);
                System.out.println("Book \"" + book.getTitle() + "\" removed correctly");
                return 0;
            }
            else{
                System.out.println("Book \"" + book.getTitle() + "\" is lend so you can't delete it");
                return 1;
            }
        }
        else{
            System.out.println("The book with the given ID does not exist");
            return -1;
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
                    .append("\nTitle: ").append(book.getTitle())
                    .append("\nYear: ").append(book.getYear())
                    .append("\nAuthor: ").append(book.getAuthor())
                    .append("\nAvailable for lend?: ").append(book.isAvailable())
                    .append("\nWho lend book?: ").append(book.getWhoLendBook())
                    .append("\n");

                if(book.isAvailable()){
                    availableCouner++;
                }
                else{
                    lendCouner++;
                }
            }
        return new StringBuilder("Available books: ")
        .append(availableCouner)
        .append("\nLend books: ")
        .append(lendCouner)
        .append("\n").append(allBooks).toString();
    }

    public Book findByTitle(String title){
        if (bookRepository.findByTitle(title) != null){
            System.out.println(bookRepository.findByTitle(title));
            return bookRepository.findByTitle(title);
        }
        else{
            System.out.println("Book with the given title not found");
            return null;
        }
    }

    public Book findByTitleAndAuthor(String title, String author){
        if (bookRepository.findByTitleAndAuthor(title, author) != null){
            System.out.println(bookRepository.findByTitleAndAuthor(title, author));
            return bookRepository.findByTitleAndAuthor(title, author);
        }
        else{
            System.out.println("Book with the given title and author not found");
            return null;
        }

    }

    public Book findByTitleAndAuthorAndYear(String title, String author, Integer year){
        if (bookRepository.findByTitleAndAuthorAndYear(title, author, year) != null){
            System.out.println(bookRepository.findByTitleAndAuthorAndYear(title, author, year));
            return bookRepository.findByTitleAndAuthorAndYear(title, author, year);
        }
        else{
            System.out.println("Book with the given title and author and year not found");
            return null;
        }
    }

    public Book findByID(Long bookID){
        if (bookRepository.findByID(bookID) != null){
            System.out.println(bookRepository.findByID(bookID));
            return bookRepository.findByID(bookID);
        }
        else{
            System.out.println("Book with the given bookID not found");
            return null;
        }

    }

    public boolean lendBook(Long bookID, String whoLendBook){
        if (bookRepository.findByID(bookID) != null){
            if (bookRepository.findByID(bookID).isAvailable()){
                System.out.println("The book " + bookRepository.findByID(bookID).getTitle() + " was lent to Mr." + whoLendBook);
                bookRepository.lendBook(bookID,whoLendBook);
                return true;
            }else{
                System.out.println("The book " + bookRepository.findByID(bookID).getTitle()
                + " is not available it was lent to Mr." + bookRepository.findByID(bookID).getWhoLendBook());
                return false;
            }
        }else {
            System.out.println("The book with the given ID was not found");
            return false;
        }

    }
}
