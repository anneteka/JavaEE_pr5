package javaee.hw5.repository;
import javaee.hw5.repository.entity.Book;

import java.util.ArrayList;

@Deprecated
class Storage {

    private static ArrayList<Book> books=new ArrayList<>();

    static void addBook(Book book)
    {
        books.add(book);
    }
    static ArrayList<Book> bookList()
    {
        return  books;
    }

}