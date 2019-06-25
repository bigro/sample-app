package com.example.sampleapp.service;

import com.example.sampleapp.domain.model.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    List<Post> posts = new ArrayList<>();
    
    public void add(String title, String message) {
        Post post = new Post(title, message, LocalDateTime.now());
        posts.add(post);
    }
    
    public List<Post> allMessages() {
        return posts;
    }

    public Post get(String postId) {
        for (Post post : posts) {
            if (post.getId().equals(postId)) {
                return post;
            }
        }
        
        throw new IllegalArgumentException();
    }
}
