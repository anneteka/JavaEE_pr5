package javaee.hw5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/booklist")
    public String index() {
        return "index";
    }

    @PostMapping("/books")
    public String myPost(){
        return "redirect:/booklist";
    }
    @GetMapping("/books")
    public String myBooks(){
        return "books";
    }
}
