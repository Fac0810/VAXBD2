package ar.edu.unlp.info.bd2.model;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table ( name  = "nurse")
@DiscriminatorValue("3")
public class Nurse extends Personal{
    @Column(name= "experience")
    private Integer experience;

    public Nurse() {
    }
    public Nurse(String fullName, String dni, Collection<Centre> centres, Integer experience) {
        super(fullName, dni, centres);
        this.experience = experience;
    }


}
