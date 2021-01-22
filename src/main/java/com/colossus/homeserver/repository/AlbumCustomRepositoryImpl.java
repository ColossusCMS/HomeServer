package com.colossus.homeserver.repository;

import com.colossus.homeserver.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class AlbumCustomRepositoryImpl implements AlbumCustomRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Album> findByAlbum() {
        return entityManager.createQuery("select a from Album as a", Album.class).getResultList();
    }
}
