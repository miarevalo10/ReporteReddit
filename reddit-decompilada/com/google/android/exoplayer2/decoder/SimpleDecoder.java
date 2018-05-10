package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    protected final I[] f12805a;
    protected int f12806b;
    private final Thread f12807c;
    private final Object f12808d = new Object();
    private final LinkedList<I> f12809e = new LinkedList();
    private final LinkedList<O> f12810f = new LinkedList();
    private final O[] f12811g;
    private int f12812h;
    private I f12813i;
    private E f12814j;
    private boolean f12815k;
    private boolean f12816l;
    private int f12817m;

    class C03891 extends Thread {
        final /* synthetic */ SimpleDecoder f4240a;

        C03891(SimpleDecoder simpleDecoder) {
            this.f4240a = simpleDecoder;
        }

        public void run() {
            SimpleDecoder.m11977a(this.f4240a);
        }
    }

    public abstract E mo3377a(I i, O o, boolean z);

    public abstract I mo3380e();

    public abstract O mo3381f();

    public final /* synthetic */ Object mo1322a() throws Exception {
        return m11979g();
    }

    public final /* synthetic */ void mo1323a(Object obj) throws Exception {
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) obj;
        synchronized (this.f12808d) {
            m11981i();
            Assertions.m4184a(decoderInputBuffer == this.f12813i);
            this.f12809e.addLast(decoderInputBuffer);
            m11982j();
            this.f12813i = null;
        }
    }

    public final /* synthetic */ Object mo1324b() throws Exception {
        return m11980h();
    }

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.f12805a = iArr;
        this.f12806b = 2;
        int i = 0;
        for (int i2 = 0; i2 < this.f12806b; i2++) {
            this.f12805a[i2] = mo3380e();
        }
        this.f12811g = oArr;
        this.f12812h = 2;
        while (i < this.f12812h) {
            this.f12811g[i] = mo3381f();
            i++;
        }
        this.f12807c = new C03891(this);
        this.f12807c.start();
    }

    private I m11979g() throws Exception {
        I i;
        synchronized (this.f12808d) {
            DecoderInputBuffer decoderInputBuffer;
            m11981i();
            Assertions.m4186b(this.f12813i == null);
            if (this.f12806b == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.f12805a;
                int i2 = this.f12806b - 1;
                this.f12806b = i2;
                decoderInputBuffer = decoderInputBufferArr[i2];
            }
            this.f12813i = decoderInputBuffer;
            i = this.f12813i;
        }
        return i;
    }

    private O m11980h() throws Exception {
        synchronized (this.f12808d) {
            m11981i();
            if (this.f12810f.isEmpty()) {
                return null;
            }
            OutputBuffer outputBuffer = (OutputBuffer) this.f12810f.removeFirst();
            return outputBuffer;
        }
    }

    public void mo3379a(O o) {
        synchronized (this.f12808d) {
            m11978b(o);
            m11982j();
        }
    }

    public final void mo1325c() {
        synchronized (this.f12808d) {
            this.f12815k = true;
            this.f12817m = 0;
            if (this.f12813i != null) {
                m11976a(this.f12813i);
                this.f12813i = null;
            }
            while (!this.f12809e.isEmpty()) {
                m11976a((DecoderInputBuffer) this.f12809e.removeFirst());
            }
            while (!this.f12810f.isEmpty()) {
                m11978b((OutputBuffer) this.f12810f.removeFirst());
            }
        }
    }

    public final void mo1326d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.f12808d;
        monitor-enter(r0);
        r1 = 1;
        r2.f12816l = r1;	 Catch:{ all -> 0x001a }
        r1 = r2.f12808d;	 Catch:{ all -> 0x001a }
        r1.notify();	 Catch:{ all -> 0x001a }
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        r0 = r2.f12807c;	 Catch:{ InterruptedException -> 0x0012 }
        r0.join();	 Catch:{ InterruptedException -> 0x0012 }
        return;
    L_0x0012:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        return;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.decoder.SimpleDecoder.d():void");
    }

    private void m11981i() throws Exception {
        if (this.f12814j != null) {
            throw this.f12814j;
        }
    }

    private void m11982j() {
        if (m11984l()) {
            this.f12808d.notify();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m11983k() throws java.lang.InterruptedException {
        /*
        r6 = this;
        r0 = r6.f12808d;
        monitor-enter(r0);
    L_0x0003:
        r1 = r6.f12816l;	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0013;
    L_0x0007:
        r1 = r6.m11984l();	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0013;
    L_0x000d:
        r1 = r6.f12808d;	 Catch:{ all -> 0x0086 }
        r1.wait();	 Catch:{ all -> 0x0086 }
        goto L_0x0003;
    L_0x0013:
        r1 = r6.f12816l;	 Catch:{ all -> 0x0086 }
        r2 = 0;
        if (r1 == 0) goto L_0x001a;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        return r2;
    L_0x001a:
        r1 = r6.f12809e;	 Catch:{ all -> 0x0086 }
        r1 = r1.removeFirst();	 Catch:{ all -> 0x0086 }
        r1 = (com.google.android.exoplayer2.decoder.DecoderInputBuffer) r1;	 Catch:{ all -> 0x0086 }
        r3 = r6.f12811g;	 Catch:{ all -> 0x0086 }
        r4 = r6.f12812h;	 Catch:{ all -> 0x0086 }
        r5 = 1;
        r4 = r4 - r5;
        r6.f12812h = r4;	 Catch:{ all -> 0x0086 }
        r3 = r3[r4];	 Catch:{ all -> 0x0086 }
        r4 = r6.f12815k;	 Catch:{ all -> 0x0086 }
        r6.f12815k = r2;	 Catch:{ all -> 0x0086 }
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        r0 = r1.m3715c();
        if (r0 == 0) goto L_0x003c;
    L_0x0037:
        r0 = 4;
        r3.m3713a(r0);
        goto L_0x0059;
    L_0x003c:
        r0 = r1.c_();
        if (r0 == 0) goto L_0x0047;
    L_0x0042:
        r0 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3.m3713a(r0);
    L_0x0047:
        r0 = r6.mo3377a(r1, r3, r4);
        r6.f12814j = r0;
        r0 = r6.f12814j;
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        r0 = r6.f12808d;
        monitor-enter(r0);
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        return r2;
    L_0x0056:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        throw r1;
    L_0x0059:
        r4 = r6.f12808d;
        monitor-enter(r4);
        r0 = r6.f12815k;	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0064;
    L_0x0060:
        r6.m11978b(r3);	 Catch:{ all -> 0x0083 }
        goto L_0x007e;
    L_0x0064:
        r0 = r3.c_();	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0073;
    L_0x006a:
        r0 = r6.f12817m;	 Catch:{ all -> 0x0083 }
        r0 = r0 + r5;
        r6.f12817m = r0;	 Catch:{ all -> 0x0083 }
        r6.m11978b(r3);	 Catch:{ all -> 0x0083 }
        goto L_0x007e;
    L_0x0073:
        r0 = r6.f12817m;	 Catch:{ all -> 0x0083 }
        r3.f12804c = r0;	 Catch:{ all -> 0x0083 }
        r6.f12817m = r2;	 Catch:{ all -> 0x0083 }
        r0 = r6.f12810f;	 Catch:{ all -> 0x0083 }
        r0.addLast(r3);	 Catch:{ all -> 0x0083 }
    L_0x007e:
        r6.m11976a(r1);	 Catch:{ all -> 0x0083 }
        monitor-exit(r4);	 Catch:{ all -> 0x0083 }
        return r5;
    L_0x0083:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0083 }
        throw r0;
    L_0x0086:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.decoder.SimpleDecoder.k():boolean");
    }

    private boolean m11984l() {
        return !this.f12809e.isEmpty() && this.f12812h > 0;
    }

    private void m11976a(I i) {
        i.mo1321a();
        DecoderInputBuffer[] decoderInputBufferArr = this.f12805a;
        int i2 = this.f12806b;
        this.f12806b = i2 + 1;
        decoderInputBufferArr[i2] = i;
    }

    private void m11978b(O o) {
        o.mo1321a();
        OutputBuffer[] outputBufferArr = this.f12811g;
        int i = this.f12812h;
        this.f12812h = i + 1;
        outputBufferArr[i] = o;
    }

    static /* synthetic */ void m11977a(SimpleDecoder simpleDecoder) {
        do {
            try {
            } catch (SimpleDecoder simpleDecoder2) {
                throw new IllegalStateException(simpleDecoder2);
            }
        } while (simpleDecoder2.m11983k());
    }
}
