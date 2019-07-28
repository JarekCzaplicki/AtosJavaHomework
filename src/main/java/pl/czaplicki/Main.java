package pl.czaplicki;

import pl.czaplicki.jarek.model.Book;
import pl.czaplicki.jarek.repository.BookRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookRepository repo = new BookRepository();
        repo.addNewBook(new Book("Test działania", "JarekCzaplicki", 2019));
        repo.addNewBook(new Book("Test działania1", "Ala", 2019));
        repo.addNewBook(new Book("Test działania111", "Ola", 2019));
        repo.addNewBook(new Book("Test działania11", "Iza", 2009));
        repo.addNewBook(new Book("Test działania3", "Kat", 2000));
        repo.addNewBook(new Book("Test działania4", "Dog", 2019));
        repo.addNewBook(new Book("Test działania5", "Mause", 2000));


//        List<Book> allBooks = repo.getAllBooks();
//        for (Book allBook : allBooks) {
//            System.out.println(allBook);
//        }

        System.out.println(repo.findByTitle("Test działania4"));
        System.out.println(repo.findByTitleAndAuthor("Test działania111", "Ola"));
        repo.lentAbook(repo.findByTitle("Test działania4"), "Ktos");
        System.out.println(repo.findByTitle("Test działania4"));


    }
}
