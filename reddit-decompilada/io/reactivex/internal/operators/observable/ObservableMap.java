package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends U> f38025a;

    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> f39602f;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f39602f = function;
        }

        public final void onNext(T t) {
            if (!this.d) {
                if (this.e != 0) {
                    this.a.onNext(null);
                    return;
                }
                try {
                    this.a.onNext(ObjectHelper.m26573a(this.f39602f.apply(t), "The mapper function returned a null value."));
                } catch (T t2) {
                    m38065a(t2);
                }
            }
        }

        public final int mo7033a(int i) {
            return m38066b(i);
        }

        public final U poll() throws Exception {
            Object poll = this.c.poll();
            return poll != null ? ObjectHelper.m26573a(this.f39602f.apply(poll), "The mapper function returned a null value.") : null;
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f38025a = function;
    }

    public final void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new MapObserver(observer, this.f38025a));
    }
}
