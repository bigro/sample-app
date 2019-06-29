package com.example.sampleapp.controller;

import com.example.sampleapp.domain.model.Account;
import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Controller
public class BoardController {

    private PostService postService;
    private HttpSession session;

    public BoardController(PostService postService, HttpSession session) {
        this.postService = postService;
        this.session = session;
    }

    @GetMapping("/")
    public String show(Model model) {
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            return "login";
        }

        List<Post> posts = postService.allMessages();
        model.addAttribute("posts", posts);
        model.addAttribute("account", account);
        return "board";
    }

    @PostMapping("/")
    public String post(@RequestParam String title, @RequestParam String message) {
        Account account = (Account) session.getAttribute("account");
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
