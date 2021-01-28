package com.colossus.homeserver.service;

import com.colossus.homeserver.exception.NotFoundException;
import com.colossus.homeserver.model.Post;
import com.colossus.homeserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        List<Post> posts = postRepository.findAll();
        Post oldPost = posts.get(0);
        if (oldPost == null) {
            throw new NotFoundException(oldPost.getId() + " is not found");
        }

        oldPost.setContent(post.getContent());
        oldPost.setCode(post.getCode());
        return postRepository.save(oldPost);
    }

    public Post findById() {
        List<Post> posts = postRepository.findAll();
        Post post = posts.get(0);
       if (post == null) {
            throw new NotFoundException(post.getId() + " is not found");
        }
        return post;
    }
}
