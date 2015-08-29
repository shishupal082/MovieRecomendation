package com.movierecomendation.libs;

import com.movierecomendation.model.*;
import com.sun.tools.javac.jvm.Gen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by shishupal.kumar on 02/07/15.
 */
public class MovieRecomendorLibs {
    private Logger logger = LoggerFactory.getLogger(RatingLibs.class);
    private MovieDatabase movieDatabase;
    public MovieRecomendorLibs(MovieDatabase movieDatabase){
        this.movieDatabase = movieDatabase;
    }
    /**
     * Why it return list => Because more than one movie can have same max watch count.
     * */
    public List<Movie> getMostWatchedMovie(){
        List<Rating>movieRatingList = movieDatabase.getMovieRatingList();
        Map<Movie,Integer>mapMovieToWatchCount = new HashMap<Movie, Integer>();
        List<Movie>mostWatchedMovies = new ArrayList<Movie>();
        for(Rating rating:movieRatingList) {
            Movie movie = rating.getMovie();
            int watchCount;
            if(mapMovieToWatchCount.containsKey(movie)) {
                watchCount = mapMovieToWatchCount.get(movie);
                watchCount += 1;
            } else {
                watchCount = 1;
            }
            mapMovieToWatchCount.put(movie, watchCount);
        }
        //Movie mostWatchedMovie = null;
        int maxWatchCount = Integer.MIN_VALUE;
        for(Movie movie:mapMovieToWatchCount.keySet()) {
            int watchCount = mapMovieToWatchCount.get(movie);
            if(watchCount > maxWatchCount) {
                mostWatchedMovies.clear();
                mostWatchedMovies.add(movie);
                maxWatchCount = watchCount;
            }else if(watchCount == maxWatchCount) {
                mostWatchedMovies.add(movie);
            }else{
                continue;
            }
        }
        return mostWatchedMovies;
    }

    public List<Genre> getMostWatchedGenre(){
        Map<Genre, Integer>mapGenreToWatchCount = this.getPossibleGenreCount();
        List<Genre>mostWatchedGenre = new ArrayList<Genre>();
        Integer maxWatchedCount = Integer.MIN_VALUE;
        for (Genre genre : mapGenreToWatchCount.keySet()){
            int watchedCount = mapGenreToWatchCount.get(genre);
            if(watchedCount > maxWatchedCount){
                mostWatchedGenre.clear();
                mostWatchedGenre.add(genre);
                maxWatchedCount = watchedCount;
            }else if(watchedCount == maxWatchedCount){
                mostWatchedGenre.add(genre);
            }else{
                continue;
            }
        }
        return mostWatchedGenre;
    }
    public Map<String, Integer> getPossibleRatingCount(){
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

    public Map<Genre, Integer> getPossibleGenreCount(){
        List<Rating>movieRatingList = movieDatabase.getMovieRatingList();
        Map<Genre, Integer>mapGenreToWatchCount = new HashMap<Genre, Integer>();
        for (Rating rating:movieRatingList){
            Movie movie = rating.getMovie();
            for (Genre genre : movie.getGenre()){
                if(mapGenreToWatchCount.containsKey(genre)){
                    mapGenreToWatchCount.put(genre, mapGenreToWatchCount.get(genre)+1);
                }else {
                    mapGenreToWatchCount.put(genre, 1);
                }
            }
        }
        return mapGenreToWatchCount;
    }
}
