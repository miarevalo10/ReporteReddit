package rx;

import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private final Subscriber<?> f41659a;
    private Producer f41660b;
    private long f41661c;
    protected final SubscriptionList f41662d;

    public void aV_() {
    }

    protected Subscriber() {
        this(null, false);
    }

    protected Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    protected Subscriber(Subscriber<?> subscriber, boolean z) {
        this.f41661c = Long.MIN_VALUE;
        this.f41659a = subscriber;
        subscriber = (!z || subscriber == null) ? new SubscriptionList() : subscriber.f41662d;
        this.f41662d = subscriber;
    }

    public final void m43809a(Subscription subscription) {
        this.f41662d.m43910a(subscription);
    }

    public final void mo7893c() {
        this.f41662d.mo7893c();
    }

    public final boolean mo7894d() {
        return this.f41662d.f41803b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void m43807a(long r7) {
        /*
        r6 = this;
        r0 = 0;
        r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x001a;
    L_0x0006:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "number requested cannot be negative: ";
        r1.<init>(r2);
        r1.append(r7);
        r7 = r1.toString();
        r0.<init>(r7);
        throw r0;
    L_0x001a:
        monitor-enter(r6);
        r2 = r6.f41660b;	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x0026;
    L_0x001f:
        r0 = r6.f41660b;	 Catch:{ all -> 0x0044 }
        monitor-exit(r6);	 Catch:{ all -> 0x0044 }
        r0.mo7901a(r7);
        return;
    L_0x0026:
        r2 = r6.f41661c;	 Catch:{ all -> 0x0044 }
        r4 = -9223372036854775808;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0031;
    L_0x002e:
        r6.f41661c = r7;	 Catch:{ all -> 0x0044 }
        goto L_0x0042;
    L_0x0031:
        r2 = r6.f41661c;	 Catch:{ all -> 0x0044 }
        r2 = r2 + r7;
        r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r7 >= 0) goto L_0x0040;
    L_0x0038:
        r7 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6.f41661c = r7;	 Catch:{ all -> 0x0044 }
        goto L_0x0042;
    L_0x0040:
        r6.f41661c = r2;	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r6);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0044:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0044 }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.Subscriber.a(long):void");
    }

    public void mo7929a(Producer producer) {
        synchronized (this) {
            long j = this.f41661c;
            this.f41660b = producer;
            producer = (this.f41659a == null || j != Long.MIN_VALUE) ? null : true;
        }
        if (producer != null) {
            this.f41659a.mo7929a(this.f41660b);
        } else if (j == Long.MIN_VALUE) {
            this.f41660b.mo7901a(Long.MAX_VALUE);
        } else {
            this.f41660b.mo7901a(j);
        }
    }
}
