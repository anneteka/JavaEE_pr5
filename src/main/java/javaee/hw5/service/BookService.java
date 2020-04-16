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

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(int id){
        return bookRepository.findById(id);
    }

    public List<Book> findAllByIbsnOrTitle(String ibsnOrTitle){
        return bookRepository.findAllByIbsnOrTitle(ibsnOrTitle, ibsnOrTitle);
    }
}
