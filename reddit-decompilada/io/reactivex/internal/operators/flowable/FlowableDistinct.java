package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, K> f37704a;
    final Callable<? extends Collection<? super K>> f37705b;

    static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {
        final Collection<? super K> f39396a;
        final Function<? super T, K> f39397b;

        DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
            super(subscriber);
            this.f39397b = function;
            this.f39396a = collection;
        }

        public final void onNext(T t) {
            if (!this.h) {
                if (this.i == 0) {
                    try {
                        if (this.f39396a.add(ObjectHelper.m26573a(this.f39397b.apply(t), "The keySelector returned a null key"))) {
                            this.e.onNext(t);
                            return;
                        } else {
                            this.f.request(1);
                            return;
                        }
                    } catch (T t2) {
                        m38157a((Throwable) t2);
                        return;
                    }
                }
                this.e.onNext(null);
            }
        }

        public final void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.h = true;
            this.f39396a.clear();
            this.e.onError(th);
        }

        public final void onComplete() {
            if (!this.h) {
                this.h = true;
                this.f39396a.clear();
                this.e.onComplete();
            }
        }

        public final int mo7033a(int i) {
            return m38159b(i);
        }

        public final T poll() throws Exception {
            T poll;
            while (true) {
                poll = this.g.poll();
                if (poll == null) {
                    break;
                } else if (this.f39396a.add(ObjectHelper.m26573a(this.f39397b.apply(poll), "The keySelector returned a null key"))) {
                    break;
                } else if (this.i == 2) {
                    this.f.request(1);
                }
            }
            return poll;
        }

        public final void clear() {
            this.f39396a.clear();
            super.clear();
        }
    }

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(flowable);
        this.f37704a = function;
        this.f37705b = callable;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.source.subscribe(new DistinctSubscriber(subscriber, this.f37704a, (Collection) ObjectHelper.m26573a(this.f37705b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
