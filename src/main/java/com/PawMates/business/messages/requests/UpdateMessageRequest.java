package com.PawMates.business.messages.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMessageRequest {

    private Long id; // Güncellenecek mesajın ID'si
    private String content; // Opsiyonel: Mesaj içeriğinin güncellenmesi durumunda kullanılır
    private boolean isRead; // Mesajın okundu/okunmadı durumunu günceller
}