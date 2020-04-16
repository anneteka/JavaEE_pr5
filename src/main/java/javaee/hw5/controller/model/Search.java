package javaee.hw5.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@Service
@Deprecated
public class Search {
    private String searchString;

    public Search() {
    }

    public Search(String searchString) {
        this.searchString = searchString;
    }
}
