package com.hamiltonGomes.curriculum.dto;

import jakarta.validation.constraints.Email;

public record PersonalInformationDto(
        @Email
        String fullName,
        String email,
        String position,
        String country,
        String state,
        String city
) {
}
