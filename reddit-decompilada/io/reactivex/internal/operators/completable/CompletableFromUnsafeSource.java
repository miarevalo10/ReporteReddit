package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;

public final class CompletableFromUnsafeSource extends Completable {
    final CompletableSource f34745a;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.f34745a = completableSource;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34745a.subscribe(completableObserver);
    }
}
