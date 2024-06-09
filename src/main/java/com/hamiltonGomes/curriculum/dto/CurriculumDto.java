package com.hamiltonGomes.curriculum.dto;

import jakarta.validation.Valid;

import java.util.List;

public record CurriculumDto(
        PersonalInformationDto personalInformation,
        @Valid
        List<AcademicEducationDto> academicEducations,
        @Valid
        List<ProfessionalExperienceDto> professionalExperiences,
        @Valid
        List<HardSkillsDto> hardSkills
) {
}
