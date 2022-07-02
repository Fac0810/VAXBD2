package ar.edu.unlp.info.bd2.repositories;
import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Shot;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;



public interface ShotRepository extends CrudRepository<Shot, Long> {

    @Query("SELECT s.centre " +
            "FROM Shot s " +
            "GROUP BY s.centre " +
            "ORDER BY count(s.centre.id) desc")
    Centre getTopShotCentre(PageRequest of);
}