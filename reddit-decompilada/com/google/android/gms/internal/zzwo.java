package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

@zzzv
public final class zzwo extends zzxb {
    public final Context f14700a;
    String f14701b = m14425c("description");
    long f14702c = m14426d("start_ticks");
    long f14703d = m14426d("end_ticks");
    String f14704e = m14425c("summary");
    String f14705f = m14425c("location");
    private final Map<String, String> f14706g;

    public zzwo(zzanh com_google_android_gms_internal_zzanh, Map<String, String> map) {
        super(com_google_android_gms_internal_zzanh, "createCalendarEvent");
        this.f14706g = map;
        this.f14700a = com_google_android_gms_internal_zzanh.mo3467d();
    }

    private final String m14425c(String str) {
        return TextUtils.isEmpty((CharSequence) this.f14706g.get(str)) ? "" : (String) this.f14706g.get(str);
    }

    private final long m14426d(java.lang.String r5) {
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
        r4 = this;
        r0 = r4.f14706g;
        r5 = r0.get(r5);
        r5 = (java.lang.String) r5;
        r0 = -1;
        if (r5 != 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = java.lang.Long.parseLong(r5);	 Catch:{ NumberFormatException -> 0x0012 }
        return r2;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwo.d(java.lang.String):long");
    }
}
