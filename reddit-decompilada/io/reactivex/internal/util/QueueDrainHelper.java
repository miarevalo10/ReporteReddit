package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class QueueDrainHelper {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, U> void m26727a(io.reactivex.internal.fuseable.SimplePlainQueue<T> r8, org.reactivestreams.Subscriber<? super U> r9, io.reactivex.disposables.Disposable r10, io.reactivex.internal.util.QueueDrain<T, U> r11) {
        /*
        r0 = 1;
        r1 = r0;
    L_0x0002:
        r2 = r11.mo7605e();
        r3 = r8.poll();
        r4 = 0;
        if (r3 != 0) goto L_0x000f;
    L_0x000d:
        r5 = r0;
        goto L_0x0010;
    L_0x000f:
        r5 = r4;
    L_0x0010:
        r6 = r11.mo7604d();
        if (r6 == 0) goto L_0x001b;
    L_0x0016:
        r8.clear();
    L_0x0019:
        r4 = r0;
        goto L_0x0030;
    L_0x001b:
        if (r2 == 0) goto L_0x0030;
    L_0x001d:
        r2 = r11.mo7606h();
        if (r2 == 0) goto L_0x002a;
    L_0x0023:
        r8.clear();
        r9.onError(r2);
        goto L_0x0019;
    L_0x002a:
        if (r5 == 0) goto L_0x0030;
    L_0x002c:
        r9.onComplete();
        goto L_0x0019;
    L_0x0030:
        if (r4 == 0) goto L_0x0038;
    L_0x0032:
        if (r10 == 0) goto L_0x0037;
    L_0x0034:
        r10.mo5626a();
    L_0x0037:
        return;
    L_0x0038:
        if (r5 != 0) goto L_0x006a;
    L_0x003a:
        r4 = r11.mo7607i();
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0057;
    L_0x0044:
        r2 = r11.mo7603a(r9, r3);
        if (r2 == 0) goto L_0x0002;
    L_0x004a:
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0002;
    L_0x0053:
        r11.mo7608j();
        goto L_0x0002;
    L_0x0057:
        r8.clear();
        if (r10 == 0) goto L_0x005f;
    L_0x005c:
        r10.mo5626a();
    L_0x005f:
        r8 = new io.reactivex.exceptions.MissingBackpressureException;
        r10 = "Could not emit value due to lack of requests.";
        r8.<init>(r10);
        r9.onError(r8);
        return;
    L_0x006a:
        r1 = -r1;
        r1 = r11.mo7602a(r1);
        if (r1 != 0) goto L_0x0002;
    L_0x0071:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.QueueDrainHelper.a(io.reactivex.internal.fuseable.SimplePlainQueue, org.reactivestreams.Subscriber, io.reactivex.disposables.Disposable, io.reactivex.internal.util.QueueDrain):void");
    }

    public static <T, U> void m26726a(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        int i = 1;
        while (!m26732a(observableQueueDrain.mo7037d(), simplePlainQueue.isEmpty(), observer, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean d = observableQueueDrain.mo7037d();
                Object poll = simplePlainQueue.poll();
                boolean z = poll == null;
                if (!m26732a(d, z, observer, simplePlainQueue, disposable, observableQueueDrain)) {
                    if (z) {
                        i = observableQueueDrain.mo7034a(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                    observableQueueDrain.mo7035a(observer, poll);
                } else {
                    return;
                }
            }
        }
    }

    private static <T, U> boolean m26732a(boolean z, boolean z2, Observer<?> observer, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.mo7036c()) {
            simpleQueue.clear();
            disposable.mo5626a();
            return true;
        }
        if (z) {
            z = observableQueueDrain.mo7038g();
            if (z) {
                simpleQueue.clear();
                if (disposable != null) {
                    disposable.mo5626a();
                }
                observer.onError(z);
                return true;
            } else if (z2) {
                if (disposable != null) {
                    disposable.mo5626a();
                }
                observer.onComplete();
                return true;
            }
        }
        return false;
    }

    public static <T> SimpleQueue<T> m26725a(int i) {
        if (i < 0) {
            return new SpscLinkedArrayQueue(-i);
        }
        return new SpscArrayQueue(i);
    }

    public static void m26729a(Subscription subscription, int i) {
        subscription.request(i < 0 ? Long.MAX_VALUE : (long) i);
    }

    public static <T> boolean m26730a(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        AtomicLong atomicLong2;
        long j2;
        long j3 = j;
        do {
            j2 = atomicLong.get();
            atomicLong2 = atomicLong;
        } while (!atomicLong2.compareAndSet(j2, BackpressureHelper.m26669a(Long.MAX_VALUE & j2, j3) | (j2 & Long.MIN_VALUE)));
        if (j2 != Long.MIN_VALUE) {
            return false;
        }
        m26733b(j3 | Long.MIN_VALUE, subscriber, queue, atomicLong2, booleanSupplier);
        return true;
    }

    private static boolean m26731a(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.mo6617a();
        } catch (BooleanSupplier booleanSupplier2) {
            Exceptions.m26521b(booleanSupplier2);
            return true;
        }
    }

    private static <T> boolean m26733b(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (m26731a(booleanSupplier)) {
                    return true;
                }
                Object poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j2++;
            } else if (m26731a(booleanSupplier) != null) {
                return true;
            } else {
                if (queue.isEmpty() != null) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    j2 = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & j2) == 0) {
                        return 0;
                    }
                    j = j2;
                    j2 &= Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void m26728a(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        if (queue.isEmpty()) {
            subscriber.onComplete();
        } else if (!m26733b(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            AtomicLong atomicLong2;
            long j;
            long j2;
            do {
                j = atomicLong.get();
                if ((j & Long.MIN_VALUE) == 0) {
                    j2 = j | Long.MIN_VALUE;
                    atomicLong2 = atomicLong;
                } else {
                    return;
                }
            } while (!atomicLong2.compareAndSet(j, j2));
            if (j != 0) {
                m26733b(j2, subscriber, queue, atomicLong2, booleanSupplier);
            }
        }
    }
}
