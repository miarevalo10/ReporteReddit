package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeRange implements OnSubscribe<Integer> {
    private final int f41904a = 1;
    private final int f41905b = 15;

    static final class RangeProducer extends AtomicLong implements Producer {
        private final Subscriber<? super Integer> f41680a;
        private final int f41681b;
        private long f41682c;

        RangeProducer(Subscriber<? super Integer> subscriber, int i, int i2) {
            this.f41680a = subscriber;
            this.f41682c = (long) i;
            this.f41681b = i2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo7901a(long r13) {
            /*
            r12 = this;
            r0 = r12.get();
            r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 != 0) goto L_0x000e;
        L_0x000d:
            return;
        L_0x000e:
            r0 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1));
            r4 = 1;
            r6 = 0;
            if (r0 != 0) goto L_0x0042;
        L_0x0016:
            r0 = r12.compareAndSet(r6, r2);
            if (r0 == 0) goto L_0x0042;
        L_0x001c:
            r13 = r12.f41681b;
            r13 = (long) r13;
            r13 = r13 + r4;
            r0 = r12.f41680a;
            r1 = r12.f41682c;
        L_0x0024:
            r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1));
            if (r3 == 0) goto L_0x0038;
        L_0x0028:
            r3 = r0.mo7894d();
            if (r3 != 0) goto L_0x0041;
        L_0x002e:
            r3 = (int) r1;
            r3 = java.lang.Integer.valueOf(r3);
            r0.a_(r3);
            r1 = r1 + r4;
            goto L_0x0024;
        L_0x0038:
            r13 = r0.mo7894d();
            if (r13 != 0) goto L_0x0041;
        L_0x003e:
            r0.mo7906b();
        L_0x0041:
            return;
        L_0x0042:
            r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1));
            if (r0 <= 0) goto L_0x0094;
        L_0x0046:
            r0 = rx.internal.operators.BackpressureUtils.m43445a(r12, r13);
            r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
            if (r0 != 0) goto L_0x0094;
        L_0x004e:
            r0 = r12.f41681b;
            r0 = (long) r0;
            r0 = r0 + r4;
            r2 = r12.f41682c;
            r8 = r12.f41680a;
            r9 = r2;
            r2 = r13;
        L_0x0058:
            r13 = r6;
        L_0x0059:
            r11 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1));
            if (r11 == 0) goto L_0x0072;
        L_0x005d:
            r11 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            if (r11 == 0) goto L_0x0072;
        L_0x0061:
            r11 = r8.mo7894d();
            if (r11 != 0) goto L_0x0094;
        L_0x0067:
            r11 = (int) r9;
            r11 = java.lang.Integer.valueOf(r11);
            r8.a_(r11);
            r9 = r9 + r4;
            r13 = r13 + r4;
            goto L_0x0059;
        L_0x0072:
            r2 = r8.mo7894d();
            if (r2 != 0) goto L_0x0094;
        L_0x0078:
            r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            if (r2 != 0) goto L_0x0080;
        L_0x007c:
            r8.mo7906b();
            return;
        L_0x0080:
            r2 = r12.get();
            r11 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1));
            if (r11 != 0) goto L_0x0059;
        L_0x0088:
            r12.f41682c = r9;
            r13 = -r13;
            r2 = r12.addAndGet(r13);
            r13 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
            if (r13 == 0) goto L_0x0094;
        L_0x0093:
            goto L_0x0058;
        L_0x0094:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeRange.RangeProducer.a(long):void");
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.mo7929a(new RangeProducer(subscriber, this.f41904a, this.f41905b));
    }
}
