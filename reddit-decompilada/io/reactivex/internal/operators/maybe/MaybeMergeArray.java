package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

public final class MaybeMergeArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] f35600a;

    interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int mo6634a();

        int mo6635b();

        void mo6636c();

        T peek();

        T poll();
    }

    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        int f35596a;
        final AtomicInteger f35597b = new AtomicInteger();

        ClqSimpleQueue() {
        }

        public final boolean offer(T t) {
            this.f35597b.getAndIncrement();
            return super.offer(t);
        }

        public final T poll() {
            T poll = super.poll();
            if (poll != null) {
                this.f35596a++;
            }
            return poll;
        }

        public final int mo6634a() {
            return this.f35596a;
        }

        public final int mo6635b() {
            return this.f35597b.get();
        }

        public final void mo6636c() {
            poll();
        }
    }

    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        final AtomicInteger f35598a = new AtomicInteger();
        int f35599b;

        MpscFillOnceSimpleQueue(int i) {
            super(i);
        }

        public final boolean offer(T t) {
            ObjectHelper.m26573a((Object) t, "value is null");
            int andIncrement = this.f35598a.getAndIncrement();
            if (andIncrement >= length()) {
                return null;
            }
            lazySet(andIncrement, t);
            return true;
        }

        public final T poll() {
            int i = this.f35599b;
            if (i == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.f35598a;
            do {
                T t = get(i);
                if (t != null) {
                    this.f35599b = i + 1;
                    lazySet(i, null);
                    return t;
                }
            } while (atomicInteger.get() != i);
            return null;
        }

        public final T peek() {
            int i = this.f35599b;
            if (i == length()) {
                return null;
            }
            return get(i);
        }

        public final void mo6636c() {
            int i = this.f35599b;
            lazySet(i, null);
            this.f35599b = i + 1;
        }

        public final boolean isEmpty() {
            return this.f35599b == this.f35598a.get();
        }

        public final void clear() {
            while (poll() != null) {
                if (isEmpty()) {
                    return;
                }
            }
        }

        public final int mo6634a() {
            return this.f35599b;
        }

        public final int mo6635b() {
            return this.f35598a.get();
        }
    }

    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        final Subscriber<? super T> f39527a;
        final CompositeDisposable f39528b = new CompositeDisposable();
        final AtomicLong f39529c = new AtomicLong();
        final SimpleQueueWithConsumerIndex<Object> f39530d;
        final AtomicThrowable f39531e = new AtomicThrowable();
        final int f39532f;
        volatile boolean f39533g;
        boolean f39534h;
        long f39535i;

        MergeMaybeObserver(Subscriber<? super T> subscriber, int i, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            this.f39527a = subscriber;
            this.f39532f = i;
            this.f39530d = simpleQueueWithConsumerIndex;
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39534h = true;
            return 2;
        }

        public final T poll() throws Exception {
            T poll;
            do {
                poll = this.f39530d.poll();
            } while (poll == NotificationLite.f25198a);
            return poll;
        }

        public final boolean isEmpty() {
            return this.f39530d.isEmpty();
        }

        public final void clear() {
            this.f39530d.clear();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39529c, j);
                m39702a();
            }
        }

        public final void cancel() {
            if (!this.f39533g) {
                this.f39533g = true;
                this.f39528b.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f39530d.clear();
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            this.f39528b.mo5631a(disposable);
        }

        public final void onSuccess(T t) {
            this.f39530d.offer(t);
            m39702a();
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f39531e, th)) {
                this.f39528b.mo5626a();
                this.f39530d.offer(NotificationLite.f25198a);
                m39702a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f39530d.offer(NotificationLite.f25198a);
            m39702a();
        }

        private void m39702a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                Subscriber subscriber;
                SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex;
                if (this.f39534h) {
                    subscriber = this.f39527a;
                    simpleQueueWithConsumerIndex = this.f39530d;
                    int i2 = 1;
                    while (!this.f39533g) {
                        Throwable th = (Throwable) this.f39531e.get();
                        if (th != null) {
                            simpleQueueWithConsumerIndex.clear();
                            subscriber.onError(th);
                            return;
                        }
                        int i3 = simpleQueueWithConsumerIndex.mo6635b() == this.f39532f ? 1 : 0;
                        if (!simpleQueueWithConsumerIndex.isEmpty()) {
                            subscriber.onNext(null);
                        }
                        if (i3 != 0) {
                            subscriber.onComplete();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                    simpleQueueWithConsumerIndex.clear();
                    return;
                }
                subscriber = this.f39527a;
                simpleQueueWithConsumerIndex = this.f39530d;
                long j = this.f39535i;
                do {
                    int i4;
                    long j2 = this.f39529c.get();
                    while (true) {
                        i4 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i4 != 0) {
                            if (!this.f39533g) {
                                if (((Throwable) this.f39531e.get()) == null) {
                                    if (simpleQueueWithConsumerIndex.mo6634a() != this.f39532f) {
                                        NotificationLite poll = simpleQueueWithConsumerIndex.poll();
                                        if (poll == null) {
                                            break;
                                        } else if (poll != NotificationLite.f25198a) {
                                            subscriber.onNext(poll);
                                            j++;
                                        }
                                    } else {
                                        subscriber.onComplete();
                                        return;
                                    }
                                }
                                simpleQueueWithConsumerIndex.clear();
                                subscriber.onError(ExceptionHelper.m26683a(this.f39531e));
                                return;
                            }
                            simpleQueueWithConsumerIndex.clear();
                            return;
                        }
                        break;
                    }
                    if (i4 == 0) {
                        if (((Throwable) this.f39531e.get()) != null) {
                            simpleQueueWithConsumerIndex.clear();
                            subscriber.onError(ExceptionHelper.m26683a(this.f39531e));
                            return;
                        }
                        while (simpleQueueWithConsumerIndex.peek() == NotificationLite.f25198a) {
                            simpleQueueWithConsumerIndex.mo6636c();
                        }
                        if (simpleQueueWithConsumerIndex.mo6634a() == this.f39532f) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    this.f39535i = j;
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f35600a = maybeSourceArr;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        SimpleQueueWithConsumerIndex mpscFillOnceSimpleQueue;
        MaybeSource[] maybeSourceArr = this.f35600a;
        int length = maybeSourceArr.length;
        if (length <= Flowable.bufferSize()) {
            mpscFillOnceSimpleQueue = new MpscFillOnceSimpleQueue(length);
        } else {
            mpscFillOnceSimpleQueue = new ClqSimpleQueue();
        }
        MaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, mpscFillOnceSimpleQueue);
        subscriber.mo5623a(mergeMaybeObserver);
        subscriber = mergeMaybeObserver.f39531e;
        length = maybeSourceArr.length;
        int i = 0;
        while (i < length) {
            MaybeSource maybeSource = maybeSourceArr[i];
            if (!mergeMaybeObserver.f39533g) {
                if (subscriber.get() == null) {
                    maybeSource.subscribe(mergeMaybeObserver);
                    i++;
                }
            }
            return;
        }
    }
}
