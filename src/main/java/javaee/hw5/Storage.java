package javaee.hw5;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

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