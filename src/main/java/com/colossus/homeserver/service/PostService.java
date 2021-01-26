package com.colossus.homeserver.service;

import com.colossus.homeserver.exception.NotFoundException;
import com.colossus.homeserver.model.Post;
import com.colossus.homeserver.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        Post oldPost = postRepository.findById();
        if (oldPost == null) {
            throw new NotFoundException(id + "not found");
        }

        oldPost.setContent(post.getContent());
        oldPost.setCode(post.getCode());
        return oldPost;
    }

    @Transactional(readOnly = true)
    public Post findById(Long id) {
        Post post = postRepository.findById();
        if (post == null) {
            throw new NotFoundException(id + "not found");
        }
        return post;
    }
}
