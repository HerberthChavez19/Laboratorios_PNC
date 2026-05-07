package com.example.ejercicioevaluado02_pnc.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Wizard")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "wizardName")
    private String name;

    @Column(name = "wizardhouse")
    private String house;

    @Column(name = "wizardPatronus")
    private String patronus;

    @Column(name = "wizardFan")
    private Boolean isDeatheater;
}

