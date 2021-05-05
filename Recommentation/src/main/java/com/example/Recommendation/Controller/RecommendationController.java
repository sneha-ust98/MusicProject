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

@RestController
@AllArgsConstructor
public class RecommendationController
{
    private static final Logger log= LoggerFactory.getLogger(RecommendationController.class);
    @Autowired
    private RecommendationService service;
    @GetMapping("/recommend")
    public List<Recommendation> getSongs(){
        log.info("This is to get all reccomentations");
        return service.getAllSongs();
    }

    @PostMapping("/recommend")
    public ResponseEntity<Recommendation> saveSong(@Valid @RequestBody Recommendation recommendation){
        log.info("This is to add reccomentations");
        return new ResponseEntity<Recommendation>(service.saveSong(recommendation), HttpStatus.CREATED);
    }


    @DeleteMapping("/recommend/{id}")
    public void deleteSong(@PathVariable int id){
        log.info("this is to delete recommentations");
        service.deleteSong(id);
    }


}
