package com.movierecomendation.model;

/**
 * Created by shishupal.kumar on 28/06/15.
 */

import java.util.List;
import java.util.Map;


public class MovieDatabase {
    private Map<Integer, Movie> movieMap;
    private Map<Integer,User> userMap;
    private List<Rating> movieRatingList;
    public MovieDatabase(Map<Integer, Movie> movieMap,
                         Map<Integer, User> userMap, List<Rating> movieRatingList) {

        this.movieMap = movieMap;
        this.userMap = userMap;
        this.movieRatingList = movieRatingList;
    }
    public Map<Integer, Movie> getMovieMap() {
        return movieMap;
    }
    public void setMovieMap(Map<Integer, Movie> movieMap) {
        this.movieMap = movieMap;
    }
    public Map<Integer, User> getUserMap() {
        return userMap;
    }
    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }
    public List<Rating> getMovieRatingList() {
        return movieRatingList;
    }
    public void setMovieRatingList(List<Rating> movieRatingList) {
        this.movieRatingList = movieRatingList;
    }
}