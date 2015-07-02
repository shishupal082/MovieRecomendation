package com.movierecomendation.resources;

import com.movierecomendation.DisplayResult;
import com.movierecomendation.libs.CustomResponse;
import com.movierecomendation.libs.RatingLibs;
import com.movierecomendation.parser.FileParser;
import com.movierecomendation.parser.MdbParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.http.client.methods.HttpGet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shishupal.kumar on 30/06/15.
 */
@Path("/rating")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RatingResources {
    private static Logger logger = LoggerFactory.getLogger(MovieResources.class);
    MdbParser mdb = new FileParser();
    DisplayResult displayResult = new DisplayResult();
    private RatingLibs ratingLibs = new RatingLibs(mdb.getMovieDatabase());

    @GET
    @Path("/all")
    public Response getAllUser() {
        CustomResponse res = new CustomResponse();
        return Response.status(Response.Status.FOUND).entity(res.getTooManyData()).build();
    }

    @GET
    @Path("/possibleRatingVal")
    public Response getPossibleRatingVal() {
        return Response.status(Response.Status.FOUND).entity(ratingLibs.getPossibleRatingVal()).build();
    }
}
