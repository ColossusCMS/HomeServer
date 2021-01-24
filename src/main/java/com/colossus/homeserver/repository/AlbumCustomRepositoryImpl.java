package com.colossus.homeserver.repository;

import com.colossus.homeserver.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AlbumCustomRepositoryImpl implements AlbumCustomRepository {
}
