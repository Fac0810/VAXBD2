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
            name = "VaccinationSchedule_Vaccine",
            joinColumns = {@JoinColumn(name = "vaccinationschedule_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name = "vaccine_id", referencedColumnName="id")}
    )
    private List<Vaccine> schedule = new ArrayList<Vaccine>();

    public VaccinationSchedule() {
    	
    }

    public Long getId() {
        return id;
    }

    
    public List<Vaccine> getVaccines() {
        return this.schedule;
    }

    public void addVaccine(Vaccine vaccine) {
        schedule.add(vaccine);
    }


}
