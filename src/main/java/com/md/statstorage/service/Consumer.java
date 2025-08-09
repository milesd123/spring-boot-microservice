package com.md.statstorage.service;


import com.md.statstorage.entity.EventEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final EventStorageService storageService;
    private final ObjectMapper objectMapper;

    public Consumer(EventStorageService storageService) {
        this.storageService = storageService;
        this.objectMapper = new ObjectMapper();
    }

    @RabbitListener(queues = "discord.events") // Must match queue name in RabbitMQ config
    public void receiveMessage(String messageJson) {
        try {

            // Saves json message to our EventEntity
            // Note: The messageJson and EventEntity must share the same variable names
            EventEntity event = objectMapper.readValue(messageJson, EventEntity.class);
            storageService.saveEvent(event);
            System.out.println("Saved event: " + event.getMatchId());
        } catch (Exception e) {
            System.err.println("Failed to parse or save event: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
