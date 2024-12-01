package net.yorksolutions.healthportal.controller;

import net.yorksolutions.healthportal.entity.Doctor;
import net.yorksolutions.healthportal.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return this.doctorService.getAllDoctors();
    }

    @GetMapping("/doctors-{specializationId}")
    public List<Doctor> getDoctorsBySpecialization(@PathVariable Long specializationId) {
        return this.doctorService.getDoctorsBySpecialization(specializationId);
    }
}
