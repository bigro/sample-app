package com.example.sampleapp.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    String message;
    LocalDateTime time;

    public Post(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeAsText() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return time.format(dateTimeFormatter);
    }
}
