package ar.edu.unlp.info.bd2.model;
import java.util.Collection;
public class Nurse extends Personal{
    private Integer experience;

    public Nurse(String fullName, String dni, Collection<Centre> centres, Integer experience) {
        super(fullName, dni, centres);
        this.experience = experience;
    }
}
