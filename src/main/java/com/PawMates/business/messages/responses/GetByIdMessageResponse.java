package com.PawMates.business.messages.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdMessageResponse {

    private Long id;
    private Long senderId;
    private String senderUsername; // Gönderen kullanıcının adı
    private Long receiverId;
    private String receiverUsername; // Alıcı kullanıcının adı
    private String content;
    private LocalDateTime sendTime;
    private boolean isRead;
}