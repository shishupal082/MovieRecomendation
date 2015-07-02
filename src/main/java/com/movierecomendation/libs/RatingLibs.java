package com.movierecomendation.libs;

import com.movierecomendation.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shishupal.kumar on 30/06/15.
 */
public class RatingLibs {
    private Logger logger = LoggerFactory.getLogger(RatingLibs.class);
    private MovieDatabase movieDatabase;
    public RatingLibs(){ }

    public RatingLibs(MovieDatabase mdb){
        this.movieDatabase = mdb;
    }

    public List<Rating> getAllRating(){
        return this.movieDatabase.getMovieRatingList();
    }
    /**
    * It returns toomany data so it is not used.
    */
    public List<RatingDetails> getDetailsByRating(Integer currentRating){
        List<Rating> allRatings = this.movieDatabase.getMovieRatingList();
        List<Rating> currentRatingList = new ArrayList<Rating>();
        List<RatingDetails> ratingDetailsList = new ArrayList<RatingDetails>();
        Movie movieTemp;
        User userTemp;
        for (int i=0; i < allRatings.size(); i++){
            if(allRatings.get(i).getRating() == currentRating){
                RatingDetails ratingDetails = new RatingDetails(currentRating);
                movieTemp = allRatings.get(i).getMovie();
                userTemp = allRatings.get(i).getUser();
                ratingDetails.setMovieDetailsUrl("/movie/" + movieTemp.getMovieId());
                ratingDetails.setUserDetailsUrl("/user/" + userTemp.getUserId());
                ratingDetailsList.add(ratingDetails);
            }
        }
        return ratingDetailsList;
    }

    public Map<String, Integer> getPossibleRatingVal(){
        Map<String, Integer> possibleRatingMapCount = new HashMap<String, Integer>();
        List<Rating> allRatings = this.movieDatabase.getMovieRatingList();
        Integer tempRating, total = 0;
        for (Rating rating : allRatings){
            tempRating = rating.getRating();
            try{
                possibleRatingMapCount.put(tempRating.toString(), possibleRatingMapCount.get(tempRating.toString())+1);
            }catch (Exception e){
                logger.info(String.format("Rating %s not exist in map.", tempRating));
                possibleRatingMapCount.put(tempRating.toString(), 1);
            }
        }
        for (Integer value : possibleRatingMapCount.values()){
            total += value;
        }
        possibleRatingMapCount.put("total", total);
        return possibleRatingMapCount;
    }
}
