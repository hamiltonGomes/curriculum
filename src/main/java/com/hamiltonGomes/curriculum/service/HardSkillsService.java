package com.hamiltonGomes.curriculum.service;

import com.hamiltonGomes.curriculum.entity.HardSkills;
import com.hamiltonGomes.curriculum.exception.ObjectNotFound;
import com.hamiltonGomes.curriculum.repository.HardSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardSkillsService {

    private final HardSkillsRepository hardSkillsRepository;

    @Autowired
    public HardSkillsService(HardSkillsRepository hardSkillsRepository) {
        this.hardSkillsRepository = hardSkillsRepository;
    }

    public HardSkills updateHardSkills(Long id, HardSkills hardSkills) {
        var existingHardSkills = hardSkillsRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Hard skill not found with id: " + id));

        var updatedHardSkills = updateData(existingHardSkills, hardSkills);

        return hardSkillsRepository.save(updatedHardSkills);
    }

    public void deleteHardSkills(Long id) {
        var hardSkills = hardSkillsRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Hard skill not found with id: " + id));
        hardSkillsRepository.delete(hardSkills);
    }

    public HardSkills getHardSkillsById(Long id) {
        return hardSkillsRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Hard skill not found with id: " + id));
    }

    public List<HardSkills> getAllHardSkills() {
        var hardSkillsList = hardSkillsRepository.findAll();

        if (hardSkillsList.isEmpty()) {
            throw new ObjectNotFound("No hard skills found");
        }

        return hardSkillsList;
    }


    private HardSkills updateData(HardSkills existingHardSkills, HardSkills newHardSkills) {
        existingHardSkills.setName(newHardSkills.getName());

        return existingHardSkills;
    }
}
