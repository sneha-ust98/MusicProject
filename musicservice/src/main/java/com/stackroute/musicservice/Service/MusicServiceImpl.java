package com.stackroute.musicservice.Service;

import com.stackroute.musicservice.Repository.MusicRepository;
import com.stackroute.musicservice.model.Music;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@service indicate annotated class is a service which hold business logic in service layer
@Service
@AllArgsConstructor
public class MusicServiceImpl implements MusicService
{
    @Autowired
    private MusicRepository repository;

    //implementation of service methods
    @Override
    public Music saveSong(Music music) {
        return repository.save(music);
    }

    @Override
    public List<Music> getAllSongs() {
        return repository.findAll();
    }

    @Override
    public void deleteSong(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public Music updateSong(Music music) {
        return repository.save(music);
    }

    @Override
    public Music getSongByreleaseyear(int releaseyear) {
        return repository.findSongByreleaseyear(releaseyear);
    }

    @Override
    public Music getSongBygenreAndartist(String genre, String artist) {
        return repository.findSongBygenreAndartist(genre, artist);
    }

    @Override
    public Music getSongBytitle(String title) {
        return repository.findSongBytitle(title);
    }


}
