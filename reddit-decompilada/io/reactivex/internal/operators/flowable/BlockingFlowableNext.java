package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class BlockingFlowableNext<T> implements Iterable<T> {
    final Publisher<? extends T> f25046a;

    static final class NextIterator<T> implements Iterator<T> {
        private final NextSubscriber<T> f25039a;
        private final Publisher<? extends T> f25040b;
        private T f25041c;
        private boolean f25042d = true;
        private boolean f25043e = true;
        private Throwable f25044f;
        private boolean f25045g;

        NextIterator(Publisher<? extends T> publisher, NextSubscriber<T> nextSubscriber) {
            this.f25040b = publisher;
            this.f25039a = nextSubscriber;
        }

        public final boolean hasNext() {
            if (this.f25044f != null) {
                throw ExceptionHelper.m26682a(this.f25044f);
            } else if (!this.f25042d) {
                return false;
            } else {
                if (this.f25043e) {
                    if (!m26582a()) {
                        return false;
                    }
                }
                return true;
            }
        }

        private boolean m26582a() {
            try {
                if (!this.f25045g) {
                    this.f25045g = true;
                    this.f25039a.m38077c();
                    Flowable.fromPublisher(this.f25040b).materialize().subscribe(this.f25039a);
                }
                NextSubscriber nextSubscriber = this.f25039a;
                nextSubscriber.m38077c();
                BlockingHelper.m26675a();
                Notification notification = (Notification) nextSubscriber.f37638a.take();
                if (notification.m26487b()) {
                    this.f25043e = false;
                    this.f25041c = notification.m26488c();
                    return true;
                }
                this.f25042d = false;
                if (notification.m26486a()) {
                    return false;
                }
                if (NotificationLite.m26704c(notification.f24989a)) {
                    this.f25044f = notification.m26489d();
                    throw ExceptionHelper.m26682a(this.f25044f);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (Throwable e) {
                this.f25039a.mo5626a();
                this.f25044f = e;
                throw ExceptionHelper.m26682a(e);
            }
        }

        public final T next() {
            if (this.f25044f != null) {
                throw ExceptionHelper.m26682a(this.f25044f);
            } else if (hasNext()) {
                this.f25043e = true;
                return this.f25041c;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        final BlockingQueue<Notification<T>> f37638a = new ArrayBlockingQueue(1);
        final AtomicInteger f37639b = new AtomicInteger();

        public final void onComplete() {
        }

        NextSubscriber() {
        }

        public final /* synthetic */ void onNext(Object obj) {
            obj = (Notification) obj;
            if (this.f37639b.getAndSet(0) == 1 || !obj.m26487b()) {
                while (!this.f37638a.offer(obj)) {
                    Notification notification = (Notification) this.f37638a.poll();
                    if (!(notification == null || notification.m26487b())) {
                        obj = notification;
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.m26757a(th);
        }

        final void m38077c() {
            this.f37639b.set(1);
        }
    }

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
        this.f25046a = publisher;
    }

    public final Iterator<T> iterator() {
        return new NextIterator(this.f25046a, new NextSubscriber());
    }
}
