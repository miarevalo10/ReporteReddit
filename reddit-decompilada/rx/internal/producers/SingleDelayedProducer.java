package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleDelayedProducer<T> extends AtomicInteger implements Producer {
    final Subscriber<? super T> f41726a;
    T f41727b;

    public SingleDelayedProducer(Subscriber<? super T> subscriber) {
        this.f41726a = subscriber;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo7901a(long r3) {
        /*
        r2 = this;
        r0 = 0;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 >= 0) goto L_0x000e;
    L_0x0006:
        r3 = new java.lang.IllegalArgumentException;
        r4 = "n >= 0 required";
        r3.<init>(r4);
        throw r3;
    L_0x000e:
        if (r3 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r3 = r2.get();
        if (r3 != 0) goto L_0x0020;
    L_0x0017:
        r3 = 0;
        r4 = 2;
        r3 = r2.compareAndSet(r3, r4);
        if (r3 != 0) goto L_0x0031;
    L_0x001f:
        goto L_0x0011;
    L_0x0020:
        r4 = 1;
        if (r3 != r4) goto L_0x0031;
    L_0x0023:
        r3 = 3;
        r3 = r2.compareAndSet(r4, r3);
        if (r3 == 0) goto L_0x0031;
    L_0x002a:
        r3 = r2.f41726a;
        r4 = r2.f41727b;
        m43846a(r3, r4);
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.SingleDelayedProducer.a(long):void");
    }

    public final void m43848a(T t) {
        while (true) {
            int i = get();
            if (i != 0) {
                break;
            }
            this.f41727b = t;
            if (compareAndSet(0, 1)) {
                return;
            }
        }
        if (i == 2 && compareAndSet(2, 3)) {
            m43846a(this.f41726a, t);
        }
    }

    private static <T> void m43846a(Subscriber<? super T> subscriber, T t) {
        if (!subscriber.mo7894d()) {
            try {
                subscriber.a_(t);
                if (subscriber.mo7894d() == null) {
                    subscriber.mo7906b();
                }
            } catch (Throwable th) {
                Exceptions.m43433a(th, subscriber, t);
            }
        }
    }
}
