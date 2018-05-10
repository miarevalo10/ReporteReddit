package rx.internal.producers;

import rx.Producer;

public final class ProducerArbiter implements Producer {
    static final Producer f41719g = new C31191();
    long f41720a;
    Producer f41721b;
    boolean f41722c;
    long f41723d;
    long f41724e;
    Producer f41725f;

    static class C31191 implements Producer {
        public final void mo7901a(long j) {
        }

        C31191() {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo7901a(long r5) {
        /*
        r4 = this;
        r0 = 0;
        r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x000e;
    L_0x0006:
        r5 = new java.lang.IllegalArgumentException;
        r6 = "n >= 0 required";
        r5.<init>(r6);
        throw r5;
    L_0x000e:
        if (r2 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        monitor-enter(r4);
        r2 = r4.f41722c;	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x001d;
    L_0x0016:
        r0 = r4.f41723d;	 Catch:{ all -> 0x0044 }
        r0 = r0 + r5;
        r4.f41723d = r0;	 Catch:{ all -> 0x0044 }
        monitor-exit(r4);	 Catch:{ all -> 0x0044 }
        return;
    L_0x001d:
        r2 = 1;
        r4.f41722c = r2;	 Catch:{ all -> 0x0044 }
        monitor-exit(r4);	 Catch:{ all -> 0x0044 }
        r2 = r4.f41720a;	 Catch:{ all -> 0x003a }
        r2 = r2 + r5;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x002d;
    L_0x0028:
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
    L_0x002d:
        r4.f41720a = r2;	 Catch:{ all -> 0x003a }
        r0 = r4.f41721b;	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x0033:
        r0.mo7901a(r5);	 Catch:{ all -> 0x003a }
    L_0x0036:
        r4.m43842a();	 Catch:{ all -> 0x003a }
        return;
    L_0x003a:
        r5 = move-exception;
        monitor-enter(r4);
        r6 = 0;
        r4.f41722c = r6;	 Catch:{ all -> 0x0041 }
        monitor-exit(r4);	 Catch:{ all -> 0x0041 }
        throw r5;
    L_0x0041:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0041 }
        throw r5;
    L_0x0044:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0044 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.a(long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m43845b(long r7) {
        /*
        r6 = this;
        r0 = 0;
        r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x000e;
    L_0x0006:
        r7 = new java.lang.IllegalArgumentException;
        r8 = "n > 0 required";
        r7.<init>(r8);
        throw r7;
    L_0x000e:
        monitor-enter(r6);
        r2 = r6.f41722c;	 Catch:{ all -> 0x0046 }
        if (r2 == 0) goto L_0x001a;
    L_0x0013:
        r0 = r6.f41724e;	 Catch:{ all -> 0x0046 }
        r0 = r0 + r7;
        r6.f41724e = r0;	 Catch:{ all -> 0x0046 }
        monitor-exit(r6);	 Catch:{ all -> 0x0046 }
        return;
    L_0x001a:
        r2 = 1;
        r6.f41722c = r2;	 Catch:{ all -> 0x0046 }
        monitor-exit(r6);	 Catch:{ all -> 0x0046 }
        r2 = r6.f41720a;	 Catch:{ all -> 0x003c }
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0038;
    L_0x0029:
        r2 = r2 - r7;
        r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r7 >= 0) goto L_0x0036;
    L_0x002e:
        r7 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x003c }
        r8 = "more items arrived than were requested";
        r7.<init>(r8);	 Catch:{ all -> 0x003c }
        throw r7;	 Catch:{ all -> 0x003c }
    L_0x0036:
        r6.f41720a = r2;	 Catch:{ all -> 0x003c }
    L_0x0038:
        r6.m43842a();	 Catch:{ all -> 0x003c }
        return;
    L_0x003c:
        r7 = move-exception;
        monitor-enter(r6);
        r8 = 0;
        r6.f41722c = r8;	 Catch:{ all -> 0x0043 }
        monitor-exit(r6);	 Catch:{ all -> 0x0043 }
        throw r7;
    L_0x0043:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0043 }
        throw r7;
    L_0x0046:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0046 }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.b(long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m43844a(rx.Producer r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f41722c;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x000d;
    L_0x0005:
        if (r3 != 0) goto L_0x0009;
    L_0x0007:
        r3 = f41719g;	 Catch:{ all -> 0x0028 }
    L_0x0009:
        r2.f41725f = r3;	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        return;
    L_0x000d:
        r0 = 1;
        r2.f41722c = r0;	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        r2.f41721b = r3;	 Catch:{ all -> 0x001e }
        if (r3 == 0) goto L_0x001a;
    L_0x0015:
        r0 = r2.f41720a;	 Catch:{ all -> 0x001e }
        r3.mo7901a(r0);	 Catch:{ all -> 0x001e }
    L_0x001a:
        r2.m43842a();	 Catch:{ all -> 0x001e }
        return;
    L_0x001e:
        r3 = move-exception;
        monitor-enter(r2);
        r0 = 0;
        r2.f41722c = r0;	 Catch:{ all -> 0x0025 }
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        throw r3;
    L_0x0025:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        throw r3;
    L_0x0028:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.a(rx.Producer):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m43842a() {
        /*
        r14 = this;
    L_0x0000:
        monitor-enter(r14);
        r0 = r14.f41723d;	 Catch:{ all -> 0x0061 }
        r2 = r14.f41724e;	 Catch:{ all -> 0x0061 }
        r4 = r14.f41725f;	 Catch:{ all -> 0x0061 }
        r5 = 0;
        r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r7 != 0) goto L_0x0018;
    L_0x000d:
        r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r8 != 0) goto L_0x0018;
    L_0x0011:
        if (r4 != 0) goto L_0x0018;
    L_0x0013:
        r0 = 0;
        r14.f41722c = r0;	 Catch:{ all -> 0x0061 }
        monitor-exit(r14);	 Catch:{ all -> 0x0061 }
        return;
    L_0x0018:
        r14.f41723d = r5;	 Catch:{ all -> 0x0061 }
        r14.f41724e = r5;	 Catch:{ all -> 0x0061 }
        r8 = 0;
        r14.f41725f = r8;	 Catch:{ all -> 0x0061 }
        monitor-exit(r14);	 Catch:{ all -> 0x0061 }
        r9 = r14.f41720a;
        r11 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 == 0) goto L_0x0048;
    L_0x002b:
        r9 = r9 + r0;
        r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r13 < 0) goto L_0x0045;
    L_0x0030:
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 != 0) goto L_0x0035;
    L_0x0034:
        goto L_0x0045;
    L_0x0035:
        r9 = r9 - r2;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0042;
    L_0x003a:
        r0 = new java.lang.IllegalStateException;
        r1 = "more produced than requested";
        r0.<init>(r1);
        throw r0;
    L_0x0042:
        r14.f41720a = r9;
        goto L_0x0048;
    L_0x0045:
        r14.f41720a = r11;
        r9 = r11;
    L_0x0048:
        if (r4 == 0) goto L_0x0057;
    L_0x004a:
        r0 = f41719g;
        if (r4 != r0) goto L_0x0051;
    L_0x004e:
        r14.f41721b = r8;
        goto L_0x0000;
    L_0x0051:
        r14.f41721b = r4;
        r4.mo7901a(r9);
        goto L_0x0000;
    L_0x0057:
        r2 = r14.f41721b;
        if (r2 == 0) goto L_0x0000;
    L_0x005b:
        if (r7 == 0) goto L_0x0000;
    L_0x005d:
        r2.mo7901a(r0);
        goto L_0x0000;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0061 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.a():void");
    }
}
