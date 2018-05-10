package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    final ObservableSource<T> f25098a;
    final T f25099b;

    static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object f35624a;

        final class Iterator implements java.util.Iterator<T> {
            final /* synthetic */ MostRecentObserver f25096a;
            private Object f25097b;

            Iterator(MostRecentObserver mostRecentObserver) {
                this.f25096a = mostRecentObserver;
            }

            public final boolean hasNext() {
                this.f25097b = this.f25096a.f35624a;
                return !NotificationLite.m26701b(this.f25097b);
            }

            public final T next() {
                try {
                    if (this.f25097b == null) {
                        Object obj = this.f25096a.f35624a;
                    }
                    if (NotificationLite.m26701b(this.f25097b)) {
                        throw new NoSuchElementException();
                    } else if (NotificationLite.m26704c(this.f25097b)) {
                        throw ExceptionHelper.m26682a(NotificationLite.m26707f(this.f25097b));
                    } else {
                        T e = NotificationLite.m26706e(this.f25097b);
                        this.f25097b = null;
                        return e;
                    }
                } finally {
                    this.f25097b = null;
                }
            }

            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentObserver(T t) {
            this.f35624a = NotificationLite.m26696a((Object) t);
        }

        public final void onComplete() {
            this.f35624a = NotificationLite.m26694a();
        }

        public final void onError(Throwable th) {
            this.f35624a = NotificationLite.m26697a(th);
        }

        public final void onNext(T t) {
            this.f35624a = NotificationLite.m26696a((Object) t);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.f25098a = observableSource;
        this.f25099b = t;
    }

    public final Iterator<T> iterator() {
        Object mostRecentObserver = new MostRecentObserver(this.f25099b);
        this.f25098a.subscribe(mostRecentObserver);
        return new Iterator(mostRecentObserver);
    }
}
