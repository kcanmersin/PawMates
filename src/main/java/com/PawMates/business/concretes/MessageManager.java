package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.MessageService;
import com.PawMates.business.messages.requests.CreateMessageRequest;
import com.PawMates.business.messages.requests.UpdateMessageRequest;
import com.PawMates.business.messages.responses.GetAllMessagesResponse;
import com.PawMates.business.messages.responses.GetByIdMessageResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.MessageRepository;
import com.PawMates.entities.concretes.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageManager implements MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllMessagesResponse> getAllMessages() {
        List<Message> messages = messageRepository.findAll();
        return messages.stream()
                .map(message -> modelMapperService.forResponse()
                        .map(message, GetAllMessagesResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdMessageResponse getMessageById(Long id) {

        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found for this id :: " + id));
        return modelMapperService.forResponse().map(message, GetByIdMessageResponse.class);
    }

    @Override
    public void createMessage(CreateMessageRequest createMessageRequest) {
        Message message = modelMapperService.forRequest().map(createMessageRequest, Message.class);
        messageRepository.save(message);
    }

    @Override
    public void updateMessage(UpdateMessageRequest updateMessageRequest) {
        Message message = messageRepository.findById(updateMessageRequest.getId())
                .orElseThrow(() -> new RuntimeException("Message not found for this id :: " + updateMessageRequest.getId()));
        message.setContent(updateMessageRequest.getContent());
        message.setRead(updateMessageRequest.isRead());
        messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
