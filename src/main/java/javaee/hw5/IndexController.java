package javaee.hw5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class IndexController {
    ArrayList<Book> books;

    @RequestMapping("/booklist")
    public String booklist(Model model) {
        model.addAttribute("bookStorage", Storage.bookList());
        return "index";
    }

    @PostMapping("/add-book")
    public String myPost(@ModelAttribute("book") Book book, Model model) {
        Storage.addBook(book);
        return "redirect:/booklist";
    }

    @GetMapping("/books")
    public String myBooks(Model model) {
        model.addAttribute("book", new Book());
        return "books";
    }
}
