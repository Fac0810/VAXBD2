package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StaffRepository extends CrudRepository<Staff, Long> {
    @Query("FROM Staff s " +
            "WHERE s.fullName like concat('%', :name, '%')")
    List<Staff> getStaffWithName(@Param("name") String name);
}
