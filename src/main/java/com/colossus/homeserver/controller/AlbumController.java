package com.colossus.homeserver.controller;

import com.colossus.homeserver.model.Album;
import com.colossus.homeserver.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/album/album")
    public String openAlbumList(Model model) {
        List<Album> albums = albumService.get1
        return "/album/album";
    }

}
