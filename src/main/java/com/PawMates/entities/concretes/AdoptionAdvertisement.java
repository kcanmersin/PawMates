package com.PawMates.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adoption_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionAdvertisement extends Advertisement {

    @Column(name = "pet_condition")
    private String petCondition;

    @Column(name = "requirements_for_adoption")
    private String requirementsForAdoption;

    // Constructor, getters, and setters
}