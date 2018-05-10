package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
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
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing<T, D> extends Observable<T> {
    final Callable<? extends D> f35744a;
    final Function<? super D, ? extends ObservableSource<? extends T>> f35745b;
    final Consumer<? super D> f35746c;
    final boolean f35747d;

    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        final Observer<? super T> f32250a;
        final D f32251b;
        final Consumer<? super D> f32252c;
        final boolean f32253d;
        Disposable f32254e;

        UsingObserver(Observer<? super T> observer, D d, Consumer<? super D> consumer, boolean z) {
            this.f32250a = observer;
            this.f32251b = d;
            this.f32252c = consumer;
            this.f32253d = z;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32254e, disposable)) {
                this.f32254e = disposable;
                this.f32250a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f32250a.onNext(t);
        }

        public final void onError(Throwable th) {
            if (this.f32253d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f32252c.accept(this.f32251b);
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.f32254e.mo5626a();
                this.f32250a.onError(th);
                return;
            }
            this.f32250a.onError(th);
            this.f32254e.mo5626a();
            m32662c();
        }

        public final void onComplete() {
            if (this.f32253d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f32252c.accept(this.f32251b);
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f32250a.onError(th);
                        return;
                    }
                }
                this.f32254e.mo5626a();
                this.f32250a.onComplete();
                return;
            }
            this.f32250a.onComplete();
            this.f32254e.mo5626a();
            m32662c();
        }

        public final void mo5626a() {
            m32662c();
            this.f32254e.mo5626a();
        }

        public final boolean mo5627b() {
            return get();
        }

        private void m32662c() {
            if (compareAndSet(false, true)) {
                try {
                    this.f32252c.accept(this.f32251b);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.f35744a = callable;
        this.f35745b = function;
        this.f35746c = consumer;
        this.f35747d = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f35744a.call();
            try {
                ((ObservableSource) ObjectHelper.m26573a(this.f35745b.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.f35746c, this.f35747d));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptyDisposable.m38051a(new CompositeException(th, th), (Observer) observer);
            }
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptyDisposable.m38051a(th2, (Observer) observer);
        }
    }
}
