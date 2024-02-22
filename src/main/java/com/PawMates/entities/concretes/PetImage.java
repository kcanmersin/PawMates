package com.PawMates.entities.concretes;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "pet_images")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Lob
    @Column(name = "image")
    private byte[] image;


}
