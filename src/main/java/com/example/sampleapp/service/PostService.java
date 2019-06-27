package com.example.sampleapp.service;

import com.example.sampleapp.datasource.PostDataSource;
import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.domain.model.PostRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class PostService {
    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void add(String title, String message) {
        Post post = new Post(title, message, OffsetDateTime.now(ZoneId.of("Asia/Tokyo")).toLocalDateTime());
        postRepository.register(post);
    }
    
    public List<Post> allMessages() {
        return postRepository.findAll();
    }

    public Post get(String postId) {
        return postRepository.get(postId);
    }

    public void delete(String postId) {
        postRepository.delete(postId);
    }
}
