package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableLift extends Completable {
    final CompletableSource f34747a;
    final CompletableOperator f34748b;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.f34747a = completableSource;
        this.f34748b = completableOperator;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.f34747a.subscribe(this.f34748b.m26470a());
        } catch (CompletableObserver completableObserver2) {
            throw completableObserver2;
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
        }
    }
}
