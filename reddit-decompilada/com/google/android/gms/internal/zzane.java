package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;

@zzzv
public final class zzane implements zzt<zzamp> {
    private zzana f14198a;

    private static java.lang.Integer m13405a(java.util.Map<java.lang.String, java.lang.String> r3, java.lang.String r4) {
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
        r0 = r3.containsKey(r4);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r3.get(r4);	 Catch:{ NumberFormatException -> 0x0017 }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x0017 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0017 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0017 }
        return r0;
    L_0x0017:
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r0 = 39;
        r2 = java.lang.String.valueOf(r4);
        r2 = r2.length();
        r0 = r0 + r2;
        r2 = java.lang.String.valueOf(r3);
        r2 = r2.length();
        r0 = r0 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r0);
        r0 = "Precache invalid numeric parameter '";
        r2.append(r0);
        r2.append(r4);
        r4 = "': ";
        r2.append(r4);
        r2.append(r3);
        r3 = r2.toString();
        com.google.android.gms.internal.zzakb.m5371e(r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzane.a(java.util.Map, java.lang.String):java.lang.Integer");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzamp com_google_android_gms_internal_zzamp = (zzamp) obj;
        zzbs.m4505x();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str != null) {
                if (this.f14198a != null) {
                    zzakb.m5371e("Threadless precache task has already started.");
                    return;
                } else if (zzamz.m5430b(com_google_android_gms_internal_zzamp) != null) {
                    zzakb.m5371e("Precache task is already running.");
                    return;
                } else if (com_google_android_gms_internal_zzamp.mo3468e() == null) {
                    zzakb.m5371e("Precache requires a dependency provider.");
                    return;
                } else {
                    int i;
                    int i2;
                    zzamo com_google_android_gms_internal_zzamo = new zzamo((String) map.get("flags"));
                    Integer a = m13405a(map, "notifyBytes");
                    Integer a2 = m13405a(map, "notifyMillis");
                    Integer a3 = m13405a(map, "player");
                    int i3 = 0;
                    if (a3 == null) {
                        a3 = Integer.valueOf(0);
                    }
                    a3.intValue();
                    zzana a4 = com_google_android_gms_internal_zzamp.mo3468e().f5649a.mo1752a(com_google_android_gms_internal_zzamp);
                    if (a == null) {
                        if (a2 == null) {
                            i = 0;
                            if (i != 0) {
                                for (String str2 : com_google_android_gms_internal_zzamo.f6557a.split(",")) {
                                    if (str2.equals("1") && !str2.equals("2")) {
                                        i3 = 1;
                                        break;
                                    }
                                }
                                if (i3 != 0) {
                                    if (a == null) {
                                        a.intValue();
                                    } else {
                                        a2.intValue();
                                    }
                                    this.f14198a = a4;
                                }
                            }
                            new zzamx(com_google_android_gms_internal_zzamp, a4, str).mo1645e();
                        }
                    }
                    i = 1;
                    if (i != 0) {
                        for (i2 = 0; i2 < i; i2++) {
                            if (str2.equals("1")) {
                            }
                        }
                        if (i3 != 0) {
                            if (a == null) {
                                a2.intValue();
                            } else {
                                a.intValue();
                            }
                            this.f14198a = a4;
                        }
                    }
                    new zzamx(com_google_android_gms_internal_zzamp, a4, str).mo1645e();
                }
            } else if (zzamz.m5430b(com_google_android_gms_internal_zzamp) == null && this.f14198a == null) {
                zzakb.m5371e("Precache must specify a source.");
                return;
            }
            Integer a5 = m13405a(map, "minBufferMs");
            if (a5 != null) {
                a5.intValue();
            }
            a5 = m13405a(map, "maxBufferMs");
            if (a5 != null) {
                a5.intValue();
            }
            a5 = m13405a(map, "bufferForPlaybackMs");
            if (a5 != null) {
                a5.intValue();
            }
            a5 = m13405a(map, "bufferForPlaybackAfterRebufferMs");
            if (a5 != null) {
                a5.intValue();
            }
        } else if (this.f14198a != null) {
            this.f14198a.mo3459a();
        } else {
            if (!zzamz.m5429a(com_google_android_gms_internal_zzamp)) {
                zzakb.m5371e("Precache abort but no precache task running.");
            }
        }
    }
}
