package com.federecio.dropwizard.junitrunner;

import java.lang.annotation.Annotation;
import java.net.URL;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.yammer.dropwizard.Service;

/**
 * @author Federico Recio
 */
public class DropwizardJunitRunner extends BlockJUnit4ClassRunner {

    private Service<?> service;

    public DropwizardJunitRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected Statement classBlock(final RunNotifier notifier) {
        DropwizardTestConfig dropwizardTestConfig = getTestConfigOrFail();
        URL resource = getYamlConfigFileOrFail(dropwizardTestConfig);
        try {
            service = dropwizardTestConfig.serviceClass().newInstance();
            service.run(new String[]{"server", resource.getFile()});
        } catch (IllegalAccessException e) {
            throw new DropwizardJunitRunnerException("Could not access class or class' constructor on " + dropwizardTestConfig.serviceClass(), e);
        } catch (InstantiationException e) {
            throw new DropwizardJunitRunnerException("Could not instantiate class " + dropwizardTestConfig.serviceClass(), e);
        } catch (Exception e) {
            throw new DropwizardJunitRunnerException(e);
        }
        return super.classBlock(notifier);
    }

    protected Service<?> getService() {
        return service;
    }

    private DropwizardTestConfig getTestConfigOrFail() {
        Annotation[] annotations = getTestClass().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(DropwizardTestConfig.class)) {
                return (DropwizardTestConfig) annotation;
            }
        }
        throw new DropwizardJunitRunnerException("Test class needs to be annotated with @" + DropwizardTestConfig.class.getSimpleName());
    }

    private URL getYamlConfigFileOrFail(DropwizardTestConfig dropwizardTestConfig) {
        URL resource = getClass().getResource(dropwizardTestConfig.yamlFile());
        if(resource == null) {
            throw new DropwizardJunitRunnerException("Yaml file not found");
        }
        return resource;
    }
}