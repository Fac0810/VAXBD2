package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import javax.persistence.*;


@Entity(name="Shot")
public class Shot {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Patient patient;

    @ManyToOne
	private Vaccine vaccine;
	
	@Column(name="date")
	private Date date;

    @ManyToOne
	private Centre centre;

    @ManyToOne
	private Nurse nurse;
	
    @OneToOne(cascade = CascadeType.ALL)
	private ShotCertificate certificate;

    public Shot() {
    }

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

