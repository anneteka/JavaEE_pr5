package javaee.hw5.controller;

import javaee.hw5.PassEncode;
import javaee.hw5.repository.entity.Book;
import javaee.hw5.repository.entity.User;
import javaee.hw5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("registration_page")
    public String getRegisterPage() {
        return "registration";
    }


    @PostMapping(value = "/signup")
    public ResponseEntity register(@RequestBody User user) {
        if (userService.userExists(user.getUsername())) {
            return new ResponseEntity<>("Username is taken.",
                    HttpStatus.FORBIDDEN);
        }
        String userPassword = user.getPassword();
        PassEncode encoder = new PassEncode();
        String encodedPassword = encoder.encode(userPassword);
        user.setPassword(encodedPassword);
        userService.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/booklist/favorites")
    public ResponseEntity<List<Book>> getFavorites(final Principal principal) {
        String login = principal.getName();
        List<Book> favorites = userService.findFavorites(login);
        List<Book> response = new ArrayList<>();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping(value = "/booklist/favorites/add")
    public ResponseEntity addFavorites(final Principal principal, @RequestBody final Book book) {
        String login = principal.getName();
        userService.addFavorites(login, book.getId());
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping(value = "/booklist/favorites/delete")
    public ResponseEntity deleteFavorites(final Principal principal, @RequestBody final Book book) {
        String login = principal.getName();
        userService.deleteFavorites(book.getId(), login);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/booklist/isFavorite/{id}", produces = "application/json")

    public ResponseEntity<Boolean> isFavorite(final Principal principal, @PathVariable("id") final int id) {
        if (principal == null) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        boolean fav = userService.isFavorite(id, principal.getName());
        return new ResponseEntity<>(fav, HttpStatus.OK);
    }
}

