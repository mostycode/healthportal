package net.yorksolutions.healthportal.service;

import net.yorksolutions.healthportal.entity.Specialization;
import net.yorksolutions.healthportal.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    private SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
    this.specializationRepository = specializationRepository;
    }

    public List<Specialization> getAllSpecializations() {
        return this.specializationRepository.findAll();
    }

}
