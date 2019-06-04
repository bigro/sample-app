package com.example.sampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
    
    @GetMapping("/")
    public String show() {
        return "board";
    }
    
    @PostMapping("/")
    public String post(@RequestParam String message, Model model) {
        model.addAttribute("message", message);
        return "board";
    }
}
