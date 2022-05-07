package ar.edu.unlp.info.bd2.model;

import java.util.Date;
import java.lang.Math;

public class ShotCertificate {

	private Long id;
	private Date fecha;
	private Double numSerie;
	
	public ShotCertificate(Date fecha) {
		this.fecha= fecha;
		this.numSerie = Math.random();
	}
	
    public Long getId() {
    	return this.id;
    }
	
	public Double getSerialNumber() {
		return this.numSerie;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
}
