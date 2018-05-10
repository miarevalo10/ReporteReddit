package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;
import io.reactivex.internal.observers.FullArbiterObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    static final Disposable f38104e = new EmptyDisposable();
    final long f38105a;
    final TimeUnit f38106b;
    final Scheduler f38107c;
    final ObservableSource<? extends T> f38108d;

    static final class EmptyDisposable implements Disposable {
        public final void mo5626a() {
        }

        public final boolean mo5627b() {
            return true;
        }

        EmptyDisposable() {
        }
    }

    static final class TimeoutTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        final Observer<? super T> f32224a;
        final long f32225b;
        final TimeUnit f32226c;
        final Worker f32227d;
        Disposable f32228e;
        volatile long f32229f;
        volatile boolean f32230g;

        final class TimeoutTask implements Runnable {
            final /* synthetic */ TimeoutTimedObserver f25134a;
            private final long f25135b;

            TimeoutTask(TimeoutTimedObserver timeoutTimedObserver, long j) {
                this.f25134a = timeoutTimedObserver;
                this.f25135b = j;
            }

            public final void run() {
                if (this.f25135b == this.f25134a.f32229f) {
                    this.f25134a.f32230g = true;
                    this.f25134a.f32228e.mo5626a();
                    DisposableHelper.m32090a(this.f25134a);
                    this.f25134a.f32224a.onError(new TimeoutException());
                    this.f25134a.f32227d.mo5626a();
                }
            }
        }

        TimeoutTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Worker worker) {
            this.f32224a = observer;
            this.f32225b = j;
            this.f32226c = timeUnit;
            this.f32227d = worker;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32228e, disposable)) {
                this.f32228e = disposable;
                this.f32224a.onSubscribe(this);
                m32648a(0);
            }
        }

        public final void onNext(T t) {
            if (!this.f32230g) {
                long j = this.f32229f + 1;
                this.f32229f = j;
                this.f32224a.onNext(t);
                m32648a(j);
            }
        }

        private void m32648a(long j) {
            Disposable disposable = (Disposable) get();
            if (disposable != null) {
                disposable.mo5626a();
            }
            if (compareAndSet(disposable, ObservableTimeoutTimed.f38104e)) {
                DisposableHelper.m32094c(this, this.f32227d.mo6607a(new TimeoutTask(this, j), this.f32225b, this.f32226c));
            }
        }

        public final void onError(Throwable th) {
            if (this.f32230g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32230g = true;
            this.f32224a.onError(th);
            mo5626a();
        }

        public final void onComplete() {
            if (!this.f32230g) {
                this.f32230g = true;
                this.f32224a.onComplete();
                mo5626a();
            }
        }

        public final void mo5626a() {
            this.f32228e.mo5626a();
            this.f32227d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32227d.mo5627b();
        }
    }

    static final class TimeoutTimedOtherObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        final Observer<? super T> f32231a;
        final long f32232b;
        final TimeUnit f32233c;
        final Worker f32234d;
        final ObservableSource<? extends T> f32235e;
        Disposable f32236f;
        final ObserverFullArbiter<T> f32237g;
        volatile long f32238h;
        volatile boolean f32239i;

        final class SubscribeNext implements Runnable {
            final /* synthetic */ TimeoutTimedOtherObserver f25136a;
            private final long f25137b;

            SubscribeNext(TimeoutTimedOtherObserver timeoutTimedOtherObserver, long j) {
                this.f25136a = timeoutTimedOtherObserver;
                this.f25137b = j;
            }

            public final void run() {
                if (this.f25137b == this.f25136a.f32238h) {
                    this.f25136a.f32239i = true;
                    this.f25136a.f32236f.mo5626a();
                    DisposableHelper.m32090a(this.f25136a);
                    TimeoutTimedOtherObserver timeoutTimedOtherObserver = this.f25136a;
                    timeoutTimedOtherObserver.f32235e.subscribe(new FullArbiterObserver(timeoutTimedOtherObserver.f32237g));
                    this.f25136a.f32234d.mo5626a();
                }
            }
        }

        TimeoutTimedOtherObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Worker worker, ObservableSource<? extends T> observableSource) {
            this.f32231a = observer;
            this.f32232b = j;
            this.f32233c = timeUnit;
            this.f32234d = worker;
            this.f32235e = observableSource;
            this.f32237g = new ObserverFullArbiter(observer, this);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32236f, disposable)) {
                this.f32236f = disposable;
                if (this.f32237g.m38060a(disposable) != null) {
                    this.f32231a.onSubscribe(this.f32237g);
                    m32651a(0);
                }
            }
        }

        public final void onNext(T t) {
            if (!this.f32239i) {
                long j = this.f32238h + 1;
                this.f32238h = j;
                if (this.f32237g.m38061a((Object) t, this.f32236f) != null) {
                    m32651a(j);
                }
            }
        }

        private void m32651a(long j) {
            Disposable disposable = (Disposable) get();
            if (disposable != null) {
                disposable.mo5626a();
            }
            if (compareAndSet(disposable, ObservableTimeoutTimed.f38104e)) {
                DisposableHelper.m32094c(this, this.f32234d.mo6607a(new SubscribeNext(this, j), this.f32232b, this.f32233c));
            }
        }

        public final void onError(Throwable th) {
            if (this.f32239i) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32239i = true;
            this.f32237g.m38059a(th, this.f32236f);
            this.f32234d.mo5626a();
        }

        public final void onComplete() {
            if (!this.f32239i) {
                this.f32239i = true;
                this.f32237g.m38062b(this.f32236f);
                this.f32234d.mo5626a();
            }
        }

        public final void mo5626a() {
            this.f32236f.mo5626a();
            this.f32234d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32234d.mo5627b();
        }
    }

    public ObservableTimeoutTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f38105a = j;
        this.f38106b = timeUnit;
        this.f38107c = scheduler;
        this.f38108d = observableSource2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        if (this.f38108d == null) {
            this.source.subscribe(new TimeoutTimedObserver(new SerializedObserver(observer), this.f38105a, this.f38106b, this.f38107c.mo5629a()));
            return;
        }
        this.source.subscribe(new TimeoutTimedOtherObserver(observer, this.f38105a, this.f38106b, this.f38107c.mo5629a(), this.f38108d));
    }
}
