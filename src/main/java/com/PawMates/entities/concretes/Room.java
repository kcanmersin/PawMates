package com.PawMates.entities.concretes;

import com.PawMates.authorization.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rooms")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "topic",length = 50, nullable = false)
    private String topic;

    @Column(name = "description",length = 5000, nullable = false)
    private String description;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated = new Date();

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.CreationTimestamp
    private Date created;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments ;

    // Constructors, Getters, and Setters
}
