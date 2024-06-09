package com.hamiltonGomes.curriculum.repository;

import com.hamiltonGomes.curriculum.entity.HardSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillsRepository extends JpaRepository<HardSkills, Long> {
}
