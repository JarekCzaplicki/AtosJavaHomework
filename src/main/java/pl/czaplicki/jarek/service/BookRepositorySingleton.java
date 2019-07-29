package pl.czaplicki.jarek.service;

import pl.czaplicki.jarek.repository.BookRepository;
/**
 * @author jarekczaplicki@tlen.pl
 *
 * The class that protects you from creating multiple instances of the repository
 */
public class BookRepositorySingleton {

    public static BookRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final BookRepository INSTANCE = new BookRepository();
    }
}
