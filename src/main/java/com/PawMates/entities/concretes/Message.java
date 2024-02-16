package com.PawMates.entities.concretes;

import com.PawMates.authorization.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender; // Mesajı gönderen kullanıcı

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private User receiver; // Mesajı alan kullanıcı

    @Column(name = "content", columnDefinition = "TEXT")
    private String content; // Mesaj içeriği

    @Column(name = "send_time")
    private LocalDateTime sendTime; // Mesajın gönderildiği zaman

    @Column(name = "is_read")
    private boolean isRead; // Mesajın okunup okunmadığı

    @Column(name = "received_time")
    private LocalDateTime receivedTime;

    @Column(name = "read_time")
    private LocalDateTime readTime;

//    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<MessageAttachment> attachments;

}
