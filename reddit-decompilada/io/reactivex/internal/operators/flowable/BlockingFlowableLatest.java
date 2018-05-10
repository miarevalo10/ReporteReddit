package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

public final class BlockingFlowableLatest<T> implements Iterable<T> {
    final Publisher<? extends T> f25034a;

    static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T> {
        final Semaphore f37634a = new Semaphore(0);
        final AtomicReference<Notification<T>> f37635b = new AtomicReference();
        Notification<T> f37636c;

        public final void onComplete() {
        }

        LatestSubscriberIterator() {
        }

        public final /* synthetic */ void onNext(Object obj) {
            if ((this.f37635b.getAndSet((Notification) obj) == null ? true : null) != null) {
                this.f37634a.release();
            }
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.m26757a(th);
        }

        public final boolean hasNext() {
            if (this.f37636c == null || !NotificationLite.m26704c(this.f37636c.f24989a)) {
                if ((this.f37636c == null || this.f37636c.m26487b()) && this.f37636c == null) {
                    try {
                        BlockingHelper.m26675a();
                        this.f37634a.acquire();
                        Notification notification = (Notification) this.f37635b.getAndSet(null);
                        this.f37636c = notification;
                        if (NotificationLite.m26704c(notification.f24989a)) {
                            throw ExceptionHelper.m26682a(notification.m26489d());
                        }
                    } catch (Throwable e) {
                        mo5626a();
                        this.f37636c = Notification.m26484a(e);
                        throw ExceptionHelper.m26682a(e);
                    }
                }
                return this.f37636c.m26487b();
            }
            throw ExceptionHelper.m26682a(this.f37636c.m26489d());
        }

        public final T next() {
            if (hasNext() && this.f37636c.m26487b()) {
                T c = this.f37636c.m26488c();
                this.f37636c = null;
                return c;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.f25034a = publisher;
    }

    public final Iterator<T> iterator() {
        FlowableSubscriber latestSubscriberIterator = new LatestSubscriberIterator();
        Flowable.fromPublisher(this.f25034a).materialize().subscribe(latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
