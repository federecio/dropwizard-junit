package com.federecio.dropwizard.junitrunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.yammer.dropwizard.Service;

/**
 * @author Federico Recio
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DropwizardTestConfig {

    Class<? extends Service<?>> serviceClass();

    String yamlFile();
}