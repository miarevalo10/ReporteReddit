package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOperator;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final MaybeOperator<? extends R, ? super T> f37923b;

    public MaybeLift(MaybeSource<T> maybeSource, MaybeOperator<? extends R, ? super T> maybeOperator) {
        super(maybeSource);
        this.f37923b = maybeOperator;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        try {
            this.a.subscribe((MaybeObserver) ObjectHelper.m26573a(this.f37923b.m26481a(), "The operator returned a null MaybeObserver"));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38050a(th, (MaybeObserver) maybeObserver);
        }
    }
}
