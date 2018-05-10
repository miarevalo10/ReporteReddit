package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Scheduler f37936b;

    static final class SubscribeTask<T> implements Runnable {
        final MaybeObserver<? super T> f25091a;
        final MaybeSource<T> f25092b;

        SubscribeTask(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f25091a = maybeObserver;
            this.f25092b = maybeSource;
        }

        public final void run() {
            this.f25092b.subscribe(this.f25091a);
        }
    }

    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final SequentialDisposable f31510a = new SequentialDisposable();
        final MaybeObserver<? super T> f31511b;

        SubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31511b = maybeObserver;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f31510a.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            this.f31511b.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31511b.onError(th);
        }

        public final void onComplete() {
            this.f31511b.onComplete();
        }
    }

    public MaybeSubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f37936b = scheduler;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(subscribeOnMaybeObserver);
        DisposableHelper.m32094c(subscribeOnMaybeObserver.f31510a, this.f37936b.mo5677a(new SubscribeTask(subscribeOnMaybeObserver, this.a)));
    }
}
