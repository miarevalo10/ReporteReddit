package com.nytimes.android.external.cache3;

public class ExecutionError extends Error {
    public ExecutionError(Error error) {
        super(error);
    }
}
