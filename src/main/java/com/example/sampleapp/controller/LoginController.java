package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    private AccountService accountService;
    private HttpSession session;

    public LoginController(AccountService accountService, HttpSession session) {
        this.accountService = accountService;
        this.session = session;
    }

    @PostMapping("login")
    public String login(@RequestParam String accountName, Model model) {
        Account account = new Account(accountName);
        accountService.add(account);
        session.setAttribute("account", account);
        model.addAttribute("account", account);

        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout() {
        session.removeAttribute("account");
        return "redirect:/";
    }
}
