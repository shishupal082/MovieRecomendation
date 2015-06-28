package com.movierecomendation.libs;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.movierecomendation.exception.UserNotFound;
import com.movierecomendation.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class UserLibs {
    private Logger logger = LoggerFactory.getLogger(MovieLibs.class);
    private Integer maxUserId = 20;
    public UserLibs() {}

    private String getPhoneById(Integer userId){
        Long phone;
        phone = 9999999999L - userId;
        return phone.toString();
    }
    public List<User> getAllUser(){
        List<User> allUser = new ArrayList<User>();

        for (int i=0; i<maxUserId; i++){
            User user = new User();
            user.setUserId(i+1);
            user.setPhone(this.getPhoneById(user.getUserId()));
            allUser.add(user);
        }

        return allUser;
    }

    public User getUserById(Integer userId) throws UserNotFound {
        if(userId > maxUserId){
            throw new UserNotFound("User not found.", "user_id_not_found");
        }
        User user = new User();
        user.setUserId(userId);
        user.setPhone(this.getPhoneById(user.getUserId()));
        return user;
    }
}
