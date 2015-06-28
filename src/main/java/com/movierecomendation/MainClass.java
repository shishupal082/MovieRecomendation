package com.movierecomendation;

import com.movierecomendation.libs.MovieLibs;
import com.movierecomendation.model.Movie;
import com.movierecomendation.parser.HardCodedParser;
import com.movierecomendation.parser.MdbParser;

import java.util.List;

/**
 * Created by shishupal.kumar on 28/06/15.
 */
public class MainClass {
    public static void main(String args[]){
//        MDBParser mdb=new FileParser("movie.data","user.data","ratings.data","genre.data");
        MdbParser mdb = new HardCodedParser();
        DisplayResult displayResult = new DisplayResult();
        MovieLibs movieLibs = new MovieLibs(mdb.getMovieDatabase());

        displayResult.dispayMovieDatabase(mdb.getMovieDatabase());
//        List<Movie> mostWatchedMovies = movieLibs.getMostWatchedMovie();

    }
}
