package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(types = Account.class)
public class LoginController {
    
    AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @PostMapping("login")
    public String login(@RequestParam String accountName, Model model) {
        Account account = new Account(accountName);
        accountService.add(account);
        model.addAttribute("account", account);

        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
