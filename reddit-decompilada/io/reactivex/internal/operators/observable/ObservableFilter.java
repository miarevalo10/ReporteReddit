package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> f37999a;

    static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        final Predicate<? super T> f39583f;

        FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.f39583f = predicate;
        }

        public final void onNext(T t) {
            if (this.e == 0) {
                try {
                    if (this.f39583f.test(t)) {
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
            } while (!this.f39583f.test(poll));
            return poll;
        }
    }

    public ObservableFilter(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f37999a = predicate;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new FilterObserver(observer, this.f37999a));
    }
}
