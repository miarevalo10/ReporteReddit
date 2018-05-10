package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzadc;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzafq;
import com.google.android.gms.internal.zzafr;
import com.google.android.gms.internal.zzaft;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzafy;
import com.google.android.gms.internal.zzafz;
import com.google.android.gms.internal.zzagd;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzahs;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzxl;
import com.google.android.gms.internal.zzxr;
import com.google.android.gms.internal.zzyb;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

@zzzv
public abstract class zza extends zzkt implements zzb, zzq, zzafy, zzje, zzyb, zzzx {
    protected zznu f17125a;
    protected zzns f17126b;
    protected boolean f17127c = false;
    protected final zzbi f17128d;
    protected final zzbt f17129e;
    protected transient zzjj f17130f;
    protected final zzfs f17131g;
    protected final zzv f17132h;
    private zzns f17133i;

    protected static boolean m17424a(zzjj com_google_android_gms_internal_zzjj) {
        Bundle bundle = com_google_android_gms_internal_zzjj.f18146m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            if (bundle.containsKey("gw")) {
                return false;
            }
        }
        return true;
    }

    private static long mo4271b(java.lang.String r3) {
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
        r0 = "ufe";
        r0 = r3.indexOf(r0);
        r1 = 44;
        r1 = r3.indexOf(r1, r0);
        r2 = -1;
        if (r1 != r2) goto L_0x0013;
    L_0x000f:
        r1 = r3.length();
    L_0x0013:
        r0 = r0 + 4;
        r3 = r3.substring(r0, r1);	 Catch:{ IndexOutOfBoundsException -> 0x0021, NumberFormatException -> 0x001e }
        r0 = java.lang.Long.parseLong(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0021, NumberFormatException -> 0x001e }
        return r0;
    L_0x001e:
        r3 = "Cannot find valid format of Url fetch time in CSI latency info.";
        goto L_0x0023;
    L_0x0021:
        r3 = "Invalid index for Url fetch time in CSI latency info.";
    L_0x0023:
        com.google.android.gms.internal.zzakb.m5371e(r3);
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zza.b(java.lang.String):long");
    }

    public String mo1985A() {
        return this.f17129e.f5599b;
    }

    public final zzkx mo1986B() {
        return this.f17129e.f5612o;
    }

    public final zzkh mo1987C() {
        return this.f17129e.f5611n;
    }

    protected final List<String> m17429a(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String a : list) {
            arrayList.add(zzafi.m5105a(a, this.f17129e.f5600c));
        }
        return arrayList;
    }

    protected void mo4265a(int i) {
        mo4266a(i, false);
    }

    protected void mo4266a(int i, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append("Failed to load ad: ");
        stringBuilder.append(i);
        zzakb.m5371e(stringBuilder.toString());
        this.f17127c = z;
        if (this.f17129e.f5611n != null) {
            try {
                this.f17129e.f5611n.mo1963a(i);
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.f17129e.f5584A != null) {
            try {
                this.f17129e.f5584A.mo1675a(i);
            } catch (Throwable e2) {
                zzakb.m5369c("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    protected final void m17432a(View view) {
        zzbu com_google_android_gms_ads_internal_zzbu = this.f17129e.f5603f;
        if (com_google_android_gms_ads_internal_zzbu != null) {
            com_google_android_gms_ads_internal_zzbu.addView(view, zzbs.m4488g().mo4446d());
        }
    }

    public final void mo1990a(zzadp com_google_android_gms_internal_zzadp) {
        zzbq.m4816b("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f17129e.f5584A = com_google_android_gms_internal_zzadp;
    }

    public abstract void mo4267a(zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu);

    public final void mo1991a(zzjn com_google_android_gms_internal_zzjn) {
        zzbq.m4816b("setAdSize must be called on the main UI thread.");
        this.f17129e.f5606i = com_google_android_gms_internal_zzjn;
        if (!(this.f17129e.f5607j == null || this.f17129e.f5607j.f6289b == null || this.f17129e.f5589F != 0)) {
            this.f17129e.f5607j.f6289b.mo3981a(zzapa.m5486a(com_google_android_gms_internal_zzjn));
        }
        if (this.f17129e.f5603f != null) {
            if (this.f17129e.f5603f.getChildCount() > 1) {
                this.f17129e.f5603f.removeView(this.f17129e.f5603f.getNextView());
            }
            this.f17129e.f5603f.setMinimumWidth(com_google_android_gms_internal_zzjn.f18157f);
            this.f17129e.f5603f.setMinimumHeight(com_google_android_gms_internal_zzjn.f18154c);
            this.f17129e.f5603f.requestLayout();
        }
    }

    public final void mo1992a(zzke com_google_android_gms_internal_zzke) {
        zzbq.m4816b("setAdListener must be called on the main UI thread.");
        this.f17129e.f5610m = com_google_android_gms_internal_zzke;
    }

    public final void mo1993a(zzkh com_google_android_gms_internal_zzkh) {
        zzbq.m4816b("setAdListener must be called on the main UI thread.");
        this.f17129e.f5611n = com_google_android_gms_internal_zzkh;
    }

    public final void mo1994a(zzkx com_google_android_gms_internal_zzkx) {
        zzbq.m4816b("setAppEventListener must be called on the main UI thread.");
        this.f17129e.f5612o = com_google_android_gms_internal_zzkx;
    }

    public final void mo1995a(zzld com_google_android_gms_internal_zzld) {
        zzbq.m4816b("setCorrelationIdProvider must be called on the main UI thread");
        this.f17129e.f5613p = com_google_android_gms_internal_zzld;
    }

    public final void mo1996a(zzlr com_google_android_gms_internal_zzlr) {
        zzbq.m4816b("setIconAdOptions must be called on the main UI thread.");
        this.f17129e.f5620w = com_google_android_gms_internal_zzlr;
    }

    public final void mo1997a(zzmr com_google_android_gms_internal_zzmr) {
        zzbq.m4816b("setVideoOptions must be called on the main UI thread.");
        this.f17129e.f5619v = com_google_android_gms_internal_zzmr;
    }

    public void mo1998a(zzoa com_google_android_gms_internal_zzoa) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void mo1999a(zzxl com_google_android_gms_internal_zzxl) {
        zzakb.m5371e("setInAppPurchaseListener is deprecated and should not be called.");
    }

    public final void mo2000a(zzxr com_google_android_gms_internal_zzxr, String str) {
        zzakb.m5371e("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    public final void mo2001a(String str) {
        zzbq.m4816b("setUserId must be called on the main UI thread.");
        this.f17129e.f5585B = str;
    }

    public final void mo3387a(String str, String str2) {
        if (this.f17129e.f5612o != null) {
            try {
                this.f17129e.f5612o.mo2017a(str, str2);
            } catch (Throwable e) {
                zzakb.m5369c("Could not call the AppEventListener.", e);
            }
        }
    }

    boolean mo3950a(zzafo com_google_android_gms_internal_zzafo) {
        return false;
    }

    public abstract boolean mo3951a(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2);

    protected abstract boolean mo3952a(zzjj com_google_android_gms_internal_zzjj, zznu com_google_android_gms_internal_zznu);

    protected final void m17453b(zzaeq com_google_android_gms_internal_zzaeq) {
        if (this.f17129e.f5584A != null) {
            try {
                String str = "";
                int i = 1;
                if (com_google_android_gms_internal_zzaeq != null) {
                    str = com_google_android_gms_internal_zzaeq.f17534a;
                    i = com_google_android_gms_internal_zzaeq.f17535b;
                }
                this.f17129e.f5584A.mo1676a(new zzadc(str, i));
            } catch (Throwable e) {
                zzakb.m5369c("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    public void mo2002b(boolean z) {
        zzakb.m5371e("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void mo2004c(boolean z) {
        throw new IllegalStateException("onImmersiveModeUpdated is not supported for current ad type");
    }

    protected boolean mo3954c(zzjj com_google_android_gms_internal_zzjj) {
        if (this.f17129e.f5603f == null) {
            return false;
        }
        ViewParent parent = this.f17129e.f5603f.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzbs.m4486e();
        return zzahn.m5180a(view, view.getContext());
    }

    protected void mo4272d(boolean z) {
        zzakb.m5370d("Ad finished loading.");
        this.f17127c = z;
        if (this.f17129e.f5611n != null) {
            try {
                this.f17129e.f5611n.mo1965c();
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.f17129e.f5584A != null) {
            try {
                this.f17129e.f5584A.mo1674a();
            } catch (Throwable e2) {
                zzakb.m5369c("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    public final void mo3390g() {
        m17474t();
    }

    public final zzv m17462h() {
        return this.f17132h;
    }

    public final IObjectWrapper mo2007j() {
        zzbq.m4816b("getAdFrame must be called on the main UI thread.");
        return zzn.m17692a(this.f17129e.f5603f);
    }

    public final zzjn mo2008k() {
        zzbq.m4816b("getAdSize must be called on the main UI thread.");
        return this.f17129e.f5606i == null ? null : new zzmp(this.f17129e.f5606i);
    }

    public final boolean mo2009l() {
        zzbq.m4816b("isLoaded must be called on the main UI thread.");
        return this.f17129e.f5604g == null && this.f17129e.f5605h == null && this.f17129e.f5607j != null;
    }

    public final void mo2010m() {
        zzbq.m4816b("recordManualImpression must be called on the main UI thread.");
        if (this.f17129e.f5607j == null) {
            zzakb.m5371e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzakb.m5366b("Pinging manual tracking URLs.");
        if (!this.f17129e.f5607j.f6279E) {
            List arrayList = new ArrayList();
            if (this.f17129e.f5607j.f6293f != null) {
                arrayList.addAll(this.f17129e.f5607j.f6293f);
            }
            if (!(this.f17129e.f5607j.f6301n == null || this.f17129e.f5607j.f6301n.f8053h == null)) {
                arrayList.addAll(this.f17129e.f5607j.f6301n.f8053h);
            }
            if (!arrayList.isEmpty()) {
                zzbs.m4486e();
                zzahn.m5170a(this.f17129e.f5600c, this.f17129e.f5602e.f17551a, arrayList);
                this.f17129e.f5607j.f6279E = true;
            }
        }
    }

    public void mo2011n() {
        zzbq.m4816b("pause must be called on the main UI thread.");
    }

    public void mo2012o() {
        zzbq.m4816b("resume must be called on the main UI thread.");
    }

    public final void mo2013p() {
        zzbq.m4816b("stopLoading must be called on the main UI thread.");
        this.f17127c = false;
        this.f17129e.m4511a(true);
    }

    public final boolean mo2014q() {
        return this.f17127c;
    }

    public zzll mo2015r() {
        return null;
    }

    public void mo4286s() {
        zzakb.m5370d("Ad closing.");
        if (this.f17129e.f5611n != null) {
            try {
                this.f17129e.f5611n.mo1962a();
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.f17129e.f5584A != null) {
            try {
                this.f17129e.f5584A.mo1679d();
            } catch (Throwable e2) {
                zzakb.m5369c("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected final void m17474t() {
        zzakb.m5370d("Ad leaving application.");
        if (this.f17129e.f5611n != null) {
            try {
                this.f17129e.f5611n.mo1964b();
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.f17129e.f5584A != null) {
            try {
                this.f17129e.f5584A.mo1680e();
            } catch (Throwable e2) {
                zzakb.m5369c("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected final void m17475u() {
        zzakb.m5370d("Ad opening.");
        if (this.f17129e.f5611n != null) {
            try {
                this.f17129e.f5611n.mo1966d();
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.f17129e.f5584A != null) {
            try {
                this.f17129e.f5584A.mo1677b();
            } catch (Throwable e2) {
                zzakb.m5369c("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void mo4273v() {
        mo4272d(false);
    }

    public final void m17477w() {
        zzakb.m5370d("Ad impression.");
        if (this.f17129e.f5611n != null) {
            try {
                this.f17129e.f5611n.mo1968f();
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdImpression().", e);
            }
        }
    }

    public final void m17478x() {
        zzakb.m5370d("Ad clicked.");
        if (this.f17129e.f5611n != null) {
            try {
                this.f17129e.f5611n.mo1967e();
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdClicked().", e);
            }
        }
    }

    protected final void m17479y() {
        if (this.f17129e.f5584A != null) {
            try {
                this.f17129e.f5584A.mo1678c();
            } catch (Throwable e) {
                zzakb.m5369c("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public final void m17480z() {
        zzafo com_google_android_gms_internal_zzafo = this.f17129e.f5607j;
        if (com_google_android_gms_internal_zzafo != null && !TextUtils.isEmpty(com_google_android_gms_internal_zzafo.f6275A) && !com_google_android_gms_internal_zzafo.f6280F && zzbs.m4495n().m5283b()) {
            zzakb.m5366b("Sending troubleshooting signals to the server.");
            zzbs.m4495n().m5281a(this.f17129e.f5600c, this.f17129e.f5602e.f17551a, com_google_android_gms_internal_zzafo.f6275A, this.f17129e.f5599b);
            com_google_android_gms_internal_zzafo.f6280F = true;
        }
    }

    zza(zzbt com_google_android_gms_ads_internal_zzbt, zzv com_google_android_gms_ads_internal_zzv) {
        this.f17129e = com_google_android_gms_ads_internal_zzbt;
        this.f17128d = new zzbi(this);
        this.f17132h = com_google_android_gms_ads_internal_zzv;
        com_google_android_gms_ads_internal_zzbt = zzbs.m4486e();
        com_google_android_gms_ads_internal_zzv = this.f17129e.f5600c;
        if (!com_google_android_gms_ads_internal_zzbt.f6380b) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            com_google_android_gms_ads_internal_zzv.getApplicationContext().registerReceiver(new zzahs(com_google_android_gms_ads_internal_zzbt), intentFilter);
            com_google_android_gms_ads_internal_zzbt.f6380b = true;
        }
        zzbs.m4486e().m5229b(this.f17129e.f5600c);
        zzagd.m5122a(this.f17129e.f5600c);
        zzbs.m4478A().m4434a(this.f17129e.f5600c);
        zzbs.m4490i().m13243a(this.f17129e.f5600c, this.f17129e.f5602e);
        zzbs.m4491j().m6319a(this.f17129e.f5600c);
        this.f17131g = zzbs.m4490i().f14073b;
        com_google_android_gms_ads_internal_zzbt = zzbs.m4489h();
        com_google_android_gms_ads_internal_zzv = this.f17129e.f5600c;
        synchronized (com_google_android_gms_ads_internal_zzbt.f7656a) {
            if (!com_google_android_gms_ads_internal_zzbt.f7658c) {
                if (((Boolean) zzkb.m6350f().m6488a(zznh.au)).booleanValue()) {
                    Context context = null;
                    Context applicationContext = com_google_android_gms_ads_internal_zzv.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = com_google_android_gms_ads_internal_zzv;
                    }
                    if (applicationContext instanceof Application) {
                        context = (Application) applicationContext;
                    }
                    if (context == null) {
                        zzakb.m5371e("Can not cast Context to Application");
                    } else {
                        if (com_google_android_gms_ads_internal_zzbt.f7657b == null) {
                            com_google_android_gms_ads_internal_zzbt.f7657b = new zzhh();
                        }
                        zzhh com_google_android_gms_internal_zzhh = com_google_android_gms_ads_internal_zzbt.f7657b;
                        if (!com_google_android_gms_internal_zzhh.f7663e) {
                            context.registerActivityLifecycleCallbacks(com_google_android_gms_internal_zzhh);
                            if (com_google_android_gms_ads_internal_zzv instanceof Activity) {
                                com_google_android_gms_internal_zzhh.m6290a((Activity) com_google_android_gms_ads_internal_zzv);
                            }
                            com_google_android_gms_internal_zzhh.f7660b = context;
                            com_google_android_gms_internal_zzhh.f7664f = ((Long) zzkb.m6350f().m6488a(zznh.av)).longValue();
                            com_google_android_gms_internal_zzhh.f7663e = true;
                        }
                        com_google_android_gms_ads_internal_zzbt.f7658c = true;
                    }
                }
            }
        }
        zzbs.m4480C().m5307a(this.f17129e.f5600c);
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bX)).booleanValue() != null) {
            Timer timer = new Timer();
            timer.schedule(new zzb(this, new CountDownLatch(((Integer) zzkb.m6350f().m6488a(zznh.bZ)).intValue()), timer), 0, ((Long) zzkb.m6350f().m6488a(zznh.bY)).longValue());
        }
    }

    public final void m17443a(zzns com_google_android_gms_internal_zzns) {
        this.f17125a = new zznu(((Boolean) zzkb.m6350f().m6488a(zznh.f7872H)).booleanValue(), "load_ad", this.f17129e.f5606i.f18152a);
        this.f17133i = new zzns(-1, null, null);
        if (com_google_android_gms_internal_zzns == null) {
            this.f17126b = new zzns(-1, null, null);
        } else {
            this.f17126b = new zzns(com_google_android_gms_internal_zzns.f7937a, com_google_android_gms_internal_zzns.f7938b, com_google_android_gms_internal_zzns.f7939c);
        }
    }

    public void mo2006i() {
        zzbq.m4816b("destroy must be called on the main UI thread.");
        this.f17128d.m4471a();
        zzfs com_google_android_gms_internal_zzfs = this.f17131g;
        zzafo com_google_android_gms_internal_zzafo = this.f17129e.f5607j;
        synchronized (com_google_android_gms_internal_zzfs.f14455a) {
            zzft com_google_android_gms_internal_zzft = (zzft) com_google_android_gms_internal_zzfs.f14456b.get(com_google_android_gms_internal_zzafo);
            if (com_google_android_gms_internal_zzft != null) {
                com_google_android_gms_internal_zzft.m6246e();
            }
        }
        zzbt com_google_android_gms_ads_internal_zzbt = this.f17129e;
        if (com_google_android_gms_ads_internal_zzbt.f5603f != null) {
            zzbu com_google_android_gms_ads_internal_zzbu = com_google_android_gms_ads_internal_zzbt.f5603f;
            zzagf.m13278a("Disable position monitoring on adFrame.");
            if (com_google_android_gms_ads_internal_zzbu.f5625b != null) {
                com_google_android_gms_ads_internal_zzbu.f5625b.m5315b();
            }
        }
        com_google_android_gms_ads_internal_zzbt.f5611n = null;
        com_google_android_gms_ads_internal_zzbt.f5612o = null;
        com_google_android_gms_ads_internal_zzbt.f5623z = null;
        com_google_android_gms_ads_internal_zzbt.f5613p = null;
        com_google_android_gms_ads_internal_zzbt.m4511a(false);
        if (com_google_android_gms_ads_internal_zzbt.f5603f != null) {
            com_google_android_gms_ads_internal_zzbt.f5603f.removeAllViews();
        }
        com_google_android_gms_ads_internal_zzbt.m4509a();
        com_google_android_gms_ads_internal_zzbt.m4512b();
        com_google_android_gms_ads_internal_zzbt.f5607j = null;
    }

    public boolean mo2003b(zzjj com_google_android_gms_internal_zzjj) {
        zza com_google_android_gms_ads_internal_zza = this;
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        zzbq.m4816b("loadAd must be called on the main UI thread.");
        zzid j = zzbs.m4491j();
        if (((Boolean) zzkb.m6350f().m6488a(zznh.cp)).booleanValue()) {
            synchronized (j.f7722b) {
                try {
                    j.m6318a();
                    zzbs.m4486e();
                    zzahn.f6379a.removeCallbacks(j.f7721a);
                    zzbs.m4486e();
                    zzahn.f6379a.postDelayed(j.f7721a, ((Long) zzkb.m6350f().m6488a(zznh.cq)).longValue());
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }
        }
        if (((Boolean) zzkb.m6350f().m6488a(zznh.aB)).booleanValue()) {
            zzjj.m18774a(com_google_android_gms_internal_zzjj);
        }
        if (zzi.m4903b(com_google_android_gms_ads_internal_zza.f17129e.f5600c) && com_google_android_gms_internal_zzjj2.f18144k != null) {
            zzjk com_google_android_gms_internal_zzjk = new zzjk(com_google_android_gms_internal_zzjj2);
            com_google_android_gms_internal_zzjk.f7747j = null;
            long j2 = com_google_android_gms_internal_zzjk.f7738a;
            Bundle bundle = com_google_android_gms_internal_zzjk.f7739b;
            int i = com_google_android_gms_internal_zzjk.f7740c;
            List list = com_google_android_gms_internal_zzjk.f7741d;
            boolean z = com_google_android_gms_internal_zzjk.f7742e;
            int i2 = com_google_android_gms_internal_zzjk.f7743f;
            boolean z2 = com_google_android_gms_internal_zzjk.f7744g;
            String str = com_google_android_gms_internal_zzjk.f7745h;
            zzmn com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzjk.f7746i;
            Location location = com_google_android_gms_internal_zzjk.f7747j;
            String str2 = com_google_android_gms_internal_zzjk.f7748k;
            Bundle bundle2 = com_google_android_gms_internal_zzjk.f7749l;
            Bundle bundle3 = com_google_android_gms_internal_zzjk.f7750m;
            Location location2 = location;
            zzjj com_google_android_gms_internal_zzjj3 = new zzjj(7, j2, bundle, i, list, z, i2, z2, str, com_google_android_gms_internal_zzmn, location2, str2, bundle2, bundle3, com_google_android_gms_internal_zzjk.f7751n, com_google_android_gms_internal_zzjk.f7752o, com_google_android_gms_internal_zzjk.f7753p, false);
        }
        if (com_google_android_gms_ads_internal_zza.f17129e.f5604g == null) {
            if (com_google_android_gms_ads_internal_zza.f17129e.f5605h == null) {
                String str3;
                zzakb.m5370d("Starting ad request.");
                m17443a(null);
                com_google_android_gms_ads_internal_zza.f17126b = com_google_android_gms_ads_internal_zza.f17125a.m6502a();
                if (com_google_android_gms_internal_zzjj2.f18139f) {
                    str3 = "This request is sent from a test device.";
                } else {
                    zzkb.m6345a();
                    str3 = zzajr.m5320a(com_google_android_gms_ads_internal_zza.f17129e.f5600c);
                    StringBuilder stringBuilder = new StringBuilder(71 + String.valueOf(str3).length());
                    stringBuilder.append("Use AdRequest.Builder.addTestDevice(\"");
                    stringBuilder.append(str3);
                    stringBuilder.append("\") to get test ads on this device.");
                    str3 = stringBuilder.toString();
                }
                zzakb.m5370d(str3);
                com_google_android_gms_ads_internal_zza.f17128d.f5533a = com_google_android_gms_internal_zzjj2;
                com_google_android_gms_ads_internal_zza.f17127c = mo3952a(com_google_android_gms_internal_zzjj2, com_google_android_gms_ads_internal_zza.f17125a);
                return com_google_android_gms_ads_internal_zza.f17127c;
            }
        }
        zzakb.m5371e(com_google_android_gms_ads_internal_zza.f17130f != null ? "Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes." : "Loading already in progress, saving this object for future refreshes.");
        com_google_android_gms_ads_internal_zza.f17130f = com_google_android_gms_internal_zzjj2;
        return false;
    }

    public final void mo3386a(zzafp com_google_android_gms_internal_zzafp) {
        if (!(com_google_android_gms_internal_zzafp.f6315b.f17453m == -1 || TextUtils.isEmpty(com_google_android_gms_internal_zzafp.f6315b.f17463w))) {
            long b = mo4271b(com_google_android_gms_internal_zzafp.f6315b.f17463w);
            if (b != -1) {
                this.f17125a.m6506a(this.f17125a.m6503a(com_google_android_gms_internal_zzafp.f6315b.f17453m + b), "stc");
            }
        }
        zznu com_google_android_gms_internal_zznu = this.f17125a;
        String str = com_google_android_gms_internal_zzafp.f6315b.f17463w;
        if (com_google_android_gms_internal_zznu.f7942a) {
            synchronized (com_google_android_gms_internal_zznu.f7943b) {
                com_google_android_gms_internal_zznu.f7944c = str;
            }
        }
        this.f17125a.m6506a(this.f17126b, "arf");
        this.f17133i = this.f17125a.m6502a();
        this.f17125a.m6504a("gqi", com_google_android_gms_internal_zzafp.f6315b.f17464x);
        this.f17129e.f5604g = null;
        this.f17129e.f5608k = com_google_android_gms_internal_zzafp;
        com_google_android_gms_internal_zzafp.f6322i.m6325a(new zzc(com_google_android_gms_internal_zzafp));
        com_google_android_gms_internal_zzafp.f6322i.m6326a(com.google.android.gms.internal.zziu.zza.zzb.AD_LOADED);
        mo4267a(com_google_android_gms_internal_zzafp, this.f17125a);
    }

    public void mo3389b(zzafo com_google_android_gms_internal_zzafo) {
        this.f17125a.m6506a(this.f17133i, "awr");
        this.f17129e.f5605h = null;
        if (!(com_google_android_gms_internal_zzafo.f6291d == -2 || com_google_android_gms_internal_zzafo.f6291d == 3 || this.f17129e.f5591H == null)) {
            zzaft i = zzbs.m4490i();
            Collection collection = this.f17129e.f5591H;
            synchronized (i.f14072a) {
                i.f14074c.addAll(collection);
            }
        }
        if (com_google_android_gms_internal_zzafo.f6291d == -1) {
            this.f17127c = null;
            return;
        }
        if (mo3950a(com_google_android_gms_internal_zzafo)) {
            zzakb.m5366b("Ad refresh scheduled.");
        }
        if (com_google_android_gms_internal_zzafo.f6291d != -2) {
            zzis com_google_android_gms_internal_zzis;
            com.google.android.gms.internal.zziu.zza.zzb com_google_android_gms_internal_zziu_zza_zzb;
            if (com_google_android_gms_internal_zzafo.f6291d == 3) {
                com_google_android_gms_internal_zzis = com_google_android_gms_internal_zzafo.f6282H;
                com_google_android_gms_internal_zziu_zza_zzb = com.google.android.gms.internal.zziu.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL;
            } else {
                com_google_android_gms_internal_zzis = com_google_android_gms_internal_zzafo.f6282H;
                com_google_android_gms_internal_zziu_zza_zzb = com.google.android.gms.internal.zziu.zza.zzb.AD_FAILED_TO_LOAD;
            }
            com_google_android_gms_internal_zzis.m6326a(com_google_android_gms_internal_zziu_zza_zzb);
            mo4265a(com_google_android_gms_internal_zzafo.f6291d);
            return;
        }
        if (this.f17129e.f5587D == null) {
            this.f17129e.f5587D = new zzafz(this.f17129e.f5599b);
        }
        if (this.f17129e.f5603f != null) {
            this.f17129e.f5603f.f5624a.f6397d = com_google_android_gms_internal_zzafo.f6275A;
        }
        this.f17131g.m13915a(this.f17129e.f5607j);
        if (mo3951a(this.f17129e.f5607j, com_google_android_gms_internal_zzafo)) {
            this.f17129e.f5607j = com_google_android_gms_internal_zzafo;
            zzbt com_google_android_gms_ads_internal_zzbt = this.f17129e;
            if (com_google_android_gms_ads_internal_zzbt.f5609l != null) {
                zzafq com_google_android_gms_internal_zzafq;
                if (com_google_android_gms_ads_internal_zzbt.f5607j != null) {
                    com_google_android_gms_internal_zzafq = com_google_android_gms_ads_internal_zzbt.f5609l;
                    long j = com_google_android_gms_ads_internal_zzbt.f5607j.f6311x;
                    synchronized (com_google_android_gms_internal_zzafq.f6326c) {
                        com_google_android_gms_internal_zzafq.f6333j = j;
                        if (com_google_android_gms_internal_zzafq.f6333j != -1) {
                            com_google_android_gms_internal_zzafq.f6324a.m13245a(com_google_android_gms_internal_zzafq);
                        }
                    }
                    com_google_android_gms_internal_zzafq = com_google_android_gms_ads_internal_zzbt.f5609l;
                    j = com_google_android_gms_ads_internal_zzbt.f5607j.f6312y;
                    synchronized (com_google_android_gms_internal_zzafq.f6326c) {
                        if (com_google_android_gms_internal_zzafq.f6333j != -1) {
                            com_google_android_gms_internal_zzafq.f6327d = j;
                            com_google_android_gms_internal_zzafq.f6324a.m13245a(com_google_android_gms_internal_zzafq);
                        }
                    }
                    com_google_android_gms_internal_zzafq = com_google_android_gms_ads_internal_zzbt.f5609l;
                    boolean z = com_google_android_gms_ads_internal_zzbt.f5607j.f6300m;
                    synchronized (com_google_android_gms_internal_zzafq.f6326c) {
                        if (com_google_android_gms_internal_zzafq.f6333j != -1) {
                            com_google_android_gms_internal_zzafq.f6329f = z;
                            com_google_android_gms_internal_zzafq.f6324a.m13245a(com_google_android_gms_internal_zzafq);
                        }
                    }
                }
                com_google_android_gms_internal_zzafq = com_google_android_gms_ads_internal_zzbt.f5609l;
                boolean z2 = com_google_android_gms_ads_internal_zzbt.f5606i.f18155d;
                synchronized (com_google_android_gms_internal_zzafq.f6326c) {
                    if (com_google_android_gms_internal_zzafq.f6333j != -1) {
                        com_google_android_gms_internal_zzafq.f6330g = SystemClock.elapsedRealtime();
                        if (!z2) {
                            com_google_android_gms_internal_zzafq.f6328e = com_google_android_gms_internal_zzafq.f6330g;
                            com_google_android_gms_internal_zzafq.f6324a.m13245a(com_google_android_gms_internal_zzafq);
                        }
                    }
                }
            }
            this.f17125a.m6504a("is_mraid", this.f17129e.f5607j.m5110a() ? "1" : "0");
            this.f17125a.m6504a("is_mediation", this.f17129e.f5607j.f6300m ? "1" : "0");
            if (!(this.f17129e.f5607j.f6289b == null || this.f17129e.f5607j.f6289b.mo4019w() == null)) {
                this.f17125a.m6504a("is_delay_pl", this.f17129e.f5607j.f6289b.mo4019w().m5454e() ? "1" : "0");
            }
            this.f17125a.m6506a(this.f17126b, "ttc");
            if (zzbs.m4490i().m13257e() != null) {
                zzbs.m4490i().m13257e().m6496a(this.f17125a);
            }
            m17480z();
            if (this.f17129e.m4513c()) {
                mo4273v();
            }
        }
        if (com_google_android_gms_internal_zzafo.f6281G != null) {
            zzbs.m4486e();
            zzahn.m5171a(this.f17129e.f5600c, com_google_android_gms_internal_zzafo.f6281G);
        }
    }

    public void mo1263e() {
        if (this.f17129e.f5607j == null) {
            zzakb.m5371e("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzakb.m5366b("Pinging click URLs.");
        if (this.f17129e.f5609l != null) {
            zzafq com_google_android_gms_internal_zzafq = this.f17129e.f5609l;
            synchronized (com_google_android_gms_internal_zzafq.f6326c) {
                if (com_google_android_gms_internal_zzafq.f6333j != -1) {
                    zzafr com_google_android_gms_internal_zzafr = new zzafr();
                    com_google_android_gms_internal_zzafr.f6336a = SystemClock.elapsedRealtime();
                    com_google_android_gms_internal_zzafq.f6325b.add(com_google_android_gms_internal_zzafr);
                    com_google_android_gms_internal_zzafq.f6331h++;
                    zzafx d = com_google_android_gms_internal_zzafq.f6324a.m13255d();
                    synchronized (d.f6357f) {
                        d.f6358g++;
                    }
                    com_google_android_gms_internal_zzafq.f6324a.m13245a(com_google_android_gms_internal_zzafq);
                }
            }
        }
        if (this.f17129e.f5607j.f6290c != null) {
            zzbs.m4486e();
            zzahn.m5170a(this.f17129e.f5600c, this.f17129e.f5602e.f17551a, m17429a(this.f17129e.f5607j.f6290c));
        }
        if (this.f17129e.f5610m != null) {
            try {
                this.f17129e.f5610m.mo1961a();
            } catch (Throwable e) {
                zzakb.m5369c("Could not notify onAdClicked event.", e);
            }
        }
    }

    public final void mo3388a(HashSet<zzafq> hashSet) {
        this.f17129e.f5591H = hashSet;
    }
}
