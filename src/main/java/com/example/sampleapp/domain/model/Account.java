package com.example.sampleapp.domain.model;

public class Account {
    String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean same(Account account) {
        return this.name.equals(account.name);
    }
    
    public boolean isEmpty() {
        return name == null;
    }

    public String getName() {
        return name;
    }
}
