package com.hamiltonGomes.curriculum.controller;

import com.hamiltonGomes.curriculum.entity.PersonalInformation;
import com.hamiltonGomes.curriculum.service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal-information")
public class PersonalInformationController {

    private final PersonalInformationService personalInformationService;

    @Autowired
    public PersonalInformationController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInformation> updatePersonalInformation(@PathVariable Long id, @RequestBody PersonalInformation personalInformation) {
        PersonalInformation updatedPersonalInformation = personalInformationService.updatePersonalInformation(id, personalInformation);
        return ResponseEntity.ok(updatedPersonalInformation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalInformation(@PathVariable Long id) {
        personalInformationService.deletePersonalInformation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInformation> getPersonalInformationById(@PathVariable Long id) {
        PersonalInformation personalInformation = personalInformationService.getPersonalInformationById(id);
        return ResponseEntity.ok(personalInformation);
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonalInformation>> getAllPersonalInformation() {
        List<PersonalInformation> personalInformationList = personalInformationService.getAllPersonalInformation();
        return ResponseEntity.ok(personalInformationList);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<PersonalInformation>> findAllByPosition(@PathVariable String position) {
        List<PersonalInformation> personalInformationList = personalInformationService.findAllByPosition(position);
        return ResponseEntity.ok(personalInformationList);
    }
}
