package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzduu<T_WRAPPER extends zzduv<T_ENGINE>, T_ENGINE> {
    public static final zzduu<zzduw, Cipher> f7327a = new zzduu(new zzduw());
    public static final zzduu<zzdva, Mac> f7328b = new zzduu(new zzdva());
    public static final zzduu<zzdux, KeyAgreement> f7329c = new zzduu(new zzdux());
    public static final zzduu<zzduz, KeyPairGenerator> f7330d = new zzduu(new zzduz());
    private static final Logger f7331e = Logger.getLogger(zzduu.class.getName());
    private static final List<Provider> f7332f;
    private static zzduu<zzdvc, Signature> f7333g = new zzduu(new zzdvc());
    private static zzduu<zzdvb, MessageDigest> f7334h = new zzduu(new zzdvb());
    private static zzduu<zzduy, KeyFactory> f7335i = new zzduu(new zzduy());
    private T_WRAPPER f7336j;
    private List<Provider> f7337k = f7332f;
    private boolean f7338l = true;

    static {
        if (zzdvj.m5922a()) {
            String[] strArr = new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL"};
            List arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                Provider provider = Security.getProvider(strArr[i]);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f7331e.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{r4}));
                }
            }
            f7332f = arrayList;
        } else {
            f7332f = new ArrayList();
        }
    }

    private zzduu(T_WRAPPER t_wrapper) {
        this.f7336j = t_wrapper;
    }

    private final boolean m5910a(java.lang.String r2, java.security.Provider r3) {
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
        r1 = this;
        r0 = r1.f7336j;	 Catch:{ Exception -> 0x0007 }
        r0.mo1867a(r2, r3);	 Catch:{ Exception -> 0x0007 }
        r2 = 1;
        return r2;
    L_0x0007:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzduu.a(java.lang.String, java.security.Provider):boolean");
    }

    public final T_ENGINE m5911a(String str) throws GeneralSecurityException {
        Provider provider;
        for (Provider provider2 : this.f7337k) {
            if (m5910a(str, provider2)) {
                zzduv com_google_android_gms_internal_zzduv = this.f7336j;
                break;
            }
        }
        if (this.f7338l) {
            com_google_android_gms_internal_zzduv = this.f7336j;
            provider2 = null;
            return com_google_android_gms_internal_zzduv.mo1867a(str, provider2);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }
}
