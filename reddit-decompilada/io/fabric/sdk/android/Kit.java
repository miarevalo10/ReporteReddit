package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.AsyncTask.C21184;
import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Task;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.Executor;

public abstract class Kit<Result> implements Comparable<Kit> {
    Context context;
    final DependsOn dependsOnAnnotation = ((DependsOn) getClass().getAnnotation(DependsOn.class));
    Fabric fabric;
    IdManager idManager;
    InitializationCallback<Result> initializationCallback;
    InitializationTask<Result> initializationTask = new InitializationTask(this);

    public abstract Result doInBackground();

    public abstract String getIdentifier();

    public abstract String getVersion();

    protected void onCancelled(Result result) {
    }

    protected void onPostExecute(Result result) {
    }

    public boolean onPreExecute() {
        return true;
    }

    void injectParameters(Context context, Fabric fabric, InitializationCallback<Result> initializationCallback, IdManager idManager) {
        this.fabric = fabric;
        this.context = new FabricContext(context, getIdentifier(), getPath());
        this.initializationCallback = initializationCallback;
        this.idManager = idManager;
    }

    final void initialize() {
        AsyncTask asyncTask = this.initializationTask;
        Void[] voidArr = new Void[]{null};
        Executor proxyExecutor = new ProxyExecutor(this.fabric.f24695c, asyncTask);
        if (asyncTask.f24815f != Status.PENDING) {
            switch (C21184.f24792a[asyncTask.f24815f.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                default:
                    break;
            }
        }
        asyncTask.f24815f = Status.RUNNING;
        asyncTask.mo6589a();
        asyncTask.f24813d.f24803b = voidArr;
        proxyExecutor.execute(asyncTask.f24814e);
    }

    protected IdManager getIdManager() {
        return this.idManager;
    }

    public Context getContext() {
        return this.context;
    }

    public Fabric getFabric() {
        return this.fabric;
    }

    public String getPath() {
        StringBuilder stringBuilder = new StringBuilder(".Fabric");
        stringBuilder.append(File.separator);
        stringBuilder.append(getIdentifier());
        return stringBuilder.toString();
    }

    public int compareTo(Kit kit) {
        if (containsAnnotatedDependency(kit)) {
            return 1;
        }
        if (kit.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (hasAnnotatedDependency() && !kit.hasAnnotatedDependency()) {
            return 1;
        }
        if (hasAnnotatedDependency() || kit.hasAnnotatedDependency() == null) {
            return null;
        }
        return -1;
    }

    boolean containsAnnotatedDependency(Kit kit) {
        if (hasAnnotatedDependency()) {
            for (Class isAssignableFrom : this.dependsOnAnnotation.m26383a()) {
                if (isAssignableFrom.isAssignableFrom(kit.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    protected Collection<Task> getDependencies() {
        return this.initializationTask.getDependencies();
    }
}
