package com.hamiltonGomes.curriculum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hamiltonGomes.curriculum.dto.AcademicEducationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "academic_educations")
@NoArgsConstructor
@AllArgsConstructor
public class AcademicEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String institution;

    @Column(nullable = false)
    private String startDate;

    private String endDate;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    @JsonBackReference
    private Curriculum curriculum;

    public AcademicEducation(AcademicEducationDto academicEducationDto) {
        this.course = academicEducationDto.course();
        this.institution = academicEducationDto.institution();
        this.startDate = academicEducationDto.startDate();
        this.endDate = academicEducationDto.endDate();
    }
}
