package com.hamiltonGomes.curriculum.controller;

import com.hamiltonGomes.curriculum.entity.HardSkills;
import com.hamiltonGomes.curriculum.service.HardSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hard-skills")
public class HardSkillsController {

    private final HardSkillsService hardSkillsService;

    @Autowired
    public HardSkillsController(HardSkillsService hardSkillsService) {
        this.hardSkillsService = hardSkillsService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardSkills> updateHardSkills(@PathVariable Long id, @RequestBody HardSkills hardSkills) {
        HardSkills updatedHardSkills = hardSkillsService.updateHardSkills(id, hardSkills);
        return ResponseEntity.ok(updatedHardSkills);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardSkills(@PathVariable Long id) {
        hardSkillsService.deleteHardSkills(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardSkills> getHardSkillsById(@PathVariable Long id) {
        HardSkills hardSkills = hardSkillsService.getHardSkillsById(id);
        return ResponseEntity.ok(hardSkills);
    }

    @GetMapping("/")
    public ResponseEntity<List<HardSkills>> getAllHardSkills() {
        List<HardSkills> hardSkillsList = hardSkillsService.getAllHardSkills();
        return ResponseEntity.ok(hardSkillsList);
    }
}
