package javaee.hw5.controller;

import javaee.hw5.repository.entity.Book;
import javaee.hw5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
//@Controller
public class RestController {

    private BookService bookService;

    @Autowired
    public RestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("rest-booklist")
    @CrossOrigin
    public ResponseEntity<Book> getbooklist(@RequestBody Book book) {
        bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("rest-booklist")
    @CrossOrigin
    public ResponseEntity<List<Book>> postbooklist(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "search_type", required = false) String type) {
        List<Book> list;
        if (search == null) {
            list = bookService.findAll();
        } else {
            int temp = Integer.parseInt(type);
            switch (temp) {
                case 0: {
                    list = bookService.findAllByTitle(search);
                    break;
                }
                case 1: {
                    list = bookService.findAllByIsbn(search);
                    break;
                }
                case 2: {
                    list = bookService.findAllByAuthor(search);
                    break;
                }
                default: {
                    list = bookService.findAllByIbsnOrTitle(search);
                }
            }

        }
        return ResponseEntity.ok(list);
    }


}
