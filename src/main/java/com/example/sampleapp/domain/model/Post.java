package com.example.sampleapp.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Post {
    String id;
    String title;
    String message;
    LocalDateTime time;

    public Post(String title, String message, LocalDateTime time) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.message = message;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeAsText() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return time.format(dateTimeFormatter);
    }
}
