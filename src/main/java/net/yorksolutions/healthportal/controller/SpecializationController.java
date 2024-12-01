package net.yorksolutions.healthportal.controller;

import net.yorksolutions.healthportal.entity.Specialization;
import net.yorksolutions.healthportal.service.SpecializationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SpecializationController {

    private SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping("/specializations")
    public List<Specialization> getSpecializations() {
        return this.specializationService.getAllSpecializations();
    }
}
