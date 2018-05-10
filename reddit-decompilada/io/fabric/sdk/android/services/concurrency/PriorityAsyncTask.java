package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import java.util.Collection;
import java.util.concurrent.Executor;

public abstract class PriorityAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements Dependency<Task>, PriorityProvider, Task {
    private final PriorityTask f31005a = new PriorityTask();

    private static class ProxyExecutor<Result> implements Executor {
        private final Executor f24825a;
        private final PriorityAsyncTask f24826b;

        public ProxyExecutor(Executor executor, PriorityAsyncTask priorityAsyncTask) {
            this.f24825a = executor;
            this.f24826b = priorityAsyncTask;
        }

        public void execute(Runnable runnable) {
            this.f24825a.execute(new PriorityFutureTask<Result>(this, runnable) {
                final /* synthetic */ ProxyExecutor f34676a;

                public final <T extends Dependency<Task> & PriorityProvider & Task> T mo6596a() {
                    return this.f34676a.f24826b;
                }
            });
        }
    }

    public /* synthetic */ void addDependency(Object obj) {
        m31963a((Task) obj);
    }

    public int compareTo(Object obj) {
        return Priority.m26384a(this, obj);
    }

    public final void m31963a(Task task) {
        if (this.f24815f != Status.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        this.f31005a.addDependency(task);
    }

    public Collection<Task> getDependencies() {
        return this.f31005a.getDependencies();
    }

    public boolean areDependenciesMet() {
        return this.f31005a.areDependenciesMet();
    }

    public Priority getPriority() {
        return this.f31005a.getPriority();
    }

    public void setFinished(boolean z) {
        this.f31005a.setFinished(z);
    }

    public boolean isFinished() {
        return this.f31005a.isFinished();
    }

    public void setError(Throwable th) {
        this.f31005a.setError(th);
    }
}
