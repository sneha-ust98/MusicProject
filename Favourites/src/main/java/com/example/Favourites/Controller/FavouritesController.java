package com.example.Favourites.Controller;

import com.example.Favourites.Exception.FavouriteAlreadyExists;
import com.example.Favourites.Model.Favourites;
import com.example.Favourites.Service.FavouriteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FavouritesController
{
    @Autowired
    private FavouriteService service;
    @PostMapping("/favourite")
    public ResponseEntity<Favourites> saveSong(@RequestBody Favourites favourites) throws FavouriteAlreadyExists {
        return new ResponseEntity<Favourites>(service.saveSong(favourites), HttpStatus.CREATED);
    }

    @DeleteMapping("/favourite/{id}")
    public void deleteSong(@PathVariable int id){
        service.deleteSong(id);
    }

    @GetMapping("/favourites")
    @ResponseBody
    public List<Favourites> getSongs(@RequestParam ("userName") String userName)
    {
        return service.getByuserName(userName);
    }


}
