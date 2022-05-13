package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class VaccinationSchedule {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "vaccinationschedule_vaccine",
            joinColumns = {@JoinColumn(name = "vaccinationscheduleId")},
            inverseJoinColumns = {@JoinColumn(name = "vaccineId")}
    )
    private List<Vaccine> schedule;


    public VaccinationSchedule() {
        this.schedule = new ArrayList<Vaccine>();
    }

    @Column(name="ID")
    public Long getId() {
        return id;
    }

    @Column(name="Schedule")
    public List<Vaccine> getVaccines() {
        return this.schedule;
    }

    public void addVaccine(Vaccine vaccine) {
        schedule.add(vaccine);
    }


}
