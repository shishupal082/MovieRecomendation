package com.movierecomendation.exception;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class MovieNotFound extends BaseException {

    public MovieNotFound(){}

    public MovieNotFound(String message){
        super(message);
    }

    public MovieNotFound(String message, String reason){
        super(message, reason);
    }
}
