package com.example.sampleapp.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Post {
    String id;
    String title;
    String message;
    LocalDateTime time;
    Account account;

    public Post(String title, String message, LocalDateTime time, Account account) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.message = message;
        this.time = time;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public String getTimeAsText() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return time.format(dateTimeFormatter);
    }
}
