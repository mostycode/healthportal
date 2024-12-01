package net.yorksolutions.healthportal.service;

import net.yorksolutions.healthportal.entity.Doctor;
import net.yorksolutions.healthportal.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return this.doctorRepository.findAll();
    }

    public List<Doctor> getDoctorsBySpecialization(Long specializationId) {
        return this.doctorRepository.findBySpecializationId(specializationId);
    }
}

