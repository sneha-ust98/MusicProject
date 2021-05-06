package com.example.Recommendation.Repository;

import com.example.Recommendation.Model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//it markes  the specific class as a dat access object

@Repository
public interface RecommendationRepository extends MongoRepository<Recommendation,Integer>
{


}
