package pl.czaplicki.jarek.service;

import pl.czaplicki.jarek.repository.BookRepository;

public class BookRepositorySingleton {

    public static BookRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final BookRepository INSTANCE = new BookRepository();
    }
}
