package com.example.Favourites.Repository;

import static org.junit.jupiter.api.Assertions.*;


        import com.example.Favourites.Model.Favourites;
        import com.example.Favourites.Repository.FavouriteRepository;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.context.junit.jupiter.SpringExtension;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNotNull;
        import static org.junit.jupiter.api.Assertions.*;
        import java.util.List;
        import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class FavouriteRepositoryTest {
    @Autowired
    private FavouriteRepository repository;
    private Favourites favourite;

    @AfterEach
    void tearDown() {
        favourite=null;
    }
    @Test
    public void givenFavouriteToSaveThenShouldReturnSavedFavourite(){
        Favourites favourite=new Favourites(2,"sneha","believer","john",1998,"pop");
        repository.save(favourite);
        Favourites favourite1=repository.findById(favourite.getId()).get();

        assertNotNull(favourite1);
        assertEquals(favourite1.getUserName(),favourite1.getUserName());
    }
    @Test
    public void givenGetAllThenShouldReturnListOfAllFavourites(){
        Favourites favourite=new Favourites(1,"sneha","believer","john",1998,"pop" );
        repository.save(favourite);
        List<Favourites>favouriteList=repository.findAll();
        assertEquals("sneha",favouriteList.get(1).getUserName());
    }


}
