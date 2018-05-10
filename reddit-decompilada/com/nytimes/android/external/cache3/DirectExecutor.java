package com.nytimes.android.external.cache3;

import java.util.concurrent.Executor;

enum DirectExecutor implements Executor {
    ;

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }

    private DirectExecutor(String str) {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
