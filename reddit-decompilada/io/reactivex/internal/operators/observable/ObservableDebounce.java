package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> f37976a;

    static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Observer<? super T> f31716a;
        final Function<? super T, ? extends ObservableSource<U>> f31717b;
        Disposable f31718c;
        final AtomicReference<Disposable> f31719d = new AtomicReference();
        volatile long f31720e;
        boolean f31721f;

        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            final DebounceObserver<T, U> f35654a;
            final long f35655b;
            final T f35656c;
            boolean f35657d;
            final AtomicBoolean f35658e = new AtomicBoolean();

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j, T t) {
                this.f35654a = debounceObserver;
                this.f35655b = j;
                this.f35656c = t;
            }

            public final void onNext(U u) {
                if (this.f35657d == null) {
                    this.f35657d = true;
                    mo5626a();
                    m35924c();
                }
            }

            final void m35924c() {
                if (this.f35658e.compareAndSet(false, true)) {
                    DebounceObserver debounceObserver = this.f35654a;
                    long j = this.f35655b;
                    Object obj = this.f35656c;
                    if (j == debounceObserver.f31720e) {
                        debounceObserver.f31716a.onNext(obj);
                    }
                }
            }

            public final void onError(Throwable th) {
                if (this.f35657d) {
                    RxJavaPlugins.m26757a(th);
                    return;
                }
                this.f35657d = true;
                this.f35654a.onError(th);
            }

            public final void onComplete() {
                if (!this.f35657d) {
                    this.f35657d = true;
                    m35924c();
                }
            }
        }

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.f31716a = observer;
            this.f31717b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31718c, disposable)) {
                this.f31718c = disposable;
                this.f31716a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31721f) {
                long j = this.f31720e + 1;
                this.f31720e = j;
                Disposable disposable = (Disposable) this.f31719d.get();
                if (disposable != null) {
                    disposable.mo5626a();
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31717b.apply(t), "The ObservableSource supplied is null");
                    Observer debounceInnerObserver = new DebounceInnerObserver(this, j, t);
                    if (this.f31719d.compareAndSet(disposable, debounceInnerObserver) != null) {
                        observableSource.subscribe(debounceInnerObserver);
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    mo5626a();
                    this.f31716a.onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f31719d);
            this.f31716a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31721f) {
                this.f31721f = true;
                Disposable disposable = (Disposable) this.f31719d.get();
                if (disposable != DisposableHelper.f31095a) {
                    ((DebounceInnerObserver) disposable).m35924c();
                    DisposableHelper.m32090a(this.f31719d);
                    this.f31716a.onComplete();
                }
            }
        }

        public final void mo5626a() {
            this.f31718c.mo5626a();
            DisposableHelper.m32090a(this.f31719d);
        }

        public final boolean mo5627b() {
            return this.f31718c.mo5627b();
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.f37976a = function;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceObserver(new SerializedObserver(observer), this.f37976a));
    }
}
