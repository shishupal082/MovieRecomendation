package com.movierecomendation;

import com.movierecomendation.resources.MovieResources;
import com.movierecomendation.resources.UserResources;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class App extends BaseApplication <AppConfiguration> {
    private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws Exception {
        logger.info("App start");
        new App().run("server", args[0]);
    }
    public void run(AppConfiguration config, Environment environment) throws Exception {
        environment.jersey().register(MovieResources.class);
        environment.jersey().register(UserResources.class);
    }
}
