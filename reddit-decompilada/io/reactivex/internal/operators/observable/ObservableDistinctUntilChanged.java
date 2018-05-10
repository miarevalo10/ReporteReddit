package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, K> f37986a;
    final BiPredicate<? super K, ? super K> f37987b;

    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Function<? super T, K> f39573f;
        final BiPredicate<? super K, ? super K> f39574g;
        K f39575h;
        boolean f39576i;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f39573f = function;
            this.f39574g = biPredicate;
        }

        public final void onNext(T t) {
            if (!this.d) {
                if (this.e != 0) {
                    this.a.onNext(t);
                    return;
                }
                try {
                    Object apply = this.f39573f.apply(t);
                    if (this.f39576i) {
                        boolean a = this.f39574g.mo4928a(this.f39575h, apply);
                        this.f39575h = apply;
                        if (a) {
                            return;
                        }
                    }
                    this.f39576i = true;
                    this.f39575h = apply;
                    this.a.onNext(t);
                } catch (T t2) {
                    m38065a(t2);
                }
            }
        }

        public final int mo7033a(int i) {
            return m38066b(i);
        }

        public final T poll() throws Exception {
            while (true) {
                T poll = this.c.poll();
                if (poll == null) {
                    return null;
                }
                Object apply = this.f39573f.apply(poll);
                if (!this.f39576i) {
                    this.f39576i = true;
                    this.f39575h = apply;
                    return poll;
                } else if (this.f39574g.mo4928a(this.f39575h, apply)) {
                    this.f39575h = apply;
                } else {
                    this.f39575h = apply;
                    return poll;
                }
            }
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f37986a = function;
        this.f37987b = biPredicate;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DistinctUntilChangedObserver(observer, this.f37986a, this.f37987b));
    }
}
