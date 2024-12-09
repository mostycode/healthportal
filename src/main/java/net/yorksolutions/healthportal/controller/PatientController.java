package net.yorksolutions.healthportal.controller;

import net.yorksolutions.healthportal.entity.Patient;
import net.yorksolutions.healthportal.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return this.patientService.getAllPatients();
    }

    @GetMapping("/e")
    public Patient findPatientByEmail(@RequestParam String email) {
        return this.patientService.findPatientByEmail(email);
    }

    @GetMapping("/search")
    public List<Patient> searchPatients(@RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam LocalDate dateOfBirth) {
        return this.patientService.searchPatients(firstName, lastName, dateOfBirth);
    }


    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        System.out.println("request received: " + patient);
        return patientService.addPatient(patient);
    }

}
