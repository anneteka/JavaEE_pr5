package javaee.hw5.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String ibsn;

    public Book() {
    }

    public Book(String title, String author, String ibsn) {
        this.title = title;
        this.author = author;
        this.ibsn = ibsn;
    }
}
