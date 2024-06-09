package com.hamiltonGomes.curriculum.repository;

import com.hamiltonGomes.curriculum.entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {
    List<PersonalInformation> findAllByPosition(String position);
}
