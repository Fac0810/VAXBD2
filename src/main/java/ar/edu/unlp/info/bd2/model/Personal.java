package ar.edu.unlp.info.bd2.model;


import java.util.Collection;

public class Personal {
    private String fullName;
    private String dni;
    private Collection<Centre> centres;

    public Personal(String fullName, String dni, Collection<Centre> centres) {
        this.fullName = fullName;
        this.dni = dni;
        this.centres = centres;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Collection<Centre> getCentres() {
        return centres;
    }

    public void setCentres(Collection<Centre> centres) {
        this.centres = centres;
    }
}
