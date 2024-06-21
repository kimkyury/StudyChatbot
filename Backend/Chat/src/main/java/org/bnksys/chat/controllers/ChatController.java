package org.bnksys.chat.controllers;

import org.bnksys.chat.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload String message) {
        kafkaProducer.sendMessage("chat", message);
    }
}
