package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.SupportStaff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SupportStaffRepository extends CrudRepository<SupportStaff, Long> {
    SupportStaff getSupportStaffByDni(String dni);
    @Query("select s.area "+//siempre poner un espacion al final
            "from SupportStaff s "+
            "group by s.area "+
            "order by count(s.area) asc")
    List<String> getLessEmployeesSupportStaffArea();
}
