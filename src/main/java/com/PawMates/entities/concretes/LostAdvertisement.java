package com.PawMates.entities.concretes;

import com.PawMates.entities.concretes.Advertisement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "lost_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LostAdvertisement   extends Advertisement {

    @Column(name = "last_seen_date")
    private LocalDate lastSeenDate;

    @Column(name = "last_seen_location")
    private String lastSeenLocation;

    // Constructor, getters, and setters
}
