package io.reactivex.internal.operators.flowable;

import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

public final class BlockingFlowableIterable<T> implements Iterable<T> {
    final Flowable<T> f25032a;
    final int f25033b;

    static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable, Runnable, Iterator<T> {
        final SpscArrayQueue<T> f34795a;
        final long f34796b;
        final long f34797c;
        final Lock f34798d = new ReentrantLock();
        final Condition f34799e = this.f34798d.newCondition();
        long f34800f;
        volatile boolean f34801g;
        Throwable f34802h;

        BlockingFlowableIterator(int i) {
            this.f34795a = new SpscArrayQueue(i);
            this.f34796b = (long) i;
            this.f34797c = (long) (i - (i >> 2));
        }

        public final boolean hasNext() {
            Throwable th;
            while (true) {
                boolean z = this.f34801g;
                boolean isEmpty = this.f34795a.isEmpty();
                if (z) {
                    th = this.f34802h;
                    if (th != null) {
                        throw ExceptionHelper.m26682a(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.m26675a();
                this.f34798d.lock();
                while (!this.f34801g && this.f34795a.isEmpty()) {
                    try {
                        this.f34799e.await();
                    } catch (Throwable th2) {
                        run();
                        throw ExceptionHelper.m26682a(th2);
                    } catch (Throwable th3) {
                        this.f34798d.unlock();
                    }
                }
                this.f34798d.unlock();
            }
        }

        public final T next() {
            if (hasNext()) {
                T poll = this.f34795a.poll();
                long j = this.f34800f + 1;
                if (j == this.f34797c) {
                    this.f34800f = 0;
                    ((Subscription) get()).request(j);
                } else {
                    this.f34800f = j;
                }
                return poll;
            }
            throw new NoSuchElementException();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(this.f34796b);
            }
        }

        public final void onNext(T t) {
            if (this.f34795a.offer(t) == null) {
                SubscriptionHelper.m32777a((AtomicReference) this);
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            }
            m35632c();
        }

        public final void onError(Throwable th) {
            this.f34802h = th;
            this.f34801g = true;
            m35632c();
        }

        public final void onComplete() {
            this.f34801g = true;
            m35632c();
        }

        private void m35632c() {
            this.f34798d.lock();
            try {
                this.f34799e.signalAll();
            } finally {
                this.f34798d.unlock();
            }
        }

        public final void run() {
            SubscriptionHelper.m32777a((AtomicReference) this);
            m35632c();
        }

        public final void remove() {
            throw new UnsupportedOperationException(ModQueueOptionsPresenter.ACTION_REMOVE);
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return SubscriptionHelper.m32780a((Subscription) get());
        }
    }

    public BlockingFlowableIterable(Flowable<T> flowable, int i) {
        this.f25032a = flowable;
        this.f25033b = i;
    }

    public final Iterator<T> iterator() {
        FlowableSubscriber blockingFlowableIterator = new BlockingFlowableIterator(this.f25033b);
        this.f25032a.subscribe(blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
