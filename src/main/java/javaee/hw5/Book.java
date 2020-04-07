package javaee.hw5;

public class Book {
    private String title;
    private String author;
    private String ibsn;

    public Book() {
    }

    public Book(String title, String author, String ibsn) {
        this.title = title;
        this.author = author;
        this.ibsn = ibsn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIbsn() {
        return ibsn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ibsn='" + ibsn + '\'' +
                '}';
    }
}
