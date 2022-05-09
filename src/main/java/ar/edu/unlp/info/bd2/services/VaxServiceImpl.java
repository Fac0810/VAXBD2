package ar.edu.unlp.info.bd2.services;
import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;

import java.util.*;


public class VaxServiceImpl implements VaxService{
    private VaxRepository repository;

    public VaxServiceImpl(VaxRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
    	Patient patient = new Patient(email, fullname, password, dayOfBirth);
    	try {
    		repository.save(patient);
    	}
    	catch(Exception e){
    		throw new VaxException("Constraint Violation");
    	}
        return patient;
    }

    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        Vaccine vaccine = new Vaccine(name);
        try {
            repository.save(vaccine);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }
        return vaccine;
    }

    @Override
    public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
    	Shot shot = new Shot(patient, vaccine, date, centre, nurse);
    	try {
    		repository.save(shot);
    	}
    	catch(Exception e){
    		throw new VaxException("Constraint Violation");
    	}
        return shot;
    }

    @Override
    public Optional<Patient> getPatientByEmail(String email) {
    	
        return Optional.empty();
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        return this.repository.getVaccineByName(name);
    }

    @Override
    public Centre createCentre(String name) throws VaxException {
        //Fran
        Centre c = new Centre(name);
        try {
            this.repository.save(c);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }

        return c;
    }

    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        //Fran
        Nurse n = new Nurse(fullName,dni, experience);
        try {
            this.repository.save(n);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }
        return n ;
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        //Fran
        SupportStaff s = new SupportStaff(fullName,dni,area);
        try {
            this.repository.save(s);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }

        return s;
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        ArrayList<Vaccine> vaxList = new ArrayList<Vaccine>();
        VaccinationSchedule vaxSchedule = new VaccinationSchedule(vaxList);
        try {
            repository.save(vaxSchedule);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }
        return vaxSchedule;
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        return this.repository.getVaccinationScheduleByID(id);
    }

    @Override
    public Optional<Centre> getCentreByName(String name) throws VaxException {
        //Fran
        return this.repository.getCentreByName(name);
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        //Fran
        try {
            this.repository.save(staff);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }

        return staff;
    }

    @Override
    public Centre updateCentre(Centre centre){
        this.repository.save(centre);
        return centre;
    }
    //Fran

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {

        return this.repository.getSupportStaffByDni(dni);
    }
    //Fran
}
