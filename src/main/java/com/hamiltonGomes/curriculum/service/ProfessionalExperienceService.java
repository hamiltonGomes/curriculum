package com.hamiltonGomes.curriculum.service;

import com.hamiltonGomes.curriculum.entity.ProfessionalExperience;
import com.hamiltonGomes.curriculum.exception.ObjectNotFound;
import com.hamiltonGomes.curriculum.repository.ProfessionalExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalExperienceService {

    private final ProfessionalExperienceRepository professionalExperienceRepository;

    @Autowired
    public ProfessionalExperienceService(ProfessionalExperienceRepository professionalExperienceRepository) {
        this.professionalExperienceRepository = professionalExperienceRepository;
    }

    public ProfessionalExperience updateProfessionalExperience(Long id, ProfessionalExperience professionalExperience) {
        var existingProfessionalExperience = professionalExperienceRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Professional experience not found with id: " + id));

        var updatedProfessionalExperience = updateData(existingProfessionalExperience, professionalExperience);

        return professionalExperienceRepository.save(updatedProfessionalExperience);
    }

    public void deleteProfessionalExperience(Long id) {
        var professionalExperience = professionalExperienceRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Professional experience not found with id: " + id));
        professionalExperienceRepository.delete(professionalExperience);
    }

    public ProfessionalExperience getProfessionalExperienceById(Long id) {
        return professionalExperienceRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Professional experience not found with id: " + id));
    }

    public List<ProfessionalExperience> getAllProfessionalExperiences() {
        var professionalExperiences = professionalExperienceRepository.findAll();

        if (professionalExperiences.isEmpty()) {
            throw new ObjectNotFound("No professional experiences found");
        }

        return professionalExperiences;
    }

    private ProfessionalExperience updateData(ProfessionalExperience existingProfessionalExperience, ProfessionalExperience newProfessionalExperience) {
        existingProfessionalExperience.setDescription(newProfessionalExperience.getDescription());

        return existingProfessionalExperience;
    }
}
