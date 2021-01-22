package com.colossus.homeserver.repository;

import com.colossus.homeserver.model.Album;

import java.util.List;

public interface AlbumCustomRepository {
    List<Album> findByAlbum();
}
