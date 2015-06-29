package com.movierecomendation.resources;

import com.movierecomendation.DisplayResult;
import com.movierecomendation.libs.CustomResponse;
import com.movierecomendation.libs.MovieLibs;
import com.movierecomendation.libs.UserLibs;
import com.movierecomendation.exception.UserNotFound;
import com.movierecomendation.model.User;
import com.movierecomendation.parser.FileParser;
import com.movierecomendation.parser.MdbParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserResources {
    private static Logger logger = LoggerFactory.getLogger(MovieResources.class);
    private CustomResponse customResponse = new CustomResponse();

    MdbParser mdb = new FileParser();
    DisplayResult displayResult = new DisplayResult();
    private UserLibs userLibs = new UserLibs(mdb.getMovieDatabase());

    @GET
    @Path("/all")
    public Response getAllUser() {
        return Response.status(Response.Status.FOUND).entity(userLibs.getAllUser()).build();
    }

    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Integer userId) {
        return Response.status(Response.Status.FOUND).entity(userLibs.getUserById(userId)).build();
    }

    @POST
    @Path("/post")
    public Response postUser(User user) {
        logger.info(String.format("%s", user.toString()));
        HashMap<String, String> res = customResponse.get("SUCECSS", "not_started");
        return Response.status(Response.Status.FOUND).entity(res).build();
    }

}
