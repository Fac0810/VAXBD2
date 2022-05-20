package ar.edu.unlp.info.bd2.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;

import java.util.Date;
import java.util.List;
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
    public Optional<Centre> getCentreByName(String name){
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
    }
    public List<Staff> getStaffWithName(String name) {
        return getSession().createQuery("FROM Staff s " +
                        "WHERE s.fullName like concat('%', :name, '%')")
                .setParameter("name",   name ).getResultList();

    }
    public List<Centre> getCentresTopNStaff(int n) {
        return getSession().createQuery("SELECT c " +
                                                  "FROM Centre c JOIN c.staff " +
                                                  "GROUP BY c.id " +
                                                  "ORDER BY count(c.id) desc")
                .setMaxResults(n).getResultList();
    }

    public List<Patient> getAllPatients() {
        return getSession().createQuery("from Patient").getResultList();
    }

    public List<Nurse> getNurseNotShot() {
        return getSession().createQuery("SELECT n " +
                "FROM Nurse n " +
                "WHERE n.dni not in (SELECT nur.dni " +
                                    "FROM Shot s JOIN  s.nurse nur )").getResultList();
    }

    public List<Vaccine> getUnappliedVaccines() {
        return  getSession().createQuery("SELECT vaccine " +
                "FROM Vaccine vaccine LEFT JOIN Shot shot ON shot.vaccine.id = vaccine.id " +
                "WHERE shot.vaccine.id IS NULL").getResultList();
    }

    public Centre getTopShotCentre() {
            List<Centre> c = getSession().createQuery("select s.centre " +
                                                "from Shot s " +
                                                "group by s.centre " +
                                                "order by count(s.centre.id) desc").getResultList();
            return c.get(0);
        }

    public String getLessEmployeesSupportStaffArea() {
        List<String> areas =  getSession().createQuery("select s.area "+//siempre poner un espacion al final
                "from SupportStaff s "+
                "group by s.area "+
                "order by count(s.area) asc").getResultList();
        return areas.get(0);
    }
    
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate){
    	List<ShotCertificate> shotCertificates =  getSession().createQuery("from ShotCertificate s " + 
    			"where s.fecha between :startDate " + 
    			"and :endDate ").setParameter("startDate", startDate).setParameter("endDate", endDate).getResultList();
        return shotCertificates;
    }
}
