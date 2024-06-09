package com.hamiltonGomes.curriculum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hamiltonGomes.curriculum.dto.HardSkillsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "hard_skills")
@NoArgsConstructor
@AllArgsConstructor
public class HardSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    @JsonBackReference
    private Curriculum curriculum;

    public HardSkills(HardSkillsDto hardSkillsDto) {
        this.name = hardSkillsDto.name();
    }
}
