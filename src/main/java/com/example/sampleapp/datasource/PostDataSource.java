package com.example.sampleapp.datasource;

import com.example.sampleapp.domain.model.Post;
import com.example.sampleapp.domain.model.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDataSource implements PostRepository {

    private List<Post> posts;

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
    public Post get(int postId) {
        for (Post post : posts) {
            if (post.getId() == postId) {
                return post;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void delete(int postId) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == postId) {
                posts.remove(i);
                return;
            }
        }
    }
}
