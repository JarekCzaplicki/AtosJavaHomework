package pl.czaplicki;

import pl.czaplicki.jarek.model.Book;
import pl.czaplicki.jarek.repository.BookRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookRepository repo = new BookRepository();
        repo.addNewBook(new Book("Test działania", "JarekCzaplicki", "Jarek", 2019, true));
        repo.addNewBook(new Book("Test działania1", "Ala", "Jarek", 2019, true));
        repo.addNewBook(new Book("Test działania2", "Ma", "Marek", 2019, true));
        repo.addNewBook(new Book("Test działania3", "Kota", "Marek", 2000, true));
        repo.addNewBook(new Book("Test działania4", "Patryk", "Adam", 2000, true));
        repo.addNewBook(new Book("Test działania5", "Natalia", "Adam", 2000, true));
        repo.addNewBook(new Book("Test działania6", "Ela", "Adam", 2000, true));
        repo.addNewBook(new Book("Test działania7", "Juzek", "Adam", 2130, true));

//        List<Book> allBooks = repo.getAllBooks();
//        for (Book allBook : allBooks) {
//            System.out.println(allBook);
//        }

        System.out.println(repo.findByTitle("Test działania4"));
        System.out.println(repo.findByTitleAndAuthor("Test działania3", "Kota"));


    }
}
