package ar.edu.unlp.info.bd2.model;

import java.util.Date;
import java.util.Collection;
import java.util.ArrayList;

public class Patient {
	
	private Long id;
    private String fullName;
    private String email;
    private String password;
    private Date dob;
    private Collection<Shot> shots;
    

    public Patient(String aEmail, String aFullname, String aPassword, Date aDob) {
        this.fullName = aFullname;
        this.email = aEmail;
        this.password = aPassword;
        this.dob = aDob;
        this.shots = new ArrayList<Shot>();
    }
    
    public Long getId() {
    	return this.id;
    }

    public String getEmail() {
    	return this.email;
    }
    
    public String getFullname() {
    	return this.fullName;
    }
    
    public String getPassword() {
    	return this.password;
    }

    public Date getDayOfBirth() {
    	return this.dob;
    }

    public void addShot(Shot shot) {
    	this.shots.add(shot);
    }
    
    public Collection<Shot> getShots() {
    	return this.shots;
    }


}
