package com.movierecomendation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class User {
    private Integer userId;
    private String userName; // It is type of user : technician, teacher, it,...
    private String phone;

    public User(){ }

    public User(Integer userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    @JsonIgnoreProperties
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() { return phone; }

    @JsonIgnoreProperties
    public void setPhone(String phone) { this.phone = phone; }

    public String getUserName() {
        return userName;
    }

    @JsonIgnoreProperties
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Movie [userId=" + userId + ",userName=" + userName + ", phone=" + phone + "]";
    }
}
