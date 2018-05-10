package com.google.android.gms.common.api;

public abstract class ResultTransform<R extends Result, S extends Result> {
    public static Status m4676a(Status status) {
        return status;
    }

    public abstract PendingResult<S> m4677a();
}
