package com.colossus.homeserver.repository;

import com.colossus.homeserver.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById();
}
