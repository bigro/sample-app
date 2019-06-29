package com.example.sampleapp.service;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.model.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void edit(User user) {
        userRepository.update(user);
    }

    public User get(Account account) {
        return userRepository.get(account);
    }
}
