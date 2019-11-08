package be.multimedi.weblessons.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
    private static final String BOOKS_VIEW = "books/booklist";
    private static final String BOOK_VIEW = "books/bookdetail";

    @Autowired
    private BookRepository repo;

    @GetMapping
    public String handleBookList(ModelMap model) {
        model.addAttribute("books", repo.getBooks());
        return BOOKS_VIEW;
    }

    @GetMapping(params = {"isbn"})
    public String handleBookDetails(@RequestParam("isbn") String isbn, ModelMap model) {
        Book book = repo.getBook(isbn);
        model.addAttribute("book", book);
        return BOOK_VIEW;
    }
}