package com.PawMates.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "advertisement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets; // Represent multiple pets associated with an advertisement

    @Column(name = "phone_number")
    private String phoneNumber; // İletişim bilgisi olarak telefon numarası

    @Column(name = "email")
    private String email; // İletişim bilgisi olarak email

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address; // Her ilanın bir adresi olabilir

    @Column(name = "created_date")
    private LocalDateTime createdDate; // İlanın oluşturulma zamanı

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}
