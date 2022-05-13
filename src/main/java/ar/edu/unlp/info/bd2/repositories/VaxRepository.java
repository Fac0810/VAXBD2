package ar.edu.unlp.info.bd2.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import ar.edu.unlp.info.bd2.model.*;

import javax.persistence.NoResultException;

public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }


    public void save(Object o) {
        try {
            this.sessionFactory.getCurrentSession().saveOrUpdate(o);
        } catch (Exception e) {
            this.sessionFactory.getCurrentSession().clear();
            throw e;
        }

    }
    public Patient getPatienteByEmail(String email){
        try {
            return (Patient) getSession().createQuery("FROM Patient pat WHERE pat.email = :email").setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }


	public Optional<Patient> getPatientByEmail(String email) {
        return getSession().createQuery
                ("from Patient pat where pat.email = :email").setParameter("email", email).uniqueResultOptional();
    }
    
    public Optional<Vaccine> getVaccineByName(String name) {

        return getSession().createQuery
                    ("from Vaccine vax where vax.name = :name").setParameter("name", name).uniqueResultOptional();

    }

    public VaccinationSchedule getVaccinationScheduleByID(Long id) {
        return (VaccinationSchedule) getSession().createQuery(
                "from VaccinationSchedule vac where vac.id = :id").setParameter("id", id).uniqueResult();

    }


    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        return getSession().createQuery
                        ("from SupportStaff sup where sup.dni = :dni").setParameter("dni", dni).uniqueResultOptional();

    }
    public Optional<Centre> getCentreByName(String name) {
        //Fran
        return this.getSession().createQuery("from Centre c where c.name = :name")
                .setParameter("name",name).uniqueResultOptional();
    }
    public Nurse getNurseByDni(String dni){
        try {
            return (Nurse) getSession().createQuery("FROM Nurse n WHERE n.dni = :dni").setParameter("dni", dni)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
