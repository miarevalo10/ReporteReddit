package io.reactivex.internal.operators.flowable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> f37728a;
    final boolean f37729b;
    final int f37730c;

    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super R> f35041a;
        final boolean f35042b;
        final int f35043c;
        final AtomicLong f35044d = new AtomicLong();
        final CompositeDisposable f35045e = new CompositeDisposable();
        final AtomicInteger f35046f = new AtomicInteger(1);
        final AtomicThrowable f35047g = new AtomicThrowable();
        final Function<? super T, ? extends MaybeSource<? extends R>> f35048h;
        final AtomicReference<SpscLinkedArrayQueue<R>> f35049i = new AtomicReference();
        Subscription f35050j;
        volatile boolean f35051k;

        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            final /* synthetic */ FlatMapMaybeSubscriber f31263a;

            InnerObserver(FlatMapMaybeSubscriber flatMapMaybeSubscriber) {
                this.f31263a = flatMapMaybeSubscriber;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onSuccess(R r7) {
                /*
                r6 = this;
                r0 = r6.f31263a;
                r1 = r0.f35045e;
                r1.mo5633c(r6);
                r1 = r0.get();
                if (r1 != 0) goto L_0x007d;
            L_0x000d:
                r1 = 1;
                r2 = 0;
                r3 = r0.compareAndSet(r2, r1);
                if (r3 == 0) goto L_0x007d;
            L_0x0015:
                r3 = r0.f35046f;
                r3 = r3.decrementAndGet();
                if (r3 != 0) goto L_0x001e;
            L_0x001d:
                goto L_0x001f;
            L_0x001e:
                r1 = r2;
            L_0x001f:
                r2 = r0.f35044d;
                r2 = r2.get();
                r4 = 0;
                r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                if (r2 == 0) goto L_0x006a;
            L_0x002b:
                r2 = r0.f35041a;
                r2.onNext(r7);
                r7 = r0.f35049i;
                r7 = r7.get();
                r7 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r7;
                if (r1 == 0) goto L_0x0056;
            L_0x003a:
                if (r7 == 0) goto L_0x0042;
            L_0x003c:
                r7 = r7.isEmpty();
                if (r7 == 0) goto L_0x0056;
            L_0x0042:
                r7 = r0.f35047g;
                r7 = io.reactivex.internal.util.ExceptionHelper.m26683a(r7);
                if (r7 == 0) goto L_0x0050;
            L_0x004a:
                r0 = r0.f35041a;
                r0.onError(r7);
                return;
            L_0x0050:
                r7 = r0.f35041a;
                r7.onComplete();
                return;
            L_0x0056:
                r7 = r0.f35044d;
                r1 = 1;
                io.reactivex.internal.util.BackpressureHelper.m26673c(r7, r1);
                r7 = r0.f35043c;
                r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
                if (r7 == r3) goto L_0x0073;
            L_0x0064:
                r7 = r0.f35050j;
                r7.request(r1);
                goto L_0x0073;
            L_0x006a:
                r1 = r0.m35724a();
                monitor-enter(r1);
                r1.offer(r7);	 Catch:{ all -> 0x007a }
                monitor-exit(r1);	 Catch:{ all -> 0x007a }
            L_0x0073:
                r7 = r0.decrementAndGet();
                if (r7 == 0) goto L_0x0094;
            L_0x0079:
                goto L_0x0091;
            L_0x007a:
                r7 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x007a }
                throw r7;
            L_0x007d:
                r1 = r0.m35724a();
                monitor-enter(r1);
                r1.offer(r7);	 Catch:{ all -> 0x0095 }
                monitor-exit(r1);	 Catch:{ all -> 0x0095 }
                r7 = r0.f35046f;
                r7.decrementAndGet();
                r7 = r0.getAndIncrement();
                if (r7 != 0) goto L_0x0094;
            L_0x0091:
                r0.m35727c();
            L_0x0094:
                return;
            L_0x0095:
                r7 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0095 }
                throw r7;
                */
                throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.InnerObserver.onSuccess(java.lang.Object):void");
            }

            public final void onError(Throwable th) {
                FlatMapMaybeSubscriber flatMapMaybeSubscriber = this.f31263a;
                flatMapMaybeSubscriber.f35045e.mo5633c(this);
                if (ExceptionHelper.m26684a(flatMapMaybeSubscriber.f35047g, th)) {
                    if (flatMapMaybeSubscriber.f35042b == null) {
                        flatMapMaybeSubscriber.f35050j.cancel();
                        flatMapMaybeSubscriber.f35045e.mo5626a();
                    } else if (flatMapMaybeSubscriber.f35043c != Integer.MAX_VALUE) {
                        flatMapMaybeSubscriber.f35050j.request(1);
                    }
                    flatMapMaybeSubscriber.f35046f.decrementAndGet();
                    flatMapMaybeSubscriber.m35726b();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }

            public final void onComplete() {
                FlatMapMaybeSubscriber flatMapMaybeSubscriber = this.f31263a;
                flatMapMaybeSubscriber.f35045e.mo5633c(this);
                if (flatMapMaybeSubscriber.get() == 0) {
                    int i = 1;
                    if (flatMapMaybeSubscriber.compareAndSet(0, 1)) {
                        if (flatMapMaybeSubscriber.f35046f.decrementAndGet() != 0) {
                            i = 0;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) flatMapMaybeSubscriber.f35049i.get();
                        if (i == 0 || !(spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            if (flatMapMaybeSubscriber.f35043c != RedditJobManager.f10810d) {
                                flatMapMaybeSubscriber.f35050j.request(1);
                            }
                            if (flatMapMaybeSubscriber.decrementAndGet() != 0) {
                                flatMapMaybeSubscriber.m35727c();
                                return;
                            }
                        }
                        Throwable a = ExceptionHelper.m26683a(flatMapMaybeSubscriber.f35047g);
                        if (a != null) {
                            flatMapMaybeSubscriber.f35041a.onError(a);
                            return;
                        } else {
                            flatMapMaybeSubscriber.f35041a.onComplete();
                            return;
                        }
                    }
                }
                flatMapMaybeSubscriber.f35046f.decrementAndGet();
                if (flatMapMaybeSubscriber.f35043c != RedditJobManager.f10810d) {
                    flatMapMaybeSubscriber.f35050j.request(1);
                }
                flatMapMaybeSubscriber.m35726b();
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }
        }

        FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
            this.f35041a = subscriber;
            this.f35048h = function;
            this.f35042b = z;
            this.f35043c = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35050j, subscription)) {
                this.f35050j = subscription;
                this.f35041a.mo5623a(this);
                if (this.f35043c == RedditJobManager.f10810d) {
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                subscription.request((long) this.f35043c);
            }
        }

        public final void onNext(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.m26573a(this.f35048h.apply(t), "The mapper returned a null MaybeSource");
                this.f35046f.getAndIncrement();
                Disposable innerObserver = new InnerObserver(this);
                if (!this.f35051k && this.f35045e.mo5631a(innerObserver)) {
                    maybeSource.subscribe(innerObserver);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f35050j.cancel();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f35046f.decrementAndGet();
            if (ExceptionHelper.m26684a(this.f35047g, th)) {
                if (this.f35042b == null) {
                    this.f35045e.mo5626a();
                }
                m35726b();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f35046f.decrementAndGet();
            m35726b();
        }

        public final void cancel() {
            this.f35051k = true;
            this.f35050j.cancel();
            this.f35045e.mo5626a();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35044d, j);
                m35726b();
            }
        }

        final SpscLinkedArrayQueue<R> m35724a() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f35049i.get();
                if (spscLinkedArrayQueue != null) {
                    return spscLinkedArrayQueue;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue(Flowable.bufferSize());
            } while (!this.f35049i.compareAndSet(null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        final void m35726b() {
            if (getAndIncrement() == 0) {
                m35727c();
            }
        }

        private void m35723d() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f35049i.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m35727c() {
            /*
            r17 = this;
            r0 = r17;
            r1 = r0.f35041a;
            r2 = r0.f35046f;
            r3 = r0.f35049i;
            r4 = 1;
            r5 = r4;
        L_0x000a:
            r6 = r0.f35044d;
            r6 = r6.get();
            r8 = 0;
            r10 = r8;
        L_0x0013:
            r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
            r13 = 0;
            if (r12 == 0) goto L_0x0076;
        L_0x0018:
            r14 = r0.f35051k;
            if (r14 == 0) goto L_0x0020;
        L_0x001c:
            r17.m35723d();
            return;
        L_0x0020:
            r14 = r0.f35042b;
            if (r14 != 0) goto L_0x003b;
        L_0x0024:
            r14 = r0.f35047g;
            r14 = r14.get();
            r14 = (java.lang.Throwable) r14;
            if (r14 == 0) goto L_0x003b;
        L_0x002e:
            r2 = r0.f35047g;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            r17.m35723d();
            r1.onError(r2);
            return;
        L_0x003b:
            r14 = r2.get();
            if (r14 != 0) goto L_0x0043;
        L_0x0041:
            r14 = r4;
            goto L_0x0044;
        L_0x0043:
            r14 = r13;
        L_0x0044:
            r15 = r3.get();
            r15 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r15;
            if (r15 == 0) goto L_0x0051;
        L_0x004c:
            r15 = r15.poll();
            goto L_0x0052;
        L_0x0051:
            r15 = 0;
        L_0x0052:
            if (r15 != 0) goto L_0x0057;
        L_0x0054:
            r16 = r4;
            goto L_0x0059;
        L_0x0057:
            r16 = r13;
        L_0x0059:
            if (r14 == 0) goto L_0x006d;
        L_0x005b:
            if (r16 == 0) goto L_0x006d;
        L_0x005d:
            r2 = r0.f35047g;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            if (r2 == 0) goto L_0x0069;
        L_0x0065:
            r1.onError(r2);
            return;
        L_0x0069:
            r1.onComplete();
            return;
        L_0x006d:
            if (r16 != 0) goto L_0x0076;
        L_0x006f:
            r1.onNext(r15);
            r12 = 1;
            r10 = r10 + r12;
            goto L_0x0013;
        L_0x0076:
            if (r12 != 0) goto L_0x00c7;
        L_0x0078:
            r6 = r0.f35051k;
            if (r6 == 0) goto L_0x0080;
        L_0x007c:
            r17.m35723d();
            return;
        L_0x0080:
            r6 = r0.f35042b;
            if (r6 != 0) goto L_0x009b;
        L_0x0084:
            r6 = r0.f35047g;
            r6 = r6.get();
            r6 = (java.lang.Throwable) r6;
            if (r6 == 0) goto L_0x009b;
        L_0x008e:
            r2 = r0.f35047g;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            r17.m35723d();
            r1.onError(r2);
            return;
        L_0x009b:
            r6 = r2.get();
            if (r6 != 0) goto L_0x00a3;
        L_0x00a1:
            r6 = r4;
            goto L_0x00a4;
        L_0x00a3:
            r6 = r13;
        L_0x00a4:
            r7 = r3.get();
            r7 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r7;
            if (r7 == 0) goto L_0x00b2;
        L_0x00ac:
            r7 = r7.isEmpty();
            if (r7 == 0) goto L_0x00b3;
        L_0x00b2:
            r13 = r4;
        L_0x00b3:
            if (r6 == 0) goto L_0x00c7;
        L_0x00b5:
            if (r13 == 0) goto L_0x00c7;
        L_0x00b7:
            r2 = r0.f35047g;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26683a(r2);
            if (r2 == 0) goto L_0x00c3;
        L_0x00bf:
            r1.onError(r2);
            return;
        L_0x00c3:
            r1.onComplete();
            return;
        L_0x00c7:
            r6 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
            if (r6 == 0) goto L_0x00dc;
        L_0x00cb:
            r6 = r0.f35044d;
            io.reactivex.internal.util.BackpressureHelper.m26673c(r6, r10);
            r6 = r0.f35043c;
            r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
            if (r6 == r7) goto L_0x00dc;
        L_0x00d7:
            r6 = r0.f35050j;
            r6.request(r10);
        L_0x00dc:
            r5 = -r5;
            r5 = r0.addAndGet(r5);
            if (r5 != 0) goto L_0x000a;
        L_0x00e3:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.c():void");
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        super(flowable);
        this.f37728a = function;
        this.f37729b = z;
        this.f37730c = i;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new FlatMapMaybeSubscriber(subscriber, this.f37728a, this.f37729b, this.f37730c));
    }
}
