package io.federecio.dropwizard.junitrunner;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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