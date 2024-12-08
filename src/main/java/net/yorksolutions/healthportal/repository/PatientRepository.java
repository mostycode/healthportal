package net.yorksolutions.healthportal.repository;

import net.yorksolutions.healthportal.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    @Query("SELECT p FROM Patient p WHERE " +
//            "(:firstName IS NULL OR p.firstName = :firstName) AND " +
//            "(:lastName IS NULL OR p.lastName = :lastName) AND " +
//            "(:dateOfBirth IS NULL OR p.dateOfBirth = :dateOfBirth)")
//    List<Patient> findPatients(String firstName, String lastName, LocalDate dateOfBirth);

    List<Patient> findPatientsByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth);

    Patient findPatientByEmail(String email);
}
