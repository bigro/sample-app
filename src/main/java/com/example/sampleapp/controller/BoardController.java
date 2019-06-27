package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.service.AccountService;
import com.example.sampleapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@SessionAttributes(types = Account.class)
public class BoardController {
    
    PostService postService;
    AccountService accountService;

    public BoardController(PostService postService, AccountService accountService) {
        this.postService = postService;
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String show(Model model, Account account) {
        System.out.println("account:" + account);
        if (account.isEmpty()) {
            return "login";
        }
        
        List<Post> posts = postService.allMessages();
        model.addAttribute("posts", posts);
        return "board";
    }
    
    @PostMapping("/")
    public String post(@RequestParam String title, @RequestParam String message, Model model) {
        postService.add(title, message);
        
        return "redirect:/";
    }
    
    @GetMapping("{postId}")
    public String detail(@PathVariable String postId, Model model) {
        Post post = postService.get(postId);
        
        model.addAttribute("post", post);
        return "detail";
    }

    @PostMapping("delete")
    public String delete(@RequestParam String postId, Model model) {
        postService.delete(postId);

        return "redirect:/";
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
