package com.movierecomendation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class BaseException extends Exception {
    private Logger logger = LoggerFactory.getLogger(UserNotFound.class);
    private String message;
    private String reason;

    public BaseException(){}

    public BaseException(String message){
        super(message);
        this.setMessage(message);
    }

    public BaseException(String message, String reason){
        super(message);
        this.setMessage(message);
        this.setReason(reason);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
