package com.hamiltonGomes.curriculum.service;

import com.hamiltonGomes.curriculum.entity.AcademicEducation;
import com.hamiltonGomes.curriculum.exception.ObjectNotFound;
import com.hamiltonGomes.curriculum.repository.AcademicEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEducationService {
    private final AcademicEducationRepository academicEducationRepository;

    @Autowired
    public AcademicEducationService(AcademicEducationRepository academicEducationRepository) {
        this.academicEducationRepository = academicEducationRepository;
    }

    public AcademicEducation updateAcademicEducation(Long id, AcademicEducation academicEducation) {
        if (!academicEducationRepository.existsById(id)) {
            throw new ObjectNotFound("Academic education not found with id: " + id);
        }
        academicEducation.setId(id);
        return academicEducationRepository.save(academicEducation);
    }

    public void deleteAcademicEducation(Long id) {
        if (!academicEducationRepository.existsById(id)) {
            throw new ObjectNotFound("Academic education not found with id: " + id);
        }
        academicEducationRepository.deleteById(id);
    }

    public AcademicEducation getAcademicEducationById(Long id) {
        return academicEducationRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Academic education not found with id: " + id));
    }

    public List<AcademicEducation> getAllAcademicEducation() {
        List<AcademicEducation> academicEducations = academicEducationRepository.findAll();
        if (academicEducations.isEmpty()) {
            throw new ObjectNotFound("No academic education found");
        }
        return academicEducations;
    }

}
