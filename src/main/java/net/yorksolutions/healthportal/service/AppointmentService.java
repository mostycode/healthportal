package net.yorksolutions.healthportal.service;

import net.yorksolutions.healthportal.dto.AppointmentDTO;
import net.yorksolutions.healthportal.entity.Appointment;
import net.yorksolutions.healthportal.entity.Doctor;
import net.yorksolutions.healthportal.entity.Patient;
import net.yorksolutions.healthportal.repository.AppointmentRepository;
import net.yorksolutions.healthportal.repository.DoctorRepository;
import net.yorksolutions.healthportal.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment createAppointment(AppointmentDTO appointmentDTO) {

        Optional<Doctor> doctorOptional = this.doctorRepository.findById(appointmentDTO.getDoctorId());
        if(doctorOptional.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        //find patient obj  by id
        Optional<Patient> patientOptional = this.patientRepository.findById(appointmentDTO.getPatientId());
        if(patientOptional.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        //create appointment object with doc obj & patient obj
        Appointment appointment = new Appointment(
                patientOptional.get(),
                doctorOptional.get(),
                appointmentDTO.getAppointmentDateTime(),
                Appointment.VisitType.valueOf(appointmentDTO.getVisitType()));
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
