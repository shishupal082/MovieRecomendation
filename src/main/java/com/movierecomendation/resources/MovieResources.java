package com.movierecomendation.resources;

/**
 * Created by shishupal.kumar on 27/06/15.
 */

import com.movierecomendation.DisplayResult;
import com.movierecomendation.libs.MovieLibs;
import com.movierecomendation.parser.FileParser;
import com.movierecomendation.parser.MdbParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResources {
    private static Logger logger = LoggerFactory.getLogger(MovieResources.class);

    MdbParser mdb = new FileParser();
    DisplayResult displayResult = new DisplayResult();
    MovieLibs movieLibs = new MovieLibs(mdb.getMovieDatabase());

    @GET
    @Path("/all")
    public Response getAllMovie() {
        return Response.status(Response.Status.FOUND).entity(movieLibs.getAllMovies()).build();
    }

    @GET
    @Path("/{movieId}")
    public Response getMovie(@PathParam("movieId") Integer movieId){
        return Response.status(Response.Status.FOUND).entity(movieLibs.getMovieById(movieId)).build();
    }
}
