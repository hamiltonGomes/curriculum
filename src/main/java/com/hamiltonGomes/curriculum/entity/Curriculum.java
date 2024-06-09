package com.hamiltonGomes.curriculum.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hamiltonGomes.curriculum.dto.CurriculumDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "curriculums")
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "curriculum")
    @JsonManagedReference
    private PersonalInformation personalInformation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    @JsonManagedReference
    private List<ProfessionalExperience> professionalExperiences;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    @JsonManagedReference
    private List<HardSkills> hardSkills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculum")
    @JsonManagedReference
    private List<AcademicEducation> academicEducations;

    public Curriculum(CurriculumDto curriculumDto) {
        this.personalInformation = new PersonalInformation(curriculumDto.personalInformation());
        personalInformation.setCurriculum(this);
        this.professionalExperiences = curriculumDto.professionalExperiences().stream().map(exp -> {
            ProfessionalExperience professionalExperience = new ProfessionalExperience(exp);
            professionalExperience.setCurriculum(this);
            return professionalExperience;
        }).collect(Collectors.toList());
        this.hardSkills = curriculumDto.hardSkills().stream().map(c -> {
            HardSkills hardSkills = new HardSkills(c);
            hardSkills.setCurriculum(this);
            return hardSkills;
        }).collect(Collectors.toList());
        this.academicEducations = curriculumDto.academicEducations().stream().map(f -> {
            AcademicEducation academicEducation = new AcademicEducation(f);
            academicEducation.setCurriculum(this);
            return academicEducation;
        }).collect(Collectors.toList());
    }

    public void updateFromDto(CurriculumDto curriculumDto) {
        this.setPersonalInformation(new PersonalInformation(curriculumDto.personalInformation()));
    }
}
