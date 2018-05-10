package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.security.cert.Certificate;
import java.util.List;

public final class Handshake {
    final TlsVersion f23192a;
    public final CipherSuite f23193b;
    public final List<Certificate> f23194c;
    final List<Certificate> f23195d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f23192a = tlsVersion;
        this.f23193b = cipherSuite;
        this.f23194c = list;
        this.f23195d = list2;
    }

    public static com.sendbird.android.shadow.okhttp3.Handshake m25258a(javax.net.ssl.SSLSession r4) {
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
        r0 = r4.getCipherSuite();
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r4 = new java.lang.IllegalStateException;
        r0 = "cipherSuite == null";
        r4.<init>(r0);
        throw r4;
    L_0x000e:
        r0 = com.sendbird.android.shadow.okhttp3.CipherSuite.m25210a(r0);
        r1 = r4.getProtocol();
        if (r1 != 0) goto L_0x0020;
    L_0x0018:
        r4 = new java.lang.IllegalStateException;
        r0 = "tlsVersion == null";
        r4.<init>(r0);
        throw r4;
    L_0x0020:
        r1 = com.sendbird.android.shadow.okhttp3.TlsVersion.m25341a(r1);
        r2 = r4.getPeerCertificates();	 Catch:{ SSLPeerUnverifiedException -> 0x0029 }
        goto L_0x002a;
    L_0x0029:
        r2 = 0;
    L_0x002a:
        if (r2 == 0) goto L_0x0031;
    L_0x002c:
        r2 = com.sendbird.android.shadow.okhttp3.internal.Util.m25363a(r2);
        goto L_0x0035;
    L_0x0031:
        r2 = java.util.Collections.emptyList();
    L_0x0035:
        r4 = r4.getLocalCertificates();
        if (r4 == 0) goto L_0x0040;
    L_0x003b:
        r4 = com.sendbird.android.shadow.okhttp3.internal.Util.m25363a(r4);
        goto L_0x0044;
    L_0x0040:
        r4 = java.util.Collections.emptyList();
    L_0x0044:
        r3 = new com.sendbird.android.shadow.okhttp3.Handshake;
        r3.<init>(r1, r0, r2, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Handshake.a(javax.net.ssl.SSLSession):com.sendbird.android.shadow.okhttp3.Handshake");
    }

    public static Handshake m25257a(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, Util.m25362a((List) list), Util.m25362a((List) list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (this.f23192a.equals(handshake.f23192a) && this.f23193b.equals(handshake.f23193b) && this.f23194c.equals(handshake.f23194c) && this.f23195d.equals(handshake.f23195d) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (((((527 + this.f23192a.hashCode()) * 31) + this.f23193b.hashCode()) * 31) + this.f23194c.hashCode())) + this.f23195d.hashCode();
    }
}
