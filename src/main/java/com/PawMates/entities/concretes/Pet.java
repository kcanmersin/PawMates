package com.PawMates.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // Establishing the Many-To-One relationship
    @JoinColumn(name = "pet_type_id") // This column will hold the foreign key to PetType
    private PetType type; // Changing from String type to PetType

    @Column(name = "breed") // Irk
    private String breed;

    @Column(name = "age")
    private String age;

    // @Column(name="location") // Commented out for brevity
    // private String location;

    @Column(name = "gender") // Cinsiyet
    private String gender;
}
