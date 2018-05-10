package com.twitter.sdk.android.core.internal.scribe;

import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.scribe.ScribeEvent.Transform;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;

public class ScribeClient {
    final ConcurrentHashMap<Long, ScribeHandler> f23981a = new ConcurrentHashMap(2);
    private final Kit f23982b;
    private final ScheduledExecutorService f23983c;
    private final ScribeConfig f23984d;
    private final Transform f23985e;
    private final TwitterAuthConfig f23986f;
    private final SessionManager<? extends Session<TwitterAuthToken>> f23987g;
    private final GuestSessionProvider f23988h;
    private final SSLSocketFactory f23989i;
    private final IdManager f23990j;

    public ScribeClient(Kit kit, ScheduledExecutorService scheduledExecutorService, ScribeConfig scribeConfig, Transform transform, TwitterAuthConfig twitterAuthConfig, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, SSLSocketFactory sSLSocketFactory, IdManager idManager) {
        this.f23982b = kit;
        this.f23983c = scheduledExecutorService;
        this.f23984d = scribeConfig;
        this.f23985e = transform;
        this.f23986f = twitterAuthConfig;
        this.f23987g = sessionManager;
        this.f23988h = guestSessionProvider;
        this.f23989i = sSLSocketFactory;
        this.f23990j = idManager;
    }

