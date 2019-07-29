package pl.czaplicki.jarek.controller;

import pl.czaplicki.jarek.model.Book;

import static org.junit.jupiter.api.Assertions.*;
class BookControllerTest {

  BookController con = new BookController();

  @org.junit.jupiter.api.Test
  void addNewBook() {
    assertTrue(con.addNewBook(new Book("Pan i Pani", "Franek", 2019)) != null);
    assertTrue(con.addNewBook(new Book("Abra kadabra", "Wiedzma", 1219))!= null);
    assertTrue(con.addNewBook(new Book("Alabaster", "Ala", 2019))!= null);
    assertTrue(con.addNewBook(new Book("Aleksandria", "Ola", 2019))!= null);
    assertTrue(con.addNewBook(new Book("Siostra Izobara", "Iza", 2009))!= null);
    assertTrue(con.addNewBook(new Book("In search of gravel", "Kat", 2000))!= null);
    assertTrue(con.addNewBook(new Book("All bones in the world", "Dog", 2019))!= null);
    assertTrue(con.addNewBook(new Book("How to avoid traps", "Mouse", 2000))!= null);
  }

  @org.junit.jupiter.api.Test
  void lentBook() {
  assertTrue(con.lentBook(4L, "Tester"));
  assertFalse(con.lentBook(4L, "Tester II"));
  assertFalse(con.lentBook(999L, "Tester II"));
  }

  @org.junit.jupiter.api.Test
  void removeBook() {
  assertTrue((con.removeBook(1L)) == 0);
  assertTrue((con.removeBook(2L)) == 0);
  assertTrue((con.removeBook(3L)) == 0);
  }

  @org.junit.jupiter.api.Test
  void getAllBooks() {
  addNewBook();
    assertTrue(con.getAllBooks() != null);
  }

  @org.junit.jupiter.api.Test
  void findByTitle() {
    assertTrue(con.findByTitle("Pan i Pani") != null);
    assertTrue(con.findByTitle("Abra kadabra")!= null);
    assertTrue(con.findByTitle("Alabaster")!= null);
    assertTrue(con.findByTitle("Aleksandria")!= null);
    assertTrue(con.findByTitle("Siostra ")== null);
    assertTrue(con.findByTitle("In search of gravel")!= null);
    assertTrue(con.findByTitle("All bones the world")== null);
    assertTrue(con.findByTitle("How to avoid traps")!= null);
  }

  @org.junit.jupiter.api.Test
  void findByTitleAndAuthor() {
    assertTrue(con.findByTitleAndAuthor("Pan i Pani", "Franek") != null);
    assertTrue(con.findByTitleAndAuthor("Abra kadabra", "Wiedzma")!= null);
    assertTrue(con.findByTitleAndAuthor("Alabaster", "Ala")!= null);
    assertTrue(con.findByTitleAndAuthor("Aleksandria", "Ola")!= null);
    assertTrue(con.findByTitleAndAuthor("Siostra Izobara", "Oza")== null);
    assertTrue(con.findByTitleAndAuthor("In search of gravel", "Kat")!= null);
    assertTrue(con.findByTitleAndAuthor("All bones in world", "Dog")== null);
    assertTrue(con.findByTitleAndAuthor("How to avoid traps", "Mouse")!= null);
  }

  @org.junit.jupiter.api.Test
  void findByTitleAndAuthorAndYear() {
    assertTrue(con.addNewBook(new Book("Pan i Pani", "Franek", 2019)) != null);
    assertTrue(con.addNewBook(new Book("Abra kadabra", "Wiedzma", 1219))!= null);
    assertTrue(con.addNewBook(new Book("Alabaster", "Ala", 2019))!= null);
    assertTrue(con.addNewBook(new Book("Aleksandria", "Ola", 2019))!= null);
    assertTrue(con.addNewBook(new Book("Siostra Izobara", "Iza", 2009))!= null);
    assertTrue(con.addNewBook(new Book("In search of gravel", "Kat", 2000))!= null);
    assertTrue(con.addNewBook(new Book("All bones in the world", "Dog", 2019))!= null);
    assertTrue(con.addNewBook(new Book("How to avoid traps", "Mouse", 2000))!= null);
  }

  @org.junit.jupiter.api.Test
  void findByID() {
    assertFalse(con.findByID(1L) != null);
    assertTrue(con.findByID(800L) == null);
  }
}