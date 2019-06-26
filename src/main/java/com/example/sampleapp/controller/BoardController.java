package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    
    PostService postService;

    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String show(Model model) {
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
}
