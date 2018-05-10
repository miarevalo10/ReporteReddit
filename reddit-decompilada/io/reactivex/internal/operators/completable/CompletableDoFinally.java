package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableDoFinally extends Completable {
    final CompletableSource f34730a;
    final Action f34731b;

    static final class DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {
        final CompletableObserver f31195a;
        final Action f31196b;
        Disposable f31197c;

        DoFinallyObserver(CompletableObserver completableObserver, Action action) {
            this.f31195a = completableObserver;
            this.f31196b = action;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31197c, disposable)) {
                this.f31197c = disposable;
                this.f31195a.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.f31195a.onError(th);
            m32151c();
        }

        public final void onComplete() {
            this.f31195a.onComplete();
            m32151c();
        }

        public final void mo5626a() {
            this.f31197c.mo5626a();
            m32151c();
        }

        public final boolean mo5627b() {
            return this.f31197c.mo5627b();
        }

        private void m32151c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f31196b.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.f34730a = completableSource;
        this.f34731b = action;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34730a.subscribe(new DoFinallyObserver(completableObserver, this.f34731b));
    }
}
