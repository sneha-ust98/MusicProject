package com.example.Recommendation.Service;

import com.example.Recommendation.Model.Recommendation;

import java.util.List;

public interface RecommendationService
{
    //abstract method to save the song
    Recommendation saveSong(Recommendation recommendation);
    //abstract method to get the song
    List<Recommendation> getAllSongs();
    //abstract method to delete the song
    void deleteSong(int id);
}
