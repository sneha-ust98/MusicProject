package com.stackroute.musicservice.Service;

import com.stackroute.musicservice.model.Music;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MusicService
{
    //abstract method to save the song
    Music saveSong(Music music);
    //abstract method to get all the song
    List<Music> getAllSongs();
    //abstract method to delete the song
    void deleteSong(int id);
    //abstract method to update the song
    public Music updateSong(Music music);
    //abstract methods to get the song by releasedate,genre and artist,title
    Music getSongByreleaseyear(int releaseyear);

    Music getSongBygenreAndartist(String genre, String artist);

    Music getSongBytitle(String title);
}
