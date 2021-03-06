package javaee.hw5.repository;

import javaee.hw5.repository.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Book save(Book book);

    List<Book> findAll();

    Optional<Book> findBookById(int id);

    List<Book> findAllByIbsnOrTitle(String ibsn, String title);
}
