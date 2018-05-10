package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout<T> extends Single<T> {
    final SingleSource<T> f35845a;
    final long f35846b;
    final TimeUnit f35847c;
    final Scheduler f35848d;
    final SingleSource<? extends T> f35849e;

    static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        final SingleObserver<? super T> f32386a;
        final AtomicReference<Disposable> f32387b = new AtomicReference();
        final TimeoutFallbackObserver<T> f32388c;
        SingleSource<? extends T> f32389d;

        static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            final SingleObserver<? super T> f32385a;

            TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.f32385a = singleObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onSuccess(T t) {
                this.f32385a.onSuccess(t);
            }

            public final void onError(Throwable th) {
                this.f32385a.onError(th);
            }
        }

        TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f32386a = singleObserver;
            this.f32389d = singleSource;
            if (singleSource != null) {
                this.f32388c = new TimeoutFallbackObserver(singleObserver);
            } else {
                this.f32388c = null;
            }
        }

        public final void run() {
            Disposable disposable = (Disposable) get();
            if (disposable != DisposableHelper.f31095a && compareAndSet(disposable, DisposableHelper.f31095a)) {
                if (disposable != null) {
                    disposable.mo5626a();
                }
                SingleSource singleSource = this.f32389d;
                if (singleSource == null) {
                    this.f32386a.onError(new TimeoutException());
                } else {
                    this.f32389d = null;
                    singleSource.subscribe(this.f32388c);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            Disposable disposable = (Disposable) get();
            if (disposable != DisposableHelper.f31095a && compareAndSet(disposable, DisposableHelper.f31095a)) {
                DisposableHelper.m32090a(this.f32387b);
                this.f32386a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            Disposable disposable = (Disposable) get();
            if (disposable == DisposableHelper.f31095a || !compareAndSet(disposable, DisposableHelper.f31095a)) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            DisposableHelper.m32090a(this.f32387b);
            this.f32386a.onError(th);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            DisposableHelper.m32090a(this.f32387b);
            if (this.f32388c != null) {
                DisposableHelper.m32090a(this.f32388c);
            }
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleTimeout(SingleSource<T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.f35845a = singleSource;
        this.f35846b = j;
        this.f35847c = timeUnit;
        this.f35848d = scheduler;
        this.f35849e = singleSource2;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Object timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.f35849e);
        singleObserver.onSubscribe(timeoutMainObserver);
        DisposableHelper.m32094c(timeoutMainObserver.f32387b, this.f35848d.mo5630a(timeoutMainObserver, this.f35846b, this.f35847c));
        this.f35845a.subscribe(timeoutMainObserver);
    }
}
