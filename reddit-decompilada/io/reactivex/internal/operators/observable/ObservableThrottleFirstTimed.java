package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long f38096a;
    final TimeUnit f38097b;
    final Scheduler f38098c;

    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        final Observer<? super T> f32199a;
        final long f32200b;
        final TimeUnit f32201c;
        final Worker f32202d;
        Disposable f32203e;
        volatile boolean f32204f;
        boolean f32205g;

        DebounceTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Worker worker) {
            this.f32199a = observer;
            this.f32200b = j;
            this.f32201c = timeUnit;
            this.f32202d = worker;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32203e, disposable)) {
                this.f32203e = disposable;
                this.f32199a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f32204f && !this.f32205g) {
                this.f32204f = true;
                this.f32199a.onNext(t);
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.mo5626a();
                }
                DisposableHelper.m32094c(this, this.f32202d.mo6607a(this, this.f32200b, this.f32201c));
            }
        }

        public final void run() {
            this.f32204f = false;
        }

        public final void onError(Throwable th) {
            if (this.f32205g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32205g = true;
            this.f32199a.onError(th);
            this.f32202d.mo5626a();
        }

        public final void onComplete() {
            if (!this.f32205g) {
                this.f32205g = true;
                this.f32199a.onComplete();
                this.f32202d.mo5626a();
            }
        }

        public final void mo5626a() {
            this.f32203e.mo5626a();
            this.f32202d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32202d.mo5627b();
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f38096a = j;
        this.f38097b = timeUnit;
        this.f38098c = scheduler;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f38096a, this.f38097b, this.f38098c.mo5629a()));
    }
}
