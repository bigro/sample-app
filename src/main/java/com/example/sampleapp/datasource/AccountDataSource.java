package com.example.sampleapp.datasource;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDataSource implements AccountRepository {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public void register(Account account) {
        accounts.add(account);
    }

    @Override
    public boolean exists(Account account) {
        for (Account registeredAccount : accounts) {
            if (account.same(registeredAccount)) {
                return true;
            }
        }
        return false;
    }
}
