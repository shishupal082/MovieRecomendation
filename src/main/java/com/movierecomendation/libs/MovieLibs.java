package com.movierecomendation.libs;

import com.movierecomendation.exception.MovieNotFound;
import com.movierecomendation.model.Movie;
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
    private String movieFile = "/Users/shishupal.kumar/workspace/MovieRecomendation/src/main/resources/movie.data";
    private Logger logger = LoggerFactory.getLogger(MovieLibs.class);
    public MovieLibs() {}
    private List<String> tokanizeLine (String line, String delimator){
        List<String> lst = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(line, delimator);
        while (st.hasMoreElements()){
            lst.add(st.nextToken());
        }
        return lst;
    }
    public List<Movie> getAllMovies(){
        List<Movie> allMovies = new ArrayList<Movie>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(movieFile));
            logger.info(String.format("File successfully parsed : %s", movieFile));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                List<String> tokens = tokanizeLine(sCurrentLine, "|");
                Iterator<String> itr = tokens.iterator();
                Movie movie = new Movie();
                try {
                    movie.setMovieId(Integer.parseInt(itr.next()));
                    movie.setTitle(itr.next());
                    movie.setReleaseDate(itr.next());
                    allMovies.add(movie);
                }catch (Exception e){
                    logger.info(String.format("Line parsing error : %s", sCurrentLine));
                }
            }
        } catch (IOException e) {
            logger.info(String.format("File not found : %s", movieFile));
        }
        return allMovies;
    }
    public Movie getMovieById(Integer movieIndex) throws MovieNotFound{

        Movie movie = new Movie();
        List<Movie> allMovies = this.getAllMovies();
        for (int i=0; i < allMovies.size(); i++){
            Movie tempMovie = allMovies.get(i);
            if(tempMovie.getMovieId() == movieIndex){
                return tempMovie;
            }
        }
        throw new MovieNotFound("Movie not found.", "invalidMovieId");
    }
}
