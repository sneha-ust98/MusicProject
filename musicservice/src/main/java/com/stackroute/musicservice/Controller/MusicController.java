package com.stackroute.musicservice.Controller;

import com.stackroute.musicservice.Service.MusicService;
import com.stackroute.musicservice.model.Music;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class MusicController
{
    private static final Logger log= LoggerFactory.getLogger(MusicController.class);
    @Autowired
    private MusicService service;
    @GetMapping("/songs")
    public List<Music> getSongs(){
        log.info("this is to get all songs");
        return service.getAllSongs();
    }

    @PostMapping("/song")
    public ResponseEntity<Music> saveSong(@Valid @RequestBody Music music){
        log.info("This is to add songs");
        return new ResponseEntity<Music>(service.saveSong(music), HttpStatus.CREATED);
    }


    @DeleteMapping("/song/{id}")
    public void deleteSong(@PathVariable int id)
    {
        log.info("This is to delete songs");
        service.deleteSong(id);
    }


    @PutMapping("song")
    public ResponseEntity<Music> updateSong(@RequestBody Music music){
        return  new ResponseEntity<Music>(service.updateSong(music),HttpStatus.OK);
    }
    @GetMapping("song1/{releaseyear}")
    public ResponseEntity<Music> getSongByreleaseyear(@PathVariable int releaaseyear)
    {
        return new ResponseEntity<Music>(service.getSongByreleaseyear(releaaseyear),HttpStatus.OK);
    }
    @GetMapping("song2/{genre}/{artist}")

    public ResponseEntity<Music> getUserByGenderAndAge(@PathVariable String genre,@PathVariable String artist)
    {
        return new ResponseEntity<Music>(service.getSongBygenreAndartist(genre, artist),HttpStatus.OK);
    }
    @GetMapping("song3/{title}")
    public ResponseEntity<Music> getSongBytitle(@PathVariable String title)
    {
        return new ResponseEntity<Music>(service.getSongBytitle(title),HttpStatus.OK);
    }


}
