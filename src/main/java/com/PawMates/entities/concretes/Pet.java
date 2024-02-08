package com.PawMates.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pets")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_type_id")
    private PetType type;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private String age;

    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id") // Bu sütun Pet ile Advertisement arasındaki ilişkiyi belirtir
    private Advertisement advertisement; // Bu Pet'in ait olduğu İlan
}
