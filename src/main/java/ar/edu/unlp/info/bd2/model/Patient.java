package ar.edu.unlp.info.bd2.model;

public class Patient {
    private String firstName;
    private String lastName;
    private Integer DNI;

    public Patient(String aFirstName, String aLastName, Integer aDNI) {
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.DNI = aDNI;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public Integer getDNI() {
        return this.DNI;
    }





}
