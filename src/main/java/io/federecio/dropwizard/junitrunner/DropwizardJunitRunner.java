package io.federecio.dropwizard.junitrunner;

import io.dropwizard.Application;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * @author Federico Recio
 */
public class DropwizardJunitRunner extends BlockJUnit4ClassRunner {

    private Application<?> application;

    public DropwizardJunitRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected Statement classBlock(final RunNotifier notifier) {
        DropwizardTestConfig dropwizardTestConfig = getTestConfigOrFail();
        URL resource = getYamlConfigFileOrFail(dropwizardTestConfig);
        try {
            application = dropwizardTestConfig.applicationClass().newInstance();
            application.run(new String[]{"server", resource.getFile()});
        } catch (IllegalAccessException e) {
            throw new DropwizardJunitRunnerException("Could not access class or class' constructor on " + dropwizardTestConfig.applicationClass(), e);
        } catch (InstantiationException e) {
            throw new DropwizardJunitRunnerException("Could not instantiate class " + dropwizardTestConfig.applicationClass(), e);
        } catch (Exception e) {
            throw new DropwizardJunitRunnerException(e);
        }
        return super.classBlock(notifier);
    }

    protected Application<?> getApplication() {
        return application;
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