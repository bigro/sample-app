package com.example.sampleapp.controller;

import com.example.sampleapp.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    
    BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String show(Model model) {
        List<String> messages = boardService.allMessages();
        model.addAttribute("messages", messages);
        return "board";
    }
    
    @PostMapping("/")
    public String post(@RequestParam String message, Model model) {
        boardService.add(message);
        
        return "redirect:/";
    }
}
