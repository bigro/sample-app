package com.example.sampleapp.domain.model;

public interface AccountRepository {
    
    void register(Account account);
    
    boolean exists(Account account);
}
