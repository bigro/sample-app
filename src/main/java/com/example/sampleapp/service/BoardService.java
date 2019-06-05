package com.example.sampleapp.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    List<String> messages = new ArrayList<>();
    
    public void add(String message) {
        messages.add(message);
    }
    
    public List<String> allMessages() {
        return messages;
    }
}
