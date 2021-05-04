package com.example.Recommendation.Controller;

import com.example.Recommendation.Model.Recommendation;
import com.example.Recommendation.Service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecommendationController
{
    @Autowired
    private RecommendationService service;
    @GetMapping("/recommend")
    public List<Recommendation> getSongs(){
        return service.getAllSongs();
    }

    @PostMapping("/recommend")
    public ResponseEntity<Recommendation> saveSong(@RequestBody Recommendation recommendation){
        return new ResponseEntity<Recommendation>(service.saveSong(recommendation), HttpStatus.CREATED);
    }


    @DeleteMapping("/recommend/{id}")
    public void deleteSong(@PathVariable int id){
        service.deleteSong(id);
    }


}
