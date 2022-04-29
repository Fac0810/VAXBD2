package ar.edu.unlp.info.bd2.model;

import java.time.LocalDate;
import java.lang.Math;

public class ShotCertificate {

	private LocalDate fecha;
	private Double numSerie;
	
	public ShotCertificate() {
		this.fecha= LocalDate.now();
		this.numSerie = Math.random();
	}
	
	
}
