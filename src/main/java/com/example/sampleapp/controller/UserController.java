package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("user")
@SessionAttributes(types = Account.class)
public class UserController {
    
    private AccountService accountService;

    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @GetMapping("edit")
    public String editPage(Account account, Model model) {
        model.addAttribute("account", account);

        return "user/edit";
    }
}
