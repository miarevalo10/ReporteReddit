package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.Protocol;

public final class StatusLine {
    public final Protocol f23425a;
    public final int f23426b;
    public final String f23427c;

    public StatusLine(Protocol protocol, int i, String str) {
        this.f23425a = protocol;
        this.f23426b = i;
        this.f23427c = str;
    }

    public static com.sendbird.android.shadow.okhttp3.internal.http.StatusLine m25443a(java.lang.String r8) throws java.io.IOException {
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
        r0 = "HTTP/1.";
        r0 = r8.startsWith(r0);
        r1 = 4;
        r2 = 32;
        r3 = 9;
        if (r0 == 0) goto L_0x0056;
    L_0x000d:
        r0 = r8.length();
        if (r0 < r3) goto L_0x0042;
    L_0x0013:
        r0 = 8;
        r0 = r8.charAt(r0);
        if (r0 == r2) goto L_0x001c;
    L_0x001b:
        goto L_0x0042;
    L_0x001c:
        r0 = 7;
        r0 = r8.charAt(r0);
        r0 = r0 + -48;
        if (r0 != 0) goto L_0x0028;
    L_0x0025:
        r0 = com.sendbird.android.shadow.okhttp3.Protocol.HTTP_1_0;
        goto L_0x0061;
    L_0x0028:
        r4 = 1;
        if (r0 != r4) goto L_0x002e;
    L_0x002b:
        r0 = com.sendbird.android.shadow.okhttp3.Protocol.HTTP_1_1;
        goto L_0x0061;
    L_0x002e:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0042:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0056:
        r0 = "ICY ";
        r0 = r8.startsWith(r0);
        if (r0 == 0) goto L_0x00c6;
    L_0x005e:
        r0 = com.sendbird.android.shadow.okhttp3.Protocol.HTTP_1_0;
        r3 = r1;
    L_0x0061:
        r4 = r8.length();
        r5 = r3 + 3;
        if (r4 >= r5) goto L_0x007d;
    L_0x0069:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x007d:
        r4 = r8.substring(r3, r5);	 Catch:{ NumberFormatException -> 0x00b2 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x00b2 }
        r6 = "";
        r7 = r8.length();
        if (r7 <= r5) goto L_0x00ac;
    L_0x008d:
        r5 = r8.charAt(r5);
        if (r5 == r2) goto L_0x00a7;
    L_0x0093:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00a7:
        r3 = r3 + r1;
        r6 = r8.substring(r3);
    L_0x00ac:
        r8 = new com.sendbird.android.shadow.okhttp3.internal.http.StatusLine;
        r8.<init>(r0, r4, r6);
        return r8;
    L_0x00b2:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00c6:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http.StatusLine.a(java.lang.String):com.sendbird.android.shadow.okhttp3.internal.http.StatusLine");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f23425a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ');
        stringBuilder.append(this.f23426b);
        if (this.f23427c != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.f23427c);
        }
        return stringBuilder.toString();
    }
}
