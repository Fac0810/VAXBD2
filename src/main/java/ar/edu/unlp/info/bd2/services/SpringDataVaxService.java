package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;



public class SpringDataVaxService implements VaxService{
    @Autowired
    private CentreRepository centreRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private SupportStaffRepository supportStaffRepository;


    @Override
    @Transactional
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
        return null;
    }

    @Override
    @Transactional
    public Vaccine createVaccine(String name) throws VaxException {
        return null;
    }

    @Override
    @Transactional
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
    @Transactional
    public Centre createCentre(String name) throws VaxException {

        return (Centre) this.centreRepository.save(new Centre(name));
    }

    @Override
    @Transactional
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        return (Nurse) this.nurseRepository.save(new Nurse(dni, fullName, experience));
    }

    @Override
    @Transactional
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        return this.supportStaffRepository.save(new SupportStaff(fullName, dni, area));
    }

    @Override
    @Transactional
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        return null;
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        return null;
    }

    @Override
    public Optional<Centre> getCentreByName(String name) throws VaxException {
        return Optional.ofNullable(this.centreRepository.getCentreByName(name));
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        return null;
    }

    @Override
    @Transactional
    public Centre updateCentre(Centre centre) {
        return this.centreRepository.save(centre);
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {

        return Optional.ofNullable(this.supportStaffRepository.getSupportStaffByDni(dni));
    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return null;
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        return null;
    }

    @Override
    public Centre getTopShotCentre() {
        return null;
    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return null;
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        return null;
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return null;
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
    @Transactional
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
        return null;
    }
}
