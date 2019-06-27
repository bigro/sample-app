package com.example.sampleapp.service;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void add(Account account) {
        if (!accountRepository.exists(account)) {
            accountRepository.register(account);
        }
    }
}
