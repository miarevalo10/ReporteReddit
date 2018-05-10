package android.support.v4.provider;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.concurrent.Callable;

public class SelfDestructiveThread {
    private final Object f1357a = new Object();
    private HandlerThread f1358b;
    private Handler f1359c;
    private int f1360d;
    private Callback f1361e = new C01201(this);
    private final int f1362f;
    private final int f1363g;
    private final String f1364h;

    class C01201 implements Callback {
        final /* synthetic */ SelfDestructiveThread f1344a;

        C01201(SelfDestructiveThread selfDestructiveThread) {
            this.f1344a = selfDestructiveThread;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SelfDestructiveThread.m987a(this.f1344a);
                    return true;
                case 1:
                    SelfDestructiveThread.m988a(this.f1344a, (Runnable) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    }

    class C01222 implements Runnable {
        final /* synthetic */ Callable f1347a;
        final /* synthetic */ Handler f1348b;
        final /* synthetic */ ReplyCallback f1349c;
        final /* synthetic */ SelfDestructiveThread f1350d;

        C01222(SelfDestructiveThread selfDestructiveThread, Callable callable, Handler handler, ReplyCallback replyCallback) {
            this.f1350d = selfDestructiveThread;
            this.f1347a = callable;
            this.f1348b = handler;
            this.f1349c = replyCallback;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f1347a;	 Catch:{ Exception -> 0x0007 }
            r0 = r0.call();	 Catch:{ Exception -> 0x0007 }
            goto L_0x0008;
        L_0x0007:
            r0 = 0;
        L_0x0008:
            r1 = r3.f1348b;
            r2 = new android.support.v4.provider.SelfDestructiveThread$2$1;
            r2.<init>(r3, r0);
            r1.post(r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.SelfDestructiveThread.2.run():void");
        }
    }

    public interface ReplyCallback<T> {
        void mo350a(T t);
    }

    public SelfDestructiveThread(String str) {
        this.f1364h = str;
        this.f1363g = 10;
        this.f1362f = AbstractSpiCall.DEFAULT_TIMEOUT;
        this.f1360d = null;
    }

    final void m990a(Runnable runnable) {
        synchronized (this.f1357a) {
            if (this.f1358b == null) {
                this.f1358b = new HandlerThread(this.f1364h, this.f1363g);
                this.f1358b.start();
                this.f1359c = new Handler(this.f1358b.getLooper(), this.f1361e);
                this.f1360d++;
            }
            this.f1359c.removeMessages(0);
            this.f1359c.sendMessage(this.f1359c.obtainMessage(1, runnable));
        }
    }

    public final <T> T m989a(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r12 = this;
        r7 = new java.util.concurrent.locks.ReentrantLock;
        r7.<init>();
        r8 = r7.newCondition();
        r9 = new java.util.concurrent.atomic.AtomicReference;
        r9.<init>();
        r10 = new java.util.concurrent.atomic.AtomicBoolean;
        r0 = 1;
        r10.<init>(r0);
        r11 = new android.support.v4.provider.SelfDestructiveThread$3;
        r0 = r11;
        r1 = r12;
        r2 = r9;
        r3 = r13;
        r4 = r7;
        r5 = r10;
        r6 = r8;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r12.m990a(r11);
        r7.lock();
        r13 = r10.get();	 Catch:{ all -> 0x005c }
        if (r13 != 0) goto L_0x0034;	 Catch:{ all -> 0x005c }
    L_0x002c:
        r13 = r9.get();	 Catch:{ all -> 0x005c }
        r7.unlock();
        return r13;
    L_0x0034:
        r13 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x005c }
        r0 = (long) r14;	 Catch:{ all -> 0x005c }
        r13 = r13.toNanos(r0);	 Catch:{ all -> 0x005c }
    L_0x003b:
        r0 = r8.awaitNanos(r13);	 Catch:{ InterruptedException -> 0x0040 }
        r13 = r0;
    L_0x0040:
        r0 = r10.get();	 Catch:{ all -> 0x005c }
        if (r0 != 0) goto L_0x004e;	 Catch:{ all -> 0x005c }
    L_0x0046:
        r13 = r9.get();	 Catch:{ all -> 0x005c }
        r7.unlock();
        return r13;
    L_0x004e:
        r0 = 0;
        r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x003b;
    L_0x0054:
        r13 = new java.lang.InterruptedException;	 Catch:{ all -> 0x005c }
        r14 = "timeout";	 Catch:{ all -> 0x005c }
        r13.<init>(r14);	 Catch:{ all -> 0x005c }
        throw r13;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r13 = move-exception;
        r7.unlock();
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.SelfDestructiveThread.a(java.util.concurrent.Callable, int):T");
    }

    static /* synthetic */ void m988a(SelfDestructiveThread selfDestructiveThread, Runnable runnable) {
        runnable.run();
        synchronized (selfDestructiveThread.f1357a) {
            selfDestructiveThread.f1359c.removeMessages(0);
            selfDestructiveThread.f1359c.sendMessageDelayed(selfDestructiveThread.f1359c.obtainMessage(0), (long) selfDestructiveThread.f1362f);
        }
    }

    static /* synthetic */ void m987a(SelfDestructiveThread selfDestructiveThread) {
        synchronized (selfDestructiveThread.f1357a) {
            if (selfDestructiveThread.f1359c.hasMessages(1)) {
                return;
            }
            selfDestructiveThread.f1358b.quit();
            selfDestructiveThread.f1358b = null;
            selfDestructiveThread.f1359c = null;
        }
    }
}
