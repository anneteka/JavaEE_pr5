package javaee.hw5.service;

import javaee.hw5.repository.BookRepository;
import javaee.hw5.repository.FavouriteRepository;
import javaee.hw5.repository.UserRepository;
import javaee.hw5.repository.entity.Book;
import javaee.hw5.repository.entity.Favourite;
import javaee.hw5.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private FavouriteRepository favouriteRepository;
    private BookRepository bookRepository;

    @Autowired
    public UserService(UserRepository userRepository, FavouriteRepository favouriteRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.favouriteRepository = favouriteRepository;
        this.bookRepository = bookRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public List<Book> findFavorites(String login) {
        Optional<User> user = userRepository.findByUsername(login);
        if (user.isPresent()) {
            List<Favourite> favs = favouriteRepository.findAllByUser(user.get().getId());
            ArrayList<Book> favbooks = new ArrayList<>();
            for (Favourite fav : favs) {
                favbooks.add(bookRepository.findById(fav.getBook()).get());
            }
            return favbooks;
        } else return new ArrayList<>();
    }

    public void addFavorites(String login, int id) {
        Optional<User> user = userRepository.findByUsername(login);
        favouriteRepository.save(new Favourite(user.get().getId(), id));
    }

    public void deleteFavorites(int bookid, String login) {
        Optional<User> user = userRepository.findByUsername(login);
        favouriteRepository.delete(new Favourite(user.get().getId(), bookid));
    }

    public boolean isFavorite(int id, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            return favouriteRepository.findByUserAndBook(user.get().getId(), id).isPresent();
        }
        return false;
    }
}
