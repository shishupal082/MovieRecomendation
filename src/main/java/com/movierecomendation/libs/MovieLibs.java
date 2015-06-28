package com.movierecomendation.libs;

import com.movierecomendation.exception.MovieNotFound;
import com.movierecomendation.model.*;
import com.sun.tools.classfile.Code_attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class MovieLibs {
    private Logger logger = LoggerFactory.getLogger(MovieLibs.class);
    private MovieDatabase movieDatabase;
    public MovieLibs() {}

    public MovieLibs(MovieDatabase movieDatabase){
        this.movieDatabase = movieDatabase;
    }
    public List<Movie> getAllMovies(){
        Map<Integer, Movie> movieMap = movieDatabase.getMovieMap();
        List<Movie> allMovies = new ArrayList<Movie>();
        for (Map.Entry<Integer, Movie> temoMovie : movieMap.entrySet()){
            allMovies.add(temoMovie.getValue());
        }
        return allMovies;
    }
    public Movie getMovieById(Integer movieId) throws MovieNotFound{
        Map<Integer, Movie> movieMap = movieDatabase.getMovieMap();
        Movie movie = movieMap.get(movieId);
        if(movie == null){
            throw new MovieNotFound("Movie not found.", "invalidMovieId");
        }
        return movie;
    }

    public List<Movie> getMostWatchedMovie(){
        List<Rating>movieRatingList = movieDatabase.getMovieRatingList();
        Map<Movie,Integer>mapMovieToWatchCount=new HashMap<Movie,Integer>();
        List<Movie>mostWatchedMovies=new ArrayList<Movie>();
        for(Rating rating:movieRatingList)
        {
            Movie movie=rating.getMovie();
            int watchCount;
            if(mapMovieToWatchCount.containsKey(movie))
            {
                watchCount=mapMovieToWatchCount.get(movie);
                watchCount+=1;
            }
            else
                watchCount=1;
            mapMovieToWatchCount.put(movie, watchCount);
        }
        //Movie mostWatchedMovie=null;
        int maxWatchCount=Integer.MIN_VALUE;
        for(Movie movie:mapMovieToWatchCount.keySet())
        {
            int watchCount=mapMovieToWatchCount.get(movie);
            if(watchCount>maxWatchCount)
            {
                mostWatchedMovies.clear();
                mostWatchedMovies.add(movie);
                maxWatchCount=watchCount;
            }
            else if(watchCount==maxWatchCount)
            {
                mostWatchedMovies.add(movie);
            }
        }
        return mostWatchedMovies;
    }

    public User mostActiveUser(){
        User user = new User();
        return user;
    }

    public Movie getTopMovieByGenre(){
        Movie movie = new Movie();
        return movie;
    }
    public Movie getTopMovieByYear(Integer year){
        Movie movie = new Movie();
        return movie;
    }
}
