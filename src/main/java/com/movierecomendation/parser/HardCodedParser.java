package com.movierecomendation.parser;

/**
 * Created by shishupal.kumar on 28/06/15.
 */
import com.movierecomendation.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class HardCodedParser implements MdbParser {

//    @Override
    public MovieDatabase getMovieDatabase() {
        Map<Integer,Movie> movieMap = movieFileParser();
        Map<Integer,User> userMap = userFileParser();
        List<Rating>listOfMovieRating = ratingFileParser(movieMap,userMap);
        return new MovieDatabase(movieMap, userMap, listOfMovieRating);
    }

    private Map<Integer, Movie> movieFileParser() {
        Map<Integer, Movie> movieMap=new HashMap<Integer, Movie>();
        Set<Genre> genre=new HashSet<Genre>();
        genre.add(Genre.values()[1]);
        movieMap.put(100, new Movie(100, "xyz", genre));
        Set<Genre> genre2=new HashSet<Genre>();
        genre2.add(Genre.COMEDY);
        genre2.add(Genre.ACTION);
        movieMap.put(101, new Movie(101,"xy",genre2));
        return movieMap;

    }

    private Map<Integer, User> userFileParser() {
        Map<Integer,User> userMap=new HashMap<Integer,User>();
        userMap.put(12,new User(12,"s/wdeveloper"));
        userMap.put(13,new User(13,"s/wdeveloper"));
        userMap.put(14,new User(14,"s/wdeveloper"));
        return userMap;
    }

    private List<Rating>ratingFileParser(Map<Integer, Movie> movieMap, Map<Integer, User>userMap) {
        List<Rating> listOfMovieRating = new ArrayList<Rating>();
        listOfMovieRating.add(new Rating(movieMap.get(100),userMap.get(12),8));
        listOfMovieRating.add(new Rating(movieMap.get(100),userMap.get(13),6));
        listOfMovieRating.add(new Rating(movieMap.get(101),userMap.get(14),5));
        listOfMovieRating.add(new Rating(movieMap.get(100),userMap.get(14),9));
        listOfMovieRating.add(new Rating(movieMap.get(101),userMap.get(12),4));
        return listOfMovieRating;
    }
}