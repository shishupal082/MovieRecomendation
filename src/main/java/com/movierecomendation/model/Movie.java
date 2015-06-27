package com.movierecomendation.model;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class Movie {
    private int movieId;
    String title;
    String releaseDate;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie [movieID=" + movieId + ", title=" + title + ", releaseDate="
                + releaseDate + "]";
    }
}
