package ar.edu.unlp.info.bd2.model;

import java.time.LocalDate;;

public class Shot {

	private Patient paciente;
	private Vaccine vacuna;
	private LocalDate fecha;
	//private Centre centro;
	//private Nurse aplicante;
	
    public Shot(Patient aPatient, Vaccine aVaccine) {
        this.paciente= aPatient;
        this.vacuna= aVaccine;
        this.fecha= LocalDate.now();
        
        //crea un ShotCertificate
    }
    
    public Patient getPaciente() {
    	return this.paciente;
    }
	
    public Vaccine getVacuna() {
    	return this.vacuna;
    }
    
    public LocalDate getFecha() {
    	return this.fecha;
    }
    
    /*
    public Centre getCentro() {
    	return this.centro;
    }
    
    public Nurse getAplicante() {
    	return this.aplicante
    }
    
     
     */
     
    
}
