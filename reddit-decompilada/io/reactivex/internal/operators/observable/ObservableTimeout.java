package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.FullArbiterObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> f38101a;
    final Function<? super T, ? extends ObservableSource<V>> f38102b;
    final ObservableSource<? extends T> f38103c;

    interface OnTimeout {
        void mo5672a(long j);

        void mo5673a(Throwable th);
    }

    static final class TimeoutObserver<T, U, V> extends AtomicReference<Disposable> implements Observer<T>, Disposable, OnTimeout {
        final Observer<? super T> f32211a;
        final ObservableSource<U> f32212b;
        final Function<? super T, ? extends ObservableSource<V>> f32213c;
        Disposable f32214d;
        volatile long f32215e;

        TimeoutObserver(Observer<? super T> observer, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
            this.f32211a = observer;
            this.f32212b = observableSource;
            this.f32213c = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32214d, disposable)) {
                this.f32214d = disposable;
                disposable = this.f32211a;
                ObservableSource observableSource = this.f32212b;
                if (observableSource != null) {
                    Observer timeoutInnerObserver = new TimeoutInnerObserver(this, 0);
                    if (compareAndSet(null, timeoutInnerObserver)) {
                        disposable.onSubscribe(this);
                        observableSource.subscribe(timeoutInnerObserver);
                    }
                    return;
                }
                disposable.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            long j = this.f32215e + 1;
            this.f32215e = j;
            this.f32211a.onNext(t);
            Disposable disposable = (Disposable) get();
            if (disposable != null) {
                disposable.mo5626a();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f32213c.apply(t), "The ObservableSource returned is null");
                Observer timeoutInnerObserver = new TimeoutInnerObserver(this, j);
                if (compareAndSet(disposable, timeoutInnerObserver)) {
                    observableSource.subscribe(timeoutInnerObserver);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                mo5626a();
                this.f32211a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f32211a.onError(th);
        }

        public final void onComplete() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f32211a.onComplete();
        }

        public final void mo5626a() {
            if (DisposableHelper.m32090a((AtomicReference) this)) {
                this.f32214d.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.f32214d.mo5627b();
        }

        public final void mo5672a(long j) {
            if (j == this.f32215e) {
                mo5626a();
                this.f32211a.onError(new TimeoutException());
            }
        }

        public final void mo5673a(Throwable th) {
            this.f32214d.mo5626a();
            this.f32211a.onError(th);
        }
    }

    static final class TimeoutOtherObserver<T, U, V> extends AtomicReference<Disposable> implements Observer<T>, Disposable, OnTimeout {
        final Observer<? super T> f32216a;
        final ObservableSource<U> f32217b;
        final Function<? super T, ? extends ObservableSource<V>> f32218c;
        final ObservableSource<? extends T> f32219d;
        final ObserverFullArbiter<T> f32220e;
        Disposable f32221f;
        boolean f32222g;
        volatile long f32223h;

        TimeoutOtherObserver(Observer<? super T> observer, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
            this.f32216a = observer;
            this.f32217b = observableSource;
            this.f32218c = function;
            this.f32219d = observableSource2;
            this.f32220e = new ObserverFullArbiter(observer, this);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32221f, disposable)) {
                this.f32221f = disposable;
                this.f32220e.m38060a(disposable);
                disposable = this.f32216a;
                ObservableSource observableSource = this.f32217b;
                if (observableSource != null) {
                    Observer timeoutInnerObserver = new TimeoutInnerObserver(this, 0);
                    if (compareAndSet(null, timeoutInnerObserver)) {
                        disposable.onSubscribe(this.f32220e);
                        observableSource.subscribe(timeoutInnerObserver);
                    }
                    return;
                }
                disposable.onSubscribe(this.f32220e);
            }
        }

        public final void onNext(T t) {
            if (!this.f32222g) {
                long j = this.f32223h + 1;
                this.f32223h = j;
                if (this.f32220e.m38061a((Object) t, this.f32221f)) {
                    Disposable disposable = (Disposable) get();
                    if (disposable != null) {
                        disposable.mo5626a();
                    }
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f32218c.apply(t), "The ObservableSource returned is null");
                        Observer timeoutInnerObserver = new TimeoutInnerObserver(this, j);
                        if (compareAndSet(disposable, timeoutInnerObserver)) {
                            observableSource.subscribe(timeoutInnerObserver);
                        }
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        this.f32216a.onError(t2);
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f32222g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32222g = true;
            mo5626a();
            this.f32220e.m38059a(th, this.f32221f);
        }

        public final void onComplete() {
            if (!this.f32222g) {
                this.f32222g = true;
                mo5626a();
                this.f32220e.m38062b(this.f32221f);
            }
        }

        public final void mo5626a() {
            if (DisposableHelper.m32090a((AtomicReference) this)) {
                this.f32221f.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.f32221f.mo5627b();
        }

        public final void mo5672a(long j) {
            if (j == this.f32223h) {
                mo5626a();
                this.f32219d.subscribe(new FullArbiterObserver(this.f32220e));
            }
        }

        public final void mo5673a(Throwable th) {
            this.f32221f.mo5626a();
            this.f32216a.onError(th);
        }
    }

    static final class TimeoutInnerObserver<T, U, V> extends DisposableObserver<Object> {
        final OnTimeout f35736a;
        final long f35737b;
        boolean f35738c;

        TimeoutInnerObserver(OnTimeout onTimeout, long j) {
            this.f35736a = onTimeout;
            this.f35737b = j;
        }

        public final void onNext(Object obj) {
            if (this.f35738c == null) {
                this.f35738c = true;
                mo5626a();
                this.f35736a.mo5672a(this.f35737b);
            }
        }

        public final void onError(Throwable th) {
            if (this.f35738c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35738c = true;
            this.f35736a.mo5673a(th);
        }

        public final void onComplete() {
            if (!this.f35738c) {
                this.f35738c = true;
                this.f35736a.mo5672a(this.f35737b);
            }
        }
    }

    public ObservableTimeout(ObservableSource<T> observableSource, ObservableSource<U> observableSource2, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource3) {
        super(observableSource);
        this.f38101a = observableSource2;
        this.f38102b = function;
        this.f38103c = observableSource3;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        if (this.f38103c == null) {
            this.source.subscribe(new TimeoutObserver(new SerializedObserver(observer), this.f38101a, this.f38102b));
        } else {
            this.source.subscribe(new TimeoutOtherObserver(observer, this.f38101a, this.f38102b, this.f38103c));
        }
    }
}
