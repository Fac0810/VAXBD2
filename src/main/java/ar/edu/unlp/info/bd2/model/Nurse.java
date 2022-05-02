package ar.edu.unlp.info.bd2.model;

public class Nurse extends Personal{
    private Integer experience;

    public Nurse(String nombreCompleto, Integer dni, Collection<Center> centros, Integer experience) {
        super(nombreCompleto, dni, centros);
        this.experience = experience;
    }
}
