package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Callable<S> f35076a;
    final BiFunction<S, Emitter<T>, S> f35077b;
    final Consumer<? super S> f35078c;

    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        final Subscriber<? super T> f31267a;
        final BiFunction<S, ? super Emitter<T>, S> f31268b;
        final Consumer<? super S> f31269c;
        S f31270d;
        volatile boolean f31271e;
        boolean f31272f;
        boolean f31273g;

        GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.f31267a = subscriber;
            this.f31268b = biFunction;
            this.f31269c = consumer;
            this.f31270d = s;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j) && BackpressureHelper.m26670a((AtomicLong) this, j) == 0) {
                Object obj = this.f31270d;
                BiFunction biFunction = this.f31268b;
                long j2 = j;
                while (true) {
                    j = 0;
                    while (true) {
                        if (j == j2) {
                            j2 = get();
                            if (j == j2) {
                                break;
                            }
                        } else if (this.f31271e) {
                            this.f31270d = null;
                            m32185b(obj);
                            return;
                        } else {
                            this.f31273g = false;
                            try {
                                Object apply = biFunction.apply(obj, this);
                                if (this.f31272f) {
                                    this.f31271e = true;
                                    this.f31270d = null;
                                    m32185b(apply);
                                    return;
                                }
                                j++;
                                obj = apply;
                            } catch (Throwable th) {
                                Exceptions.m26521b(th);
                                this.f31271e = true;
                                this.f31270d = null;
                                mo5642a(th);
                                m32185b(obj);
                                return;
                            }
                        }
                    }
                    this.f31270d = obj;
                    j2 = addAndGet(-j);
                    if (j2 == 0) {
                        return;
                    }
                }
            }
        }

        private void m32185b(S s) {
            try {
                this.f31269c.accept(s);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void cancel() {
            if (!this.f31271e) {
                this.f31271e = true;
                if (BackpressureHelper.m26670a((AtomicLong) this, 1) == 0) {
                    Object obj = this.f31270d;
                    this.f31270d = null;
                    m32185b(obj);
                }
            }
        }

        public final void mo5641a(T t) {
            if (!this.f31272f) {
                if (this.f31273g) {
                    mo5642a(new IllegalStateException("onNext already called in this generate turn"));
                } else if (t == null) {
                    mo5642a(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.f31273g = true;
                    this.f31267a.onNext(t);
                }
            }
        }

        public final void mo5642a(Throwable th) {
            if (this.f31272f) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f31272f = true;
            this.f31267a.onError(th);
        }

        public final void aA_() {
            if (!this.f31272f) {
                this.f31272f = true;
                this.f31267a.onComplete();
            }
        }
    }

    public FlowableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f35076a = callable;
        this.f35077b = biFunction;
        this.f35078c = consumer;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.mo5623a(new GeneratorSubscription(subscriber, this.f35077b, this.f35078c, this.f35076a.call()));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
