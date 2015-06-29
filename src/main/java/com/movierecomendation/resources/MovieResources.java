package com.movierecomendation.resources;

/**
 * Created by shishupal.kumar on 27/06/15.
 */

import com.codahale.metrics.annotation.Timed;
import com.movierecomendation.DisplayResult;
import com.movierecomendation.exception.MovieNotFound;
import com.movierecomendation.libs.CustomResponse;
import com.movierecomendation.libs.MovieLibs;
import com.movierecomendation.model.Movie;
import com.movierecomendation.parser.HardCodedParser;
import com.movierecomendation.parser.MdbParser;
import com.sun.tools.classfile.Code_attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResources {
    private static Logger logger = LoggerFactory.getLogger(MovieResources.class);
    private CustomResponse customResponse = new CustomResponse();

    MdbParser mdb = new HardCodedParser();
    DisplayResult displayResult = new DisplayResult();
    MovieLibs movieLibs = new MovieLibs(mdb.getMovieDatabase());

    @GET
    @Path("/all")
    public Response getAllMovie() {
        return Response.status(Response.Status.FOUND).entity(movieLibs.getAllMovies()).build();
    }

    @GET
    @Path("/{movieId}")
    public Response getMovie(@PathParam("movieId") Integer movieId) throws MovieNotFound{
        logger.info(String.format("Fetching movie for movieId %s", movieId));
        try{
            return Response.status(Response.Status.FOUND).entity(movieLibs.getMovieById(movieId)).build();
        }catch (MovieNotFound e){
            return Response.status(Response.Status.FOUND).entity(customResponse.getException(e)).build();
        }
    }

    @GET
    @Path("/v2/{movieId}")
    public Response getMovieV2(@PathParam("movieId") Integer movieId) {
        logger.info(String.format("Fetching movie for movieId %s", movieId));
        return Response.status(Response.Status.FOUND).entity(movieLibs.getMovieByIdV2(movieId)).build();
    }

    @POST
    @Path("/post")
    public Response postMovie(Movie movie) {
        logger.info(String.format("%s", movie.toString()));
        HashMap<String, String> res = customResponse.get("SUCECSS", "not_started");
        return Response.status(Response.Status.FOUND).entity(res).build();
    }
}
