package com.movierecomendation.exception;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class UserNotFound extends BaseException {

    public UserNotFound(){}

    public UserNotFound(String message){
        super(message);
    }

    public UserNotFound(String message, String reason){
        super(message, reason);
    }
}
