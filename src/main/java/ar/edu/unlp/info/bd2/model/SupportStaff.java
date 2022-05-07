package ar.edu.unlp.info.bd2.model;
import java.util.Collection;
import javax.persistence.*;
@Entity
@Table ( name  = "supportStaff")
@DiscriminatorValue("2")
public class SupportStaff extends Personal{
    @Column(name = "area")
    private String area;

    public SupportStaff() {
    }

    public SupportStaff(String nombreCompleto, String dni, Collection<Centre> centros, String area) {
        super(nombreCompleto, dni, centros);
        this.area = area;
    }

}
