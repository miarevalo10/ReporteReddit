package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

public final class CompletableOnErrorComplete extends Completable {
    final CompletableSource f34765a;
    final Predicate<? super Throwable> f34766b;

    final class OnError implements CompletableObserver {
        final /* synthetic */ CompletableOnErrorComplete f31218a;
        private final CompletableObserver f31219b;

        OnError(CompletableOnErrorComplete completableOnErrorComplete, CompletableObserver completableObserver) {
            this.f31218a = completableOnErrorComplete;
            this.f31219b = completableObserver;
        }

        public final void onComplete() {
            this.f31219b.onComplete();
        }

        public final void onError(Throwable th) {
            try {
                if (this.f31218a.f34766b.test(th)) {
                    this.f31219b.onComplete();
                } else {
                    this.f31219b.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f31219b.onError(new CompositeException(th, th2));
            }
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31219b.onSubscribe(disposable);
        }
    }

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.f34765a = completableSource;
        this.f34766b = predicate;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34765a.subscribe(new OnError(this, completableObserver));
    }
}
