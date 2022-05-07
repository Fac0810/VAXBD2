package ar.edu.unlp.info.bd2.model;

public class Patient {
	
	private Long id;
    private String firstName;
    private String lastName;
    private Integer DNI;

    public Patient(String aFirstName, String aLastName, Integer aDNI) {
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.DNI = aDNI;
    }
    
    public Long getId() {
    	return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getFullname() {
    	return this.lastName+" "+this.firstName;
    }
    
    public Integer getDNI() {
        return this.DNI;
    }





}
