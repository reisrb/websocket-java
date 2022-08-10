package com.example.websocketexample.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.websocketexample.domain.MessageDto;
import com.example.websocketexample.service.WebSocketService;

@RestController
@RequestMapping("/notification")
public class WebSocketController {

  @Autowired
  private WebSocketService webSocketService;
  
  @PostMapping
  @CrossOrigin
  public void sendMessage(@RequestBody MessageDto messageDto){
    webSocketService.sendMessage(messageDto);
  }

}
