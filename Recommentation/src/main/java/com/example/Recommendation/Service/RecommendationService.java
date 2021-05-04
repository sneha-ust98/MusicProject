package com.example.Recommendation.Service;

import com.example.Recommendation.Model.Recommendation;

import java.util.List;

public interface RecommendationService
{
    Recommendation saveSong(Recommendation recommendation);
    List<Recommendation> getAllSongs();
    void deleteSong(int id);
}
