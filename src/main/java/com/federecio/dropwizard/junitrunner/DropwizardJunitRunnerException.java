package com.federecio.dropwizard.junitrunner;

/**
 * @author Federico Recio
 */
public class DropwizardJunitRunnerException extends RuntimeException {

    public DropwizardJunitRunnerException(String s) {
        super(s);
    }

    public DropwizardJunitRunnerException(Exception e) {
        super(e);
    }

    public DropwizardJunitRunnerException(String s, Exception e) {
        super(s, e);
    }
}
