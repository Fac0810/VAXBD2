package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue
    private Long id;
	
    private String name;


    public Vaccine() {
    }

    public Vaccine(String aName) {
        this.name = aName;
    }

    
    public Long getId() {
        return this.id;
    }

    
    public String getName() {
        return this.name;
    }



}
