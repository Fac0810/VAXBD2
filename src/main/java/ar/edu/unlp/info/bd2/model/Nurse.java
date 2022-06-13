package ar.edu.unlp.info.bd2.model;
import javax.persistence.*;

@Entity
@DiscriminatorValue("nurse")
public class Nurse extends Staff {

    @Column(name= "experience")
    private Integer experience;

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Nurse() {
    }
    
    public Nurse(String fullName, String dni,  Integer experience) {
        super(fullName, dni);
        this.experience = experience;
    }


}
