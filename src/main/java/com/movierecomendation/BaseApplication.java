package com.movierecomendation;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by shishupal.kumar on 27/06/15.
 */public abstract class BaseApplication<T extends Configuration> extends Application<T> {

    public BaseApplication() {
    }

    public void initialize(Bootstrap<T> bootstrap) {
    }

    public void run(T configuration, Environment environment) throws Exception {
    }
}
