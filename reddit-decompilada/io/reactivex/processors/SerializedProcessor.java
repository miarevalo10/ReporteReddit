package io.reactivex.processors;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class SerializedProcessor<T> extends FlowableProcessor<T> {
    final FlowableProcessor<T> f38149a;
    boolean f38150b;
    AppendOnlyLinkedArrayList<Object> f38151c;
    volatile boolean f38152d;

    SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.f38149a = flowableProcessor;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f38149a.subscribe((Subscriber) subscriber);
    }

    public final void mo5623a(Subscription subscription) {
        boolean z = true;
        if (!this.f38152d) {
            synchronized (this) {
                if (!this.f38152d) {
                    if (this.f38150b) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f38151c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                            this.f38151c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.m26667a(NotificationLite.m26698a(subscription));
                        return;
                    }
                    this.f38150b = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.f38149a.mo5623a(subscription);
        m38164b();
    }

    public final void onNext(T t) {
        if (!this.f38152d) {
            synchronized (this) {
                if (this.f38152d) {
                } else if (this.f38150b) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f38151c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f38151c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26696a((Object) t));
                } else {
                    this.f38150b = true;
                    this.f38149a.onNext(t);
                    m38164b();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
        r3 = this;
        r0 = r3.f38152d;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x0008:
        monitor-enter(r3);
        r0 = r3.f38152d;	 Catch:{ all -> 0x003b }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        r1 = r2;
        goto L_0x002e;
    L_0x0011:
        r3.f38152d = r2;	 Catch:{ all -> 0x003b }
        r0 = r3.f38150b;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x002c;
    L_0x0017:
        r0 = r3.f38151c;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0022;
    L_0x001b:
        r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList;	 Catch:{ all -> 0x003b }
        r0.<init>();	 Catch:{ all -> 0x003b }
        r3.f38151c = r0;	 Catch:{ all -> 0x003b }
    L_0x0022:
        r4 = io.reactivex.internal.util.NotificationLite.m26697a(r4);	 Catch:{ all -> 0x003b }
        r0 = r0.f25180b;	 Catch:{ all -> 0x003b }
        r0[r1] = r4;	 Catch:{ all -> 0x003b }
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        return;
    L_0x002c:
        r3.f38150b = r2;	 Catch:{ all -> 0x003b }
    L_0x002e:
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        if (r1 == 0) goto L_0x0035;
    L_0x0031:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x0035:
        r0 = r3.f38149a;
        r0.onError(r4);
        return;
    L_0x003b:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.SerializedProcessor.onError(java.lang.Throwable):void");
    }

    public final void onComplete() {
        if (!this.f38152d) {
            synchronized (this) {
                if (this.f38152d) {
                    return;
                }
                this.f38152d = true;
                if (this.f38150b) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f38151c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f38151c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26694a());
                    return;
                }
                this.f38150b = true;
                this.f38149a.onComplete();
            }
        }
    }

    private void m38164b() {
        while (true) {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f38151c;
                if (appendOnlyLinkedArrayList == null) {
                    this.f38150b = false;
                    return;
                }
                this.f38151c = null;
            }
            appendOnlyLinkedArrayList.m26668a(this.f38149a);
        }
    }
}
