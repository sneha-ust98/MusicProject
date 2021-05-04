package com.stackroute.musicservice.Repository;

import com.stackroute.musicservice.model.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends MongoRepository<Music,Integer>
{

    @Query(value = "{releaseyear:?0") Music findSongByreleaseyear(int releaseyear);

    @Query(value = "{genre:?0,artist:?1") Music findSongBygenreAndartist(String genre,String artist);

    @Query(value = "{title:?0") Music findSongBytitle(String title);

}
