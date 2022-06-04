package ar.edu.unlp.info.bd2.services;
import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import javax.transaction.Transactional;


public class VaxServiceImpl implements VaxService{
    private VaxRepository repository;

    public VaxServiceImpl(VaxRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {

        if (this.repository.getPatientByEmail(email).isPresent()) {
            throw new VaxException("Constraint Violation");
        }
        Patient patient = new Patient(email, fullname, password, dayOfBirth);
        repository.save(patient);

        return patient;
    }

    @Override
    @Transactional
    public Vaccine createVaccine(String name) throws VaxException {
        if (this.repository.getVaccineByName(name).isPresent()) {
            throw new VaxException("Constraint Violation");
        }

        Vaccine vaccine = new Vaccine(name);
        repository.save(vaccine);

        return vaccine;
    }

    @Override
    @Transactional
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
    @Transactional
    public Centre createCentre(String name) throws VaxException {
        if (this.repository.getCentreByName(name).isPresent()){
            throw new VaxException("Constraint Violation");

        }
        Centre c = new Centre(name);
        this.repository.save(c);
        return c;
    }

    @Override
    @Transactional
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {

        if (this.repository.getNurseByDni(dni) != null ){
            throw new VaxException("Constraint Violation");
        }
        Nurse n = new Nurse(fullName,dni, experience);
        this.repository.save(n);
        return n ;
    }

    @Override
    @Transactional
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        if (this.repository.getSupportStaffByDni(dni).isPresent()){
            throw new VaxException("Constraint Violation");
        }
        SupportStaff s = new SupportStaff(fullName,dni,area);
        this.repository.save(s);
        return s;
    }

    @Override
    @Transactional
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
        return this.repository.getCentreByName(name);
    }

    @Override
    @Transactional
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        try {
            this.repository.save(staff);
        }
        catch(Exception e){
            throw new VaxException("Constraint Violation");
        }

        return staff;
    }

    @Override
    @Transactional
    public Centre updateCentre(Centre centre){
        this.repository.save(centre);
        return centre;
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {

        return this.repository.getSupportStaffByDni(dni);
    }

    @Override
    public List<Patient> getAllPatients() {
        return this.repository.getAllPatients();
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return this.repository.getNurseWithMoreThanNYearsExperience(years);
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        return repository.getCentresTopNStaff(n);
    }

    @Override
    public Centre getTopShotCentre() {
        return repository.getTopShotCentre();

    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return repository.getNurseNotShot();
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        return this.repository.getLessEmployeesSupportStaffArea();
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return repository.getStaffWithName(name);
    }

    @Override
    public List<Vaccine> getUnappliedVaccines() {
        return repository.getUnappliedVaccines();
    }

    @Override
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
    	return repository.getShotCertificatesBetweenDates(startDate,endDate);
    }

    @Override
    @Transactional
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vs) {
        this.repository.save(vs);
        return vs;
    }
}
