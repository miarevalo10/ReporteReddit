package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class SingleUsing<T, U> extends Single<T> {
    final Callable<U> f35857a;
    final Function<? super U, ? extends SingleSource<? extends T>> f35858b;
    final Consumer<? super U> f35859c;
    final boolean f35860d;

    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32396a;
        final Consumer<? super U> f32397b;
        final boolean f32398c;
        Disposable f32399d;

        UsingSingleObserver(SingleObserver<? super T> singleObserver, U u, boolean z, Consumer<? super U> consumer) {
            super(u);
            this.f32396a = singleObserver;
            this.f32398c = z;
            this.f32397b = consumer;
        }

        public final void mo5626a() {
            this.f32399d.mo5626a();
            this.f32399d = DisposableHelper.f31095a;
            m32734c();
        }

        public final boolean mo5627b() {
            return this.f32399d.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32399d, disposable)) {
                this.f32399d = disposable;
                this.f32396a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32399d = DisposableHelper.f31095a;
            if (this.f32398c) {
                UsingSingleObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f32397b.accept(andSet);
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        this.f32396a.onError(t2);
                        return;
                    }
                }
                return;
            }
            this.f32396a.onSuccess(t2);
            if (this.f32398c == null) {
                m32734c();
            }
        }

        public final void onError(Throwable th) {
            this.f32399d = DisposableHelper.f31095a;
            if (this.f32398c) {
                UsingSingleObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f32397b.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.f32396a.onError(th);
            if (this.f32398c == null) {
                m32734c();
            }
        }

        private void m32734c() {
            UsingSingleObserver andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f32397b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public SingleUsing(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        this.f35857a = callable;
        this.f35858b = function;
        this.f35859c = consumer;
        this.f35860d = z;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Throwable th;
        try {
            Object call = this.f35857a.call();
            try {
                ((SingleSource) ObjectHelper.m26573a(this.f35858b.apply(call), "The singleFunction returned a null SingleSource")).subscribe(new UsingSingleObserver(singleObserver, call, this.f35860d, this.f35859c));
                return;
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                RxJavaPlugins.m26757a(th2);
            }
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
            if (this.f35860d == null) {
                this.f35859c.accept(call);
            }
        } catch (Throwable th3) {
            Exceptions.m26521b(th3);
            EmptyDisposable.m38052a(th3, (SingleObserver) singleObserver);
        }
    }
}
