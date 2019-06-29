package com.example.sampleapp.service;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.AccountRepository;
import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.domain.model.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void add(Account account) {
        if (!accountRepository.exists(account)) {
            accountRepository.register(account);
            userRepository.register(User.of(account));
        }
    }
}
