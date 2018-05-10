package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> f37710a;
    final Consumer<? super Throwable> f37711b;
    final Action f37712c;
    final Action f37713d;

    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> f39418a;
        final Consumer<? super Throwable> f39419b;
        final Action f39420c;
        final Action f39421d;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.f39418a = consumer;
            this.f39419b = consumer2;
            this.f39420c = action;
            this.f39421d = action2;
        }

        public final void onNext(T t) {
            if (!this.h) {
                if (this.i != 0) {
                    this.e.onNext(null);
                    return;
                }
                try {
                    this.f39418a.accept(t);
                    this.e.onNext(t);
                } catch (T t2) {
                    m38154a((Throwable) t2);
                }
            }
        }

        public final boolean mo7052a(T t) {
            if (this.h) {
                return false;
            }
            try {
                this.f39418a.accept(t);
                return this.e.mo7052a(t);
            } catch (T t2) {
                m38154a((Throwable) t2);
                return false;
            }
        }

        public final void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            boolean z = true;
            this.h = true;
            try {
                this.f39419b.accept(th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.e.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.e.onError(th);
            }
            try {
                this.f39421d.run();
            } catch (Throwable th3) {
                Exceptions.m26521b(th3);
                RxJavaPlugins.m26757a(th3);
            }
        }

        public final void onComplete() {
            if (!this.h) {
                try {
                    this.f39420c.run();
                    this.h = true;
                    this.e.onComplete();
                    try {
                        this.f39421d.run();
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        RxJavaPlugins.m26757a(th);
                    }
                } catch (Throwable th2) {
                    m38154a(th2);
                }
            }
        }

        public final int mo7033a(int i) {
            return m38156b(i);
        }

        public final T poll() throws Exception {
            Exception b;
            CompositeException compositeException;
            try {
                T poll = this.g.poll();
                if (poll != null) {
                    try {
                        this.f39418a.accept(poll);
                        this.f39421d.run();
                    } catch (Throwable th) {
                        compositeException = new CompositeException(th, th);
                    }
                } else if (this.i == 1) {
                    this.f39420c.run();
                    this.f39421d.run();
                }
                return poll;
            } catch (Throwable th2) {
                compositeException = new CompositeException(th, th2);
            }
        }
    }

    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> f39422a;
        final Consumer<? super Throwable> f39423b;
        final Action f39424c;
        final Action f39425d;

        DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.f39422a = consumer;
            this.f39423b = consumer2;
            this.f39424c = action;
            this.f39425d = action2;
        }

        public final void onNext(T t) {
            if (!this.h) {
                if (this.i != 0) {
                    this.e.onNext(null);
                    return;
                }
                try {
                    this.f39422a.accept(t);
                    this.e.onNext(t);
                } catch (T t2) {
                    m38157a((Throwable) t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            boolean z = true;
            this.h = true;
            try {
                this.f39423b.accept(th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.e.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.e.onError(th);
            }
            try {
                this.f39425d.run();
            } catch (Throwable th3) {
                Exceptions.m26521b(th3);
                RxJavaPlugins.m26757a(th3);
            }
        }

        public final void onComplete() {
            if (!this.h) {
                try {
                    this.f39424c.run();
                    this.h = true;
                    this.e.onComplete();
                    try {
                        this.f39425d.run();
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        RxJavaPlugins.m26757a(th);
                    }
                } catch (Throwable th2) {
                    m38157a(th2);
                }
            }
        }

        public final int mo7033a(int i) {
            return m38159b(i);
        }

        public final T poll() throws Exception {
            Exception b;
            CompositeException compositeException;
            try {
                T poll = this.g.poll();
                if (poll != null) {
                    try {
                        this.f39422a.accept(poll);
                        this.f39425d.run();
                    } catch (Throwable th) {
                        compositeException = new CompositeException(th, th);
                    }
                } else if (this.i == 1) {
                    this.f39424c.run();
                    this.f39425d.run();
                }
                return poll;
            } catch (Throwable th2) {
                compositeException = new CompositeException(th, th2);
            }
        }
    }

    public FlowableDoOnEach(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.f37710a = consumer;
        this.f37711b = consumer2;
        this.f37712c = action;
        this.f37713d = action2;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new DoOnEachConditionalSubscriber((ConditionalSubscriber) subscriber, this.f37710a, this.f37711b, this.f37712c, this.f37713d));
            return;
        }
        this.source.subscribe(new DoOnEachSubscriber(subscriber, this.f37710a, this.f37711b, this.f37712c, this.f37713d));
    }
}
