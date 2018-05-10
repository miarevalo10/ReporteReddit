package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PriorityFutureTask<V> extends FutureTask<V> implements Dependency<Task>, PriorityProvider, Task {
    final Object f31006b;

    public /* synthetic */ void addDependency(Object obj) {
        ((Dependency) ((PriorityProvider) mo6596a())).addDependency((Task) obj);
    }

    public PriorityFutureTask(Callable<V> callable) {
        super(callable);
        this.f31006b = m31964a(callable);
    }

    public PriorityFutureTask(Runnable runnable, V v) {
        super(runnable, v);
        this.f31006b = m31964a(runnable);
    }

    public int compareTo(Object obj) {
        return ((PriorityProvider) mo6596a()).compareTo(obj);
    }

    public Collection<Task> getDependencies() {
        return ((Dependency) ((PriorityProvider) mo6596a())).getDependencies();
    }

    public boolean areDependenciesMet() {
        return ((Dependency) ((PriorityProvider) mo6596a())).areDependenciesMet();
    }

    public Priority getPriority() {
        return ((PriorityProvider) mo6596a()).getPriority();
    }

    public void setFinished(boolean z) {
        ((Task) ((PriorityProvider) mo6596a())).setFinished(z);
    }

    public boolean isFinished() {
        return ((Task) ((PriorityProvider) mo6596a())).isFinished();
    }

    public void setError(Throwable th) {
        ((Task) ((PriorityProvider) mo6596a())).setError(th);
    }

    public <T extends Dependency<Task> & PriorityProvider & Task> T mo6596a() {
        return (Dependency) this.f31006b;
    }

    private static <T extends Dependency<Task> & PriorityProvider & Task> T m31964a(Object obj) {
        if (PriorityTask.isProperDelegate(obj)) {
            return (Dependency) obj;
        }
        return new PriorityTask();
    }
}
