package javaee.hw5.repository;

import javaee.hw5.repository.entity.Favourite;
import javaee.hw5.repository.entity.composite.FavID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, FavID> {

    List<Favourite> findAllByUser(int user_id);

    Optional<Favourite> findByUserAndBook(int user, int book);
}
