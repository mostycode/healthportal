package net.yorksolutions.healthportal.repository;

import net.yorksolutions.healthportal.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);

    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :patientId AND a.doctor.id = :doctorId AND DATE(a.appointmentDateTime) = :appointmentDate")
    List<Appointment> findByPatientIdAndDoctorIdOnDate(Long patientId, Long doctorId, LocalDate appointmentDate);
}
