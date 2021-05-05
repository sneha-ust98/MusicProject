package com.example.Favourites.Service;

import static org.junit.jupiter.api.Assertions.*;




        import com.example.Favourites.Model.Favourites;
        import com.example.Favourites.Repository.FavouriteRepository;
        import com.example.Favourites.Service.FavouriteService;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import org.mockito.junit.jupiter.MockitoExtension;
        import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

        import static org.mockito.Mockito.*;
        import java.util.Optional;
        import  java.util.List;
        import static org.junit.jupiter.api.Assertions.*;

        import static org.mockito.ArgumentMatchers.any;




@DataMongoTest
@ExtendWith(MockitoExtension.class)
class FavouriteServiceTest {
    @Mock
    private FavouriteRepository repository;
    @InjectMocks
    private FavouriteService service;
    private Favourites favourite, favourite1;
    private List<Favourites> favouriteList;
    private Optional optional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        favourite = new Favourites(1, "Tito's Cafe", "Junk", "Burger", 160,"Jenis");
        favourite1 = new Favourites(2, "Bamboo Restaurant", "Biryani", "Bamboo Chicken Biryani", 250,"Alby");
        optional = Optional.of(favourite);
    }

    @AfterEach
    void tearDown() {
        favourite=null;
    }



    @Test
    public void givenFavouriteToSaveThenShouldNotReturnSavedFavourite()  {
        when(repository.save(any())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () ->
                service.saveSong(favourite));

        verify(repository, times(1)).save(favourite);
    }






    @Test
    public void givenGetAllThenShouldReturnListOfAllFavourites() {
        repository.save(favourite);
        when(repository.findAll()).thenReturn(favouriteList);
        List<Favourites> favouriteList1 = service.getAllSongs();
        assertEquals(favouriteList, favouriteList1);
        verify(repository, times(1)).save(favourite);
        verify(repository, times(1)).findAll();
    }





}





