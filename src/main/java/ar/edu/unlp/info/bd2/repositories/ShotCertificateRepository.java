package ar.edu.unlp.info.bd2.repositories;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;
import java.util.Optional;



public interface ShotCertificateRepository extends CrudRepository<ShotCertificate, Long> {

	@Query("select s from ShotCertificate s where s.fecha between :startDate and :endDate")
	List<ShotCertificate> getShotCertificatesBetweenDates(@Param("startDate")Date startDate,@Param("endDate") Date endDate);
}