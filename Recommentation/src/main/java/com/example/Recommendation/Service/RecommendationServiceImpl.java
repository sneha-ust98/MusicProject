package com.example.Recommendation.Service;

import com.example.Recommendation.Model.Recommendation;
import com.example.Recommendation.Repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationServiceImpl implements RecommendationService{
    @Autowired
    private RecommendationRepository repository;

    @Override
    public Recommendation saveSong(Recommendation recommendation) {
        return repository.save(recommendation);
    }

    @Override
    public List<Recommendation> getAllSongs() {
        return repository.findAll();
    }

    @Override
    public void deleteSong(int id) {
      repository.deleteById(id);
    }
}
