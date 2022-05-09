package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class VaccinationSchedule {

    @Id
    private Long id;

    @ManyToOne
    private ArrayList<Vaccine> schedule;

    public VaccinationSchedule(ArrayList<Vaccine> aSchedule) {
        this.schedule = aSchedule;
    }

    @Column(name="ID")
    public Long getId() {
        return id;
    }

    @Column(name="Schedule")
    public ArrayList<Vaccine> getVaccines() {
        return this.schedule;
    }

    public void addVaccine(Vaccine vaccine) {
        schedule.add(vaccine);
    }


}
