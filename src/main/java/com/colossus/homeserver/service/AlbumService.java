package com.colossus.homeserver.service;

import com.colossus.homeserver.model.Album;
import com.colossus.homeserver.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAlbumList() {
        List<Album> list = Collections.emptyList();
        int albumTotalCount = albumRepository.findByAlbum();
    }
}
