package com.federecio.dropwizard.junitrunner;

import org.eclipse.jetty.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jayway.restassured.RestAssured;

/**
 * @author Federico Recio
 */
@RunWith(DropwizardJunitRunner.class)
@DropwizardTestConfig(applicationClass = TestApplication.class, yamlFile = "/test.yaml")
public class DropwizardJunitRunnerTest {

    @Test
    public void test() throws Exception {
        RestAssured.expect().statusCode(HttpStatus.OK_200).when().get("/test");
    }
}
