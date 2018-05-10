package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class CompletableEmpty extends Completable {
    public static final Completable f34734a = new CompletableEmpty();

    private CompletableEmpty() {
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.m38046a(completableObserver);
    }
}
