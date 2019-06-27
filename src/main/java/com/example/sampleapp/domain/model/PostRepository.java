package com.example.sampleapp.domain.model;

import java.util.List;

public interface PostRepository {
    
    void register(Post post);

    List<Post> findAll();

    Post get(int postId);

    void delete(int postId);
}
