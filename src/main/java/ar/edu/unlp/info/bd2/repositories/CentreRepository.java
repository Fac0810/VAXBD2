package ar.edu.unlp.info.bd2.repositories;
import ar.edu.unlp.info.bd2.model.Centre;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CentreRepository extends CrudRepository<Centre, Long> {
    Centre getCentreByName(String name);
    @Query("SELECT c " +
                  "FROM Centre c JOIN c.staff " +
                  "GROUP BY c.id " +
                  "ORDER BY count(c.id) desc")
    List<Centre> getCentresTopNStaff(PageRequest of);
}
