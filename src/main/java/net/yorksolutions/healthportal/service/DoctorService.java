package net.yorksolutions.healthportal.service;

import net.yorksolutions.healthportal.dto.DoctorDTO;
import net.yorksolutions.healthportal.entity.Appointment;
import net.yorksolutions.healthportal.entity.Doctor;
import net.yorksolutions.healthportal.entity.Specialization;
import net.yorksolutions.healthportal.repository.AppointmentRepository;
import net.yorksolutions.healthportal.repository.DoctorRepository;
import net.yorksolutions.healthportal.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final SpecializationRepository specializationRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository,
                         SpecializationRepository specializationRepository,
                         AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.specializationRepository = specializationRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<Doctor> getAllDoctors() {
        return this.doctorRepository.findAll();
    }

    public List<Doctor> getDoctorsBySpecialization(Long specializationId) {
        return this.doctorRepository.findBySpecializationId(specializationId);
    }

    public Doctor addDoctor(DoctorDTO doctorDTO) {
        Optional<Specialization> specializationOptional = specializationRepository.findById(doctorDTO.getSpecializationId());
        if (specializationOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specialization Not Found");
        }

        Doctor doctor = new Doctor(
                doctorDTO.getFirstName(),
                doctorDTO.getLastName(),
                specializationOptional.get()
        );

        return this.doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(id);
        this.appointmentRepository.deleteAll(appointments);
        this.doctorRepository.deleteById(id);
    }
}

