package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.timer.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class PriorityMessageQueue implements MessageQueue {
    public final Object f12170a = new Object();
    public final UnsafeMessageQueue[] f12171b;
    public final DelayedMessageBag f12172c;
    public final Timer f12173d;
    public final AtomicBoolean f12174e = new AtomicBoolean(false);
    public boolean f12175f = false;
    public final MessageFactory f12176g;

    public PriorityMessageQueue(Timer timer, MessageFactory messageFactory) {
        this.f12172c = new DelayedMessageBag(messageFactory);
        this.f12176g = messageFactory;
        this.f12171b = new UnsafeMessageQueue[(Type.f3002o + 1)];
        this.f12173d = timer;
    }

    public final com.birbit.android.jobqueue.messaging.Message m11059a(com.birbit.android.jobqueue.messaging.MessageQueueConsumer r12) {
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
        r11 = this;
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r2 = r11.f12174e;
        r2 = r2.get();
        if (r2 == 0) goto L_0x00a5;
    L_0x000a:
        r2 = r11.f12170a;
        monitor-enter(r2);
        r3 = r11.f12173d;	 Catch:{ all -> 0x00a2 }
        r3 = r3.mo829a();	 Catch:{ all -> 0x00a2 }
        r5 = "[%s] looking for next message at time %s";	 Catch:{ all -> 0x00a2 }
        r6 = 2;	 Catch:{ all -> 0x00a2 }
        r7 = new java.lang.Object[r6];	 Catch:{ all -> 0x00a2 }
        r8 = "priority_mq";	 Catch:{ all -> 0x00a2 }
        r7[r0] = r8;	 Catch:{ all -> 0x00a2 }
        r8 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x00a2 }
        r9 = 1;	 Catch:{ all -> 0x00a2 }
        r7[r9] = r8;	 Catch:{ all -> 0x00a2 }
        com.birbit.android.jobqueue.log.JqLog.m2558a(r5, r7);	 Catch:{ all -> 0x00a2 }
        r5 = r11.f12172c;	 Catch:{ all -> 0x00a2 }
        r5 = r5.m2563a(r3, r11);	 Catch:{ all -> 0x00a2 }
        r7 = "[%s] next delayed job %s";	 Catch:{ all -> 0x00a2 }
        r8 = new java.lang.Object[r6];	 Catch:{ all -> 0x00a2 }
        r10 = "priority_mq";	 Catch:{ all -> 0x00a2 }
        r8[r0] = r10;	 Catch:{ all -> 0x00a2 }
        r8[r9] = r5;	 Catch:{ all -> 0x00a2 }
        com.birbit.android.jobqueue.log.JqLog.m2558a(r7, r8);	 Catch:{ all -> 0x00a2 }
        r7 = com.birbit.android.jobqueue.messaging.Type.f3002o;	 Catch:{ all -> 0x00a2 }
    L_0x003b:
        if (r7 < 0) goto L_0x004e;	 Catch:{ all -> 0x00a2 }
    L_0x003d:
        r8 = r11.f12171b;	 Catch:{ all -> 0x00a2 }
        r8 = r8[r7];	 Catch:{ all -> 0x00a2 }
        if (r8 == 0) goto L_0x004b;	 Catch:{ all -> 0x00a2 }
    L_0x0043:
        r8 = r8.m2574c();	 Catch:{ all -> 0x00a2 }
        if (r8 == 0) goto L_0x004b;	 Catch:{ all -> 0x00a2 }
    L_0x0049:
        monitor-exit(r2);	 Catch:{ all -> 0x00a2 }
        return r8;	 Catch:{ all -> 0x00a2 }
    L_0x004b:
        r7 = r7 + -1;	 Catch:{ all -> 0x00a2 }
        goto L_0x003b;	 Catch:{ all -> 0x00a2 }
    L_0x004e:
        r11.f12175f = r0;	 Catch:{ all -> 0x00a2 }
        monitor-exit(r2);	 Catch:{ all -> 0x00a2 }
        if (r1 != 0) goto L_0x0057;
    L_0x0053:
        r12.mo799a();
        r1 = r9;
    L_0x0057:
        r7 = r11.f12170a;
        monitor-enter(r7);
        r2 = "[%s] did on idle post a message? %s";	 Catch:{ all -> 0x009f }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x009f }
        r8 = "priority_mq";	 Catch:{ all -> 0x009f }
        r6[r0] = r8;	 Catch:{ all -> 0x009f }
        r8 = r11.f12175f;	 Catch:{ all -> 0x009f }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ all -> 0x009f }
        r6[r9] = r8;	 Catch:{ all -> 0x009f }
        com.birbit.android.jobqueue.log.JqLog.m2558a(r2, r6);	 Catch:{ all -> 0x009f }
        r2 = r11.f12175f;	 Catch:{ all -> 0x009f }
        if (r2 == 0) goto L_0x0073;	 Catch:{ all -> 0x009f }
    L_0x0071:
        monitor-exit(r7);	 Catch:{ all -> 0x009f }
        goto L_0x0002;	 Catch:{ all -> 0x009f }
    L_0x0073:
        if (r5 == 0) goto L_0x007f;	 Catch:{ all -> 0x009f }
    L_0x0075:
        r8 = r5.longValue();	 Catch:{ all -> 0x009f }
        r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));	 Catch:{ all -> 0x009f }
        if (r2 > 0) goto L_0x007f;	 Catch:{ all -> 0x009f }
    L_0x007d:
        monitor-exit(r7);	 Catch:{ all -> 0x009f }
        goto L_0x0002;	 Catch:{ all -> 0x009f }
    L_0x007f:
        r2 = r11.f12174e;	 Catch:{ all -> 0x009f }
        r2 = r2.get();	 Catch:{ all -> 0x009f }
        if (r2 == 0) goto L_0x009c;
    L_0x0087:
        if (r5 != 0) goto L_0x0091;
    L_0x0089:
        r2 = r11.f12173d;	 Catch:{ InterruptedException -> 0x009c }
        r3 = r11.f12170a;	 Catch:{ InterruptedException -> 0x009c }
        r2.mo830a(r3);	 Catch:{ InterruptedException -> 0x009c }
        goto L_0x009c;	 Catch:{ InterruptedException -> 0x009c }
    L_0x0091:
        r2 = r11.f12173d;	 Catch:{ InterruptedException -> 0x009c }
        r3 = r11.f12170a;	 Catch:{ InterruptedException -> 0x009c }
        r4 = r5.longValue();	 Catch:{ InterruptedException -> 0x009c }
        r2.mo831a(r3, r4);	 Catch:{ InterruptedException -> 0x009c }
    L_0x009c:
        monitor-exit(r7);	 Catch:{ all -> 0x009f }
        goto L_0x0002;	 Catch:{ all -> 0x009f }
    L_0x009f:
        r12 = move-exception;	 Catch:{ all -> 0x009f }
        monitor-exit(r7);	 Catch:{ all -> 0x009f }
        throw r12;
    L_0x00a2:
        r12 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00a2 }
        throw r12;
    L_0x00a5:
        r12 = 0;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.messaging.PriorityMessageQueue.a(com.birbit.android.jobqueue.messaging.MessageQueueConsumer):com.birbit.android.jobqueue.messaging.Message");
    }

    public final void mo821a(Message message) {
        synchronized (this.f12170a) {
            this.f12175f = true;
            int i = message.f2985a.f3005n;
            if (this.f12171b[i] == null) {
                UnsafeMessageQueue[] unsafeMessageQueueArr = this.f12171b;
                MessageFactory messageFactory = this.f12176g;
                StringBuilder stringBuilder = new StringBuilder("queue_");
                stringBuilder.append(message.f2985a.name());
                unsafeMessageQueueArr[i] = new UnsafeMessageQueue(messageFactory, stringBuilder.toString());
            }
            this.f12171b[i].mo821a(message);
            this.f12173d.mo832b(this.f12170a);
        }
    }
}
