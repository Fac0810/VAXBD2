package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class VaccinationSchedule {

    @Id
    private Integer id;

    private Collection<Vaccine> schedule;

    public VaccinationSchedule(Collection<Vaccine> aSchedule) {
        this.schedule = aSchedule;
    }

    @Column(name="ID")
    public Integer getId() {
        return id;
    }

    @Column(name="Schedule")
    public Collection<Vaccine> getVaccines() {
        return this.schedule;
    }

    public void addVaccine(Vaccine vaccine) {
        schedule.add(vaccine);
    }


}
