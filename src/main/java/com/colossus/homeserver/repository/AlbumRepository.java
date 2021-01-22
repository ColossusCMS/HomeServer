package com.colossus.homeserver.repository;

import com.colossus.homeserver.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumCustomRepository {
}
