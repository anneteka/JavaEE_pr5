package javaee.hw5.service;

import javaee.hw5.repository.BookRepository;
import javaee.hw5.repository.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAllByIbsnOrTitle(String isbnOrTitle) {
        return bookRepository.findAllByIsbnOrTitle(isbnOrTitle, isbnOrTitle);
    }

    public List<Book> findAllByAuthor(String author){
        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> findAllByTitle(String title){
        return bookRepository.findAllByTitle(title);
    }

    public List<Book> findAllByIsbn(String isbn){
        return bookRepository.findAllByIsbn(isbn);
    }
}
