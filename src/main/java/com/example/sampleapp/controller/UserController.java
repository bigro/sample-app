package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.GenderType;
import com.example.sampleapp.domain.model.User;
import com.example.sampleapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
@SessionAttributes(types = Account.class)
public class UserController {
    
    private UserService userService;
    private HttpSession session;

    public UserController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @GetMapping("edit")
    public String editPage(Model model) {
        Account account = (Account) session.getAttribute("account");

        User user = userService.get(account);
        
        model.addAttribute("user", user);
        model.addAttribute("genderTypes", GenderType.values());

        return "user/edit";
    }

    @PostMapping("edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/user/edit";
    }
}
