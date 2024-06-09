package com.hamiltonGomes.curriculum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hamiltonGomes.curriculum.dto.ProfessionalExperienceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "professional_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    @JsonBackReference
    private Curriculum curriculum;

    public ProfessionalExperience(ProfessionalExperienceDto professionalExperienceDto) {
        this.description = professionalExperienceDto.description();
    }
}
