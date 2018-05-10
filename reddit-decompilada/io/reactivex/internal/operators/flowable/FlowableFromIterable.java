package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class FlowableFromIterable<T> extends Flowable<T> {
    final Iterable<? extends T> f35073a;

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        Iterator<? extends T> f39452a;
        volatile boolean f39453b;
        boolean f39454c;

        public final int mo7033a(int i) {
            return i & 1;
        }

        abstract void mo7593a();

        abstract void mo7594a(long j);

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.f39452a = it;
        }

        public final T poll() {
            if (this.f39452a == null) {
                return null;
            }
            if (!this.f39454c) {
                this.f39454c = true;
            } else if (!this.f39452a.hasNext()) {
                return null;
            }
            return ObjectHelper.m26573a(this.f39452a.next(), "Iterator.next() returned a null value");
        }

        public final boolean isEmpty() {
            if (this.f39452a != null) {
                if (this.f39452a.hasNext()) {
                    return false;
                }
            }
            return true;
        }

        public final void clear() {
            this.f39452a = null;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j) && BackpressureHelper.m26670a((AtomicLong) this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo7593a();
                    return;
                }
                mo7594a(j);
            }
        }

        public final void cancel() {
            this.f39453b = true;
        }
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        final ConditionalSubscriber<? super T> f40246d;

        IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.f40246d = conditionalSubscriber;
        }

        final void mo7593a() {
            Iterator it = this.a;
            ConditionalSubscriber conditionalSubscriber = this.f40246d;
            while (!this.b) {
                try {
                    Object next = it.next();
                    if (!this.b) {
                        if (next == null) {
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        conditionalSubscriber.mo7052a(next);
                        if (!this.b) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.b) {
                                        conditionalSubscriber.onComplete();
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.m26521b(th);
                                conditionalSubscriber.onError(th);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    conditionalSubscriber.onError(th2);
                    return;
                }
            }
        }

        final void mo7594a(long j) {
            Iterator it = this.a;
            ConditionalSubscriber conditionalSubscriber = this.f40246d;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2) {
                        j2 = get();
                        if (j == j2) {
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.b) {
                        try {
                            Object next = it.next();
                            if (!this.b) {
                                if (next == null) {
                                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean a = conditionalSubscriber.mo7052a(next);
                                if (!this.b) {
                                    try {
                                        if (!it.hasNext()) {
                                            break loop0;
                                        } else if (a) {
                                            j++;
                                        }
                                    } catch (long j3) {
                                        Exceptions.m26521b(j3);
                                        conditionalSubscriber.onError(j3);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (long j32) {
                            Exceptions.m26521b(j32);
                            conditionalSubscriber.onError(j32);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.b == null) {
                    conditionalSubscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        final Subscriber<? super T> f40247d;

        IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.f40247d = subscriber;
        }

        final void mo7593a() {
            Iterator it = this.a;
            Subscriber subscriber = this.f40247d;
            while (!this.b) {
                try {
                    Object next = it.next();
                    if (!this.b) {
                        if (next == null) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(next);
                        if (!this.b) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.b) {
                                        subscriber.onComplete();
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.m26521b(th);
                                subscriber.onError(th);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        final void mo7594a(long j) {
            Iterator it = this.a;
            Subscriber subscriber = this.f40247d;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2) {
                        j2 = get();
                        if (j == j2) {
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.b) {
                        try {
                            Object next = it.next();
                            if (!this.b) {
                                if (next == null) {
                                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                subscriber.onNext(next);
                                if (!this.b) {
                                    try {
                                        if (!it.hasNext()) {
                                            break loop0;
                                        }
                                        j++;
                                    } catch (long j3) {
                                        Exceptions.m26521b(j3);
                                        subscriber.onError(j3);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (long j32) {
                            Exceptions.m26521b(j32);
                            subscriber.onError(j32);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.b == null) {
                    subscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f35073a = iterable;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            m35733a(subscriber, this.f35073a.iterator());
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }

    public static <T> void m35733a(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.m38161a((Subscriber) subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.mo5623a(new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.mo5623a(new IteratorSubscription(subscriber, it));
            }
        } catch (Iterator<? extends T> it2) {
            Exceptions.m26521b(it2);
            EmptySubscription.m38160a(it2, subscriber);
        }
    }
}
