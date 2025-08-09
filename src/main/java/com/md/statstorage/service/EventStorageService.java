package com.md.statstorage.service;


import com.md.statstorage.entity.EventEntity;
import com.md.statstorage.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventStorageService {

    // Create private instanc of our repository
    private final EventRepository repository;

    public EventStorageService(EventRepository repository) {
        this.repository = repository;
    }

    // This is automatically implemented by the JpaRepository
    // I could implement in the repository to only allow certain methods
    public void saveEvent(EventEntity event) {
        repository.save(event);
    }
}