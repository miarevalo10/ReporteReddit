package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long f38060a;
    final TimeUnit f38061b;
    final Scheduler f38062c;
    final boolean f38063d;

    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        final Observer<? super T> f32055b;
        final long f32056c;
        final TimeUnit f32057d;
        final Scheduler f32058e;
        final AtomicReference<Disposable> f32059f = new AtomicReference();
        Disposable f32060g;

        abstract void mo6647c();

        SampleTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f32055b = observer;
            this.f32056c = j;
            this.f32057d = timeUnit;
            this.f32058e = scheduler;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32060g, disposable)) {
                this.f32060g = disposable;
                this.f32055b.onSubscribe(this);
                DisposableHelper.m32094c(this.f32059f, this.f32058e.mo5675a(this, this.f32056c, this.f32056c, this.f32057d));
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            m32579e();
            this.f32055b.onError(th);
        }

        public void onComplete() {
            m32579e();
            mo6647c();
        }

        private void m32579e() {
            DisposableHelper.m32090a(this.f32059f);
        }

        public final void mo5626a() {
            m32579e();
            this.f32060g.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32060g.mo5627b();
        }

        final void m32583d() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f32055b.onNext(andSet);
            }
        }
    }

    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        final AtomicInteger f35720a = new AtomicInteger(1);

        SampleTimedEmitLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        final void mo6647c() {
            m32583d();
            if (this.f35720a.decrementAndGet() == 0) {
                this.b.onComplete();
            }
        }

        public final void run() {
            if (this.f35720a.incrementAndGet() == 2) {
                m32583d();
                if (this.f35720a.decrementAndGet() == 0) {
                    this.b.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        SampleTimedNoLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        final void mo6647c() {
            this.b.onComplete();
        }

        public final void run() {
            m32583d();
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.f38060a = j;
        this.f38061b = timeUnit;
        this.f38062c = scheduler;
        this.f38063d = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Observer serializedObserver = new SerializedObserver(observer);
        if (this.f38063d != null) {
            this.source.subscribe(new SampleTimedEmitLast(serializedObserver, this.f38060a, this.f38061b, this.f38062c));
        } else {
            this.source.subscribe(new SampleTimedNoLast(serializedObserver, this.f38060a, this.f38061b, this.f38062c));
        }
    }
}
