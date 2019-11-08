package be.multimedi.weblessons.books;

import java.util.List;

public interface BookRepository {
    List<Book> getBooks();
    Book getBook(String isbn);
}
