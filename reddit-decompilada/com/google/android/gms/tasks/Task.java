package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

public abstract class Task<TResult> {
    public Task<TResult> mo2306a(OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task<TResult> mo2307a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Task<TResult> mo2308a(Executor executor, OnFailureListener onFailureListener);

    public abstract Task<TResult> mo2309a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener);

    public abstract boolean mo2310a();

    public abstract boolean mo2311b();

    public abstract TResult mo2312c();

    public abstract Exception mo2313d();
}
