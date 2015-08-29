package com.movierecomendation.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.TEXT_HTML)


/**
 * Created by shishupal.kumar on 24/07/15.
 */
@Path("/web")
public class Web {
    private static Logger logger = LoggerFactory.getLogger(MovieResources.class);
    public String greeting() {
        return "greeting";
    }
}
