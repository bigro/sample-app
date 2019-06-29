package com.example.sampleapp.domain.model;

public class Account {
    private String name;

    public Account() {
    }

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

    public void setName(String name) {
        this.name = name;
    }
}
