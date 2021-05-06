package com.example.Favourites.Controller;

import com.example.Favourites.Exception.FavouriteAlreadyExists;
import com.example.Favourites.Model.Favourites;
import com.example.Favourites.Service.FavouriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//restcontroller annotation is used to create restfull web services using spring MVC
@RestController
@AllArgsConstructor

public class FavouritesController
{
    //logger object creation
    private static final Logger log=LoggerFactory.getLogger(FavouritesController.class);
    @Autowired
    private FavouriteService service;
    //method to post the favourites of the user
    @PostMapping("/favourite")

    public ResponseEntity<Favourites> saveSong( @RequestBody Favourites favourites) throws FavouriteAlreadyExists {
        log.info("This is for getting favourites");
        return new ResponseEntity<Favourites>(service.saveSong(favourites), HttpStatus.CREATED);

    }
    //method to delete the favourite list using id
    @DeleteMapping("/favourite/{id}")
    public void deleteSong(@PathVariable int id){
        log.info("This is for deleting favourites");
        log.debug("this is debug");
        service.deleteSong(id);
    }

    //method to get favourite songs
    @GetMapping("/favourites")
    @ResponseBody
    public List<Favourites> getSongs(@RequestParam ("userName") String userName)
    {
        log.info("This is for retrieving all favourites");
        return service.getByuserName(userName);
    }


}
