package com.federecio.dropwizard.junitrunner;

import com.codahale.dropwizard.Application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Federico Recio
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DropwizardTestConfig {

    Class<? extends Application<?>> applicationClass();

    String yamlFile();
}