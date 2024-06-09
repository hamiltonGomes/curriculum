package com.hamiltonGomes.curriculum.controller;

import com.hamiltonGomes.curriculum.entity.ProfessionalExperience;
import com.hamiltonGomes.curriculum.service.ProfessionalExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professional-experience")
public class ProfessionalExperienceController {

    private final ProfessionalExperienceService professionalExperienceService;

    @Autowired
    public ProfessionalExperienceController(ProfessionalExperienceService professionalExperienceService) {
        this.professionalExperienceService = professionalExperienceService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalExperience> updateProfessionalExperience(@PathVariable Long id, @RequestBody ProfessionalExperience professionalExperience) {
        ProfessionalExperience updatedProfessionalExperience = professionalExperienceService.updateProfessionalExperience(id, professionalExperience);
        return ResponseEntity.ok(updatedProfessionalExperience);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessionalExperience(@PathVariable Long id) {
        professionalExperienceService.deleteProfessionalExperience(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalExperience> getProfessionalExperienceById(@PathVariable Long id) {
        ProfessionalExperience professionalExperience = professionalExperienceService.getProfessionalExperienceById(id);
        return ResponseEntity.ok(professionalExperience);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProfessionalExperience>> getAllProfessionalExperiences() {
        List<ProfessionalExperience> professionalExperiences = professionalExperienceService.getAllProfessionalExperiences();
        return ResponseEntity.ok(professionalExperiences);
    }
}
