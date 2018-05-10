package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> f37988a;

    static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {
        final Consumer<? super T> f39577f;

        DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.f39577f = consumer;
        }

        public final void onNext(T t) {
            this.a.onNext(t);
            if (this.e == 0) {
                try {
                    this.f39577f.accept(t);
                } catch (T t2) {
                    m38065a(t2);
                }
            }
        }

        public final int mo7033a(int i) {
            return m38066b(i);
        }

        public final T poll() throws Exception {
            T poll = this.c.poll();
            if (poll != null) {
                this.f39577f.accept(poll);
            }
            return poll;
        }
    }

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.f37988a = consumer;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DoAfterObserver(observer, this.f37988a));
    }
}
