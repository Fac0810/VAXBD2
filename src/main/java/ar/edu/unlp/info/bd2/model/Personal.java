package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.Collection;
@Entity( name  = "personal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personal_type", discriminatorType = DiscriminatorType.STRING)
public class Personal {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column( name = "fullName")
    private String fullName;
    @Column( name = "dni")
    private String dni;
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "staff")
    private Collection<Centre> centres;

    public Personal() {
    }

    public Personal(String fullName, String dni) {
        this.fullName = fullName;
        this.dni = dni;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
