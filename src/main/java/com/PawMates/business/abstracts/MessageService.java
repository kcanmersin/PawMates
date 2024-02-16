package com.PawMates.business.abstracts;



import com.PawMates.business.messages.requests.CreateMessageRequest;
import com.PawMates.business.messages.requests.UpdateMessageRequest;
import com.PawMates.business.messages.responses.GetAllMessagesResponse;
import com.PawMates.business.messages.responses.GetByIdMessageResponse;

import java.util.List;

public interface MessageService {
    List<GetAllMessagesResponse> getAllMessages();
    GetByIdMessageResponse getMessageById(Long id);
    void createMessage(CreateMessageRequest createMessageRequest);
    void updateMessage(UpdateMessageRequest updateMessageRequest);
    void deleteMessage(Long id);
}
