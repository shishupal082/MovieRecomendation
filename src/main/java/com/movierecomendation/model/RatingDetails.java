package com.movierecomendation.model;

/**
 * Created by shishupal.kumar on 02/07/15.
 */
public class RatingDetails {
    private Integer rating;
    private String movieDetailsUrl;
    private String userDetailsUrl;

    public RatingDetails(){}
    public RatingDetails(Integer rating){
        this.rating = rating;
    }
    public String getMovieDetailsUrl() {
        return movieDetailsUrl;
    }

    public void setMovieDetailsUrl(String movieDetailsUrl) {
        this.movieDetailsUrl = movieDetailsUrl;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getUserDetailsUrl() {
        return userDetailsUrl;
    }

    public void setUserDetailsUrl(String userDetailsUrl) {
        this.userDetailsUrl = userDetailsUrl;
    }

    @Override
    public String toString() {
        return "RatingDetails{" +
                "movieDetailsUrl='" + movieDetailsUrl + '\'' +
                ", rating=" + rating +
                ", userDetailsUrl='" + userDetailsUrl + '\'' +
                '}';
    }
}
