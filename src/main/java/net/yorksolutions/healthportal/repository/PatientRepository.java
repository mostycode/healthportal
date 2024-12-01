package net.yorksolutions.healthportal.repository;

import net.yorksolutions.healthportal.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
