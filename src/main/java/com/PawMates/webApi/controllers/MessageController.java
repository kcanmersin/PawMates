package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.MessageService;
import com.PawMates.business.messages.requests.CreateMessageRequest;
import com.PawMates.business.messages.requests.UpdateMessageRequest;
import com.PawMates.business.messages.responses.GetAllMessagesResponse;
import com.PawMates.business.messages.responses.GetByIdMessageResponse;
import com.PawMates.business.messages.responses.GetMessagesBetweenUsersResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping()
    public List<GetAllMessagesResponse> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public GetByIdMessageResponse getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id); // Bu kısım getById metodunun parametresine göre düzeltilmeli
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessage(@RequestBody @Valid CreateMessageRequest createMessageRequest) {
        messageService.createMessage(createMessageRequest);
    }

    @PutMapping("/{id}")
    public void updateMessage(@PathVariable Long id, @RequestBody @Valid UpdateMessageRequest updateMessageRequest) {
        // ID consistency check can be added here if needed
        updateMessageRequest.setId(id); // Assuming UpdateMessageRequest includes an ID setter
        messageService.updateMessage(updateMessageRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }

    @GetMapping("/between")
    public List<GetMessagesBetweenUsersResponse> getMessagesBetweenUsers(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return messageService.getMessagesBetweenUsers(senderId, receiverId);
    }
    @PatchMapping("/markRead")
    @ResponseStatus(HttpStatus.OK)
    public void markMessagesAsRead(@RequestParam Long senderId, @RequestParam Long receiverId) {
        messageService.markMessagesAsRead(senderId, receiverId);
    }


}
