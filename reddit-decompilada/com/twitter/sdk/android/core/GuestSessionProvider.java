package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;

public class GuestSessionProvider {
    private final OAuth2Service f23918a;
    private final SessionManager<GuestSession> f23919b;

    public GuestSessionProvider(OAuth2Service oAuth2Service, SessionManager<GuestSession> sessionManager) {
        this.f23918a = oAuth2Service;
        this.f23919b = sessionManager;
    }

    public final synchronized GuestSession m25836a() {
        GuestSession guestSession = (GuestSession) this.f23919b.mo5463a();
        Object obj = (guestSession == null || guestSession.f23922a == null || ((GuestAuthToken) guestSession.f23922a).mo6583a()) ? null : 1;
        if (obj != null) {
            return guestSession;
        }
        m25835b();
        return (GuestSession) this.f23919b.mo5463a();
    }

    public final synchronized GuestSession m25837a(GuestSession guestSession) {
        GuestSession guestSession2 = (GuestSession) this.f23919b.mo5463a();
        if (!(guestSession == null || guestSession.equals(guestSession2) == null)) {
            m25835b();
        }
        return (GuestSession) this.f23919b.mo5463a();
    }

    private void m25835b() {
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
        r7 = this;
        r0 = io.fabric.sdk.android.Fabric.m26243b();
        r1 = "GuestSessionProvider";
        r2 = "Refreshing expired guest session.";
        r0.mo5562a(r1, r2);
        r0 = new java.util.concurrent.CountDownLatch;
        r1 = 1;
        r0.<init>(r1);
        r1 = r7.f23918a;
        r2 = new com.twitter.sdk.android.core.GuestSessionProvider$1;
        r2.<init>(r7, r0);
        r3 = new com.twitter.sdk.android.core.internal.oauth.OAuth2Service$1;
        r3.<init>(r1, r2);
        r2 = r1.f30722a;
        r1 = r1.f23965b;
        r1 = r1.f30696d;
        r4 = new java.lang.StringBuilder;
        r5 = "Basic ";
        r4.<init>(r5);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r1.f23926a;
        r6 = io.fabric.sdk.android.services.network.UrlUtils.m26424b(r6);
        r5.append(r6);
        r6 = ":";
        r5.append(r6);
        r1 = r1.f23927b;
        r1 = io.fabric.sdk.android.services.network.UrlUtils.m26424b(r1);
        r5.append(r1);
        r1 = r5.toString();
        r1 = io.fabric.sdk.android.services.network.HttpRequest.Base64.m26400a(r1);
        r4.append(r1);
        r1 = r4.toString();
        r4 = "client_credentials";
        r1 = r2.getAppAuthToken(r1, r4);
        r1.a(r3);
        r0.await();	 Catch:{ InterruptedException -> 0x0062 }
        return;
    L_0x0062:
        r0 = r7.f23919b;
        r0.mo5467c();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.GuestSessionProvider.b():void");
    }
}
