package com.stackroute.musicservice.Service;

import com.stackroute.musicservice.model.Music;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MusicService
{
    Music saveSong(Music music);
    List<Music> getAllSongs();
    void deleteSong(int id);
    public Music updateSong(Music music);

    Music getSongByreleaseyear(int releaseyear);

    Music getSongBygenreAndartist(String genre, String artist);

    Music getSongBytitle(String title);
}
