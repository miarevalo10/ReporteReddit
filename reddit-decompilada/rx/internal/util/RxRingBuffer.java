package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public class RxRingBuffer implements Subscription {
    public static final int f41779b;
    public static final ObjectPool<Queue<Object>> f41780c = new C31591();
    public static final ObjectPool<Queue<Object>> f41781d = new C31602();
    private static final NotificationLite<Object> f41782e = NotificationLite.m43450a();
    public volatile Object f41783a;
    private Queue<Object> f41784f;
    private final int f41785g;
    private final ObjectPool<Queue<Object>> f41786h;

    static class C31591 extends ObjectPool<Queue<Object>> {
        C31591() {
        }

        protected final /* synthetic */ Object mo7931b() {
            return new SpscArrayQueue(RxRingBuffer.f41779b);
        }
    }

    static class C31602 extends ObjectPool<Queue<Object>> {
        C31602() {
        }

        protected final /* synthetic */ Object mo7931b() {
            return new SpmcArrayQueue(RxRingBuffer.f41779b);
        }
    }

    static {
        int i = PlatformDependent.m43470a() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder("Failed to set 'rx.buffer.size' with value ");
                stringBuilder.append(property);
                stringBuilder.append(" => ");
                stringBuilder.append(e.getMessage());
                printStream.println(stringBuilder.toString());
            }
        }
        f41779b = i;
    }

    public static RxRingBuffer m43891a() {
        if (UnsafeAccess.m43484a()) {
            return new RxRingBuffer(f41780c, f41779b);
        }
        return new RxRingBuffer();
    }

    public static RxRingBuffer m43892b() {
        if (UnsafeAccess.m43484a()) {
            return new RxRingBuffer(f41781d, f41779b);
        }
        return new RxRingBuffer();
    }

    private RxRingBuffer(Queue<Object> queue, int i) {
        this.f41784f = queue;
        this.f41786h = null;
        this.f41785g = i;
    }

    private RxRingBuffer(ObjectPool<Queue<Object>> objectPool, int i) {
        this.f41786h = objectPool;
        this.f41784f = (Queue) objectPool.m43888a();
        this.f41785g = i;
    }

    public final synchronized void m43898e() {
        Queue queue = this.f41784f;
        ObjectPool objectPool = this.f41786h;
        if (!(objectPool == null || queue == null)) {
            queue.clear();
            this.f41784f = null;
            if (queue != null) {
                objectPool.f41774a.offer(queue);
            }
        }
    }

    public final void mo7893c() {
        m43898e();
    }

    RxRingBuffer() {
        this(new SynchronizedQueue(f41779b), f41779b);
    }

    public final void m43895a(Object obj) throws MissingBackpressureException {
        synchronized (this) {
            Queue queue = this.f41784f;
            int i = 1;
            if (queue != null) {
                obj = queue.offer(NotificationLite.m43448a(obj)) ^ 1;
                i = 0;
            } else {
                obj = null;
            }
        }
        if (i != 0) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (obj != null) {
            throw new MissingBackpressureException();
        }
    }

    public final boolean m43899f() {
        Queue queue = this.f41784f;
        if (queue == null) {
            return true;
        }
        return queue.isEmpty();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m43900g() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f41784f;	 Catch:{ all -> 0x001d }
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        return r1;
    L_0x0008:
        r2 = r0.poll();	 Catch:{ all -> 0x001d }
        r3 = r4.f41783a;	 Catch:{ all -> 0x001d }
        if (r2 != 0) goto L_0x001b;
    L_0x0010:
        if (r3 == 0) goto L_0x001b;
    L_0x0012:
        r0 = r0.peek();	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x001b;
    L_0x0018:
        r4.f41783a = r1;	 Catch:{ all -> 0x001d }
        r2 = r3;
    L_0x001b:
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        return r2;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.RxRingBuffer.g():java.lang.Object");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m43901h() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f41784f;	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x0008;
    L_0x0005:
        r0 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x001b }
        return r0;
    L_0x0008:
        r1 = r0.peek();	 Catch:{ all -> 0x001b }
        r2 = r3.f41783a;	 Catch:{ all -> 0x001b }
        if (r1 != 0) goto L_0x0019;
    L_0x0010:
        if (r2 == 0) goto L_0x0019;
    L_0x0012:
        r0 = r0.peek();	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        r1 = r2;
    L_0x0019:
        monitor-exit(r3);	 Catch:{ all -> 0x001b }
        return r1;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.RxRingBuffer.h():java.lang.Object");
    }

    public static boolean m43893b(Object obj) {
        return NotificationLite.m43453b(obj);
    }

    public static Object m43894c(Object obj) {
        return NotificationLite.m43454c(obj);
    }

    public final boolean mo7894d() {
        return this.f41784f == null;
    }
}
