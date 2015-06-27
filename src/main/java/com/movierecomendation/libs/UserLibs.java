package com.movierecomendation.libs;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.movierecomendation.exception.UserNotFound;
import com.movierecomendation.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class UserLibs {
    private Logger logger = LoggerFactory.getLogger(MovieLibs.class);
    public UserLibs() {}


    public User getUserById(Integer userId) throws UserNotFound {
        User user = new User();
        user.setUserId(userId);
        if(userId > 20){
            throw new UserNotFound("User not found.", "user_id_not_found");
        }
        return user;
    }
}
