package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Nurse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface NurseRepository extends CrudRepository<Nurse, Long> {
    Nurse getNurseByDni(String dni);
    @Query("FROM Nurse n " +
            "WHERE n.experience > :years")
    List<Nurse> getNurseWithMoreThanNYearsExperience(@Param("years") int years);
}
