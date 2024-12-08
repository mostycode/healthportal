package net.yorksolutions.healthportal.controller;

import net.yorksolutions.healthportal.dto.DoctorDTO;
import net.yorksolutions.healthportal.entity.Doctor;
import net.yorksolutions.healthportal.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:5173")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return this.doctorService.getAllDoctors();
    }

    @GetMapping("/s")
    public List<Doctor> getDoctorsBySpecializationId(@RequestParam Long id) {
        return this.doctorService.getDoctorsBySpecialization(id);
    }

    @PostMapping("/create")
    public Doctor addDoctor(@RequestBody DoctorDTO doctorDTO) {
        return this.doctorService.addDoctor(doctorDTO);
    }

//    public Doctor updateDoctor(@RequestBody DoctorDTO doctorDTO) {}

    @DeleteMapping("/del/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        this.doctorService.deleteDoctor(id);
    }
}
