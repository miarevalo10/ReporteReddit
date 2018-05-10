package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {
    final CompletableSource f34728a;
    final Scheduler f34729b;

    static final class CompletableObserverImplementation implements CompletableObserver, Disposable, Runnable {
        final CompletableObserver f31191a;
        final Scheduler f31192b;
        Disposable f31193c;
        volatile boolean f31194d;

        CompletableObserverImplementation(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f31191a = completableObserver;
            this.f31192b = scheduler;
        }

        public final void onComplete() {
            if (!this.f31194d) {
                this.f31191a.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.f31194d) {
                RxJavaPlugins.m26757a(th);
            } else {
                this.f31191a.onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31193c, disposable)) {
                this.f31193c = disposable;
                this.f31191a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31194d = true;
            this.f31192b.mo5677a((Runnable) this);
        }

        public final boolean mo5627b() {
            return this.f31194d;
        }

        public final void run() {
            this.f31193c.mo5626a();
            this.f31193c = DisposableHelper.f31095a;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f34728a = completableSource;
        this.f34729b = scheduler;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34728a.subscribe(new CompletableObserverImplementation(completableObserver, this.f34729b));
    }
}
