package com.example.sampleapp.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private int id;
    private String title;
    private String message;
    private LocalDateTime time;
    private Account account;
    
    private static int seq = 1;

    public Post(String title, String message, LocalDateTime time, Account account) {
        this.id = seq;
        this.title = title;
        this.message = message;
        this.time = time;
        this.account = account;
        seq++;
    }

    public int getId() {
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
