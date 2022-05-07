package ar.edu.unlp.info.bd2.model;

import java.util.Date;

public class Shot {

	private Long id;
	private Patient patient;
	private Vaccine vaccine;
	private Date date;
	private Centre centre;
	private Nurse nurse;
	private ShotCertificate certificate;
	
    public Shot(Patient aPatient, Vaccine aVaccine, Date aDate, Centre aCentre, Nurse aNurse) {
        this.patient= aPatient;
        this.vaccine= aVaccine;
        this.date= aDate;
        this.centre= aCentre;
        this.nurse= aNurse;
        this.certificate= new ShotCertificate(date);
        this.patient.addShot(this);
    }
    
    public Long getId() {
    	return this.id;
    }
    
    public Patient getPatient() {
    	return this.patient;
    }
	
    public Vaccine getVaccine() {
    	return this.vaccine;
    }
    
    public Date getDate() {
    	return this.date;
    }
    
    
    public Centre getCentre() {
    	return this.centre;
    }
    
    public Nurse getNurse() {
    	return this.nurse;
    }
    
    public ShotCertificate getShotCertificate() {
    	return this.certificate;
    }
    
     
    
}

