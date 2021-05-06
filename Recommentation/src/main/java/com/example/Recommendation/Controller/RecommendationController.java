package com.example.Recommendation.Controller;

import com.example.Recommendation.Model.Recommendation;
import com.example.Recommendation.Service.RecommendationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//restcontroller annotation is used to create restfull web services using spring MVC
@RestController
@AllArgsConstructor
public class RecommendationController
{
    //logger object creation
    private static final Logger log= LoggerFactory.getLogger(RecommendationController.class);
    @Autowired
    private RecommendationService service;
    //method to get recommented songs as per the counter
    @GetMapping("/recommend")
    public List<Recommendation> getSongs(){
        log.info("This is to get all reccomentations");
        return service.getAllSongs();
    }

    //method to save the songs
    @PostMapping("/recommend")
    public ResponseEntity<Recommendation> saveSong(@RequestBody Recommendation recommendation){
        log.info("This is to add reccomentations");
        return new ResponseEntity<Recommendation>(service.saveSong(recommendation), HttpStatus.CREATED);
    }


    //methods to delete the songs
    @DeleteMapping("/recommend/{id}")
    public void deleteSong(@PathVariable int id){
        log.info("this is to delete recommentations");
        service.deleteSong(id);
    }


}
