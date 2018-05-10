package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.gmsg.zzaf;
import com.google.android.gms.ads.internal.gmsg.zzag;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaat;
import com.google.android.gms.internal.zzaax;
import com.google.android.gms.internal.zzacg;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafe;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzajg;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanr;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzzv
public final class zzak extends zzi implements zzag, zzx {
    private transient boolean f19795i = false;
    private int f19796j = -1;
    private boolean f19797k;
    private float f19798l;
    private boolean f19799n;
    private zzafe f19800o;
    private String f19801p;
    private final String f19802q;

    public zzak(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, zzv com_google_android_gms_ads_internal_zzv) {
        super(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv);
        String str2 = (com_google_android_gms_internal_zzjn == null || !"reward_mb".equals(com_google_android_gms_internal_zzjn.f18152a)) ? "/Interstitial" : "/Rewarded";
        this.f19802q = str2;
    }

    private final void m21504a(Bundle bundle) {
        zzbs.m4486e();
        zzahn.m5193b(this.e.f5600c, this.e.f5602e.f17551a, "gmob-apps", bundle, false);
    }

    private static zzafp m21507b(zzafp com_google_android_gms_internal_zzafp) {
        zzafp com_google_android_gms_internal_zzafp2;
        zzafp com_google_android_gms_internal_zzafp3 = com_google_android_gms_internal_zzafp;
        try {
            String jSONObject = zzacg.m4992a(com_google_android_gms_internal_zzafp3.f6315b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, com_google_android_gms_internal_zzafp3.f6314a.f17398e);
            zzuh com_google_android_gms_internal_zzuh = new zzuh(jSONObject, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
            zzaax com_google_android_gms_internal_zzaax = com_google_android_gms_internal_zzafp3.f6315b;
            zzui com_google_android_gms_internal_zzui = new zzui(Collections.singletonList(com_google_android_gms_internal_zzuh), ((Long) zzkb.m6350f().m6488a(zznh.bn)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzaax.f17428H, com_google_android_gms_internal_zzaax.f17429I, "");
            zzaat com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzafp3.f6314a;
            String str = com_google_android_gms_internal_zzaax.f17441a;
            String str2 = com_google_android_gms_internal_zzaax.f17442b;
            List emptyList = Collections.emptyList();
            List emptyList2 = Collections.emptyList();
            long j = com_google_android_gms_internal_zzaax.f17446f;
            long j2 = com_google_android_gms_internal_zzaax.f17448h;
            List emptyList3 = Collections.emptyList();
            long j3 = com_google_android_gms_internal_zzaax.f17450j;
            int i = com_google_android_gms_internal_zzaax.f17451k;
            String str3 = com_google_android_gms_internal_zzaax.f17452l;
            int i2 = i;
            zzui com_google_android_gms_internal_zzui2 = com_google_android_gms_internal_zzui;
            long j4 = com_google_android_gms_internal_zzaax.f17453m;
            String str4 = com_google_android_gms_internal_zzaax.f17454n;
            boolean z = com_google_android_gms_internal_zzaax.f17455o;
            String str5 = com_google_android_gms_internal_zzaax.f17456p;
            boolean z2 = com_google_android_gms_internal_zzaax.f17458r;
            boolean z3 = com_google_android_gms_internal_zzaax.f17459s;
            boolean z4 = com_google_android_gms_internal_zzaax.f17460t;
            boolean z5 = com_google_android_gms_internal_zzaax.f17461u;
            boolean z6 = com_google_android_gms_internal_zzaax.f17462v;
            String str6 = com_google_android_gms_internal_zzaax.f17464x;
            boolean z7 = com_google_android_gms_internal_zzaax.f17465y;
            boolean z8 = com_google_android_gms_internal_zzaax.f17466z;
            boolean z9 = z8;
            zzaat com_google_android_gms_internal_zzaat2 = com_google_android_gms_internal_zzaat;
            String str7 = str;
            String str8 = str2;
            long j5 = j;
            long j6 = j2;
            long j7 = j3;
            int i3 = i2;
            zzaax com_google_android_gms_internal_zzaax2 = new zzaax(com_google_android_gms_internal_zzaat2, str7, str8, emptyList, emptyList2, j5, true, j6, emptyList3, j7, i3, str3, j4, str4, z, str5, null, z2, z3, z4, z5, z6, str6, z7, z9, null, Collections.emptyList(), Collections.emptyList(), com_google_android_gms_internal_zzaax.f17424D, com_google_android_gms_internal_zzaax.f17425E, com_google_android_gms_internal_zzaax.f17426F, com_google_android_gms_internal_zzaax.f17427G, com_google_android_gms_internal_zzaax.f17428H, com_google_android_gms_internal_zzaax.f17429I, com_google_android_gms_internal_zzaax.f17430J, null, com_google_android_gms_internal_zzaax.f17432L, com_google_android_gms_internal_zzaax.f17433M, com_google_android_gms_internal_zzaax.f17434N, com_google_android_gms_internal_zzaax.f17435O);
            com_google_android_gms_internal_zzafp2 = com_google_android_gms_internal_zzafp;
            return new zzafp(com_google_android_gms_internal_zzafp2.f6314a, com_google_android_gms_internal_zzaax2, com_google_android_gms_internal_zzui2, com_google_android_gms_internal_zzafp2.f6317d, com_google_android_gms_internal_zzafp2.f6318e, com_google_android_gms_internal_zzafp2.f6319f, com_google_android_gms_internal_zzafp2.f6320g, null, com_google_android_gms_internal_zzafp2.f6322i, null);
        } catch (Throwable e) {
            com_google_android_gms_internal_zzafp2 = com_google_android_gms_internal_zzafp3;
            zzakb.m5367b("Unable to generate ad state for an interstitial ad with pooling.", e);
            return com_google_android_gms_internal_zzafp2;
        }
    }

    protected final boolean m21510E() {
        if (!(this.e.f5600c instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.e.f5600c).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        if (!(rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top)) {
            return true;
        }
        return false;
    }

    protected final zzanh mo4379a(zzafp com_google_android_gms_internal_zzafp, zzw com_google_android_gms_ads_internal_zzw, zzafb com_google_android_gms_internal_zzafb) throws zzanv {
        zzbs.m4487f();
        zzanh a = zzanr.m5464a(this.e.f5600c, zzapa.m5486a(this.e.f5606i), this.e.f5606i.f18152a, false, false, this.e.f5601d, this.e.f5602e, this.a, this, this.h, com_google_android_gms_internal_zzafp.f6322i);
        a.mo4019w().m5445a(this, null, this, this, ((Boolean) zzkb.m6350f().m6488a(zznh.ac)).booleanValue(), this, com_google_android_gms_ads_internal_zzw, null, com_google_android_gms_internal_zzafb);
        m20893a(a);
        a.mo3991b(com_google_android_gms_internal_zzafp.f6314a.f17415v);
        a.mo4019w().m5446a("/reward", new zzaf(this));
        return a;
    }

    public final void mo4380a(zzaeq com_google_android_gms_internal_zzaeq) {
        if (this.e.f5607j != null) {
            if (this.e.f5607j.f6310w != null) {
                zzbs.m4486e();
                zzahn.m5170a(this.e.f5600c, this.e.f5602e.f17551a, this.e.f5607j.f6310w);
            }
            if (this.e.f5607j.f6308u != null) {
                com_google_android_gms_internal_zzaeq = this.e.f5607j.f6308u;
            }
        }
        m17453b(com_google_android_gms_internal_zzaeq);
    }

    public final void mo4267a(zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu) {
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.aF)).booleanValue()) {
            super.mo4267a(com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zznu);
        } else if (com_google_android_gms_internal_zzafp.f6318e != -2) {
            super.mo4267a(com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zznu);
        } else {
            int i = com_google_android_gms_internal_zzafp.f6315b.f17447g ^ 1;
            if (zza.m17424a(com_google_android_gms_internal_zzafp.f6314a.f17396c) && i != 0) {
                this.e.f5608k = m21507b(com_google_android_gms_internal_zzafp);
            }
            super.mo4267a(this.e.f5608k, com_google_android_gms_internal_zznu);
        }
    }

