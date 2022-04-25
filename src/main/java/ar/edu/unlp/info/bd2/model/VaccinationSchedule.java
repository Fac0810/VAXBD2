package ar.edu.unlp.info.bd2.model;

import java.util.Collection;

public class VaccinationSchedule {

    private Integer id;
    private Collection<Vaccine> schedule;

    public VaccinationSchedule(Collection<Vaccine> aSchedule) {
        this.schedule = aSchedule;
        /** this.id = metodo para formar un id unico ?? **/
    }

    public Integer getId() {
        return id;
    }

    public Collection<Vaccine> getVaccines() {
        return this.schedule;
    }

    public addVaccine(Vaccine vaccine) {
        schedule.add(vaccine);
    }


}
