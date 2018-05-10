package rx.internal.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;

public final class SubscriptionList implements Subscription {
    public List<Subscription> f41802a;
    public volatile boolean f41803b;

    public SubscriptionList(Subscription... subscriptionArr) {
        this.f41802a = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(Subscription subscription) {
        this.f41802a = new LinkedList();
        this.f41802a.add(subscription);
    }

    public final boolean mo7894d() {
        return this.f41803b;
    }

    public final void m43910a(Subscription subscription) {
        if (!subscription.mo7894d()) {
            if (!this.f41803b) {
                synchronized (this) {
                    if (!this.f41803b) {
                        List list = this.f41802a;
                        if (list == null) {
                            list = new LinkedList();
                            this.f41802a = list;
                        }
                        list.add(subscription);
                        return;
                    }
                }
            }
            subscription.mo7893c();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo7893c() {
        /*
        r3 = this;
        r0 = r3.f41803b;
        if (r0 != 0) goto L_0x003d;
    L_0x0004:
        monitor-enter(r3);
        r0 = r3.f41803b;	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r3);	 Catch:{ all -> 0x003a }
        return;
    L_0x000b:
        r0 = 1;
        r3.f41803b = r0;	 Catch:{ all -> 0x003a }
        r0 = r3.f41802a;	 Catch:{ all -> 0x003a }
        r1 = 0;
        r3.f41802a = r1;	 Catch:{ all -> 0x003a }
        monitor-exit(r3);	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x003d;
    L_0x0016:
        r0 = r0.iterator();
    L_0x001a:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0036;
    L_0x0020:
        r2 = r0.next();
        r2 = (rx.Subscription) r2;
        r2.mo7893c();	 Catch:{ Throwable -> 0x002a }
        goto L_0x001a;
    L_0x002a:
        r2 = move-exception;
        if (r1 != 0) goto L_0x0032;
    L_0x002d:
        r1 = new java.util.ArrayList;
        r1.<init>();
    L_0x0032:
        r1.add(r2);
        goto L_0x001a;
    L_0x0036:
        rx.exceptions.Exceptions.m43434a(r1);
        goto L_0x003d;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003a }
        throw r0;
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.SubscriptionList.c():void");
    }
}
