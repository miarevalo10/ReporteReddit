package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn extends Completable {
    final CompletableSource f34763a;
    final Scheduler f34764b;

    static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        final CompletableObserver f31215a;
        final Scheduler f31216b;
        Throwable f31217c;

        ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f31215a = completableObserver;
            this.f31216b = scheduler;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31215a.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.f31217c = th;
            DisposableHelper.m32094c(this, this.f31216b.mo5677a((Runnable) this));
        }

        public final void onComplete() {
            DisposableHelper.m32094c(this, this.f31216b.mo5677a((Runnable) this));
        }

        public final void run() {
            Throwable th = this.f31217c;
            if (th != null) {
                this.f31217c = null;
                this.f31215a.onError(th);
                return;
            }
            this.f31215a.onComplete();
        }
    }

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f34763a = completableSource;
        this.f34764b = scheduler;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34763a.subscribe(new ObserveOnCompletableObserver(completableObserver, this.f34764b));
    }
}
