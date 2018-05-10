package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {
    public Set<Subscription> f41837a;
    public volatile boolean f41838b;

    public final boolean mo7894d() {
        return this.f41838b;
    }

    public final void m43948a(Subscription subscription) {
        if (!subscription.mo7894d()) {
            if (!this.f41838b) {
                synchronized (this) {
                    if (!this.f41838b) {
                        if (this.f41837a == null) {
                            this.f41837a = new HashSet(4);
                        }
                        this.f41837a.add(subscription);
                        return;
                    }
                }
            }
            subscription.mo7893c();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m43949b(rx.Subscription r2) {
        /*
        r1 = this;
        r0 = r1.f41838b;
        if (r0 != 0) goto L_0x0020;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.f41838b;	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x001b;
    L_0x0009:
        r0 = r1.f41837a;	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x001b;
    L_0x000e:
        r0 = r1.f41837a;	 Catch:{ all -> 0x001d }
        r0 = r0.remove(r2);	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0020;
    L_0x0017:
        r2.mo7893c();
        goto L_0x0020;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        return;
    L_0x001d:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r2;
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.b(rx.Subscription):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo7893c() {
        /*
        r2 = this;
        r0 = r2.f41838b;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        monitor-enter(r2);
        r0 = r2.f41838b;	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        return;
    L_0x000b:
        r0 = 1;
        r2.f41838b = r0;	 Catch:{ all -> 0x0018 }
        r0 = r2.f41837a;	 Catch:{ all -> 0x0018 }
        r1 = 0;
        r2.f41837a = r1;	 Catch:{ all -> 0x0018 }
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        m43947a(r0);
        goto L_0x001b;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.c():void");
    }

    public static void m43947a(Collection<Subscription> collection) {
        if (collection != null) {
            List list = null;
            for (Subscription c : collection) {
                try {
                    c.mo7893c();
                } catch (Throwable th) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(th);
                }
            }
            Exceptions.m43434a(list);
        }
    }
}
