package com.colossus.homeserver.controller;

import com.colossus.homeserver.exception.NotFoundException;
import com.colossus.homeserver.model.Post;
import com.colossus.homeserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PostService postService;

    @GetMapping("/home")
    public String home() {
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String newPost(Model model) {
        Post post = postService.findById();
        if (post == null) {
            throw new NotFoundException(post.getId() + " is not found");
        }
        Post newPost = new Post();
        newPost.setContent(post.getContent());
        newPost.setCode(post.getCode());
        model.addAttribute("editPost", newPost);
        return "home/edit";
    }

    @PostMapping("/edit")
    public String modifyPost(@ModelAttribute("editPost") @Valid Post createPost, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/home/edit";
        }
        postService.updatePost(new Post(
                createPost.getContent(),
                createPost.getCode()
        ));
        return "redirect:/";
    }
}
