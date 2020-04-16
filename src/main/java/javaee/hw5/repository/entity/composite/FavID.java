package javaee.hw5.repository.entity.composite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavID {
    private int user;
    private int book;

    public FavID() {
    }

    public FavID(int user, int book) {
        this.user = user;
        this.book = book;
    }
}
