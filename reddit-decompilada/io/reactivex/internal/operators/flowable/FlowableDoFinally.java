package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action f37709a;

    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        final ConditionalSubscriber<? super T> f39408a;
        final Action f39409b;
        Subscription f39410c;
        QueueSubscription<T> f39411d;
        boolean f39412e;

        DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Action action) {
            this.f39408a = conditionalSubscriber;
            this.f39409b = action;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f39410c, subscription)) {
                this.f39410c = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f39411d = (QueueSubscription) subscription;
                }
                this.f39408a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            this.f39408a.onNext(t);
        }

        public final boolean mo7052a(T t) {
            return this.f39408a.mo7052a(t);
        }

        public final void onError(Throwable th) {
            this.f39408a.onError(th);
            m39644a();
        }

        public final void onComplete() {
            this.f39408a.onComplete();
            m39644a();
        }

        public final void cancel() {
            this.f39410c.cancel();
            m39644a();
        }

        public final void request(long j) {
            this.f39410c.request(j);
        }

        public final int mo7033a(int i) {
            QueueSubscription queueSubscription = this.f39411d;
            if (queueSubscription == null || (i & 4) != 0) {
                return 0;
            }
            i = queueSubscription.mo7033a(i);
            if (i != 0) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                this.f39412e = z;
            }
            return i;
        }

        public final void clear() {
            this.f39411d.clear();
        }

        public final boolean isEmpty() {
            return this.f39411d.isEmpty();
        }

        public final T poll() throws Exception {
            T poll = this.f39411d.poll();
            if (poll == null && this.f39412e) {
                m39644a();
            }
            return poll;
        }

        private void m39644a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f39409b.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> f39413a;
        final Action f39414b;
        Subscription f39415c;
        QueueSubscription<T> f39416d;
        boolean f39417e;

        DoFinallySubscriber(Subscriber<? super T> subscriber, Action action) {
            this.f39413a = subscriber;
            this.f39414b = action;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f39415c, subscription)) {
                this.f39415c = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f39416d = (QueueSubscription) subscription;
                }
                this.f39413a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            this.f39413a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f39413a.onError(th);
            m39648a();
        }

        public final void onComplete() {
            this.f39413a.onComplete();
            m39648a();
        }

        public final void cancel() {
            this.f39415c.cancel();
            m39648a();
        }

        public final void request(long j) {
            this.f39415c.request(j);
        }

        public final int mo7033a(int i) {
            QueueSubscription queueSubscription = this.f39416d;
            if (queueSubscription == null || (i & 4) != 0) {
                return 0;
            }
            i = queueSubscription.mo7033a(i);
            if (i != 0) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                this.f39417e = z;
            }
            return i;
        }

        public final void clear() {
            this.f39416d.clear();
        }

        public final boolean isEmpty() {
            return this.f39416d.isEmpty();
        }

        public final T poll() throws Exception {
            T poll = this.f39416d.poll();
            if (poll == null && this.f39417e) {
                m39648a();
            }
            return poll;
        }

        private void m39648a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f39414b.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.f37709a = action;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new DoFinallyConditionalSubscriber((ConditionalSubscriber) subscriber, this.f37709a));
        } else {
            this.source.subscribe(new DoFinallySubscriber(subscriber, this.f37709a));
        }
    }
}
