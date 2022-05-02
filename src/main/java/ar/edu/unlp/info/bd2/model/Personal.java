package ar.edu.unlp.info.bd2.model;


import org.springframework.data.annotation.Id;
import java.util.Collection;

public class Personal {
    private String nombreCompleto;
    private Integer dni;
    private Collection<Center> centros;

    public Personal(String nombreCompleto, Integer dni, Collection<Center> centros) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.centros = centros;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Collection<Center> getCentros() {
        return centros;
    }

    public void setCentros(Collection<Center> centros) {
        this.centros = centros;
    }
}
