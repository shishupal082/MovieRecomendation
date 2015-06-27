package com.movierecomendation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.dropwizard.Configuration;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppConfiguration extends Configuration {
}
