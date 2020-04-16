package javaee.hw5.repository.entity;

import javaee.hw5.repository.entity.myenums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String username;
    private String password;

    @Column(name = "role")
    private Role role = Role.USER;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
