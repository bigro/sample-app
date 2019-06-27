package com.example.sampleapp.datasource;

import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.domain.model.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDataSource implements PostRepository {

    List<Post> posts;

    public PostDataSource() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void register(Post post) {
        posts.add(post);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post get(String postId) {
        for (Post post : posts) {
            if (post.getId().equals(postId)) {
                return post;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void delete(String postId) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(postId)) {
                posts.remove(i);
                return;
            }
        }
    }
}
