dropwizard-junit
================

a JUnit TestRunner that allows to load Dropwizard resources for testing


How to use it
-------------

* Add the Maven repository

        <repositories>
            <repository>
                <id>dropwizard-junit</id>
                <url>https://raw.github.com/federecio/dropwizard-junit/mvn-repo/</url>
            </repository>
        </repositories>


* Add the Maven dependency

        <dependency>
            <groupId>com.federecio</groupId>
            <artifactId>dropwizard-junit</artifactId>
            <version>0.1</version>
            <scope>test</scope>
        </dependency>


* Write your tests

    import org.junit.Test;
    import org.junit.runner.RunWith;

    import com.federecio.dropwizard.junitrunner.DropwizardJunitRunner;
    import com.federecio.dropwizard.junitrunner.DropwizardTestConfig;

    @RunWith(DropwizardJunitRunner.class)
    @DropwizardTestConfig(serviceClass = YourServiceClass.class, yamlFile = "/yourconfig.yaml")
    public class YourTest {

        // cool tests here - your Dropwizard service has been started
    }