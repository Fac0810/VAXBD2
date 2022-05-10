package ar.edu.unlp.info.bd2.model;
import java.util.Collection;
import javax.persistence.*;

@Entity
@DiscriminatorValue("NURSE")
public class Nurse extends Personal{

    @Column(name= "experience")
    private Integer experience;

    public Nurse() {
    }
    public Nurse(String fullName, String dni,  Integer experience) {
        super(fullName, dni);
        this.experience = experience;
    }


}
