package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Nurse;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface NurseRepository extends CrudRepository<Nurse, Long> {
    Nurse getNurseByDni(String dni);
    
    @Query("SELECT n " +
            "FROM Nurse n " +
            "WHERE n.dni not in (SELECT nur.dni " +
                                "FROM Shot s JOIN  s.nurse nur )")
    List<Nurse> getNurseNotShot();
}