    public final void mo4381a(boolean z) {
        this.e.f5590G = z;
    }

    public final void mo4382a(boolean z, float f) {
        this.f19797k = z;
        this.f19798l = f;
    }

    public final boolean mo3951a(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        if (!super.mo3951a(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzafo2)) {
            return false;
        }
        if (!(this.e.m4513c() || this.e.f5588E == null || com_google_android_gms_internal_zzafo2.f6297j == null)) {
            this.g.m13918a(this.e.f5606i, com_google_android_gms_internal_zzafo2, this.e.f5588E);
        }
        return true;
    }

    public final boolean mo3952a(zzjj com_google_android_gms_internal_zzjj, zznu com_google_android_gms_internal_zznu) {
        if (this.e.f5607j != null) {
            zzakb.m5371e("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.f19800o == null && zza.m17424a(com_google_android_gms_internal_zzjj) && zzbs.m4507z().m5099d(this.e.f5600c) && !TextUtils.isEmpty(this.e.f5599b)) {
            this.f19800o = new zzafe(this.e.f5600c, this.e.f5599b);
        }
        return super.mo3952a(com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zznu);
    }

    public final void mo1753b() {
        super.mo1753b();
        this.g.m13915a(this.e.f5607j);
        if (this.f19800o != null) {
            this.f19800o.m13229a(false);
        }
    }

    public final void mo2004c(boolean z) {
        zzbq.m4816b("setImmersiveMode must be called on the main UI thread.");
        this.f19799n = z;
    }

    public final void d_() {
        if (!(this.e.f5607j == null || this.e.f5607j.f6309v == null)) {
            zzbs.m4486e();
            zzahn.m5170a(this.e.f5600c, this.e.f5602e.f17551a, this.e.f5607j.f6309v);
        }
        m17479y();
    }

    protected final void mo4286s() {
        m21511F();
        super.mo4286s();
    }

    protected final void mo4273v() {
        super.mo4273v();
        this.f19795i = true;
    }

    protected final boolean mo4270a(zzjj com_google_android_gms_internal_zzjj, zzafo com_google_android_gms_internal_zzafo, boolean z) {
        if (!(this.e.m4513c() == null || com_google_android_gms_internal_zzafo.f6289b == null)) {
            zzbs.m4488g();
            zzaht.m5232a(com_google_android_gms_internal_zzafo.f6289b);
        }
        return this.d.f5534b;
    }

    public final void mo1756f() {
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
        r9 = this;
        r9.m20151U();
        super.mo1756f();
        r0 = r9.e;
        r0 = r0.f5607j;
        if (r0 == 0) goto L_0x0023;
    L_0x000c:
        r0 = r9.e;
        r0 = r0.f5607j;
        r0 = r0.f6289b;
        if (r0 == 0) goto L_0x0023;
    L_0x0014:
        r0 = r9.e;
        r0 = r0.f5607j;
        r0 = r0.f6289b;
        r0 = r0.mo4019w();
        if (r0 == 0) goto L_0x0023;
    L_0x0020:
        r0.m5456g();
    L_0x0023:
        r0 = com.google.android.gms.ads.internal.zzbs.m4507z();
        r1 = r9.e;
        r1 = r1.f5600c;
        r0 = r0.m5099d(r1);
        r1 = 1;
        if (r0 == 0) goto L_0x008b;
    L_0x0032:
        r0 = r9.e;
        r0 = r0.f5607j;
        if (r0 == 0) goto L_0x008b;
    L_0x0038:
        r0 = r9.e;
        r0 = r0.f5607j;
        r0 = r0.f6289b;
        if (r0 == 0) goto L_0x008b;
    L_0x0040:
        r0 = com.google.android.gms.ads.internal.zzbs.m4507z();
        r2 = r9.e;
        r2 = r2.f5607j;
        r2 = r2.f6289b;
        r2 = r2.getContext();
        r3 = r9.f19801p;
        r4 = r0.m5090a(r2);
        if (r4 == 0) goto L_0x008b;
    L_0x0056:
        r4 = r2 instanceof android.app.Activity;
        if (r4 == 0) goto L_0x008b;
    L_0x005a:
        r4 = "com.google.firebase.analytics.FirebaseAnalytics";
        r5 = r0.f6262a;
        r6 = 0;
        r4 = r0.m5091a(r2, r4, r5, r6);
        if (r4 == 0) goto L_0x008b;
    L_0x0065:
        r4 = "setCurrentScreen";
        r4 = r0.m5098d(r2, r4);
        r5 = r2;	 Catch:{ Exception -> 0x0086 }
        r5 = (android.app.Activity) r5;	 Catch:{ Exception -> 0x0086 }
        r7 = r0.f6262a;	 Catch:{ Exception -> 0x0086 }
        r7 = r7.get();	 Catch:{ Exception -> 0x0086 }
        r8 = 3;	 Catch:{ Exception -> 0x0086 }
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0086 }
        r8[r6] = r5;	 Catch:{ Exception -> 0x0086 }
        r8[r1] = r3;	 Catch:{ Exception -> 0x0086 }
        r3 = 2;	 Catch:{ Exception -> 0x0086 }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x0086 }
        r8[r3] = r2;	 Catch:{ Exception -> 0x0086 }
        r4.invoke(r7, r8);	 Catch:{ Exception -> 0x0086 }
        goto L_0x008b;
    L_0x0086:
        r2 = "setCurrentScreen";
        r0.m5094b(r2, r6);
    L_0x008b:
        r0 = r9.f19800o;
        if (r0 == 0) goto L_0x0094;
    L_0x008f:
        r0 = r9.f19800o;
        r0.m13229a(r1);
    L_0x0094:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzak.f():void");
    }

    public final void mo1988D() {
        zzbq.m4816b("showInterstitial must be called on the main UI thread.");
        if (zzbs.m4507z().m5099d(this.e.f5600c)) {
            this.f19801p = zzbs.m4507z().m5101f(this.e.f5600c);
            String valueOf = String.valueOf(this.f19801p);
            String valueOf2 = String.valueOf(this.f19802q);
            this.f19801p = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        if (this.e.f5607j == null) {
            zzakb.m5371e("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bd)).booleanValue()) {
            Bundle bundle;
            valueOf = (this.e.f5600c.getApplicationContext() != null ? this.e.f5600c.getApplicationContext() : this.e.f5600c).getPackageName();
            if (!this.f19795i) {
                zzakb.m5371e("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", valueOf);
                bundle.putString("action", "show_interstitial_before_load_finish");
                m21504a(bundle);
            }
            zzbs.m4486e();
            if (!zzahn.m5212f(this.e.f5600c)) {
                zzakb.m5371e("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", valueOf);
                bundle.putString("action", "show_interstitial_app_not_in_foreground");
                m21504a(bundle);
            }
        }
        if (!this.e.m4514d()) {
            if (this.e.f5607j.f6300m && this.e.f5607j.f6302o != null) {
                try {
                    if (((Boolean) zzkb.m6350f().m6488a(zznh.aD)).booleanValue()) {
                        this.e.f5607j.f6302o.mo2181a(this.f19799n);
                    }
                    this.e.f5607j.f6302o.mo2182b();
                } catch (Throwable e) {
                    zzakb.m5369c("Could not show interstitial.", e);
                    m21511F();
                }
            } else if (this.e.f5607j.f6289b == null) {
                zzakb.m5371e("The interstitial failed to load.");
            } else if (this.e.f5607j.f6289b.mo3476z()) {
                zzakb.m5371e("The interstitial is already showing.");
            } else {
                this.e.f5607j.f6289b.mo3993b(true);
                zzbt com_google_android_gms_ads_internal_zzbt = this.e;
                zzanh com_google_android_gms_internal_zzanh = this.e.f5607j.f6289b;
                Object obj = null;
                if (com_google_android_gms_internal_zzanh == null) {
                    throw null;
                }
                int i;
                com_google_android_gms_ads_internal_zzbt.m4510a((View) com_google_android_gms_internal_zzanh);
                if (this.e.f5607j.f6297j != null) {
                    this.g.m13917a(this.e.f5606i, this.e.f5607j);
                }
                zzafo com_google_android_gms_internal_zzafo = this.e.f5607j;
                if (com_google_android_gms_internal_zzafo.m5110a()) {
                    Context context = this.e.f5600c;
                    zzanh com_google_android_gms_internal_zzanh2 = com_google_android_gms_internal_zzafo.f6289b;
                    if (com_google_android_gms_internal_zzanh2 == null) {
                        throw null;
                    }
                    new zzgp(context, (View) com_google_android_gms_internal_zzanh2).m6265a(com_google_android_gms_internal_zzafo.f6289b);
                } else {
                    com_google_android_gms_internal_zzafo.f6289b.mo4019w().f6619f = new zzal(this, com_google_android_gms_internal_zzafo);
                }
                if (this.e.f5590G) {
                    zzbs.m4486e();
                    obj = zzahn.m5213g(this.e.f5600c);
                }
                zzajg w = zzbs.m4504w();
                if (obj == null) {
                    zzakb.m5366b("Bitmap is null. Skipping putting into the Memory Map.");
                    i = -1;
                } else {
                    i = w.f6448b.getAndIncrement();
                    w.f6447a.put(Integer.valueOf(i), obj);
                }
                this.f19796j = i;
                if (!((Boolean) zzkb.m6350f().m6488a(zznh.bE)).booleanValue() || obj == null) {
                    zzao com_google_android_gms_ads_internal_zzao = new zzao(this.e.f5590G, m21510E(), false, 0.0f, -1, this.f19799n, this.e.f5607j.f6283I);
                    int A = this.e.f5607j.f6289b.mo3964A();
                    AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.e.f5607j.f6289b, A == -1 ? this.e.f5607j.f6294g : A, this.e.f5602e, this.e.f5607j.f6313z, com_google_android_gms_ads_internal_zzao);
                    zzbs.m4484c();
                    zzl.m4450a(this.e.f5600c, adOverlayInfoParcel, true);
                    return;
                }
                new zzam(this, this.f19796j).m13277h();
            }
        }
    }

    public final void m21511F() {
        zzajg w = zzbs.m4504w();
        w.f6447a.remove(Integer.valueOf(this.f19796j));
        if (this.e.m4513c()) {
            this.e.m4509a();
            this.e.f5607j = null;
            this.e.f5590G = false;
            this.f19795i = false;
        }
    }
}
