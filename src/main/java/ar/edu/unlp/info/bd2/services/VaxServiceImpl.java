package ar.edu.unlp.info.bd2.services;
import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;

import java.util.Date;
import java.util.Optional;

public class VaxServiceImpl implements VaxService{
    private VaxRepository repository;

    public VaxServiceImpl(VaxRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
        return null;
    }

    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        return null;
    }

    @Override
    public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
        return null;
    }

    @Override
    public Optional<Patient> getPatientByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        return Optional.empty();
    }

    @Override
    public Centre createCentre(String name) throws VaxException {
        //Fran
        Centre c = new Centre(name);
        return this.repository.createCentre();
    }

    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        //Fran
        return null;
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        //Fran
        return null;
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        return null;
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        return null;
    }

    @Override
    public Optional<Centre> getCentreByName(String name) throws VaxException {
        //Fran
        return Optional.empty();
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        //Fran
        return null;
    }

    @Override
    public Centre updateCentre(Centre centre) {

        return null;
    }
    //Fran

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {

        return this.repository.getSupportStaffByDni(dni);
    }
    //Fran
}
