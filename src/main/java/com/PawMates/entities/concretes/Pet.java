package com.PawMates.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="type") // Köpek, kedi vb.
    private String type;

    @Column(name="breed") // Irk
    private String breed;

    @Column(name="age")
    private String age;
//
//    @Column(name="location") // Sahiplendirme veya kayıp ilanı için konum
//    private String location;

    @Column(name="gender") // Cinsiyet
    private String gender;
}
