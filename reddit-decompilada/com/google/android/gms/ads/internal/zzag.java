package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzag extends zzkl {
    private final Context f17134a;
    private final zzkh f17135b;
    private final zzux f17136c;
    private final zzqq f17137d;
    private final zzrc f17138e;
    private final zzqt f17139f;
    private final zzrf f17140g;
    private final zzjn f17141h;
    private final PublisherAdViewOptions f17142i;
    private final SimpleArrayMap<String, zzqz> f17143j;
    private final SimpleArrayMap<String, zzqw> f17144k;
    private final zzpe f17145l;
    private final List<String> f17146m;
    private final zzld f17147n;
    private final String f17148o;
    private final zzakd f17149p;
    private WeakReference<zzd> f17150q;
    private final zzv f17151r;
    private final Object f17152s = new Object();

    zzag(Context context, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, zzkh com_google_android_gms_internal_zzkh, zzqq com_google_android_gms_internal_zzqq, zzrc com_google_android_gms_internal_zzrc, zzqt com_google_android_gms_internal_zzqt, SimpleArrayMap<String, zzqz> simpleArrayMap, SimpleArrayMap<String, zzqw> simpleArrayMap2, zzpe com_google_android_gms_internal_zzpe, zzld com_google_android_gms_internal_zzld, zzv com_google_android_gms_ads_internal_zzv, zzrf com_google_android_gms_internal_zzrf, zzjn com_google_android_gms_internal_zzjn, PublisherAdViewOptions publisherAdViewOptions) {
        this.f17134a = context;
        this.f17148o = str;
        this.f17136c = com_google_android_gms_internal_zzux;
        this.f17149p = com_google_android_gms_internal_zzakd;
        this.f17135b = com_google_android_gms_internal_zzkh;
        this.f17139f = com_google_android_gms_internal_zzqt;
        this.f17137d = com_google_android_gms_internal_zzqq;
        this.f17138e = com_google_android_gms_internal_zzrc;
        this.f17143j = simpleArrayMap;
        this.f17144k = simpleArrayMap2;
        this.f17145l = com_google_android_gms_internal_zzpe;
        this.f17146m = m17487e();
        this.f17147n = com_google_android_gms_internal_zzld;
        this.f17151r = com_google_android_gms_ads_internal_zzv;
        this.f17140g = com_google_android_gms_internal_zzrf;
        this.f17141h = com_google_android_gms_internal_zzjn;
        this.f17142i = publisherAdViewOptions;
        zznh.m6490a(this.f17134a);
    }

    private static void m17484a(Runnable runnable) {
        zzahn.f6379a.post(runnable);
    }

    private final boolean m17486d() {
        if (this.f17137d == null && this.f17139f == null) {
            if (this.f17143j == null || this.f17143j.size() <= 0) {
                return false;
            }
        }
        return true;
    }

    private final List<String> m17487e() {
        List<String> arrayList = new ArrayList();
        if (this.f17139f != null) {
            arrayList.add("1");
        }
        if (this.f17137d != null) {
            arrayList.add("2");
        }
        if (this.f17143j.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo1969a() {
        /*
        r3 = this;
        r0 = r3.f17152s;
        monitor-enter(r0);
        r1 = r3.f17150q;	 Catch:{ all -> 0x001a }
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r3.f17150q;	 Catch:{ all -> 0x001a }
        r1 = r1.get();	 Catch:{ all -> 0x001a }
        r1 = (com.google.android.gms.ads.internal.zzd) r1;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0016;
    L_0x0012:
        r2 = r1.mo1989a();	 Catch:{ all -> 0x001a }
    L_0x0016:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzag.a():java.lang.String");
    }

    public final void mo1970a(zzjj com_google_android_gms_internal_zzjj) {
        m17484a(new zzah(this, com_google_android_gms_internal_zzjj));
    }

    public final void mo1971a(zzjj com_google_android_gms_internal_zzjj, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Number of ads has to be more than 0");
        }
        m17484a(new zzai(this, com_google_android_gms_internal_zzjj, i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo1972b() {
        /*
        r3 = this;
        r0 = r3.f17152s;
        monitor-enter(r0);
        r1 = r3.f17150q;	 Catch:{ all -> 0x001a }
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r3.f17150q;	 Catch:{ all -> 0x001a }
        r1 = r1.get();	 Catch:{ all -> 0x001a }
        r1 = (com.google.android.gms.ads.internal.zzd) r1;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0016;
    L_0x0012:
        r2 = r1.g_();	 Catch:{ all -> 0x001a }
    L_0x0016:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzag.b():java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo1973c() {
        /*
        r3 = this;
        r0 = r3.f17152s;
        monitor-enter(r0);
        r1 = r3.f17150q;	 Catch:{ all -> 0x001a }
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r3.f17150q;	 Catch:{ all -> 0x001a }
        r1 = r1.get();	 Catch:{ all -> 0x001a }
        r1 = (com.google.android.gms.ads.internal.zzd) r1;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0016;
    L_0x0012:
        r2 = r1.mo2014q();	 Catch:{ all -> 0x001a }
    L_0x0016:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        return r2;
    L_0x001a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzag.c():boolean");
    }

    static /* synthetic */ boolean m17485b(zzag com_google_android_gms_ads_internal_zzag) {
        return (!((Boolean) zzkb.m6350f().m6488a(zznh.aA)).booleanValue() || com_google_android_gms_ads_internal_zzag.f17140g == null) ? null : true;
    }

    static /* synthetic */ void m17482a(zzag com_google_android_gms_ads_internal_zzag, zzjj com_google_android_gms_internal_zzjj) {
        zza com_google_android_gms_ads_internal_zzq = new zzq(com_google_android_gms_ads_internal_zzag.f17134a, com_google_android_gms_ads_internal_zzag.f17151r, com_google_android_gms_ads_internal_zzag.f17141h, com_google_android_gms_ads_internal_zzag.f17148o, com_google_android_gms_ads_internal_zzag.f17136c, com_google_android_gms_ads_internal_zzag.f17149p);
        com_google_android_gms_ads_internal_zzag.f17150q = new WeakReference(com_google_android_gms_ads_internal_zzq);
        zzrf com_google_android_gms_internal_zzrf = com_google_android_gms_ads_internal_zzag.f17140g;
        zzbq.m4816b("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzq.e.f5621x = com_google_android_gms_internal_zzrf;
        if (com_google_android_gms_ads_internal_zzag.f17142i != null) {
            if (com_google_android_gms_ads_internal_zzag.f17142i.f17072b != null) {
                com_google_android_gms_ads_internal_zzq.mo1994a(com_google_android_gms_ads_internal_zzag.f17142i.f17072b);
            }
            com_google_android_gms_ads_internal_zzq.mo2002b(com_google_android_gms_ads_internal_zzag.f17142i.f17071a);
        }
        zzqq com_google_android_gms_internal_zzqq = com_google_android_gms_ads_internal_zzag.f17137d;
        zzbq.m4816b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzq.e.f5614q = com_google_android_gms_internal_zzqq;
        zzqt com_google_android_gms_internal_zzqt = com_google_android_gms_ads_internal_zzag.f17139f;
        zzbq.m4816b("setOnContentAdLoadedListener must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzq.e.f5615r = com_google_android_gms_internal_zzqt;
        SimpleArrayMap simpleArrayMap = com_google_android_gms_ads_internal_zzag.f17143j;
        zzbq.m4816b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzq.e.f5617t = simpleArrayMap;
        simpleArrayMap = com_google_android_gms_ads_internal_zzag.f17144k;
        zzbq.m4816b("setOnCustomClickListener must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzq.e.f5616s = simpleArrayMap;
        zzpe com_google_android_gms_internal_zzpe = com_google_android_gms_ads_internal_zzag.f17145l;
        zzbq.m4816b("setNativeAdOptions must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzq.e.f5618u = com_google_android_gms_internal_zzpe;
        com_google_android_gms_ads_internal_zzq.m20916b(com_google_android_gms_ads_internal_zzag.m17487e());
        com_google_android_gms_ads_internal_zzq.mo1993a(com_google_android_gms_ads_internal_zzag.f17135b);
        com_google_android_gms_ads_internal_zzq.mo1995a(com_google_android_gms_ads_internal_zzag.f17147n);
        List arrayList = new ArrayList();
        if (com_google_android_gms_ads_internal_zzag.m17486d()) {
            arrayList.add(Integer.valueOf(1));
        }
        if (com_google_android_gms_ads_internal_zzag.f17140g != null) {
            arrayList.add(Integer.valueOf(2));
        }
        com_google_android_gms_ads_internal_zzq.m20919c(arrayList);
        if (com_google_android_gms_ads_internal_zzag.m17486d()) {
            com_google_android_gms_internal_zzjj.f18136c.putBoolean("ina", true);
        }
        if (com_google_android_gms_ads_internal_zzag.f17140g != null) {
            com_google_android_gms_internal_zzjj.f18136c.putBoolean("iba", true);
        }
        com_google_android_gms_ads_internal_zzq.mo2003b(com_google_android_gms_internal_zzjj);
    }

    static /* synthetic */ void m17483a(zzag com_google_android_gms_ads_internal_zzag, zzjj com_google_android_gms_internal_zzjj, int i) {
        zza com_google_android_gms_ads_internal_zzba = new zzba(com_google_android_gms_ads_internal_zzag.f17134a, com_google_android_gms_ads_internal_zzag.f17151r, zzjn.m18776a(), com_google_android_gms_ads_internal_zzag.f17148o, com_google_android_gms_ads_internal_zzag.f17136c, com_google_android_gms_ads_internal_zzag.f17149p);
        com_google_android_gms_ads_internal_zzag.f17150q = new WeakReference(com_google_android_gms_ads_internal_zzba);
        zzqq com_google_android_gms_internal_zzqq = com_google_android_gms_ads_internal_zzag.f17137d;
        zzbq.m4816b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzba.e.f5614q = com_google_android_gms_internal_zzqq;
        zzqt com_google_android_gms_internal_zzqt = com_google_android_gms_ads_internal_zzag.f17139f;
        zzbq.m4816b("setOnContentAdLoadedListener must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzba.e.f5615r = com_google_android_gms_internal_zzqt;
        SimpleArrayMap simpleArrayMap = com_google_android_gms_ads_internal_zzag.f17143j;
        zzbq.m4816b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzba.e.f5617t = simpleArrayMap;
        com_google_android_gms_ads_internal_zzba.mo1993a(com_google_android_gms_ads_internal_zzag.f17135b);
        simpleArrayMap = com_google_android_gms_ads_internal_zzag.f17144k;
        zzbq.m4816b("setOnCustomClickListener must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzba.e.f5616s = simpleArrayMap;
        com_google_android_gms_ads_internal_zzba.m20884b(com_google_android_gms_ads_internal_zzag.m17487e());
        zzpe com_google_android_gms_internal_zzpe = com_google_android_gms_ads_internal_zzag.f17145l;
        zzbq.m4816b("setNativeAdOptions must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzba.e.f5618u = com_google_android_gms_internal_zzpe;
        com_google_android_gms_ads_internal_zzba.mo1995a(com_google_android_gms_ads_internal_zzag.f17147n);
        zzbq.m4816b("setMaxNumberOfAds must be called on the main UI thread.");
        com_google_android_gms_ads_internal_zzba.f19546k = i;
        com_google_android_gms_ads_internal_zzba.mo2003b(com_google_android_gms_internal_zzjj);
    }
}
