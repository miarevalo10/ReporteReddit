package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;

public final class Disposables {
    public static Disposable m26513a(Runnable runnable) {
        ObjectHelper.m26573a((Object) runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static Disposable m26512a() {
        return m26513a(Functions.f25013b);
    }

    public static Disposable m26514b() {
        return EmptyDisposable.INSTANCE;
    }
}
