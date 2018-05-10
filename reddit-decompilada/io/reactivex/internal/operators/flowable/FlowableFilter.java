package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> f37720a;

    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Predicate<? super T> f39426a;

        FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.f39426a = predicate;
        }

        public final void onNext(T t) {
            if (mo7052a((Object) t) == null) {
                this.f.request(1);
            }
        }

        public final boolean mo7052a(T t) {
            if (this.h) {
                return false;
            }
            if (this.i != 0) {
                return this.e.mo7052a(null);
            }
            try {
                if (!this.f39426a.test(t) || this.e.mo7052a(t) == null) {
                    return false;
                }
                return true;
            } catch (T t2) {
                m38154a((Throwable) t2);
                return true;
            }
        }

        public final int mo7033a(int i) {
            return m38156b(i);
        }

        public final T poll() throws Exception {
            QueueSubscription queueSubscription = this.g;
            Predicate predicate = this.f39426a;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.i == 2) {
                    queueSubscription.request(1);
                }
            }
        }
    }

    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Predicate<? super T> f39427a;

        FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f39427a = predicate;
        }

        public final void onNext(T t) {
            if (mo7052a((Object) t) == null) {
                this.f.request(1);
            }
        }

        public final boolean mo7052a(T t) {
            if (this.h) {
                return null;
            }
            if (this.i != 0) {
                this.e.onNext(null);
                return true;
            }
            try {
                boolean test = this.f39427a.test(t);
                if (test) {
                    this.e.onNext(t);
                }
                return test;
            } catch (T t2) {
                m38157a((Throwable) t2);
                return true;
            }
        }

        public final int mo7033a(int i) {
            return m38159b(i);
        }

        public final T poll() throws Exception {
            QueueSubscription queueSubscription = this.g;
            Predicate predicate = this.f39427a;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.i == 2) {
                    queueSubscription.request(1);
                }
            }
        }
    }

    public FlowableFilter(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f37720a = predicate;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f37720a));
        } else {
            this.source.subscribe(new FilterSubscriber(subscriber, this.f37720a));
        }
    }
}
