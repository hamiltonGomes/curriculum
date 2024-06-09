package com.hamiltonGomes.curriculum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hamiltonGomes.curriculum.dto.PersonalInformationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "personal_informations")
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @OneToOne
    @JoinColumn(name = "curriculum_id")
    @JsonBackReference
    private Curriculum curriculum;

    public PersonalInformation(PersonalInformationDto personalInformationDto) {
        this.email = personalInformationDto.email();
        this.fullName = personalInformationDto.fullName();
        this.position = personalInformationDto.position();
        this.city = personalInformationDto.city();
        this.state = personalInformationDto.state();
        this.country = personalInformationDto.country();
    }
}
