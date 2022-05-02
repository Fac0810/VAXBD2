package ar.edu.unlp.info.bd2.model;
import java.util.Collection;

public class Center {
    private String nombre;
    private Collection<Personal> personal;

    public Center(String nombre, Collection<Personal> personal) {
        this.nombre = nombre;
        this.personal = personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(Collection<Personal> personal) {
        this.personal = personal;
    }
}
