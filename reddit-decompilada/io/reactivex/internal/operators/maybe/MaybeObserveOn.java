package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Scheduler f37925b;

    static final class ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        final MaybeObserver<? super T> f31492a;
        final Scheduler f31493b;
        T f31494c;
        Throwable f31495d;

        ObserveOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
            this.f31492a = maybeObserver;
            this.f31493b = scheduler;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31492a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31494c = t;
            DisposableHelper.m32094c(this, this.f31493b.mo5677a((Runnable) this));
        }

        public final void onError(Throwable th) {
            this.f31495d = th;
            DisposableHelper.m32094c(this, this.f31493b.mo5677a((Runnable) this));
        }

        public final void onComplete() {
            DisposableHelper.m32094c(this, this.f31493b.mo5677a((Runnable) this));
        }

        public final void run() {
            Throwable th = this.f31495d;
            if (th != null) {
                this.f31495d = null;
                this.f31492a.onError(th);
                return;
            }
            Object obj = this.f31494c;
            if (obj != null) {
                this.f31494c = null;
                this.f31492a.onSuccess(obj);
                return;
            }
            this.f31492a.onComplete();
        }
    }

    public MaybeObserveOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f37925b = scheduler;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new ObserveOnMaybeObserver(maybeObserver, this.f37925b));
    }
}
