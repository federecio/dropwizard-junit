dropwizard-junit
================

A JUnit TestRunner that allows to load Dropwizard 1.0.0 resources for testing

__NOTE__: for Dropwizard 0.8.x compatibility use project version 0.6
__NOTE__: for Dropwizard 0.7.x compatibility use project version 0.5

License
-------

http://www.apache.org/licenses/LICENSE-2.0

How to use it
-------------

* Add the Maven dependency (now available in Maven Central!)

        <dependency>
            <groupId>io.federecio</groupId>
            <artifactId>dropwizard-junit</artifactId>
            <version>0.7</version>
            <scope>test</scope>
        </dependency>

*Note: you will need to add the junit dependency to your project*

* Write your tests

        @RunWith(DropwizardJunitRunner.class)
        @DropwizardTestConfig(applicationClass = YourServiceClass.class, yamlFile = "/yourconfig.yaml")
        public class YourTest {
            // cool tests here - your Dropwizard service has been started
        }

Contributors
------------

* Federico Recio ([@federecio](http://twitter.com/federecio))
* Jochen Szostek ([prefabsoft] (http://prefabsoft.com)
* Damien Raude-Morvan ([drazzib](https://github.com/drazzib))
* Thiago Moretto ([thiagomoretto] (https://github.com/thiagomoretto))