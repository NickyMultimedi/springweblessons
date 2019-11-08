package be.multimedi.weblessons.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BookInMemoryRepository implements BookRepository {
    Map<String, Book> books;

    public BookInMemoryRepository() {
        books = new HashMap<>();
        books.put("05453453454",new Book("05453453454", "Harry Potter and the Deathly Hallows", "J.K. Rowlinig", 15));
        books.put("0394837153", new Book("0394837153", "A Weird Tale of Fever", "Nicolai Zurkov", 10));
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
}
