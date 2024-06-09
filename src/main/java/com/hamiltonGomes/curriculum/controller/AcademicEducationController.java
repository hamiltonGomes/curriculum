package com.hamiltonGomes.curriculum.controller;

import com.hamiltonGomes.curriculum.entity.AcademicEducation;
import com.hamiltonGomes.curriculum.service.AcademicEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic-education")
public class AcademicEducationController {

    private final AcademicEducationService academicEducationService;

    @Autowired
    public AcademicEducationController(AcademicEducationService academicEducationService) {
        this.academicEducationService = academicEducationService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicEducation> updateAcademicEducation(@PathVariable Long id, @RequestBody AcademicEducation academicEducation) {
        AcademicEducation updatedAcademicEducation = academicEducationService.updateAcademicEducation(id, academicEducation);
        return ResponseEntity.ok(updatedAcademicEducation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicEducation(@PathVariable Long id) {
        academicEducationService.deleteAcademicEducation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicEducation> getAcademicEducationById(@PathVariable Long id) {
        AcademicEducation academicEducation = academicEducationService.getAcademicEducationById(id);
        return ResponseEntity.ok(academicEducation);
    }

    @GetMapping("/")
    public ResponseEntity<List<AcademicEducation>> getAllAcademicEducation() {
        List<AcademicEducation> academicEducations = academicEducationService.getAllAcademicEducation();
        return ResponseEntity.ok(academicEducations);
    }
}
