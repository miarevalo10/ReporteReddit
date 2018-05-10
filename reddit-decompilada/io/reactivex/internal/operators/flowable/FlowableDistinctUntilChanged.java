package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, K> f37706a;
    final BiPredicate<? super K, ? super K> f37707b;

    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        final Function<? super T, K> f39398a;
        final BiPredicate<? super K, ? super K> f39399b;
        K f39400c;
        boolean f39401d;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.f39398a = function;
            this.f39399b = biPredicate;
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
                return this.e.mo7052a(t);
            }
            try {
                Object apply = this.f39398a.apply(t);
                if (this.f39401d) {
                    boolean a = this.f39399b.mo4928a(this.f39400c, apply);
                    this.f39400c = apply;
                    if (a) {
                        return false;
                    }
                }
                this.f39401d = true;
                this.f39400c = apply;
                this.e.onNext(t);
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
            while (true) {
                T poll = this.g.poll();
                if (poll == null) {
                    return null;
                }
                Object apply = this.f39398a.apply(poll);
                if (!this.f39401d) {
                    this.f39401d = true;
                    this.f39400c = apply;
                    return poll;
                } else if (this.f39399b.mo4928a(this.f39400c, apply)) {
                    this.f39400c = apply;
                    if (this.i != 1) {
                        this.f.request(1);
                    }
                } else {
                    this.f39400c = apply;
                    return poll;
                }
            }
        }
    }

    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Function<? super T, K> f39402a;
        final BiPredicate<? super K, ? super K> f39403b;
        K f39404c;
        boolean f39405d;

        DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.f39402a = function;
            this.f39403b = biPredicate;
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
                this.e.onNext(t);
                return true;
            }
            try {
                Object apply = this.f39402a.apply(t);
                if (this.f39405d) {
                    boolean a = this.f39403b.mo4928a(this.f39404c, apply);
                    this.f39404c = apply;
                    if (a) {
                        return false;
                    }
                }
                this.f39405d = true;
                this.f39404c = apply;
                this.e.onNext(t);
                return true;
            } catch (T t2) {
                m38157a((Throwable) t2);
                return true;
            }
        }

        public final int mo7033a(int i) {
            return m38159b(i);
        }

        public final T poll() throws Exception {
            while (true) {
                T poll = this.g.poll();
                if (poll == null) {
                    return null;
                }
                Object apply = this.f39402a.apply(poll);
                if (!this.f39405d) {
                    this.f39405d = true;
                    this.f39404c = apply;
                    return poll;
                } else if (this.f39403b.mo4928a(this.f39404c, apply)) {
                    this.f39404c = apply;
                    if (this.i != 1) {
                        this.f.request(1);
                    }
                } else {
                    this.f39404c = apply;
                    return poll;
                }
            }
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.f37706a = function;
        this.f37707b = biPredicate;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.f37706a, this.f37707b));
            return;
        }
        this.source.subscribe(new DistinctUntilChangedSubscriber(subscriber, this.f37706a, this.f37707b));
    }
}
