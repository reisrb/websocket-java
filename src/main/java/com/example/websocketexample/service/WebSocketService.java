package com.example.websocketexample.service;

import com.example.websocketexample.service.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebSocketService {

  private final SimpMessagingTemplate template;
  
  public void sendMessage(MessageDto message) {
    template.convertAndSend("/topic/message", message.getMessage());
  }
}
