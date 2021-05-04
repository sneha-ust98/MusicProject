package com.example.Recommendation.Repository;

import com.example.Recommendation.Model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends MongoRepository<Recommendation,Integer>
{


}
