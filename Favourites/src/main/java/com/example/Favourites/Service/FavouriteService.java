package com.example.Favourites.Service;


import com.example.Favourites.Exception.FavouriteAlreadyExists;
import com.example.Favourites.Model.Favourites;

import java.util.List;

public interface FavouriteService
{
    //functionalities
    Favourites saveSong(Favourites favourites) throws FavouriteAlreadyExists;
    void deleteSong(int id);
    List<Favourites> getAllSongs();
    public List<Favourites> getByuserName(String userName);
    public List<Favourites> findByuserName(String userName);
}
