dropwizard-junit
================

a JUnit TestRunner that allows to load Dropwizard 0.7.1 resources for testing


How to use it
-------------

* Add the Maven repository

        <repository>
            <id>federecio-releases</id>
            <url>https://repository-federecio1.forge.cloudbees.com/release/</url>
        </repository>


* Add the Maven dependency

        <dependency>
            <groupId>com.federecio</groupId>
            <artifactId>dropwizard-junit</artifactId>
            <version>0.4</version>
            <scope>test</scope>
        </dependency>

*Note: you will need to add the junit dependency to your project*

* Write your tests

        @RunWith(DropwizardJunitRunner.class)
        @DropwizardTestConfig(serviceClass = YourServiceClass.class, yamlFile = "/yourconfig.yaml")
        public class YourTest {
            // cool tests here - your Dropwizard service has been started
        }

Contributors
------------

* Federico Recio ([@federecio](http://twitter.com/federecio))
* Damien Raude-Morvan ([drazzib](https://github.com/drazzib))