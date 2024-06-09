package com.hamiltonGomes.curriculum.service;

import com.hamiltonGomes.curriculum.entity.PersonalInformation;
import com.hamiltonGomes.curriculum.exception.ObjectNotFound;
import com.hamiltonGomes.curriculum.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInformationService {

    private final PersonalInformationRepository personalInformationRepository;

    @Autowired
    public PersonalInformationService(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    public PersonalInformation updatePersonalInformation(Long id, PersonalInformation newPersonalInformation) {
        var oldPersonalInformation = personalInformationRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Personal information not found with id: " + id));

        var personalInformation = updateData(oldPersonalInformation, newPersonalInformation);
        return personalInformationRepository.save(personalInformation);
    }

    public void deletePersonalInformation(Long id) {
        personalInformationRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Personal information not found with id: " + id));

        personalInformationRepository.deleteById(id);
    }

    public PersonalInformation getPersonalInformationById(Long id) {
        return personalInformationRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Personal information not found with id: " + id));
    }

    public List<PersonalInformation> getAllPersonalInformation() {
        var personalInformationList = personalInformationRepository.findAll();
        if (personalInformationList.isEmpty()) {
            throw new ObjectNotFound("No personal information found");
        }

        return personalInformationList;
    }

    public List<PersonalInformation> findAllByPosition(String position) {
        var personalInformationList = personalInformationRepository.findAllByPosition(position);

        if (personalInformationList.isEmpty()) {
            throw new ObjectNotFound("No personal information found with the position: " + position);
        }

        return personalInformationList;
    }

    private PersonalInformation updateData(PersonalInformation oldPersonalInformation, PersonalInformation newPersonalInformation) {
        oldPersonalInformation.setFullName(newPersonalInformation.getFullName());
        oldPersonalInformation.setCity(newPersonalInformation.getCity());
        oldPersonalInformation.setState(newPersonalInformation.getState());
        oldPersonalInformation.setEmail(newPersonalInformation.getEmail());
        oldPersonalInformation.setCountry(newPersonalInformation.getCountry());
        oldPersonalInformation.setPosition(newPersonalInformation.getPosition());

        return oldPersonalInformation;
    }
}
