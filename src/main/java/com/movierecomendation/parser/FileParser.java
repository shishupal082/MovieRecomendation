package com.movierecomendation.parser;

import com.movierecomendation.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by shishupal.kumar on 28/06/15.
 */
public class FileParser implements MdbParser {
    private Logger logger = LoggerFactory.getLogger(FileParser.class);
    private String movieFile = "movie.data";
    private String userFile = "user.data";
    private String ratingFile = "rating.data";

    public FileParser() {
        String parentPath = "/src/main/java/com/movierecomendation/parser/";
        this.movieFile = System.getProperty("user.dir").concat(parentPath + this.movieFile);
        this.userFile = System.getProperty("user.dir").concat(parentPath + this.userFile);
        this.ratingFile = System.getProperty("user.dir").concat(parentPath + this.ratingFile);
    }

    public MovieDatabase getMovieDatabase() {
        Map<Integer,Movie> movieMap = movieFileParser();
        Map<Integer,User> userMap = userFileParser();
        List<Rating>listOfMovieRating = ratingFileParser(movieMap,userMap);
        return new MovieDatabase(movieMap, userMap, listOfMovieRating);
    }

    private List<String> tokanizeLine (String line, String delimator){
        List<String> lst = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(line, delimator);
        while (st.hasMoreElements()){
            lst.add(st.nextToken());
        }
        return lst;
    }
    public Map<Integer, Movie> movieFileParser() {
        Map<Integer, Movie> mapMovie = new HashMap<Integer, Movie>();
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.movieFile));
            String line;
            while((line=bufferedReader.readLine())!=null) {
                List<String>tokens = this.tokanizeLine(line, "|");
                Iterator<String>itr=tokens.iterator();
                Movie movie=new Movie();
                try {
                    if(tokens.size()<23)continue;
                    movie.setMovieId(Integer.parseInt(itr.next()));
                    movie.setTitle(itr.next());
                    movie.setReleaseDate(itr.next());
                    itr.next(); // Ignore url
                    int index=0;
                    Set<Genre>genre=new HashSet<Genre>();
                    while(itr.hasNext()) {
                        if(itr.next().equals("1")) {
                            genre.add(Genre.values()[index]) ;

                        }
                        index+=1;
                    }
                    movie.setGenre(genre);
                    mapMovie.put(movie.getMovieId(), movie);
                }catch(Exception e) {
                    logger.info("this line has error");
                }
            }
        }
        catch(IOException e) {
            logger.info(System.getProperty("user.dir"));
            logger.info("file cannot be opened");
            logger.info(this.movieFile);
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mapMovie;
    }

    private Map<Integer, User> userFileParser() {
        Map<Integer,User>mapUser=new HashMap<Integer,User>();
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = new BufferedReader(new FileReader(userFile));
            String line;
            while((line=bufferedReader.readLine())!=null) {
                List<String>tokens = this.tokanizeLine(line,"|");
                Iterator<String>itr = tokens.iterator();
                if(tokens.size() < 5) {
                    continue;
                }
                User user=new User();
                try {
                    user.setUserId(Integer.parseInt(itr.next().trim()));
                    itr.next(); //Ignore user age
                    itr.next(); //Ignore user gender
                    user.setUserName(itr.next());
                    mapUser.put(user.getUserId(), user);
                }
                catch(NumberFormatException e) {
                    logger.info("line cannot be parsed");
                }
            }

        } catch(IOException e) {
            logger.info("I/o Error file ");
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mapUser;
    }

    /**
     * Same user can given multiple rating to the same movie
     */

    public List<Rating>ratingFileParser(Map<Integer,Movie>movieMap,Map<Integer,User>userMap) {
        logger.info("Start rating file parsing.");
        BufferedReader bufferedReader=null;
        List<Rating>ratingList=null;
        try{
            bufferedReader=new BufferedReader(new FileReader(ratingFile));
            String line;
            ratingList=new ArrayList<Rating>();
            while((line=bufferedReader.readLine())!=null)
            {
                List<String>tokens = this.tokanizeLine(line,"\t");
                Iterator<String>itr=tokens.iterator();
                if(tokens.size()<4){
                    logger.info(String.format("Invalid rating line : %s", line));
                    continue;
                }
                try{
                    int userId = Integer.parseInt(itr.next().trim());
                    int movieId = Integer.parseInt(itr.next().trim());
                    if(userMap.containsKey(userId) && movieMap.containsKey(movieId)) {
                        User user=userMap.get(userId);
                        Movie movie=movieMap.get(movieId);
                        int rate=Integer.parseInt(itr.next().trim());
                        ratingList.add(new Rating(movie,user,rate));
                    }
                    else{
                        if(!userMap.containsKey(userId)) {
                            logger.info(String.format("User with user id %s doesn't exist.", userId));
                        }
                        if(!movieMap.containsKey(movieId)) {
//                            logger.info(String.format("Movie with movie id %s doesn't exist.", movieId));
                        }
                        continue;
                    }
                } catch(NumberFormatException e) {
                    logger.info("line cannot be parsed");
                }
            }

        }
        catch(IOException e) {
            logger.info("File reading error.");
            logger.info(e.getMessage());
        }
        finally{
            try {
                bufferedReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        logger.info("Rating file parsing end.");
        return ratingList;
    }
}
