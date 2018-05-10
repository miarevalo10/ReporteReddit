package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Publisher<? extends T> f35323a;
    final Publisher<? extends T> f35324b;
    final BiPredicate<? super T, ? super T> f35325c;
    final int f35326d;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, EqualCoordinatorHelper {
        final SingleObserver<? super Boolean> f31362a;
        final BiPredicate<? super T, ? super T> f31363b;
        final EqualSubscriber<T> f31364c;
        final EqualSubscriber<T> f31365d;
        final AtomicThrowable f31366e = new AtomicThrowable();
        T f31367f;
        T f31368g;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i, BiPredicate<? super T, ? super T> biPredicate) {
            this.f31362a = singleObserver;
            this.f31363b = biPredicate;
            this.f31364c = new EqualSubscriber(this, i);
            this.f31365d = new EqualSubscriber(this, i);
        }

        public final void mo5626a() {
            SubscriptionHelper.m32777a(this.f31364c);
            SubscriptionHelper.m32777a(this.f31365d);
            if (getAndIncrement() == 0) {
                this.f31364c.m35830b();
                this.f31365d.m35830b();
            }
        }

        public final boolean mo5627b() {
            return SubscriptionHelper.m32780a((Subscription) this.f31364c.get());
        }

        private void m32222c() {
            SubscriptionHelper.m32777a(this.f31364c);
            this.f31364c.m35830b();
            SubscriptionHelper.m32777a(this.f31365d);
            this.f31365d.m35830b();
        }

        public final void ay_() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    SimpleQueue simpleQueue = this.f31364c.f35316e;
                    SimpleQueue simpleQueue2 = this.f31365d.f35316e;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!mo5627b()) {
                            if (((Throwable) this.f31366e.get()) != null) {
                                m32222c();
                                this.f31362a.onError(ExceptionHelper.m26683a(this.f31366e));
                                return;
                            }
                            boolean z = this.f31364c.f35317f;
                            Object obj = this.f31367f;
                            if (obj == null) {
                                try {
                                    obj = simpleQueue.poll();
                                    this.f31367f = obj;
                                } catch (Throwable th) {
                                    Exceptions.m26521b(th);
                                    m32222c();
                                    ExceptionHelper.m26684a(this.f31366e, th);
                                    this.f31362a.onError(ExceptionHelper.m26683a(this.f31366e));
                                    return;
                                }
                            }
                            boolean z2 = obj == null;
                            boolean z3 = this.f31365d.f35317f;
                            Object obj2 = this.f31368g;
                            if (obj2 == null) {
                                try {
                                    obj2 = simpleQueue2.poll();
                                    this.f31368g = obj2;
                                } catch (Throwable th2) {
                                    Exceptions.m26521b(th2);
                                    m32222c();
                                    ExceptionHelper.m26684a(this.f31366e, th2);
                                    this.f31362a.onError(ExceptionHelper.m26683a(this.f31366e));
                                    return;
                                }
                            }
                            boolean z4 = obj2 == null;
                            if (z && z3 && z2 && z4) {
                                this.f31362a.onSuccess(Boolean.valueOf(true));
                                return;
                            } else if (z && z3 && z2 != z4) {
                                m32222c();
                                this.f31362a.onSuccess(Boolean.valueOf(false));
                                return;
                            } else if (!(z2 || z4)) {
                                try {
                                    if (this.f31363b.mo4928a(obj, obj2)) {
                                        this.f31367f = null;
                                        this.f31368g = null;
                                        this.f31364c.m35828a();
                                        this.f31365d.m35828a();
                                    } else {
                                        m32222c();
                                        this.f31362a.onSuccess(Boolean.valueOf(false));
                                        return;
                                    }
                                } catch (Throwable th22) {
                                    Exceptions.m26521b(th22);
                                    m32222c();
                                    ExceptionHelper.m26684a(this.f31366e, th22);
                                    this.f31362a.onError(ExceptionHelper.m26683a(this.f31366e));
                                    return;
                                }
                            }
                        }
                        this.f31364c.m35830b();
                        this.f31365d.m35830b();
                        return;
                    } else if (mo5627b()) {
                        this.f31364c.m35830b();
                        this.f31365d.m35830b();
                        return;
                    } else if (((Throwable) this.f31366e.get()) != null) {
                        m32222c();
                        this.f31362a.onError(ExceptionHelper.m26683a(this.f31366e));
                        return;
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        public final void mo5653a(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31366e, th)) {
                ay_();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f35323a = publisher;
        this.f35324b = publisher2;
        this.f35325c = biPredicate;
        this.f35326d = i;
    }

    public final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f35326d, this.f35325c);
        singleObserver.onSubscribe(equalCoordinator);
        singleObserver = this.f35323a;
        Publisher publisher = this.f35324b;
        singleObserver.subscribe(equalCoordinator.f31364c);
        publisher.subscribe(equalCoordinator.f31365d);
    }

    public final Flowable<Boolean> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableSequenceEqual(this.f35323a, this.f35324b, this.f35325c, this.f35326d));
    }
}