    public final boolean m25879a(com.twitter.sdk.android.core.internal.scribe.ScribeEvent r28, long r29) {
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
        r27 = this;
        r0 = r27;
        r12 = r29;
        r1 = r0.f23981a;	 Catch:{ IOException -> 0x00f2 }
        r2 = java.lang.Long.valueOf(r29);	 Catch:{ IOException -> 0x00f2 }
        r1 = r1.containsKey(r2);	 Catch:{ IOException -> 0x00f2 }
        if (r1 != 0) goto L_0x00da;	 Catch:{ IOException -> 0x00f2 }
    L_0x0010:
        r14 = r0.f23981a;	 Catch:{ IOException -> 0x00f2 }
        r15 = java.lang.Long.valueOf(r29);	 Catch:{ IOException -> 0x00f2 }
        r1 = r0.f23982b;	 Catch:{ IOException -> 0x00f2 }
        r11 = r1.getContext();	 Catch:{ IOException -> 0x00f2 }
        r6 = new io.fabric.sdk.android.services.events.QueueFileEventStorage;	 Catch:{ IOException -> 0x00f2 }
        r1 = new io.fabric.sdk.android.services.persistence.FileStoreImpl;	 Catch:{ IOException -> 0x00f2 }
        r2 = r0.f23982b;	 Catch:{ IOException -> 0x00f2 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x00f2 }
        r1 = r1.mo5605a();	 Catch:{ IOException -> 0x00f2 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f2 }
        r2.<init>();	 Catch:{ IOException -> 0x00f2 }
        r2.append(r12);	 Catch:{ IOException -> 0x00f2 }
        r3 = "_se.tap";	 Catch:{ IOException -> 0x00f2 }
        r2.append(r3);	 Catch:{ IOException -> 0x00f2 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x00f2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f2 }
        r3.<init>();	 Catch:{ IOException -> 0x00f2 }
        r3.append(r12);	 Catch:{ IOException -> 0x00f2 }
        r4 = "_se_to_send";	 Catch:{ IOException -> 0x00f2 }
        r3.append(r4);	 Catch:{ IOException -> 0x00f2 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x00f2 }
        r6.<init>(r11, r1, r2, r3);	 Catch:{ IOException -> 0x00f2 }
        r10 = new com.twitter.sdk.android.core.internal.scribe.ScribeFilesManager;	 Catch:{ IOException -> 0x00f2 }
        r4 = r0.f23985e;	 Catch:{ IOException -> 0x00f2 }
        r5 = new io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;	 Catch:{ IOException -> 0x00f2 }
        r5.<init>();	 Catch:{ IOException -> 0x00f2 }
        r1 = r0.f23984d;	 Catch:{ IOException -> 0x00f2 }
        r7 = r1.f23997g;	 Catch:{ IOException -> 0x00f2 }
        r2 = r10;	 Catch:{ IOException -> 0x00f2 }
        r3 = r11;	 Catch:{ IOException -> 0x00f2 }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x00f2 }
        r9 = new com.twitter.sdk.android.core.internal.scribe.ScribeHandler;	 Catch:{ IOException -> 0x00f2 }
        r1 = r0.f23982b;	 Catch:{ IOException -> 0x00f2 }
        r8 = r1.getContext();	 Catch:{ IOException -> 0x00f2 }
        r1 = r0.f23984d;	 Catch:{ IOException -> 0x00f2 }
        r1 = r1.f23991a;	 Catch:{ IOException -> 0x00f2 }
        if (r1 == 0) goto L_0x00bd;	 Catch:{ IOException -> 0x00f2 }
    L_0x006e:
        r1 = "Scribe enabled";	 Catch:{ IOException -> 0x00f2 }
        io.fabric.sdk.android.services.common.CommonUtils.m26292a(r8, r1);	 Catch:{ IOException -> 0x00f2 }
        r22 = new com.twitter.sdk.android.core.internal.scribe.EnabledScribeStrategy;	 Catch:{ IOException -> 0x00f2 }
        r7 = r0.f23983c;	 Catch:{ IOException -> 0x00f2 }
        r6 = r0.f23984d;	 Catch:{ IOException -> 0x00f2 }
        r21 = new com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender;	 Catch:{ IOException -> 0x00f2 }
        r3 = r0.f23984d;	 Catch:{ IOException -> 0x00f2 }
        r4 = r0.f23986f;	 Catch:{ IOException -> 0x00f2 }
        r5 = r0.f23987g;	 Catch:{ IOException -> 0x00f2 }
        r2 = r0.f23988h;	 Catch:{ IOException -> 0x00f2 }
        r1 = r0.f23989i;	 Catch:{ IOException -> 0x00f2 }
        r23 = r10;	 Catch:{ IOException -> 0x00f2 }
        r10 = r0.f23983c;	 Catch:{ IOException -> 0x00f2 }
        r24 = r11;	 Catch:{ IOException -> 0x00f2 }
        r11 = r0.f23990j;	 Catch:{ IOException -> 0x00f2 }
        r16 = r1;	 Catch:{ IOException -> 0x00f2 }
        r1 = r21;	 Catch:{ IOException -> 0x00f2 }
        r17 = r2;	 Catch:{ IOException -> 0x00f2 }
        r2 = r8;	 Catch:{ IOException -> 0x00f2 }
        r18 = r4;	 Catch:{ IOException -> 0x00f2 }
        r19 = r5;	 Catch:{ IOException -> 0x00f2 }
        r4 = r12;	 Catch:{ IOException -> 0x00f2 }
        r20 = r6;	 Catch:{ IOException -> 0x00f2 }
        r6 = r18;	 Catch:{ IOException -> 0x00f2 }
        r18 = r7;	 Catch:{ IOException -> 0x00f2 }
        r7 = r19;	 Catch:{ IOException -> 0x00f2 }
        r25 = r8;	 Catch:{ IOException -> 0x00f2 }
        r8 = r17;	 Catch:{ IOException -> 0x00f2 }
        r12 = r9;	 Catch:{ IOException -> 0x00f2 }
        r9 = r16;	 Catch:{ IOException -> 0x00f2 }
        r13 = r23;	 Catch:{ IOException -> 0x00f2 }
        r26 = r14;	 Catch:{ IOException -> 0x00f2 }
        r14 = r24;	 Catch:{ IOException -> 0x00f2 }
        r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11);	 Catch:{ IOException -> 0x00f2 }
        r16 = r22;	 Catch:{ IOException -> 0x00f2 }
        r17 = r25;	 Catch:{ IOException -> 0x00f2 }
        r19 = r13;	 Catch:{ IOException -> 0x00f2 }
        r16.<init>(r17, r18, r19, r20, r21);	 Catch:{ IOException -> 0x00f2 }
        r1 = r22;	 Catch:{ IOException -> 0x00f2 }
        goto L_0x00d0;	 Catch:{ IOException -> 0x00f2 }
    L_0x00bd:
        r25 = r8;	 Catch:{ IOException -> 0x00f2 }
        r12 = r9;	 Catch:{ IOException -> 0x00f2 }
        r13 = r10;	 Catch:{ IOException -> 0x00f2 }
        r26 = r14;	 Catch:{ IOException -> 0x00f2 }
        r14 = r11;	 Catch:{ IOException -> 0x00f2 }
        r1 = "Scribe disabled";	 Catch:{ IOException -> 0x00f2 }
        r2 = r25;	 Catch:{ IOException -> 0x00f2 }
        io.fabric.sdk.android.services.common.CommonUtils.m26292a(r2, r1);	 Catch:{ IOException -> 0x00f2 }
        r1 = new io.fabric.sdk.android.services.events.DisabledEventsStrategy;	 Catch:{ IOException -> 0x00f2 }
        r1.<init>();	 Catch:{ IOException -> 0x00f2 }
    L_0x00d0:
        r2 = r0.f23983c;	 Catch:{ IOException -> 0x00f2 }
        r12.<init>(r14, r1, r13, r2);	 Catch:{ IOException -> 0x00f2 }
        r1 = r26;	 Catch:{ IOException -> 0x00f2 }
        r1.putIfAbsent(r15, r12);	 Catch:{ IOException -> 0x00f2 }
    L_0x00da:
        r1 = r0.f23981a;	 Catch:{ IOException -> 0x00f2 }
        r2 = java.lang.Long.valueOf(r29);	 Catch:{ IOException -> 0x00f2 }
        r1 = r1.get(r2);	 Catch:{ IOException -> 0x00f2 }
        r1 = (com.twitter.sdk.android.core.internal.scribe.ScribeHandler) r1;	 Catch:{ IOException -> 0x00f2 }
        r2 = new io.fabric.sdk.android.services.events.EventsHandler$1;	 Catch:{ IOException -> 0x00f2 }
        r3 = r28;	 Catch:{ IOException -> 0x00f2 }
        r2.<init>(r1, r3);	 Catch:{ IOException -> 0x00f2 }
        r1.m31966a(r2);	 Catch:{ IOException -> 0x00f2 }
        r1 = 1;
        return r1;
    L_0x00f2:
        r1 = r0.f23982b;
        r1 = r1.getContext();
        r2 = "Failed to scribe event";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r1, r2);
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.scribe.ScribeClient.a(com.twitter.sdk.android.core.internal.scribe.ScribeEvent, long):boolean");
    }
}
