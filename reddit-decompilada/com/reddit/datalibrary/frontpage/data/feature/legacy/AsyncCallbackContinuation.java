package com.reddit.datalibrary.frontpage.data.feature.legacy;

import bolts.Continuation;
import bolts.Task;

@Deprecated
public class AsyncCallbackContinuation<T> implements Continuation<T, Void> {
    private final AsyncCallback<T> f15857a;

    public static <T> AsyncCallbackContinuation<T> m15917a(AsyncCallback<T> asyncCallback) {
        return new AsyncCallbackContinuation(asyncCallback);
    }

    private AsyncCallbackContinuation(AsyncCallback<T> asyncCallback) {
        this.f15857a = asyncCallback;
    }

    public final /* synthetic */ Object mo769a(Task task) throws Exception {
        if (this.f15857a != null) {
            if (!task.m2417b() || task.m2419d()) {
                this.f15857a.mo3013a(task.m2421f());
            } else {
                this.f15857a.mo3014a(task.m2420e());
            }
        }
        return null;
    }
}
