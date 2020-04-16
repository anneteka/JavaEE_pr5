package javaee.hw5.repository.entity;

import javaee.hw5.repository.entity.composite.FavID;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "favourites")
@IdClass(value = FavID.class)
public class Favourite {

    @Id
    @Column(name = "user_id")
    private int user;

    @Id
    @Column(name = "bookr_id")
    private int book;

    public Favourite(int user, int book) {
        this.user = user;
        this.book = book;
    }

    public Favourite() {
    }
}
