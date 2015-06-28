package com.movierecomendation.model;

import java.util.Set;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class Movie {
    private int movieId;
    String title;
    String releaseDate;
    Set<Genre> genre;

    public Movie(){}

    public Movie(Integer movieId, String title, Set genre){
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
    }

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

    public Set<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Set<Genre> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", title=" + title + ", releaseDate="
                + releaseDate + ", genre=" + genre + "]";
    }
}
