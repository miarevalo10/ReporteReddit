package io.fabric.sdk.android.services.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {
    public static ExecutorService m26320a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(m26323c(str));
        m26321a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService m26322b(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(m26323c(str));
        m26321a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    private static ThreadFactory m26323c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public final Thread newThread(final Runnable runnable) {
                runnable = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable(this) {
                    final /* synthetic */ C21151 f30995b;

                    public void onRun() {
                        runnable.run();
                    }
                });
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(atomicLong.getAndIncrement());
                runnable.setName(stringBuilder.toString());
                return runnable;
            }
        };
    }

    private static final void m26321a(final String str, final ExecutorService executorService) {
        final TimeUnit timeUnit = TimeUnit.SECONDS;
        Runtime runtime = Runtime.getRuntime();
        Runnable c25412 = new BackgroundPriorityRunnable() {
            final /* synthetic */ long f30998c = 2;

            public final void onRun() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r7 = this;
                r0 = io.fabric.sdk.android.Fabric.m26243b();	 Catch:{ InterruptedException -> 0x004c }
                r1 = "Fabric";	 Catch:{ InterruptedException -> 0x004c }
                r2 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x004c }
                r3 = "Executing shutdown hook for ";	 Catch:{ InterruptedException -> 0x004c }
                r2.<init>(r3);	 Catch:{ InterruptedException -> 0x004c }
                r3 = r4;	 Catch:{ InterruptedException -> 0x004c }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x004c }
                r2 = r2.toString();	 Catch:{ InterruptedException -> 0x004c }
                r0.mo5562a(r1, r2);	 Catch:{ InterruptedException -> 0x004c }
                r0 = r5;	 Catch:{ InterruptedException -> 0x004c }
                r0.shutdown();	 Catch:{ InterruptedException -> 0x004c }
                r0 = r5;	 Catch:{ InterruptedException -> 0x004c }
                r1 = r7.f30998c;	 Catch:{ InterruptedException -> 0x004c }
                r3 = r0;	 Catch:{ InterruptedException -> 0x004c }
                r0 = r0.awaitTermination(r1, r3);	 Catch:{ InterruptedException -> 0x004c }
                if (r0 != 0) goto L_0x004b;	 Catch:{ InterruptedException -> 0x004c }
            L_0x002a:
                r0 = io.fabric.sdk.android.Fabric.m26243b();	 Catch:{ InterruptedException -> 0x004c }
                r1 = "Fabric";	 Catch:{ InterruptedException -> 0x004c }
                r2 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x004c }
                r2.<init>();	 Catch:{ InterruptedException -> 0x004c }
                r3 = r4;	 Catch:{ InterruptedException -> 0x004c }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x004c }
                r3 = " did not shut down in the allocated time. Requesting immediate shutdown.";	 Catch:{ InterruptedException -> 0x004c }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x004c }
                r2 = r2.toString();	 Catch:{ InterruptedException -> 0x004c }
                r0.mo5562a(r1, r2);	 Catch:{ InterruptedException -> 0x004c }
                r0 = r5;	 Catch:{ InterruptedException -> 0x004c }
                r0.shutdownNow();	 Catch:{ InterruptedException -> 0x004c }
            L_0x004b:
                return;
            L_0x004c:
                r0 = io.fabric.sdk.android.Fabric.m26243b();
                r1 = "Fabric";
                r2 = java.util.Locale.US;
                r3 = "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r6 = r4;
                r4[r5] = r6;
                r2 = java.lang.String.format(r2, r3, r4);
                r0.mo5562a(r1, r2);
                r0 = r5;
                r0.shutdownNow();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.ExecutorUtils.2.onRun():void");
            }
        };
        executorService = new StringBuilder("Crashlytics Shutdown Hook for ");
        executorService.append(str);
        runtime.addShutdownHook(new Thread(c25412, executorService.toString()));
    }
}
