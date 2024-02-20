package com.PawMates.business.messages.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMessagesBetweenUsersResponse {

    private Long id; // The ID of the message
    private Long senderId; // The ID of the user who sent the message
    private String senderUsername; // The username of the user who sent the message
    private Long receiverId; // The ID of the user who received the message
    private String receiverUsername; // The username of the user who received the message
    private String content; // The content of the message
    private LocalDateTime sendTime; // The time the message was sent
    private boolean isRead; // Whether the message has been read by the receiver
    // You might also want to include the receivedTime and readTime if those are relevant to your application's logic
}