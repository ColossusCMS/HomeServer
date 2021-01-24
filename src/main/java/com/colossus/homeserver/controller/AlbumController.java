package com.colossus.homeserver.controller;

import com.colossus.homeserver.model.Album;
import com.colossus.homeserver.service.AlbumService;
import com.colossus.homeserver.validator.AlbumValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumValidator albumValidator;

    @GetMapping("/list")
    public String openAlbumList(Model model) {
        List<Album> albums = albumService.getAlbumList();
        model.addAttribute("albums", albums);
        model.addAttribute("album", new Album());
        return "album/list";
    }

    @PostMapping("/delete")
    public String updateAlbumData(@ModelAttribute(value = "album2") Album album) {
        albumService.updateAlbum(album, 0);
        return "redirect:/album/list";
    }

    @PostMapping("/register")
    public String register(@Valid Album album, BindingResult bindingResult) {
        albumValidator.validate(album, bindingResult);
        if(bindingResult.hasErrors())
            return "album/list";
        albumService.save(album);
        return "redirect:/album/list";
    }
}
