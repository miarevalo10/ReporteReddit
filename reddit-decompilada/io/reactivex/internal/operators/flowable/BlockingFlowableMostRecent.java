package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final Flowable<T> f25037a;
    final T f25038b;

    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object f37637a;

        final class Iterator implements java.util.Iterator<T> {
            final /* synthetic */ MostRecentSubscriber f25035a;
            private Object f25036b;

            Iterator(MostRecentSubscriber mostRecentSubscriber) {
                this.f25035a = mostRecentSubscriber;
            }

            public final boolean hasNext() {
                this.f25036b = this.f25035a.f37637a;
                return !NotificationLite.m26701b(this.f25036b);
            }

            public final T next() {
                try {
                    if (this.f25036b == null) {
                        Object obj = this.f25035a.f37637a;
                    }
                    if (NotificationLite.m26701b(this.f25036b)) {
                        throw new NoSuchElementException();
                    } else if (NotificationLite.m26704c(this.f25036b)) {
                        throw ExceptionHelper.m26682a(NotificationLite.m26707f(this.f25036b));
                    } else {
                        T e = NotificationLite.m26706e(this.f25036b);
                        this.f25036b = null;
                        return e;
                    }
                } finally {
                    this.f25036b = null;
                }
            }

            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentSubscriber(T t) {
            this.f37637a = NotificationLite.m26696a((Object) t);
        }

        public final void onComplete() {
            this.f37637a = NotificationLite.m26694a();
        }

        public final void onError(Throwable th) {
            this.f37637a = NotificationLite.m26697a(th);
        }

        public final void onNext(T t) {
            this.f37637a = NotificationLite.m26696a((Object) t);
        }
    }

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t) {
        this.f25037a = flowable;
        this.f25038b = t;
    }

    public final Iterator<T> iterator() {
        FlowableSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.f25038b);
        this.f25037a.subscribe(mostRecentSubscriber);
        return new Iterator(mostRecentSubscriber);
    }
}
