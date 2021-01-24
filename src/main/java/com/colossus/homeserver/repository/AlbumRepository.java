package com.colossus.homeserver.repository;

import com.colossus.homeserver.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumCustomRepository {
    List<Album> findAlbumByFlagOrderByReleasedDesc(int flag);
    int countAlbumByFlagOrderByReleasedDesc(int flag);
}
