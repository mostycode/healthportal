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

    public List<Appointment> getAppointmentsByPatientId(@RequestParam Long patientId) {
        return this.appointmentService.getAppointmentsByPatientId(patientId);
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return this.appointmentService.createAppointment(appointmentDTO);
    }
}
