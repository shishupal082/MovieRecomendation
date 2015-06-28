package com.movierecomendation.model;

/**
 * Created by shishupal.kumar on 28/06/15.
 */
public class Rating {
    private Movie movie;
    private User user;
    private Integer rating;

    public Rating(){}

    public Rating(Movie movie, User user, int rating) {
        this.movie = movie;
        this.user = user;
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
