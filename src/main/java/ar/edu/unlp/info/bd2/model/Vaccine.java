package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vaccine {

    private String name;

    @Id
    private Integer id;

    public Vaccine(String aName) {
        this.name = aName;
    }

    @Column(name="ID")
    public Integer getId() {
        return this.id;
    }

    @Column(name="Name")
    public String getName() {
        return this.name;
    }



}
