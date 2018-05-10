package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn extends Completable {
    final CompletableSource f34776a;
    final Scheduler f34777b;

    static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        final CompletableObserver f31227a;
        final SequentialDisposable f31228b = new SequentialDisposable();
        final CompletableSource f31229c;

        SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f31227a = completableObserver;
            this.f31229c = completableSource;
        }

        public final void run() {
            this.f31229c.subscribe(this);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onError(Throwable th) {
            this.f31227a.onError(th);
        }

        public final void onComplete() {
            this.f31227a.onComplete();
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f31228b.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f34776a = completableSource;
        this.f34777b = scheduler;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Runnable subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.f34776a);
        completableObserver.onSubscribe(subscribeOnObserver);
        DisposableHelper.m32094c(subscribeOnObserver.f31228b, this.f34777b.mo5677a(subscribeOnObserver));
    }
}
