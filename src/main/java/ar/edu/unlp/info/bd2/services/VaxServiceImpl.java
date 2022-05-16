package ar.edu.unlp.info.bd2.services;
import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class VaxServiceImpl implements VaxService{
    private VaxRepository repository;

    public VaxServiceImpl(VaxRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {

        if (this.repository.getPatienteByEmail(email) != null) {
            throw new VaxException("Constraint Violation");
        }
        Patient patient = new Patient(email, fullname, password, dayOfBirth);
        repository.save(patient);

        return patient;
        /*Patient patient = new Patient(email, fullname, password, dayOfBirth);
        try {
            repository.save(patient);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }
        return patient;*/
    }

    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        if (this.repository.getVaccineByName(name).isPresent()) {
            throw new VaxException("Constraint Violation");
        }

        Vaccine vaccine = new Vaccine(name);
        repository.save(vaccine);

        return vaccine;
        /*Vaccine vaccine = new Vaccine(name);
        try {
            repository.save(vaccine);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }
        return vaccine;*/
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
    	
        return this.repository.getPatientByEmail(email);
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        return this.repository.getVaccineByName(name);
    }

    @Override
    public Centre createCentre(String name) throws VaxException {
        if (this.repository.getCentreByName(name).isPresent()){
            throw new VaxException("Constraint Violation");

        }
        Centre c = new Centre(name);
        this.repository.save(c);
        return c;
    }

    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        //Fran

        if (this.repository.getNurseByDni(dni) != null ){
            throw new VaxException("Constraint Violation");
        }
        Nurse n = new Nurse(fullName,dni, experience);
        this.repository.save(n);
        return n ;
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        //Fran
        if (this.repository.getSupportStaffByDni(dni).isPresent()){
            throw new VaxException("Constraint Violation");
        }
        SupportStaff s = new SupportStaff(fullName,dni,area);
        this.repository.save(s);
        return s;
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {

        VaccinationSchedule vaxSchedule = new VaccinationSchedule();
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

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return this.repository.getNurseWithMoreThanNYearsExperience(years);
        //fran
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        return repository.getCentresTopNStaff(n);
        //fran
    }

    @Override
    public Centre getTopShotCentre() {
        return null;

    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return repository.getNurseNotShot();
        //fran
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        return null;
        //fran
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return repository.getStaffWithName(name);
        //fran
    }

    @Override
    public List<Vaccine> getUnappliedVaccines() {
        return null;
    }

    @Override
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vs) {
        return null;
    }
}
