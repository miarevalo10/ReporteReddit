package com.birbit.android.jobqueue;

import java.util.Collection;

public class CancelResult {
    private Collection<Job> f2846a;
    private Collection<Job> f2847b;

    public interface AsyncCancelCallback {
    }

    public CancelResult(Collection<Job> collection, Collection<Job> collection2) {
        this.f2846a = collection;
        this.f2847b = collection2;
    }
}
