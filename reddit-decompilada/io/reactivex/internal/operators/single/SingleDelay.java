package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class SingleDelay<T> extends Single<T> {
    final SingleSource<? extends T> f35771a;
    final long f35772b;
    final TimeUnit f35773c;
    final Scheduler f35774d;
    final boolean f35775e;

    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> f32317a;
        final /* synthetic */ SingleDelay f32318b;
        private final SequentialDisposable f32319c;

        final class OnError implements Runnable {
            final /* synthetic */ Delay f25147a;
            private final Throwable f25148b;

            OnError(Delay delay, Throwable th) {
                this.f25147a = delay;
                this.f25148b = th;
            }

            public final void run() {
                this.f25147a.f32317a.onError(this.f25148b);
            }
        }

        final class OnSuccess implements Runnable {
            final /* synthetic */ Delay f25149a;
            private final T f25150b;

            OnSuccess(Delay delay, T t) {
                this.f25149a = delay;
                this.f25150b = t;
            }

            public final void run() {
                this.f25149a.f32317a.onSuccess(this.f25150b);
            }
        }

        Delay(SingleDelay singleDelay, SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.f32318b = singleDelay;
            this.f32319c = sequentialDisposable;
            this.f32317a = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f32319c, disposable);
        }

        public final void onSuccess(T t) {
            DisposableHelper.m32094c(this.f32319c, this.f32318b.f35774d.mo5630a(new OnSuccess(this, t), this.f32318b.f35772b, this.f32318b.f35773c));
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32094c(this.f32319c, this.f32318b.f35774d.mo5630a(new OnError(this, th), this.f32318b.f35775e != null ? this.f32318b.f35772b : 0, this.f32318b.f35773c));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f35771a = singleSource;
        this.f35772b = j;
        this.f35773c = timeUnit;
        this.f35774d = scheduler;
        this.f35775e = z;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Object sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.f35771a.subscribe(new Delay(this, sequentialDisposable, singleObserver));
    }
}
