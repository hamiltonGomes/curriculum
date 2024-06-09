package com.hamiltonGomes.curriculum.controller;

import com.hamiltonGomes.curriculum.dto.AcademicEducationDto;
import com.hamiltonGomes.curriculum.dto.CurriculumDto;
import com.hamiltonGomes.curriculum.dto.HardSkillsDto;
import com.hamiltonGomes.curriculum.dto.ProfessionalExperienceDto;
import com.hamiltonGomes.curriculum.entity.Curriculum;
import com.hamiltonGomes.curriculum.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    private final CurriculumService curriculumService;

    @Autowired
    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    @PostMapping("/")
    public ResponseEntity<Curriculum> createCurriculum(@RequestBody CurriculumDto curriculumDto) {
        Curriculum createdCurriculum = curriculumService.createCurriculum(curriculumDto);
        return ResponseEntity.ok(createdCurriculum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> updateCurriculum(@PathVariable Long id, @RequestBody CurriculumDto curriculumDto) {
        Curriculum updatedCurriculum = curriculumService.updateCurriculum(id, curriculumDto);
        return ResponseEntity.ok(updatedCurriculum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculum(@PathVariable Long id) {
        curriculumService.deleteCurriculum(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getCurriculumById(@PathVariable Long id) {
        Curriculum curriculum = curriculumService.getCurriculumById(id);
        return ResponseEntity.ok(curriculum);
    }

    @GetMapping("/")
    public ResponseEntity<List<Curriculum>> getAllCurriculums() {
        List<Curriculum> curriculums = curriculumService.getAllCurriculums();
        return ResponseEntity.ok(curriculums);
    }

    @PostMapping("/{id}/add-academic-education")
    public ResponseEntity<Curriculum> addAcademicFormation(@PathVariable Long id, @RequestBody AcademicEducationDto academicEducationDto) {
        Curriculum updatedCurriculum = curriculumService.addAcademicFormation(id, academicEducationDto);
        return ResponseEntity.ok(updatedCurriculum);
    }

    @PostMapping("/{id}/add-hard-skill")
    public ResponseEntity<Curriculum> addHardSkill(@PathVariable Long id, @RequestBody HardSkillsDto hardSkillsDto) {
        Curriculum updatedCurriculum = curriculumService.addHardSkill(id, hardSkillsDto);
        return ResponseEntity.ok(updatedCurriculum);
    }

    @PostMapping("/{id}/add-professional-experience")
    public ResponseEntity<Curriculum> addProfessionalExperience(@PathVariable Long id, @RequestBody ProfessionalExperienceDto professionalExperienceDto) {
        Curriculum updatedCurriculum = curriculumService.addProfessionalExperience(id, professionalExperienceDto);
        return ResponseEntity.ok(updatedCurriculum);
    }
}
