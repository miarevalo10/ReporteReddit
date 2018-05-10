package com.reddit.frontpage.debug;

import com.crashlytics.android.Crashlytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/debug/RedditLogger;", "", "()V", "breadcrumb", "", "message", "", "e", "lazyMessage", "Lkotlin/Function0;", "throwable", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditLogger.kt */
public final class RedditLogger {
    public static final RedditLogger f20144a = new RedditLogger();

    private RedditLogger() {
    }

    public static final void m21982a(String str) {
        Intrinsics.m26847b(str, "message");
        Crashlytics.log(str);
        Timber.b(str, new Object[0]);
    }

    public static final void m21983a(Throwable th, String str) {
        Intrinsics.m26847b(th, "throwable");
        Intrinsics.m26847b(str, "message");
        Crashlytics.logException(th);
        Timber.c(th, str, new Object[0]);
    }

    public static final void m21984a(kotlin.jvm.functions.Function0<java.lang.String> r2) {
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
        r0 = "lazyMessage";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r0);
        r0 = 0;
        r2 = r2.invoke();	 Catch:{ Exception -> 0x0019 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0019 }
        r1 = new java.lang.RuntimeException;
        r1.<init>(r2);
        r1 = (java.lang.Throwable) r1;
        r0 = new java.lang.Object[r0];
        timber.log.Timber.c(r1, r2, r0);
        return;
    L_0x0019:
        r2 = "Unable to evaluate logging message.";
        r0 = new java.lang.Object[r0];
        timber.log.Timber.e(r2, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.debug.RedditLogger.a(kotlin.jvm.functions.Function0):void");
    }
}
