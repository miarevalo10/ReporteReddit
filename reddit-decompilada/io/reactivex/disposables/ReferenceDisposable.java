package io.reactivex.disposables;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    protected abstract void mo6608a(T t);

    ReferenceDisposable(T t) {
        super(ObjectHelper.m26573a((Object) t, "value is null"));
    }

    public final void mo5626a() {
        if (get() != null) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                mo6608a(andSet);
            }
        }
    }

    public final boolean mo5627b() {
        return get() == null;
    }
}
