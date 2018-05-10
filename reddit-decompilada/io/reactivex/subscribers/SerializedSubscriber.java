package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> f35962a;
    final boolean f35963b;
    Subscription f35964c;
    boolean f35965d;
    AppendOnlyLinkedArrayList<Object> f35966e;
    volatile boolean f35967f;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, (byte) 0);
    }

    private SerializedSubscriber(Subscriber<? super T> subscriber, byte b) {
        this.f35962a = subscriber;
        this.f35963b = null;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32781a(this.f35964c, subscription)) {
            this.f35964c = subscription;
            this.f35962a.mo5623a(this);
        }
    }

    public final void onNext(T t) {
        if (!this.f35967f) {
            if (t == null) {
                this.f35964c.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (this.f35967f) {
                } else if (this.f35965d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f35966e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f35966e = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26696a((Object) t));
                } else {
                    this.f35965d = true;
                    this.f35962a.onNext(t);
                    m36034a();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
        r3 = this;
        r0 = r3.f35967f;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x0008:
        monitor-enter(r3);
        r0 = r3.f35967f;	 Catch:{ all -> 0x0045 }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        r1 = r2;
        goto L_0x0038;
    L_0x0011:
        r0 = r3.f35965d;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0034;
    L_0x0015:
        r3.f35967f = r2;	 Catch:{ all -> 0x0045 }
        r0 = r3.f35966e;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0022;
    L_0x001b:
        r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList;	 Catch:{ all -> 0x0045 }
        r0.<init>();	 Catch:{ all -> 0x0045 }
        r3.f35966e = r0;	 Catch:{ all -> 0x0045 }
    L_0x0022:
        r4 = io.reactivex.internal.util.NotificationLite.m26697a(r4);	 Catch:{ all -> 0x0045 }
        r2 = r3.f35963b;	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r0.m26667a(r4);	 Catch:{ all -> 0x0045 }
        goto L_0x0032;
    L_0x002e:
        r0 = r0.f25180b;	 Catch:{ all -> 0x0045 }
        r0[r1] = r4;	 Catch:{ all -> 0x0045 }
    L_0x0032:
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        return;
    L_0x0034:
        r3.f35967f = r2;	 Catch:{ all -> 0x0045 }
        r3.f35965d = r2;	 Catch:{ all -> 0x0045 }
    L_0x0038:
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x003f;
    L_0x003b:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x003f:
        r0 = r3.f35962a;
        r0.onError(r4);
        return;
    L_0x0045:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public final void onComplete() {
        if (!this.f35967f) {
            synchronized (this) {
                if (this.f35967f) {
                } else if (this.f35965d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f35966e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f35966e = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26694a());
                } else {
                    this.f35967f = true;
                    this.f35965d = true;
                    this.f35962a.onComplete();
                }
            }
        }
    }

    private void m36034a() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f35966e;
                if (appendOnlyLinkedArrayList == null) {
                    this.f35965d = false;
                    return;
                }
                this.f35966e = null;
            }
        } while (!appendOnlyLinkedArrayList.m26668a(this.f35962a));
    }

    public final void request(long j) {
        this.f35964c.request(j);
    }

    public final void cancel() {
        this.f35964c.cancel();
    }
}
