package ar.edu.unlp.info.bd2.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import ar.edu.unlp.info.bd2.model.*;
import org.springframework.data.jpa.repository.Query;

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
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return getSession().createQuery("FROM Nurse n " +
                                                  "WHERE n.experience > :years")
                        .setParameter("years", years).getResultList();
        //fran
    }
    // @return Una lista con los <code>n</code> centros que más staff tiene
    public List<Staff> getStaffWithName(String name) {
        return getSession().createQuery("FROM Staff as s " +
                                                   "WHERE s.fullName like '%':name'%'")
                .setParameter("name", name).getResultList();
        //fran
        //from Cat as cat where cat.mate.name like '%s%'
        // es asi el uso del like
    }
    public List<Centre> getCentresTopNStaff(int n) {
        return getSession().createQuery("SELECT c " +
                                                  "FROM Centre c JOIN c.staff " +
                                                  "GROUP BY c.id " +
                                                  "ORDER BY count(c.id) desc")
                .setMaxResults(n).getResultList();
        //fran
        //CONSULTAR SI ESTA BIEN LA CONSULTA
    }

    public List<Patient> getAllPatients() {
        return getSession().createQuery("SELECT * from Patient").getResultList(); //joaquin
    }

    public List<Nurse> getNurseNotShot() {
        return getSession().createQuery("SELECT n " +
                "FROM Nurse n " +
                "WHERE n.dni not in (SELECT nur.dni " +
                                    "FROM Shot s JOIN  s.nurse nur )").getResultList();
        //fran
        //
    }

    /**
     * @return Una lista de las vacunas de las que no se aplicaron dosis
     */
    public List<Vaccine> getUnappliedVaccines() {
        return getSession().createQuery("SELECT vax " +
                "FROM Vaccine vaccine LEFT JOIN Shot shot ON shot.vaccine.id = vaccine.id " +
                "WHERE shot.vaccine.id IS NULL").getResultList(); //joaquin
    }

    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vs) {
        return this.save(vs); //joaquin
    }
}
