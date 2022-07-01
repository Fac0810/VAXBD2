package ar.edu.unlp.info.bd2.repositories;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;



public interface ShotCertificateRepository extends CrudRepository<ShotCertificate, Long> {

}