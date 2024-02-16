package com.PawMates.business.messages.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMessageRequest {

    private Long senderId; // Mesajı gönderen kullanıcının ID'si
    private Long receiverId; // Mesajın gönderileceği kullanıcının ID'si
    private String content; // Gönderilecek mesajın içeriği
}