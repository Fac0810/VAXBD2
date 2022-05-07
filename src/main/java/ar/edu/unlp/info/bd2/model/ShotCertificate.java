package ar.edu.unlp.info.bd2.model;

import java.time.LocalDate;
import java.lang.Math;

public class ShotCertificate {

	private Long id;
	private LocalDate fecha;
	private Double numSerie;
	
	public ShotCertificate() {
		this.fecha= LocalDate.now();
		this.numSerie = Math.random();
	}
	
    public Long getId() {
    	return this.id;
    }
	
	public Double getNumSerie() {
		return this.numSerie;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
}
