package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Controller
@SessionAttributes(types = Account.class)
public class BoardController {
    
    PostService postService;

    public BoardController(PostService postService) {
        this.postService = postService;
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
    public String post(@RequestParam String title, @RequestParam String message, Account account) {
        Post post = new Post(
                title,
                message,
                OffsetDateTime.now(ZoneId.of("Asia/Tokyo")).toLocalDateTime(),
                account
                );
        postService.add(post);
        
        return "redirect:/";
    }
    
    @GetMapping("{postId}")
    public String detail(@PathVariable int postId, Model model) {
        Post post = postService.get(postId);
        
        model.addAttribute("post", post);
        return "detail";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int postId, Model model) {
        postService.delete(postId);

        return "redirect:/";
    }
}
