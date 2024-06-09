package com.hamiltonGomes.curriculum.repository;

import com.hamiltonGomes.curriculum.entity.AcademicEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicEducationRepository extends JpaRepository<AcademicEducation, Long> {
}
