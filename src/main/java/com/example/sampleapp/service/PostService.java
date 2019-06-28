package com.example.sampleapp.service;

import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.domain.model.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void add(Post post) {
        
        postRepository.register(post);
    }
    
    public List<Post> allMessages() {
        return postRepository.findAll();
    }

    public Post get(int postId) {
        return postRepository.get(postId);
    }

    public void delete(int postId) {
        postRepository.delete(postId);
    }
}
