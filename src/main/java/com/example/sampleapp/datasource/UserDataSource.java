package com.example.sampleapp.datasource;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.model.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDataSource implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public void register(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        for (User registeredUser : users) {
            if(registeredUser.same(user)) {
                registeredUser.setAccount(user.getAccount());
                registeredUser.setLastName(user.getLastName());
                registeredUser.setFirstName(user.getFirstName());
                registeredUser.setGender(user.getGender());
                registeredUser.setIntroduce(user.getIntroduce());
                return;
            }
        }
    }

    @Override
    public User get(Account account) {
        for (User user : users) {
            if(user.getAccount().same(account)) {
                return user;
            }
        }
        throw new IllegalArgumentException();
    }
}
