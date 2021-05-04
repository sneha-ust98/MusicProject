package com.example.Favourites.Repository;

import com.example.Favourites.Model.Favourites;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourites,Integer> {
    public List<Favourites> getByuserName(String userName);
    public List<Favourites> findByuserName(String userName);
}
