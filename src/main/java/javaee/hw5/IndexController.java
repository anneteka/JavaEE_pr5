package javaee.hw5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class IndexController {
    ArrayList<Book> books;

    @RequestMapping("/booklist")
    public String booklist() {
        return "index";
    }

    @PostMapping("/add-book")
    public String myPost(@ModelAttribute Book book, Model model) {
//        Storage.addBook(new Book(title, author, ibsn));
        Storage.addBook(book);
        model.addAttribute("bookStorage", Storage.bookList());
        return "redirect:/booklist";
    }

    @GetMapping("/books")
    public String myBooks(@ModelAttribute Book formBook, Model model) {
        model.addAttribute("bookStorage", Storage.bookList());
        model.addAttribute("book", new Book());
        return "books";
    }
}
