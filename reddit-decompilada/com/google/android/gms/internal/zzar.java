package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public final class zzar extends zzah {
    private final zzas f17594a;
    private final SSLSocketFactory f17595b;

    public zzar() {
        this((byte) 0);
    }

    private zzar(byte b) {
        this('\u0000');
    }

    private zzar(char c) {
        this.f17594a = null;
        this.f17595b = null;
    }

    private static java.io.InputStream m17893a(java.net.HttpURLConnection r1) {
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
        r0 = r1.getInputStream();	 Catch:{ IOException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = r1.getErrorStream();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzar.a(java.net.HttpURLConnection):java.io.InputStream");
    }

    private static List<zzl> m17894a(Map<String, List<String>> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String com_google_android_gms_internal_zzl : (List) entry.getValue()) {
                    arrayList.add(new zzl((String) entry.getKey(), com_google_android_gms_internal_zzl));
                }
            }
        }
        return arrayList;
    }

    private static void m17895a(HttpURLConnection httpURLConnection, zzr<?> com_google_android_gms_internal_zzr_) throws IOException, zza {
        byte[] a = com_google_android_gms_internal_zzr_.mo3444a();
        if (a != null) {
            httpURLConnection.setDoOutput(true);
            String str = "Content-Type";
            String str2 = "application/x-www-form-urlencoded; charset=";
            String valueOf = String.valueOf("UTF-8");
            httpURLConnection.addRequestProperty(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(a);
            dataOutputStream.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzap mo3435a(com.google.android.gms.internal.zzr<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.google.android.gms.internal.zza {
        /*
        r6 = this;
        r0 = r7.f7967b;
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = r7.mo3445b();
        r1.putAll(r2);
        r1.putAll(r8);
        r8 = r6.f17594a;
        if (r8 == 0) goto L_0x003a;
    L_0x0015:
        r8 = r6.f17594a;
        r8 = r8.m5490a();
        if (r8 != 0) goto L_0x003b;
    L_0x001d:
        r7 = new java.io.IOException;
        r8 = "URL blocked by rewriter: ";
        r0 = java.lang.String.valueOf(r0);
        r1 = r0.length();
        if (r1 == 0) goto L_0x0030;
    L_0x002b:
        r8 = r8.concat(r0);
        goto L_0x0036;
    L_0x0030:
        r0 = new java.lang.String;
        r0.<init>(r8);
        r8 = r0;
    L_0x0036:
        r7.<init>(r8);
        throw r7;
    L_0x003a:
        r8 = r0;
    L_0x003b:
        r0 = new java.net.URL;
        r0.<init>(r8);
        r8 = r0.openConnection();
        r8 = (java.net.HttpURLConnection) r8;
        r2 = java.net.HttpURLConnection.getFollowRedirects();
        r8.setInstanceFollowRedirects(r2);
        r2 = r7.m6629c();
        r8.setConnectTimeout(r2);
        r8.setReadTimeout(r2);
        r2 = 0;
        r8.setUseCaches(r2);
        r3 = 1;
        r8.setDoInput(r3);
        r4 = "https";
        r0 = r0.getProtocol();
        r4.equals(r0);
        r0 = r1.keySet();
        r0 = r0.iterator();
    L_0x0070:
        r4 = r0.hasNext();
        if (r4 == 0) goto L_0x0086;
    L_0x0076:
        r4 = r0.next();
        r4 = (java.lang.String) r4;
        r5 = r1.get(r4);
        r5 = (java.lang.String) r5;
        r8.addRequestProperty(r4, r5);
        goto L_0x0070;
    L_0x0086:
        r0 = r7.f7966a;
        switch(r0) {
            case -1: goto L_0x00b3;
            case 0: goto L_0x00ae;
            case 1: goto L_0x00a5;
            case 2: goto L_0x00a2;
            case 3: goto L_0x009f;
            case 4: goto L_0x009c;
            case 5: goto L_0x0099;
            case 6: goto L_0x0096;
            case 7: goto L_0x0093;
            default: goto L_0x008b;
        };
    L_0x008b:
        r7 = new java.lang.IllegalStateException;
        r8 = "Unknown method type.";
        r7.<init>(r8);
        throw r7;
    L_0x0093:
        r0 = "PATCH";
        goto L_0x00a7;
    L_0x0096:
        r0 = "TRACE";
        goto L_0x00b0;
    L_0x0099:
        r0 = "OPTIONS";
        goto L_0x00b0;
    L_0x009c:
        r0 = "HEAD";
        goto L_0x00b0;
    L_0x009f:
        r0 = "DELETE";
        goto L_0x00b0;
    L_0x00a2:
        r0 = "PUT";
        goto L_0x00a7;
    L_0x00a5:
        r0 = "POST";
    L_0x00a7:
        r8.setRequestMethod(r0);
        m17895a(r8, r7);
        goto L_0x00b3;
    L_0x00ae:
        r0 = "GET";
    L_0x00b0:
        r8.setRequestMethod(r0);
    L_0x00b3:
        r0 = r8.getResponseCode();
        r1 = -1;
        if (r0 != r1) goto L_0x00c2;
    L_0x00ba:
        r7 = new java.io.IOException;
        r8 = "Could not retrieve response code from HttpUrlConnection.";
        r7.<init>(r8);
        throw r7;
    L_0x00c2:
        r7 = r7.f7966a;
        r1 = 4;
        if (r7 == r1) goto L_0x00d8;
    L_0x00c7:
        r7 = 100;
        if (r7 > r0) goto L_0x00cf;
    L_0x00cb:
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 < r7) goto L_0x00d8;
    L_0x00cf:
        r7 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        if (r0 == r7) goto L_0x00d8;
    L_0x00d3:
        r7 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r0 == r7) goto L_0x00d8;
    L_0x00d7:
        r2 = r3;
    L_0x00d8:
        if (r2 != 0) goto L_0x00e8;
    L_0x00da:
        r7 = new com.google.android.gms.internal.zzap;
        r8 = r8.getHeaderFields();
        r8 = m17894a(r8);
        r7.<init>(r0, r8);
        return r7;
    L_0x00e8:
        r7 = new com.google.android.gms.internal.zzap;
        r1 = r8.getHeaderFields();
        r1 = m17894a(r1);
        r2 = r8.getContentLength();
        r8 = m17893a(r8);
        r7.<init>(r0, r1, r2, r8);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzar.a(com.google.android.gms.internal.zzr, java.util.Map):com.google.android.gms.internal.zzap");
    }
}
