package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, K> f37984a;
    final Callable<? extends Collection<? super K>> f37985b;

    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Collection<? super K> f39571f;
        final Function<? super T, K> f39572g;

        DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.f39572g = function;
            this.f39571f = collection;
        }

        public final void onNext(T t) {
            if (!this.d) {
                if (this.e == 0) {
                    try {
                        if (this.f39571f.add(ObjectHelper.m26573a(this.f39572g.apply(t), "The keySelector returned a null key"))) {
                            this.a.onNext(t);
                        }
                        return;
                    } catch (T t2) {
                        m38065a(t2);
                        return;
                    }
                }
                this.a.onNext(null);
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.d = true;
            this.f39571f.clear();
            this.a.onError(th);
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                this.f39571f.clear();
                this.a.onComplete();
            }
        }

        public final int mo7033a(int i) {
            return m38066b(i);
        }

        public final T poll() throws Exception {
            T poll;
            do {
                poll = this.c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f39571f.add(ObjectHelper.m26573a(this.f39572g.apply(poll), "The keySelector returned a null key")));
            return poll;
        }

        public final void clear() {
            this.f39571f.clear();
            super.clear();
        }
    }

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(observableSource);
        this.f37984a = function;
        this.f37985b = callable;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        try {
            this.source.subscribe(new DistinctObserver(observer, this.f37984a, (Collection) ObjectHelper.m26573a(this.f37985b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
