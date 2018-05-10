package io.reactivex.internal.operators.completable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableConcat extends Completable {
    final Publisher<? extends CompletableSource> f34716a;
    final int f34717b;

    static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        final CompletableObserver f34705a;
        final int f34706b;
        final int f34707c;
        final ConcatInnerObserver f34708d = new ConcatInnerObserver(this);
        final AtomicBoolean f34709e = new AtomicBoolean();
        int f34710f;
        int f34711g;
        SimpleQueue<CompletableSource> f34712h;
        Subscription f34713i;
        volatile boolean f34714j;
        volatile boolean f34715k;

        static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            final CompletableConcatSubscriber f31177a;

            ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.f31177a = completableConcatSubscriber;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32094c(this, disposable);
            }

            public final void onError(Throwable th) {
                this.f31177a.m35622a(th);
            }

            public final void onComplete() {
                this.f31177a.m35625c();
            }
        }

        public final /* synthetic */ void onNext(Object obj) {
            CompletableSource completableSource = (CompletableSource) obj;
            if (this.f34710f == 0 && this.f34712h.offer(completableSource) == null) {
                onError(new MissingBackpressureException());
            } else {
                m35620d();
            }
        }

        CompletableConcatSubscriber(CompletableObserver completableObserver, int i) {
            this.f34705a = completableObserver;
            this.f34706b = i;
            this.f34707c = i - (i >> 2);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34713i, subscription)) {
                this.f34713i = subscription;
                long j = this.f34706b == RedditJobManager.f10810d ? Long.MAX_VALUE : (long) this.f34706b;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(3);
                    if (a == 1) {
                        this.f34710f = a;
                        this.f34712h = queueSubscription;
                        this.f34714j = true;
                        this.f34705a.onSubscribe(this);
                        m35620d();
                        return;
                    } else if (a == 2) {
                        this.f34710f = a;
                        this.f34712h = queueSubscription;
                        this.f34705a.onSubscribe(this);
                        subscription.request(j);
                        return;
                    }
                }
                if (this.f34706b == RedditJobManager.f10810d) {
                    this.f34712h = new SpscLinkedArrayQueue(Flowable.bufferSize());
                } else {
                    this.f34712h = new SpscArrayQueue(this.f34706b);
                }
                this.f34705a.onSubscribe(this);
                subscription.request(j);
            }
        }

        public final void onError(Throwable th) {
            if (this.f34709e.compareAndSet(false, true)) {
                DisposableHelper.m32090a(this.f34708d);
                this.f34705a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f34714j = true;
            m35620d();
        }

        public final void mo5626a() {
            this.f34713i.cancel();
            DisposableHelper.m32090a(this.f34708d);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f34708d.get());
        }

        private void m35620d() {
            if (getAndIncrement() == 0) {
                while (!mo5627b()) {
                    if (!this.f34715k) {
                        boolean z = this.f34714j;
                        try {
                            CompletableSource completableSource = (CompletableSource) this.f34712h.poll();
                            boolean z2 = completableSource == null;
                            if (z && z2) {
                                if (this.f34709e.compareAndSet(false, true)) {
                                    this.f34705a.onComplete();
                                }
                                return;
                            } else if (!z2) {
                                this.f34715k = true;
                                completableSource.subscribe(this.f34708d);
                                if (this.f34710f != 1) {
                                    int i = this.f34711g + 1;
                                    if (i == this.f34707c) {
                                        this.f34711g = 0;
                                        this.f34713i.request((long) i);
                                    } else {
                                        this.f34711g = i;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.m26521b(th);
                            m35622a(th);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        final void m35622a(Throwable th) {
            if (this.f34709e.compareAndSet(false, true)) {
                this.f34713i.cancel();
                this.f34705a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        final void m35625c() {
            this.f34715k = false;
            m35620d();
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i) {
        this.f34716a = publisher;
        this.f34717b = i;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.f34716a.subscribe(new CompletableConcatSubscriber(completableObserver, this.f34717b));
    }
}
