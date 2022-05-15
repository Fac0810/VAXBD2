package ar.edu.unlp.info.bd2.model;
import javax.persistence.*;

@Entity
@DiscriminatorValue("supportstaff")
public class SupportStaff extends Staff {
    @Column(name = "area")
    private String area;



    public SupportStaff() {
    }

    public SupportStaff(String nombreCompleto, String dni, String area) {
        super(nombreCompleto, dni);
        this.area = area;
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
