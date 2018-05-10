package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {

    static final class ScalarXMapObservable<T, R> extends Observable<R> {
        final T f35723a;
        final Function<? super T, ? extends ObservableSource<? extends R>> f35724b;

        ScalarXMapObservable(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f35723a = t;
            this.f35724b = function;
        }

        public final void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f35724b.apply(this.f35723a), "The mapper returned a null ObservableSource");
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.m38048a((Observer) observer);
                            return;
                        }
                        Object scalarDisposable = new ScalarDisposable(observer, call);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                        return;
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        EmptyDisposable.m38051a(th, (Observer) observer);
                        return;
                    }
                }
                observableSource.subscribe(observer);
            } catch (Throwable th2) {
                EmptyDisposable.m38051a(th2, (Observer) observer);
            }
        }
    }

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        final Observer<? super T> f38066a;
        final T f38067b;

        public ScalarDisposable(Observer<? super T> observer, T t) {
            this.f38066a = observer;
            this.f38067b = t;
        }

        public final boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public final T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f38067b;
        }

        public final boolean isEmpty() {
            return get() != 1;
        }

        public final void clear() {
            lazySet(3);
        }

        public final void mo5626a() {
            set(3);
        }

        public final boolean mo5627b() {
            return get() == 3;
        }

        public final int mo7033a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public final void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f38066a.onNext(this.f38067b);
                if (get() == 2) {
                    lazySet(3);
                    this.f38066a.onComplete();
                }
            }
        }
    }

    public static <T, R> boolean m26648a(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (!(observableSource instanceof Callable)) {
            return null;
        }
        try {
            observableSource = ((Callable) observableSource).call();
            if (observableSource == null) {
                EmptyDisposable.m38048a((Observer) observer);
                return true;
            }
            try {
                observableSource = (ObservableSource) ObjectHelper.m26573a(function.apply(observableSource), "The mapper returned a null ObservableSource");
                if ((observableSource instanceof Callable) != null) {
                    try {
                        observableSource = ((Callable) observableSource).call();
                        if (observableSource == null) {
                            EmptyDisposable.m38048a((Observer) observer);
                            return true;
                        }
                        function = new ScalarDisposable(observer, observableSource);
                        observer.onSubscribe(function);
                        function.run();
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        EmptyDisposable.m38051a(th, (Observer) observer);
                        return true;
                    }
                }
                observableSource.subscribe(observer);
                return true;
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                EmptyDisposable.m38051a(th2, (Observer) observer);
                return true;
            }
        } catch (Throwable th22) {
            Exceptions.m26521b(th22);
            EmptyDisposable.m38051a(th22, (Observer) observer);
            return true;
        }
    }

    public static <T, U> Observable<U> m26647a(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.m26742a(new ScalarXMapObservable(t, function));
    }
}
