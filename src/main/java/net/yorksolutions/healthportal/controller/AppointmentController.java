package net.yorksolutions.healthportal.controller;

import net.yorksolutions.healthportal.dto.AppointmentDTO;
import net.yorksolutions.healthportal.entity.Appointment;
import net.yorksolutions.healthportal.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping
    public List<Appointment> getAppointments() {

        return this.appointmentService.getAppointments();
    }

    @GetMapping("/patient")
    public List<Appointment> getAppointmentsByPatientId(@RequestParam Long id) {
        return this.appointmentService.getAppointmentsByPatientId(id);
    }

    @GetMapping("/doctor")
    public List<Appointment> getAppointmentsByDoctorId(@RequestParam Long id) {
        return this.appointmentService.getAppointmentsByDoctorId(id);
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return this.appointmentService.createAppointment(appointmentDTO);
    }

    @PutMapping("/edit/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        return this.appointmentService.updateAppointment(id, appointmentDTO);
    }

    @PutMapping("/cancel/{id}")
    public Appointment cancelAppointment(@PathVariable Long id) {
        return this.appointmentService.cancelAppointment(id);
    }
}
