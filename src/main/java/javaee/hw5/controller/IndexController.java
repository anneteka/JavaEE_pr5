package javaee.hw5.controller;
import javaee.hw5.controller.model.Search;
import javaee.hw5.repository.entity.Book;
import javaee.hw5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class IndexController {

    private BookService bookService;

    @Autowired
    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("")
    public String base(){
        return "redirect:/booklist";
    }
    @RequestMapping("/booklist")
    public String booklist(Model model) {
        model.addAttribute("bookStorage", bookService.findAll());

        return "index";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute(name = "search") Search search, Model model){
        model.addAttribute("bookStorage", bookService.findAllByIbsnOrTitle(search.getSearchString()));
        return "search";
    }

    @PostMapping("/add-book")
    public String myPost(@ModelAttribute("book") Book book, Model model) {
        bookService.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/books")
    public String myBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("search", new Search());
        return "books";
    }

    @GetMapping("/book-info")
    public String bookInfo(@RequestParam int id, Model model, HttpServletResponse response){
        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent()){
            response.setStatus(404);
            return "bookInfo";
        }
        model.addAttribute("book", book.get());
        return "bookInfo";
    }
}
