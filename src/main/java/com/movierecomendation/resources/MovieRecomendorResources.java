package com.movierecomendation.resources;

import com.movierecomendation.libs.MovieRecomendorLibs;
import com.movierecomendation.model.MovieDatabase;
import com.movierecomendation.parser.FileParser;
import com.movierecomendation.parser.MdbParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by shishupal.kumar on 02/07/15.
 */
@Path("/mr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieRecomendorResources {
    private static Logger logger = LoggerFactory.getLogger(MovieResources.class);
    MdbParser mdb = new FileParser();
    MovieRecomendorLibs movieRecomendorLibs = new MovieRecomendorLibs(mdb.getMovieDatabase());

    @GET
    @Path("/mostWatchedMovie")
    public Response getMostWatchedMovie() {
        return Response.status(Response.Status.FOUND).entity(movieRecomendorLibs.getMostWatchedMovie()).build();
    }

    @GET
    @Path("/mostWatchedGenre")
    public Response getMostWatchedGenre() {
        return Response.status(Response.Status.FOUND).entity(movieRecomendorLibs.getMostWatchedGenre()).build();
    }

    @GET
    @Path("/possibleRating")
    public Response getPossibleRatingVal() {
        return Response.status(Response.Status.FOUND).entity(movieRecomendorLibs.getPossibleRatingCount()).build();
    }
    @GET
    @Path("/possibleGenre")
    public Response getPossibleGenreVal(){
        return Response.status(Response.Status.FOUND).entity(movieRecomendorLibs.getPossibleGenreCount()).build();
    }
}
