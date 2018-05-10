package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;

final class zzdqk implements zzdpw<zzdpp> {
    zzdqk() {
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13612d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdru.m21060a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e);
        }
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.AesGcmKey").m21163a(((zzdrs) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.SYMMETRIC).m20431f();
    }

    private static com.google.android.gms.internal.zzdpp m13612d(com.google.android.gms.internal.zzfes r1) throws java.security.GeneralSecurityException {
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
        r1 = com.google.android.gms.internal.zzdrs.m21051a(r1);	 Catch:{ zzfge -> 0x0010 }
        r0 = new com.google.android.gms.internal.zzdtz;	 Catch:{ zzfge -> 0x0010 }
        r1 = r1.f19607b;	 Catch:{ zzfge -> 0x0010 }
        r1 = r1.m5959c();	 Catch:{ zzfge -> 0x0010 }
        r0.<init>(r1);	 Catch:{ zzfge -> 0x0010 }
        return r0;
    L_0x0010:
        r1 = new java.security.GeneralSecurityException;
        r0 = "expected AesGcmKey proto";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdqk.d(com.google.android.gms.internal.zzfes):com.google.android.gms.internal.zzdpp");
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdru) {
            zzdru com_google_android_gms_internal_zzdru = (zzdru) com_google_android_gms_internal_zzfhe;
            zzdvk.m5923a(com_google_android_gms_internal_zzdru.f19612b);
            return zzdrs.m21050a().m21049a(zzfes.m5948a(zzdvi.m5921a(com_google_android_gms_internal_zzdru.f19612b))).m21048a(com_google_android_gms_internal_zzdru.f19611a == null ? zzdrw.m21064a() : com_google_android_gms_internal_zzdru.f19611a).m21047a().m20431f();
        }
        throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdrs) {
            zzdrs com_google_android_gms_internal_zzdrs = (zzdrs) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdrs.f19606a);
            zzdvk.m5923a(com_google_android_gms_internal_zzdrs.f19607b.mo3503a());
            return new zzdtz(com_google_android_gms_internal_zzdrs.f19607b.m5959c());
        }
        throw new GeneralSecurityException("expected AesGcmKey proto");
    }
}
