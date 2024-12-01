package net.yorksolutions.healthportal.repository;

import net.yorksolutions.healthportal.entity.Doctor;
import net.yorksolutions.healthportal.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecializationId(Long specializationId);
}
