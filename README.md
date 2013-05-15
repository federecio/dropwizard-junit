dropwizard-junit
================

a JUnit TestRunner that allows to load Dropwizard resources for testing


How to use it
-------------

    import org.junit.Test;
    import org.junit.runner.RunWith;

    import com.federecio.dropwizard.junitrunner.DropwizardJunitRunner;
    import com.federecio.dropwizard.junitrunner.DropwizardTestConfig;

    @RunWith(DropwizardJunitRunner.class)
    @DropwizardTestConfig(serviceClass = YourServiceClass.class, yamlFile = "/yourconfig.yaml")
    public class YourTest {

        // cool tests here - your Dropwizard service has been started
    }