package com.movierecomendation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.movierecomendation.model.*;

/**
 * Created by shishupal.kumar on 28/06/15.
 */


public class DisplayResult {



    public void displayTopMovieByYear(Map<Integer, List<Movie>> topMovieByYear) {

        for(Integer year:topMovieByYear.keySet())
        {
            System.out.print(year);
            for(Movie movie:topMovieByYear.get(year))
                System.out.print(" "+movie.getTitle());
            System.out.println();
        }
    }

    public void displayGenreList(List<Genre> genreList) {

        for(Genre genre:genreList)
            System.out.println(genre);

    }

    public void displayUserList(List<User> mostActiveUser) {
        for(User user:mostActiveUser)
            System.out.print(user);
    }

    public void displayGenreSet(Set<Genre>genreSet) {

        for(Genre genre:genreSet)
            System.out.println(genre);
    }

    public void displayMostWatchedMovie(List<Movie> mostWatchedMovies) {
        for(Movie movie:mostWatchedMovies)
            System.out.println(movie.getTitle());
    }

    public void dispayMovieDatabase(MovieDatabase movieDatabase){
        Map<Integer, Movie> movieMap = movieDatabase.getMovieMap();
        Map<Integer,User> userMap = movieDatabase.getUserMap();
        List<Rating> movieRatingList = movieDatabase.getMovieRatingList();

        for (Map.Entry<Integer, Movie> entry : movieMap.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        for (Map.Entry<Integer, User> entry : userMap.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}