package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> f37708a;

    static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> f39406a;

        DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.f39406a = consumer;
        }

        public final void onNext(T t) {
            this.e.onNext(t);
            if (this.i == 0) {
                try {
                    this.f39406a.accept(t);
                } catch (T t2) {
                    m38154a((Throwable) t2);
                }
            }
        }

        public final boolean mo7052a(T t) {
            boolean a = this.e.mo7052a(t);
            try {
                this.f39406a.accept(t);
            } catch (T t2) {
                m38154a((Throwable) t2);
            }
            return a;
        }

        public final int mo7033a(int i) {
            return m38156b(i);
        }

        public final T poll() throws Exception {
            T poll = this.g.poll();
            if (poll != null) {
                this.f39406a.accept(poll);
            }
            return poll;
        }
    }

    static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> f39407a;

        DoAfterSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            super(subscriber);
            this.f39407a = consumer;
        }

        public final void onNext(T t) {
            if (!this.h) {
                this.e.onNext(t);
                if (this.i == 0) {
                    try {
                        this.f39407a.accept(t);
                    } catch (T t2) {
                        m38157a((Throwable) t2);
                    }
                }
            }
        }

        public final int mo7033a(int i) {
            return m38159b(i);
        }

        public final T poll() throws Exception {
            T poll = this.g.poll();
            if (poll != null) {
                this.f39407a.accept(poll);
            }
            return poll;
        }
    }

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f37708a = consumer;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new DoAfterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f37708a));
        } else {
            this.source.subscribe(new DoAfterSubscriber(subscriber, this.f37708a));
        }
    }
}
