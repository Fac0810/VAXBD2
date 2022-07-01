package ar.edu.unlp.info.bd2.repositories;
import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;



public interface VaccineRepository extends CrudRepository<Vaccine, Long> {

    Optional<Vaccine> getVaccineByName(String name);
    
    @Query("SELECT vaccine " +
            "FROM Vaccine vaccine LEFT JOIN Shot shot ON shot.vaccine.id = vaccine.id " +
            "WHERE shot.vaccine.id IS NULL")
    List<Vaccine> getUnappliedVaccines();

}