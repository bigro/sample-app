package com.example.sampleapp.domain.model;

public class User {
    private Account account;
    private String lastName;
    private String firstName;
    private String gender;
    private String introduce;

    private User(Account account) {
        this.account = account;
    }

    public User(Account account, String lastName, String firstName, String gender, String introduce) {
        this.account = account;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.introduce = introduce;
    }
    
    public static User of(Account account) {
        return new User(account);
    }
    
    public boolean isEmpty() {
        return account == null || account.isEmpty();
    }

    public Account getAccount() {
        return account;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public boolean same(User user) {
        return account.same(user.getAccount());
    }
}
