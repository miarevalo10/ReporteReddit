package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> f37754a;

    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> f39483a;

        MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.f39483a = function;
        }

        public final void onNext(T t) {
            if (!this.h) {
                if (this.i != 0) {
                    this.e.onNext(null);
                    return;
                }
                try {
                    this.e.onNext(ObjectHelper.m26573a(this.f39483a.apply(t), "The mapper function returned a null value."));
                } catch (T t2) {
                    m38154a((Throwable) t2);
                }
            }
        }

        public final boolean mo7052a(T t) {
            if (this.h) {
                return null;
            }
            try {
                return this.e.mo7052a(ObjectHelper.m26573a(this.f39483a.apply(t), "The mapper function returned a null value."));
            } catch (T t2) {
                m38154a((Throwable) t2);
                return true;
            }
        }

        public final int mo7033a(int i) {
            return m38156b(i);
        }

        public final U poll() throws Exception {
            Object poll = this.g.poll();
            return poll != null ? ObjectHelper.m26573a(this.f39483a.apply(poll), "The mapper function returned a null value.") : null;
        }
    }

    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> f39484a;

        MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.f39484a = function;
        }

        public final void onNext(T t) {
            if (!this.h) {
                if (this.i != 0) {
                    this.e.onNext(null);
                    return;
                }
                try {
                    this.e.onNext(ObjectHelper.m26573a(this.f39484a.apply(t), "The mapper function returned a null value."));
                } catch (T t2) {
                    m38157a((Throwable) t2);
                }
            }
        }

        public final int mo7033a(int i) {
            return m38159b(i);
        }

        public final U poll() throws Exception {
            Object poll = this.g.poll();
            return poll != null ? ObjectHelper.m26573a(this.f39484a.apply(poll), "The mapper function returned a null value.") : null;
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.f37754a = function;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.f37754a));
        } else {
            this.source.subscribe(new MapSubscriber(subscriber, this.f37754a));
        }
    }
}
