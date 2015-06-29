package com.movierecomendation.libs;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.movierecomendation.exception.MovieNotFound;
import com.movierecomendation.exception.UserNotFound;
import com.movierecomendation.model.Movie;
import com.movierecomendation.model.MovieDatabase;
import com.movierecomendation.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.soap.SOAPBinding;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class UserLibs {
    private Logger logger = LoggerFactory.getLogger(MovieLibs.class);
    private Integer maxUserId = 20;
    private MovieDatabase movieDatabase;
    public UserLibs() {}

    public UserLibs(MovieDatabase movieDatabase){
        this.movieDatabase = movieDatabase;
    }

    private String getPhoneById(Integer userId){
        Long phone;
        phone = 9999999999L - userId;
        return phone.toString();
    }

    public List<User> getAllUser(){
        Map<Integer, User> userMap = movieDatabase.getUserMap();
        List<User> allUsers = new ArrayList<User>();
        for (Map.Entry<Integer, User> tempUser : userMap.entrySet()){
            allUsers.add(tempUser.getValue());
        }
        return allUsers;
    }

    public User getUserById(Integer userId) {
        Map<Integer, User> userMap = movieDatabase.getUserMap();
        User user = userMap.get(userId);
        if(user == null){
            throw new NotFoundException(String.format("User id %s not found in users.", userId));
        }
        return user;
    }
}
