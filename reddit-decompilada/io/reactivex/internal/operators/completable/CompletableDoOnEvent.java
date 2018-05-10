package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class CompletableDoOnEvent extends Completable {
    final CompletableSource f34732a;
    final Consumer<? super Throwable> f34733b;

    final class DoOnEvent implements CompletableObserver {
        final /* synthetic */ CompletableDoOnEvent f31198a;
        private final CompletableObserver f31199b;

        DoOnEvent(CompletableDoOnEvent completableDoOnEvent, CompletableObserver completableObserver) {
            this.f31198a = completableDoOnEvent;
            this.f31199b = completableObserver;
        }

        public final void onComplete() {
            try {
                this.f31198a.f34733b.accept(null);
                this.f31199b.onComplete();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.f31199b.onError(th);
            }
        }

        public final void onError(Throwable th) {
            try {
                this.f31198a.f34733b.accept(th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                th = new CompositeException(th, th2);
            }
            this.f31199b.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31199b.onSubscribe(disposable);
        }
    }

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.f34732a = completableSource;
        this.f34733b = consumer;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34732a.subscribe(new DoOnEvent(this, completableObserver));
    }
}
