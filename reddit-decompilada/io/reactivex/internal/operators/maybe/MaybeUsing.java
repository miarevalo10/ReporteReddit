package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUsing<T, D> extends Maybe<T> {
    final Callable<? extends D> f35613a;
    final Function<? super D, ? extends MaybeSource<? extends T>> f35614b;
    final Consumer<? super D> f35615c;
    final boolean f35616d;

    static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31545a;
        final Consumer<? super D> f31546b;
        final boolean f31547c;
        Disposable f31548d;

        UsingObserver(MaybeObserver<? super T> maybeObserver, D d, Consumer<? super D> consumer, boolean z) {
            super(d);
            this.f31545a = maybeObserver;
            this.f31546b = consumer;
            this.f31547c = z;
        }

        public final void mo5626a() {
            this.f31548d.mo5626a();
            this.f31548d = DisposableHelper.f31095a;
            m32340c();
        }

        private void m32340c() {
            UsingObserver andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f31546b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }

        public final boolean mo5627b() {
            return this.f31548d.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31548d, disposable)) {
                this.f31548d = disposable;
                this.f31545a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31548d = DisposableHelper.f31095a;
            if (this.f31547c) {
                UsingObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f31546b.accept(andSet);
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        this.f31545a.onError(t2);
                        return;
                    }
                }
                return;
            }
            this.f31545a.onSuccess(t2);
            if (this.f31547c == null) {
                m32340c();
            }
        }

        public final void onError(Throwable th) {
            this.f31548d = DisposableHelper.f31095a;
            if (this.f31547c) {
                UsingObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f31546b.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.f31545a.onError(th);
            if (this.f31547c == null) {
                m32340c();
            }
        }

        public final void onComplete() {
            this.f31548d = DisposableHelper.f31095a;
            if (this.f31547c) {
                UsingObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f31546b.accept(andSet);
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f31545a.onError(th);
                        return;
                    }
                }
                return;
            }
            this.f31545a.onComplete();
            if (!this.f31547c) {
                m32340c();
            }
        }
    }

    public MaybeUsing(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f35613a = callable;
        this.f35614b = function;
        this.f35615c = consumer;
        this.f35616d = z;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            Object call = this.f35613a.call();
            try {
                ((MaybeSource) ObjectHelper.m26573a(this.f35614b.apply(call), "The sourceSupplier returned a null MaybeSource")).subscribe(new UsingObserver(maybeObserver, call, this.f35615c, this.f35616d));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptyDisposable.m38050a(th2, (MaybeObserver) maybeObserver);
        }
    }
}
