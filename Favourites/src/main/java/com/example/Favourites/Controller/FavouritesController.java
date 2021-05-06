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

@RestController
@AllArgsConstructor

public class FavouritesController
{
    private static final Logger log=LoggerFactory.getLogger(FavouritesController.class);
    @Autowired
    private FavouriteService service;
    @PostMapping("/favourite")

    public ResponseEntity<Favourites> saveSong( @RequestBody Favourites favourites) throws FavouriteAlreadyExists {
        log.info("This is for getting favourites");
        return new ResponseEntity<Favourites>(service.saveSong(favourites), HttpStatus.CREATED);

    }

    @DeleteMapping("/favourite/{id}")
    public void deleteSong(@PathVariable int id){
        log.info("This is for deleting favourites");
        log.debug("this is debug");
        service.deleteSong(id);
    }

    @GetMapping("/favourites")
    @ResponseBody
    public List<Favourites> getSongs(@RequestParam ("userName") String userName)
    {
        log.info("This is for retrieving all favourites");
        return service.getByuserName(userName);
    }


}
