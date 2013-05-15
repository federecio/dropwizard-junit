package com.federecio.dropwizard.junitrunner;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * @author Federico Recio
 */
public class TestService extends Service<TestConfig> {

    @Override
    public void initialize(Bootstrap<TestConfig> bootstrap) {
        // nothing
    }

    @Override
    public void run(TestConfig configuration, Environment environment) throws Exception {
        environment.addResource(new TestResource());
    }
}