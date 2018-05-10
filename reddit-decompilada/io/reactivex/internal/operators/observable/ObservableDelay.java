package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long f37980a;
    final TimeUnit f37981b;
    final Scheduler f37982c;
    final boolean f37983d;

    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f31734a;
        final long f31735b;
        final TimeUnit f31736c;
        final Worker f31737d;
        final boolean f31738e;
        Disposable f31739f;

        final class OnComplete implements Runnable {
            final /* synthetic */ DelayObserver f25112a;

            OnComplete(DelayObserver delayObserver) {
                this.f25112a = delayObserver;
            }

            public final void run() {
                try {
                    this.f25112a.f31734a.onComplete();
                } finally {
                    this.f25112a.f31737d.mo5626a();
                }
            }
        }

        final class OnError implements Runnable {
            final /* synthetic */ DelayObserver f25113a;
            private final Throwable f25114b;

            OnError(DelayObserver delayObserver, Throwable th) {
                this.f25113a = delayObserver;
                this.f25114b = th;
            }

            public final void run() {
                try {
                    this.f25113a.f31734a.onError(this.f25114b);
                } finally {
                    this.f25113a.f31737d.mo5626a();
                }
            }
        }

        final class OnNext implements Runnable {
            final /* synthetic */ DelayObserver f25115a;
            private final T f25116b;

            OnNext(DelayObserver delayObserver, T t) {
                this.f25115a = delayObserver;
                this.f25116b = t;
            }

            public final void run() {
                this.f25115a.f31734a.onNext(this.f25116b);
            }
        }

        DelayObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Worker worker, boolean z) {
            this.f31734a = observer;
            this.f31735b = j;
            this.f31736c = timeUnit;
            this.f31737d = worker;
            this.f31738e = z;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31739f, disposable)) {
                this.f31739f = disposable;
                this.f31734a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31737d.mo6607a(new OnNext(this, t), this.f31735b, this.f31736c);
        }

        public final void onError(Throwable th) {
            this.f31737d.mo6607a(new OnError(this, th), this.f31738e != null ? this.f31735b : 0, this.f31736c);
        }

        public final void onComplete() {
            this.f31737d.mo6607a(new OnComplete(this), this.f31735b, this.f31736c);
        }

        public final void mo5626a() {
            this.f31739f.mo5626a();
            this.f31737d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31737d.mo5627b();
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.f37980a = j;
        this.f37981b = timeUnit;
        this.f37982c = scheduler;
        this.f37983d = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DelayObserver(!this.f37983d ? new SerializedObserver(observer) : observer, this.f37980a, this.f37981b, this.f37982c.mo5629a(), this.f37983d));
    }
}
