package com.PawMates.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country; // Ülke

    @Column(name = "city")
    private String city; // Şehir

    @Column(name = "district")
    private String district; // İlçe

    @Column(name = "neighborhood")
    private String neighborhood; // Mahalle

    @Column(name = "street")
    private String street; // Cadde

    @Column(name = "street2")
    private String street2; // Sokak

    @Column(name = "building_number")
    private String buildingNumber; // Bina No

    @Column(name = "floor")
    private String floor; // Kat

    @Column(name = "apartment_number")
    private String apartmentNumber; // Daire No

    @Column(name = "additional_info")
    private String additionalInfo; // Adres Tarifi

    @Column(name = "zip_code")
    private String zipCode; // Posta Kodu

    @Embedded
    private Location location; // Lokasyon bilgisi

    // Constructors, Getters, and Setters
}
