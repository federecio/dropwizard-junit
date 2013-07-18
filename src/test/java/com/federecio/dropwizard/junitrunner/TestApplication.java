package com.federecio.dropwizard.junitrunner;

import com.codahale.dropwizard.Application;
import com.codahale.dropwizard.setup.Bootstrap;
import com.codahale.dropwizard.setup.Environment;

/**
 * @author Federico Recio
 */
public class TestApplication extends Application<TestConfig> {

    @Override
    public void initialize(Bootstrap<TestConfig> bootstrap) {
        // nothing
    }

    @Override
    public void run(TestConfig configuration, Environment environment) throws Exception {
        environment.jersey().register(new TestResource());
    }
}