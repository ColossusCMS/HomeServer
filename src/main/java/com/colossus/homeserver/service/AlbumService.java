package com.colossus.homeserver.service;

import com.colossus.homeserver.model.Album;
import com.colossus.homeserver.model.Role;
import com.colossus.homeserver.model.User;
import com.colossus.homeserver.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    //리스트 전체조회
    public List<Album> getAlbumList() {
        List<Album> list = Collections.emptyList();
        int albumTotalCount = albumRepository.countAlbumByFlagOrderByReleasedDesc(1);
        if(albumTotalCount > 0)
            list = albumRepository.findAlbumByFlagOrderByReleasedDesc(1);
        return list;
    }

    //항목 삭제
    public Album updateAlbum(Album album, int flag) {
        album.setFlag(flag);
        return albumRepository.save(album);
    }

    //앨범 등록
    public Album save(Album album) {
        album.setFlag(1);
        return albumRepository.save(album);
    }
}
