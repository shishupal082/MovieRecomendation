package com.movierecomendation.resources;

import com.movierecomendation.libs.CustomResponse;
import com.movierecomendation.libs.UserLibs;
import com.movierecomendation.exception.UserNotFound;
import com.movierecomendation.model.User;
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
    private UserLibs userLibs = new UserLibs();

    @GET
    @Path("/")
    public Response getUser() {
        HashMap<String, String> res = customResponse.get();
        return Response.status(Response.Status.FOUND).entity(res).build();
    }

    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Integer userId) throws UserNotFound {
        try{
            return Response.status(Response.Status.FOUND).entity(userLibs.getUserById(userId)).build();
        }catch (UserNotFound e){
            return Response.status(Response.Status.NOT_FOUND).entity(customResponse.getException(e)).build();
        }
    }

    @POST
    @Path("/post")
    public Response postUser(User user) {
        logger.info(String.format("%s", user.toString()));
        HashMap<String, String> res = customResponse.get("SUCECSS", "not_started");
        return Response.status(Response.Status.FOUND).entity(res).build();
    }

}
