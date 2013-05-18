dropwizard-junit
================

a JUnit TestRunner that allows to load Dropwizard resources for testing


How to use it
-------------

* Add the Maven repository

        <repository>
            <id>federecio-snapshots</id>
            <url>https://repository-federecio1.forge.cloudbees.com/snapshot/</url>
        </repository>


* Add the Maven dependency

        <dependency>
            <groupId>com.federecio</groupId>
            <artifactId>dropwizard-junit</artifactId>
            <version>0.1</version>
            <scope>test</scope>
        </dependency>


* Write your tests

        @RunWith(DropwizardJunitRunner.class)
        @DropwizardTestConfig(serviceClass = YourServiceClass.class, yamlFile = "/yourconfig.yaml")
        public class YourTest {
            // cool tests here - your Dropwizard service has been started
        }