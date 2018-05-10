package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUnsubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Scheduler f37944b;

    static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        final MaybeObserver<? super T> f31542a;
        final Scheduler f31543b;
        Disposable f31544c;

        UnsubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
            this.f31542a = maybeObserver;
            this.f31543b = scheduler;
        }

        public final void mo5626a() {
            Disposable disposable = (Disposable) getAndSet(DisposableHelper.f31095a);
            if (disposable != DisposableHelper.f31095a) {
                this.f31544c = disposable;
                this.f31543b.mo5677a((Runnable) this);
            }
        }

        public final void run() {
            this.f31544c.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31542a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31542a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31542a.onError(th);
        }

        public final void onComplete() {
            this.f31542a.onComplete();
        }
    }

    public MaybeUnsubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f37944b = scheduler;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new UnsubscribeOnMaybeObserver(maybeObserver, this.f37944b));
    }
}
