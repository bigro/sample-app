package com.example.sampleapp.domain.model;

public interface UserRepository {
    
    void register(User user);

    void update(User user);

    User get(Account account);
}
