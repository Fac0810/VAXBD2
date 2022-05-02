package ar.edu.unlp.info.bd2.model;
import java.util.Collection;
public class SupportStaff extends Personal{
    private String area;

    public SupportStaff(String nombreCompleto, String dni, Collection<Centre> centros, String area) {
        super(nombreCompleto, dni, centros);
        this.area = area;
    }
}
