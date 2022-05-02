package ar.edu.unlp.info.bd2.model;

public class SupportStaff extends Personal{
    private string area;

    public SupportStaff(String nombreCompleto, Integer dni, Collection<Center> centros, string area) {
        super(nombreCompleto, dni, centros);
        this.area = area;
    }
}
