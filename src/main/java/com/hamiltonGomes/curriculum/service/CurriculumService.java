package com.hamiltonGomes.curriculum.service;

import com.hamiltonGomes.curriculum.dto.AcademicEducationDto;
import com.hamiltonGomes.curriculum.dto.CurriculumDto;
import com.hamiltonGomes.curriculum.dto.HardSkillsDto;
import com.hamiltonGomes.curriculum.dto.ProfessionalExperienceDto;
import com.hamiltonGomes.curriculum.entity.AcademicEducation;
import com.hamiltonGomes.curriculum.entity.Curriculum;
import com.hamiltonGomes.curriculum.entity.HardSkills;
import com.hamiltonGomes.curriculum.entity.ProfessionalExperience;
import com.hamiltonGomes.curriculum.exception.ObjectNotFound;
import com.hamiltonGomes.curriculum.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;

    @Autowired
    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    public Curriculum createCurriculum(CurriculumDto curriculumDto) {
        Curriculum curriculum = new Curriculum(curriculumDto);
        return curriculumRepository.save(curriculum);
    }

    public Curriculum updateCurriculum(Long id, CurriculumDto curriculumDto) {
        Curriculum curriculum = curriculumRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Curriculum not found with id: " + id));
        curriculum.updateFromDto(curriculumDto);
        return curriculumRepository.save(curriculum);
    }

    public void deleteCurriculum(Long id) {
        curriculumRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Curriculum not found with id: " + id));
        curriculumRepository.deleteById(id);
    }

    public Curriculum getCurriculumById(Long id) {
        return curriculumRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Curriculum not found with id: " + id));
    }

    public List<Curriculum> getAllCurriculums() {
        var curriculums = curriculumRepository.findAll();
        if (curriculums.isEmpty()) {
            throw new ObjectNotFound("No curriculum found");
        }
        return curriculums;
    }


    public Curriculum addAcademicFormation(Long curriculumId, AcademicEducationDto academicEducationDto) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId).orElseThrow(() -> new ObjectNotFound("Curriculum not found with id: " + curriculumId));
        AcademicEducation academicEducation = new AcademicEducation(academicEducationDto);
        academicEducation.setCurriculum(curriculum);
        curriculum.getAcademicEducations().add(academicEducation);
        return curriculumRepository.save(curriculum);
    }

    public Curriculum addHardSkill(Long curriculumId, HardSkillsDto hardSkillsDto) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId).orElseThrow(() -> new ObjectNotFound("Curriculum not found with id: " + curriculumId));
        HardSkills hardSkills = new HardSkills(hardSkillsDto);
        hardSkills.setCurriculum(curriculum);
        curriculum.getHardSkills().add(hardSkills);
        return curriculumRepository.save(curriculum);
    }

    public Curriculum addProfessionalExperience(Long curriculumId, ProfessionalExperienceDto professionalExperienceDto) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId).orElseThrow(() -> new ObjectNotFound("Curriculum not found with id: " + curriculumId));
        ProfessionalExperience professionalExperience = new ProfessionalExperience(professionalExperienceDto);
        professionalExperience.setCurriculum(curriculum);
        curriculum.getProfessionalExperiences().add(professionalExperience);
        return curriculumRepository.save(curriculum);
    }
}
