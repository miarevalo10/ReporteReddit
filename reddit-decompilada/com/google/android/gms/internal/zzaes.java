package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.zzf;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;

@zzzv
public final class zzaes implements zzafb {
    boolean f14049a;
    final Object f14050b = new Object();
    private final zzfjw f14051c;
    private final LinkedHashMap<String, zzfke> f14052d;
    private final Context f14053e;
    private final zzafd f14054f;
    private final zzaey f14055g;
    private HashSet<String> f14056h = new HashSet();
    private boolean f14057i = false;
    private boolean f14058j = false;
    private boolean f14059k = false;

    public zzaes(Context context, zzakd com_google_android_gms_internal_zzakd, zzaey com_google_android_gms_internal_zzaey, String str, zzafd com_google_android_gms_internal_zzafd) {
        zzbq.m4809a((Object) com_google_android_gms_internal_zzaey, (Object) "SafeBrowsing config is not present.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f14053e = context;
        this.f14052d = new LinkedHashMap();
        this.f14054f = com_google_android_gms_internal_zzafd;
        this.f14055g = com_google_android_gms_internal_zzaey;
        for (String toLowerCase : this.f14055g.f17540e) {
            this.f14056h.add(toLowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.f14056h.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzfjw com_google_android_gms_internal_zzfjw = new zzfjw();
        com_google_android_gms_internal_zzfjw.f18045a = Integer.valueOf(8);
        com_google_android_gms_internal_zzfjw.f18046b = str;
        com_google_android_gms_internal_zzfjw.f18047c = str;
        com_google_android_gms_internal_zzfjw.f18048d = new zzfjx();
        com_google_android_gms_internal_zzfjw.f18048d.f18061a = this.f14055g.f17536a;
        zzfkf com_google_android_gms_internal_zzfkf = new zzfkf();
        com_google_android_gms_internal_zzfkf.f18095a = com_google_android_gms_internal_zzakd.f17551a;
        com_google_android_gms_internal_zzfkf.f18097c = Boolean.valueOf(zzbhf.m5574a(this.f14053e).m5570a());
        zzf.m4930b();
        long d = (long) zzf.m4934d(this.f14053e);
        if (d > 0) {
            com_google_android_gms_internal_zzfkf.f18096b = Long.valueOf(d);
        }
        com_google_android_gms_internal_zzfjw.f18052h = com_google_android_gms_internal_zzfkf;
        this.f14051c = com_google_android_gms_internal_zzfjw;
    }

    public final zzaey mo1702a() {
        return this.f14055g;
    }

    public final void mo1703a(View view) {
        if (this.f14055g.f17538c && !this.f14058j) {
            zzbs.m4486e();
            Bitmap b = zzahn.m5186b(view);
            if (b == null) {
                zzafa.m5071a("Failed to capture the webview bitmap.");
                return;
            }
            this.f14058j = true;
            zzahn.m5194b(new zzaet(this, b));
        }
    }

    public final void mo1704a(String str) {
        synchronized (this.f14050b) {
            this.f14051c.f18050f = str;
        }
    }

    public final void mo1705a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
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
        r6 = this;
        r0 = r6.f14050b;
        monitor-enter(r0);
        r1 = 3;
        if (r9 != r1) goto L_0x000d;
    L_0x0006:
        r2 = 1;
        r6.f14059k = r2;	 Catch:{ all -> 0x000a }
        goto L_0x000d;	 Catch:{ all -> 0x000a }
    L_0x000a:
        r7 = move-exception;	 Catch:{ all -> 0x000a }
        goto L_0x00ca;	 Catch:{ all -> 0x000a }
    L_0x000d:
        r2 = r6.f14052d;	 Catch:{ all -> 0x000a }
        r2 = r2.containsKey(r7);	 Catch:{ all -> 0x000a }
        if (r2 == 0) goto L_0x0027;	 Catch:{ all -> 0x000a }
    L_0x0015:
        if (r9 != r1) goto L_0x0025;	 Catch:{ all -> 0x000a }
    L_0x0017:
        r8 = r6.f14052d;	 Catch:{ all -> 0x000a }
        r7 = r8.get(r7);	 Catch:{ all -> 0x000a }
        r7 = (com.google.android.gms.internal.zzfke) r7;	 Catch:{ all -> 0x000a }
        r8 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x000a }
        r7.f18089d = r8;	 Catch:{ all -> 0x000a }
    L_0x0025:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;	 Catch:{ all -> 0x000a }
    L_0x0027:
        r1 = new com.google.android.gms.internal.zzfke;	 Catch:{ all -> 0x000a }
        r1.<init>();	 Catch:{ all -> 0x000a }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x000a }
        r1.f18089d = r9;	 Catch:{ all -> 0x000a }
        r9 = r6.f14052d;	 Catch:{ all -> 0x000a }
        r9 = r9.size();	 Catch:{ all -> 0x000a }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x000a }
        r1.f18086a = r9;	 Catch:{ all -> 0x000a }
        r1.f18087b = r7;	 Catch:{ all -> 0x000a }
        r9 = new com.google.android.gms.internal.zzfjz;	 Catch:{ all -> 0x000a }
        r9.<init>();	 Catch:{ all -> 0x000a }
        r1.f18088c = r9;	 Catch:{ all -> 0x000a }
        r9 = r6.f14056h;	 Catch:{ all -> 0x000a }
        r9 = r9.size();	 Catch:{ all -> 0x000a }
        if (r9 <= 0) goto L_0x00c3;	 Catch:{ all -> 0x000a }
    L_0x004f:
        if (r8 == 0) goto L_0x00c3;	 Catch:{ all -> 0x000a }
    L_0x0051:
        r9 = new java.util.LinkedList;	 Catch:{ all -> 0x000a }
        r9.<init>();	 Catch:{ all -> 0x000a }
        r8 = r8.entrySet();	 Catch:{ all -> 0x000a }
        r8 = r8.iterator();	 Catch:{ all -> 0x000a }
    L_0x005e:
        r2 = r8.hasNext();	 Catch:{ all -> 0x000a }
        if (r2 == 0) goto L_0x00b6;	 Catch:{ all -> 0x000a }
    L_0x0064:
        r2 = r8.next();	 Catch:{ all -> 0x000a }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x000a }
        r3 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        if (r3 == 0) goto L_0x0077;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0070:
        r3 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        goto L_0x0079;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0077:
        r3 = "";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0079:
        r4 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        if (r4 == 0) goto L_0x0086;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x007f:
        r2 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r2 = (java.lang.String) r2;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        goto L_0x0088;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0086:
        r2 = "";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0088:
        r4 = java.util.Locale.ENGLISH;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4 = r3.toLowerCase(r4);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r5 = r6.f14056h;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4 = r5.contains(r4);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        if (r4 != 0) goto L_0x0097;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0096:
        goto L_0x005e;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0097:
        r4 = new com.google.android.gms.internal.zzfjy;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r5 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r3 = r3.getBytes(r5);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4.f18063a = r3;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r3 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r2 = r2.getBytes(r3);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4.f18064b = r2;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r9.add(r4);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        goto L_0x005e;
    L_0x00b0:
        r2 = "Cannot convert string to bytes, skip header.";	 Catch:{ all -> 0x000a }
        com.google.android.gms.internal.zzafa.m5071a(r2);	 Catch:{ all -> 0x000a }
        goto L_0x005e;	 Catch:{ all -> 0x000a }
    L_0x00b6:
        r8 = r9.size();	 Catch:{ all -> 0x000a }
        r8 = new com.google.android.gms.internal.zzfjy[r8];	 Catch:{ all -> 0x000a }
        r9.toArray(r8);	 Catch:{ all -> 0x000a }
        r9 = r1.f18088c;	 Catch:{ all -> 0x000a }
        r9.f18065a = r8;	 Catch:{ all -> 0x000a }
    L_0x00c3:
        r8 = r6.f14052d;	 Catch:{ all -> 0x000a }
        r8.put(r7, r1);	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;	 Catch:{ all -> 0x000a }
    L_0x00ca:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaes.a(java.lang.String, java.util.Map, int):void");
    }

    final zzfke m13221b(String str) {
        zzfke com_google_android_gms_internal_zzfke;
        synchronized (this.f14050b) {
            com_google_android_gms_internal_zzfke = (zzfke) this.f14052d.get(str);
        }
        return com_google_android_gms_internal_zzfke;
    }

    public final boolean mo1706b() {
        return zzq.m4913e() && this.f14055g.f17538c && !this.f14058j;
    }

    public final void mo1707c() {
        this.f14057i = true;
    }

    public final void mo1708d() {
        synchronized (this.f14050b) {
            zzafd com_google_android_gms_internal_zzafd = this.f14054f;
            this.f14052d.keySet();
            zzakv a = com_google_android_gms_internal_zzafd.mo1710a();
            a.mo1732a(new zzaeu(this, a), zzahh.f6369a);
        }
    }

    final void m13225e() {
        int i = 0;
        int i2 = (!(this.f14049a && this.f14055g.f17542g) && (!(this.f14059k && this.f14055g.f17541f) && (this.f14049a || !this.f14055g.f17539d))) ? 0 : 1;
        if (i2 != 0) {
            synchronized (this.f14050b) {
                this.f14051c.f18049e = new zzfke[this.f14052d.size()];
                this.f14052d.values().toArray(this.f14051c.f18049e);
                if (zzafa.m5072a()) {
                    String str = this.f14051c.f18046b;
                    String str2 = this.f14051c.f18050f;
                    StringBuilder stringBuilder = new StringBuilder((53 + String.valueOf(str).length()) + String.valueOf(str2).length());
                    stringBuilder.append("Sending SB report\n  url: ");
                    stringBuilder.append(str);
                    stringBuilder.append("\n  clickUrl: ");
                    stringBuilder.append(str2);
                    stringBuilder.append("\n  resources: \n");
                    StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
                    zzfke[] com_google_android_gms_internal_zzfkeArr = this.f14051c.f18049e;
                    int length = com_google_android_gms_internal_zzfkeArr.length;
                    while (i < length) {
                        zzfke com_google_android_gms_internal_zzfke = com_google_android_gms_internal_zzfkeArr[i];
                        stringBuilder2.append("    [");
                        stringBuilder2.append(com_google_android_gms_internal_zzfke.f18090e.length);
                        stringBuilder2.append("] ");
                        stringBuilder2.append(com_google_android_gms_internal_zzfke.f18087b);
                        i++;
                    }
                    zzafa.m5071a(stringBuilder2.toString());
                }
                byte[] a = zzfjs.m6205a(this.f14051c);
                String str3 = this.f14055g.f17537b;
                zzaiv com_google_android_gms_internal_zzaiv = new zzaiv(this.f14053e);
                zzakv a2 = zzaiv.m5293a(1, str3, null, a);
                if (zzafa.m5072a()) {
                    a2.mo1732a(new zzaev(), zzahh.f6369a);
                }
            }
        }
    }
}
