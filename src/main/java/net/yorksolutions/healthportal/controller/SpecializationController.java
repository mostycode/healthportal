package net.yorksolutions.healthportal.controller;

import net.yorksolutions.healthportal.entity.Specialization;
import net.yorksolutions.healthportal.service.SpecializationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/specializations")
@CrossOrigin(origins = "http://localhost:3000")
public class SpecializationController {

    private SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping()
    public List<Specialization> getSpecializations() {
        return this.specializationService.getAllSpecializations();
    }
}
