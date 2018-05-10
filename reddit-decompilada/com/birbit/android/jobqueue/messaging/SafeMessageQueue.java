package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.log.JqLog;
import com.birbit.android.jobqueue.timer.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeMessageQueue extends UnsafeMessageQueue implements MessageQueue {
    public final Object f12177a = new Object();
    public final Timer f12178b;
    public final DelayedMessageBag f12179c;
    public boolean f12180d = false;
    private final AtomicBoolean f12181i = new AtomicBoolean(false);
    private final MessageFactory f12182j;

    public SafeMessageQueue(Timer timer, MessageFactory messageFactory, String str) {
        super(messageFactory, str);
        this.f12182j = messageFactory;
        this.f12178b = timer;
        this.f12179c = new DelayedMessageBag(messageFactory);
    }

    public final void m11064a(MessageQueueConsumer messageQueueConsumer) {
        if (this.f12181i.getAndSet(true)) {
            throw new IllegalStateException("only 1 consumer per MQ");
        }
        while (this.f12181i.get()) {
            Message b = m11061b(messageQueueConsumer);
            if (b != null) {
                messageQueueConsumer.mo800a(b);
                this.f12182j.m2567a(b);
            }
        }
        JqLog.m2558a("[%s] finished queue", this.g);
    }

    public final void m11062a() {
        this.f12181i.set(false);
        synchronized (this.f12177a) {
            this.f12178b.mo832b(this.f12177a);
        }
    }

    public final void mo822b() {
        synchronized (this.f12177a) {
            super.mo822b();
        }
    }

    private com.birbit.android.jobqueue.messaging.Message m11061b(com.birbit.android.jobqueue.messaging.MessageQueueConsumer r10) {
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
        r9 = this;
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r2 = r9.f12181i;
        r2 = r2.get();
        if (r2 == 0) goto L_0x008a;
    L_0x000a:
        r2 = r9.f12177a;
        monitor-enter(r2);
        r3 = r9.f12178b;	 Catch:{ all -> 0x0087 }
        r3 = r3.mo829a();	 Catch:{ all -> 0x0087 }
        r5 = r9.f12179c;	 Catch:{ all -> 0x0087 }
        r5 = r5.m2563a(r3, r9);	 Catch:{ all -> 0x0087 }
        r6 = super.m2574c();	 Catch:{ all -> 0x0087 }
        if (r6 == 0) goto L_0x0021;	 Catch:{ all -> 0x0087 }
    L_0x001f:
        monitor-exit(r2);	 Catch:{ all -> 0x0087 }
        return r6;	 Catch:{ all -> 0x0087 }
    L_0x0021:
        r9.f12180d = r0;	 Catch:{ all -> 0x0087 }
        monitor-exit(r2);	 Catch:{ all -> 0x0087 }
        r2 = 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r10.mo799a();
        r1 = r2;
    L_0x002b:
        r6 = r9.f12177a;
        monitor-enter(r6);
        r7 = r9.f12180d;	 Catch:{ all -> 0x0084 }
        if (r7 == 0) goto L_0x0034;	 Catch:{ all -> 0x0084 }
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0084 }
        goto L_0x0002;	 Catch:{ all -> 0x0084 }
    L_0x0034:
        if (r5 == 0) goto L_0x004b;	 Catch:{ all -> 0x0084 }
    L_0x0036:
        r7 = r5.longValue();	 Catch:{ all -> 0x0084 }
        r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));	 Catch:{ all -> 0x0084 }
        if (r3 > 0) goto L_0x004b;	 Catch:{ all -> 0x0084 }
    L_0x003e:
        r3 = "[%s] next message is ready, requery";	 Catch:{ all -> 0x0084 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0084 }
        r4 = r9.g;	 Catch:{ all -> 0x0084 }
        r2[r0] = r4;	 Catch:{ all -> 0x0084 }
        com.birbit.android.jobqueue.log.JqLog.m2558a(r3, r2);	 Catch:{ all -> 0x0084 }
        monitor-exit(r6);	 Catch:{ all -> 0x0084 }
        goto L_0x0002;	 Catch:{ all -> 0x0084 }
    L_0x004b:
        r3 = r9.f12181i;	 Catch:{ all -> 0x0084 }
        r3 = r3.get();	 Catch:{ all -> 0x0084 }
        if (r3 == 0) goto L_0x0081;
    L_0x0053:
        if (r5 != 0) goto L_0x0068;
    L_0x0055:
        r3 = "[%s] will wait on the lock forever";	 Catch:{ InterruptedException -> 0x0081 }
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0081 }
        r4 = r9.g;	 Catch:{ InterruptedException -> 0x0081 }
        r2[r0] = r4;	 Catch:{ InterruptedException -> 0x0081 }
        com.birbit.android.jobqueue.log.JqLog.m2558a(r3, r2);	 Catch:{ InterruptedException -> 0x0081 }
        r2 = r9.f12178b;	 Catch:{ InterruptedException -> 0x0081 }
        r3 = r9.f12177a;	 Catch:{ InterruptedException -> 0x0081 }
        r2.mo830a(r3);	 Catch:{ InterruptedException -> 0x0081 }
        goto L_0x0081;	 Catch:{ InterruptedException -> 0x0081 }
    L_0x0068:
        r3 = "[%s] will wait on the lock until %d";	 Catch:{ InterruptedException -> 0x0081 }
        r4 = 2;	 Catch:{ InterruptedException -> 0x0081 }
        r4 = new java.lang.Object[r4];	 Catch:{ InterruptedException -> 0x0081 }
        r7 = r9.g;	 Catch:{ InterruptedException -> 0x0081 }
        r4[r0] = r7;	 Catch:{ InterruptedException -> 0x0081 }
        r4[r2] = r5;	 Catch:{ InterruptedException -> 0x0081 }
        com.birbit.android.jobqueue.log.JqLog.m2558a(r3, r4);	 Catch:{ InterruptedException -> 0x0081 }
        r2 = r9.f12178b;	 Catch:{ InterruptedException -> 0x0081 }
        r3 = r9.f12177a;	 Catch:{ InterruptedException -> 0x0081 }
        r4 = r5.longValue();	 Catch:{ InterruptedException -> 0x0081 }
        r2.mo831a(r3, r4);	 Catch:{ InterruptedException -> 0x0081 }
    L_0x0081:
        monitor-exit(r6);	 Catch:{ all -> 0x0084 }
        goto L_0x0002;	 Catch:{ all -> 0x0084 }
    L_0x0084:
        r10 = move-exception;	 Catch:{ all -> 0x0084 }
        monitor-exit(r6);	 Catch:{ all -> 0x0084 }
        throw r10;
    L_0x0087:
        r10 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0087 }
        throw r10;
    L_0x008a:
        r10 = 0;
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.messaging.SafeMessageQueue.b(com.birbit.android.jobqueue.messaging.MessageQueueConsumer):com.birbit.android.jobqueue.messaging.Message");
    }

    public final void mo821a(Message message) {
        synchronized (this.f12177a) {
            this.f12180d = true;
            super.mo821a(message);
            this.f12178b.mo832b(this.f12177a);
        }
    }
}
