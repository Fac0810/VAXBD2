package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
public class Vaccine {

    private String name;

    @Id
    @GeneratedValue
    private Long id;

    public Vaccine() {
    }

    public Vaccine(String aName) {
        this.name = aName;
    }

    @Column(name="ID")
    public Long getId() {
        return this.id;
    }

    @Column(name="Name")
    public String getName() {
        return this.name;
    }



}
