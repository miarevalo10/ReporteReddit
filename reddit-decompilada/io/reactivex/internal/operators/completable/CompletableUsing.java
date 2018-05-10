package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
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

public final class CompletableUsing<R> extends Completable {
    final Callable<R> f34791a;
    final Function<? super R, ? extends CompletableSource> f34792b;
    final Consumer<? super R> f34793c;
    final boolean f34794d;

    static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        final CompletableObserver f31238a;
        final Consumer<? super R> f31239b;
        final boolean f31240c;
        Disposable f31241d;

        UsingObserver(CompletableObserver completableObserver, R r, Consumer<? super R> consumer, boolean z) {
            super(r);
            this.f31238a = completableObserver;
            this.f31239b = consumer;
            this.f31240c = z;
        }

        public final void mo5626a() {
            this.f31241d.mo5626a();
            this.f31241d = DisposableHelper.f31095a;
            m32168c();
        }

        private void m32168c() {
            UsingObserver andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f31239b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }

        public final boolean mo5627b() {
            return this.f31241d.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31241d, disposable)) {
                this.f31241d = disposable;
                this.f31238a.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.f31241d = DisposableHelper.f31095a;
            if (this.f31240c) {
                UsingObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f31239b.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.f31238a.onError(th);
            if (this.f31240c == null) {
                m32168c();
            }
        }

        public final void onComplete() {
            this.f31241d = DisposableHelper.f31095a;
            if (this.f31240c) {
                UsingObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f31239b.accept(andSet);
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f31238a.onError(th);
                        return;
                    }
                }
                return;
            }
            this.f31238a.onComplete();
            if (!this.f31240c) {
                m32168c();
            }
        }
    }

    public CompletableUsing(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        this.f34791a = callable;
        this.f34792b = function;
        this.f34793c = consumer;
        this.f34794d = z;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        try {
            Object call = this.f34791a.call();
            try {
                ((CompletableSource) ObjectHelper.m26573a(this.f34792b.apply(call), "The completableFunction returned a null CompletableSource")).subscribe(new UsingObserver(completableObserver, call, this.f34793c, this.f34794d));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptyDisposable.m38049a(th2, completableObserver);
        }
    }
}
