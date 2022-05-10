package ar.edu.unlp.info.bd2.model;
import java.util.Collection;
import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class SupportStaff extends Personal{
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
