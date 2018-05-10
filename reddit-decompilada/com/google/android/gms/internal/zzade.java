package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzbt;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public final class zzade extends zzd implements zzaef {
    private static zzade f19558j;
    private static final zzuw f19559k = new zzuw();
    final Map<String, zzael> f19560i = new HashMap();
    private boolean f19561l;
    private boolean f19562n;
    private zzafe f19563o;

    public zzade(Context context, zzv com_google_android_gms_ads_internal_zzv, zzjn com_google_android_gms_internal_zzjn, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd) {
        super(context, com_google_android_gms_internal_zzjn, null, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv);
        f19558j = this;
        this.f19563o = new zzafe(context, null);
    }

    public static zzade m20932E() {
        return f19558j;
    }

    private static zzafp m20934b(zzafp com_google_android_gms_internal_zzafp) {
        zzafp com_google_android_gms_internal_zzafp2 = com_google_android_gms_internal_zzafp;
        zzagf.m13278a("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zzacg.m4992a(com_google_android_gms_internal_zzafp2.f6315b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, com_google_android_gms_internal_zzafp2.f6314a.f17398e);
            zzuh com_google_android_gms_internal_zzuh = new zzuh(jSONObject, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
            zzui com_google_android_gms_internal_zzui = new zzui(Arrays.asList(new zzuh[]{com_google_android_gms_internal_zzuh}), ((Long) zzkb.m6350f().m6488a(zznh.bn)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "");
            return new zzafp(com_google_android_gms_internal_zzafp2.f6314a, com_google_android_gms_internal_zzafp2.f6315b, com_google_android_gms_internal_zzui, com_google_android_gms_internal_zzafp2.f6317d, com_google_android_gms_internal_zzafp2.f6318e, com_google_android_gms_internal_zzafp2.f6319f, com_google_android_gms_internal_zzafp2.f6320g, com_google_android_gms_internal_zzafp2.f6321h, com_google_android_gms_internal_zzafp2.f6322i, null);
        } catch (Throwable e) {
            zzakb.m5367b("Unable to generate ad state for non-mediated rewarded video.", e);
            return new zzafp(com_google_android_gms_internal_zzafp2.f6314a, com_google_android_gms_internal_zzafp2.f6315b, null, com_google_android_gms_internal_zzafp2.f6317d, 0, com_google_android_gms_internal_zzafp2.f6319f, com_google_android_gms_internal_zzafp2.f6320g, com_google_android_gms_internal_zzafp2.f6321h, com_google_android_gms_internal_zzafp2.f6322i, null);
        }
    }

    public final boolean m20936G() {
        zzbq.m4816b("isLoaded must be called on the main UI thread.");
        return this.e.f5604g == null && this.e.f5605h == null && this.e.f5607j != null && !this.f19561l;
    }

    public final void mo4280H() {
        if (zzbs.m4507z().m5100e(this.e.f5600c)) {
            this.f19563o.m13229a(true);
        }
        mo4385a(this.e.f5607j, false);
        m17475u();
    }

    public final void mo4281I() {
        if (!(this.e.f5607j == null || this.e.f5607j.f6301n == null)) {
            zzbs.m4503v();
            zzuq.m6686a(this.e.f5600c, this.e.f5602e.f17551a, this.e.f5607j, this.e.f5599b, false, this.e.f5607j.f6301n.f8056k);
        }
        m17479y();
    }

    public final void mo4282J() {
        if (zzbs.m4507z().m5100e(this.e.f5600c)) {
            this.f19563o.m13229a(false);
        }
        mo4286s();
    }

    public final void mo4283K() {
        mo1263e();
    }

    public final void mo4284L() {
        m17474t();
    }

    public final void mo4267a(zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu) {
        if (com_google_android_gms_internal_zzafp.f6318e != -2) {
            zzahn.f6379a.post(new zzadg(this, com_google_android_gms_internal_zzafp));
            return;
        }
        this.e.f5608k = com_google_android_gms_internal_zzafp;
        if (com_google_android_gms_internal_zzafp.f6316c == null) {
            this.e.f5608k = m20934b(com_google_android_gms_internal_zzafp);
        }
        this.e.f5589F = 0;
        zzbt com_google_android_gms_ads_internal_zzbt = this.e;
        zzbs.m4485d();
        zzaif com_google_android_gms_internal_zzaei = new zzaei(this.e.f5600c, this.e.f5608k, this);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(com_google_android_gms_internal_zzaei.getClass().getName());
        zzakb.m5366b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        com_google_android_gms_internal_zzaei.mo1645e();
        com_google_android_gms_ads_internal_zzbt.f5605h = com_google_android_gms_internal_zzaei;
    }

    public final boolean mo3951a(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        return true;
    }

    protected final boolean mo4270a(zzjj com_google_android_gms_internal_zzjj, zzafo com_google_android_gms_internal_zzafo, boolean z) {
        return false;
    }

    public final zzael mo4271b(String str) {
        Throwable e;
        String str2;
        zzael com_google_android_gms_internal_zzael = (zzael) this.f19560i.get(str);
        if (com_google_android_gms_internal_zzael == null) {
            try {
                zzux com_google_android_gms_internal_zzux = this.m;
                if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                    com_google_android_gms_internal_zzux = f19559k;
                }
                zzael com_google_android_gms_internal_zzael2 = new zzael(com_google_android_gms_internal_zzux.mo2168a(str), this);
                try {
                    this.f19560i.put(str, com_google_android_gms_internal_zzael2);
                    return com_google_android_gms_internal_zzael2;
                } catch (Exception e2) {
                    e = e2;
                    com_google_android_gms_internal_zzael = com_google_android_gms_internal_zzael2;
                    str2 = "Fail to instantiate adapter ";
                    str = String.valueOf(str);
                    zzakb.m5369c(str.length() == 0 ? new String(str2) : str2.concat(str), e);
                    return com_google_android_gms_internal_zzael;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = "Fail to instantiate adapter ";
                str = String.valueOf(str);
                if (str.length() == 0) {
                }
                zzakb.m5369c(str.length() == 0 ? new String(str2) : str2.concat(str), e);
                return com_google_android_gms_internal_zzael;
            }
        }
        return com_google_android_gms_internal_zzael;
    }

    public final void mo2004c(boolean z) {
        zzbq.m4816b("setImmersiveMode must be called on the main UI thread.");
        this.f19562n = z;
    }

    protected final void mo4286s() {
        this.e.f5607j = null;
        super.mo4286s();
    }

    public final void m20942a(zzadv com_google_android_gms_internal_zzadv) {
        zzbq.m4816b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzadv.f17508b)) {
            zzakb.m5371e("Invalid ad unit id. Aborting.");
            zzahn.f6379a.post(new zzadf(this));
            return;
        }
        this.f19561l = false;
        this.e.f5599b = com_google_android_gms_internal_zzadv.f17508b;
        this.f19563o.f14061a = com_google_android_gms_internal_zzadv.f17508b;
        super.mo2003b((zzjj) com_google_android_gms_internal_zzadv.f17507a);
    }

    public final void mo2011n() {
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
        r0 = "pause must be called on the main UI thread.";
        com.google.android.gms.common.internal.zzbq.m4816b(r0);
        r0 = r4.f19560i;
        r0 = r0.keySet();
        r0 = r0.iterator();
    L_0x000f:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0049;
    L_0x0015:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        r2 = r4.f19560i;	 Catch:{ RemoteException -> 0x002f }
        r2 = r2.get(r1);	 Catch:{ RemoteException -> 0x002f }
        r2 = (com.google.android.gms.internal.zzael) r2;	 Catch:{ RemoteException -> 0x002f }
        if (r2 == 0) goto L_0x000f;	 Catch:{ RemoteException -> 0x002f }
    L_0x0025:
        r3 = r2.f6253a;	 Catch:{ RemoteException -> 0x002f }
        if (r3 == 0) goto L_0x000f;	 Catch:{ RemoteException -> 0x002f }
    L_0x0029:
        r2 = r2.f6253a;	 Catch:{ RemoteException -> 0x002f }
        r2.mo2184d();	 Catch:{ RemoteException -> 0x002f }
        goto L_0x000f;
    L_0x002f:
        r2 = "Fail to pause adapter: ";
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0040;
    L_0x003b:
        r1 = r2.concat(r1);
        goto L_0x0045;
    L_0x0040:
        r1 = new java.lang.String;
        r1.<init>(r2);
    L_0x0045:
        com.google.android.gms.internal.zzakb.m5371e(r1);
        goto L_0x000f;
    L_0x0049:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzade.n():void");
    }

    public final void mo2012o() {
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
        r0 = "resume must be called on the main UI thread.";
        com.google.android.gms.common.internal.zzbq.m4816b(r0);
        r0 = r4.f19560i;
        r0 = r0.keySet();
        r0 = r0.iterator();
    L_0x000f:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0049;
    L_0x0015:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        r2 = r4.f19560i;	 Catch:{ RemoteException -> 0x002f }
        r2 = r2.get(r1);	 Catch:{ RemoteException -> 0x002f }
        r2 = (com.google.android.gms.internal.zzael) r2;	 Catch:{ RemoteException -> 0x002f }
        if (r2 == 0) goto L_0x000f;	 Catch:{ RemoteException -> 0x002f }
    L_0x0025:
        r3 = r2.f6253a;	 Catch:{ RemoteException -> 0x002f }
        if (r3 == 0) goto L_0x000f;	 Catch:{ RemoteException -> 0x002f }
    L_0x0029:
        r2 = r2.f6253a;	 Catch:{ RemoteException -> 0x002f }
        r2.mo2185e();	 Catch:{ RemoteException -> 0x002f }
        goto L_0x000f;
    L_0x002f:
        r2 = "Fail to resume adapter: ";
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0040;
    L_0x003b:
        r1 = r2.concat(r1);
        goto L_0x0045;
    L_0x0040:
        r1 = new java.lang.String;
        r1.<init>(r2);
    L_0x0045:
        com.google.android.gms.internal.zzakb.m5371e(r1);
        goto L_0x000f;
    L_0x0049:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzade.o():void");
    }

    public final void mo2006i() {
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
        r0 = "destroy must be called on the main UI thread.";
        com.google.android.gms.common.internal.zzbq.m4816b(r0);
        r0 = r4.f19560i;
        r0 = r0.keySet();
        r0 = r0.iterator();
    L_0x000f:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0049;
    L_0x0015:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        r2 = r4.f19560i;	 Catch:{ RemoteException -> 0x002f }
        r2 = r2.get(r1);	 Catch:{ RemoteException -> 0x002f }
        r2 = (com.google.android.gms.internal.zzael) r2;	 Catch:{ RemoteException -> 0x002f }
        if (r2 == 0) goto L_0x000f;	 Catch:{ RemoteException -> 0x002f }
    L_0x0025:
        r3 = r2.f6253a;	 Catch:{ RemoteException -> 0x002f }
        if (r3 == 0) goto L_0x000f;	 Catch:{ RemoteException -> 0x002f }
    L_0x0029:
        r2 = r2.f6253a;	 Catch:{ RemoteException -> 0x002f }
        r2.mo2183c();	 Catch:{ RemoteException -> 0x002f }
        goto L_0x000f;
    L_0x002f:
        r2 = "Fail to destroy adapter: ";
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0040;
    L_0x003b:
        r1 = r2.concat(r1);
        goto L_0x0045;
    L_0x0040:
        r1 = new java.lang.String;
        r1.<init>(r2);
    L_0x0045:
        com.google.android.gms.internal.zzakb.m5371e(r1);
        goto L_0x000f;
    L_0x0049:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzade.i():void");
    }

    public final void m20935F() {
        zzbq.m4816b("showAd must be called on the main UI thread.");
        if (m20936G()) {
            this.f19561l = true;
            zzael b = mo4271b(this.e.f5607j.f6303p);
            if (!(b == null || b.f6253a == null)) {
                try {
                    b.f6253a.mo2181a(this.f19562n);
                    b.f6253a.mo2186f();
                    return;
                } catch (Throwable e) {
                    zzakb.m5369c("Could not call showVideo.", e);
                }
            }
            return;
        }
        zzakb.m5371e("The reward video has not loaded.");
    }

    public final void mo4285a(zzaeq com_google_android_gms_internal_zzaeq) {
        if (!(this.e.f5607j == null || this.e.f5607j.f6304q == null || TextUtils.isEmpty(this.e.f5607j.f6304q.f8074j))) {
            com_google_android_gms_internal_zzaeq = new zzaeq(this.e.f5607j.f6304q.f8074j, this.e.f5607j.f6304q.f8075k);
        }
        if (!(this.e.f5607j == null || this.e.f5607j.f6301n == null)) {
            zzbs.m4503v();
            zzuq.m6687a(this.e.f5600c, this.e.f5602e.f17551a, this.e.f5607j.f6301n.f8057l, this.e.f5585B, com_google_android_gms_internal_zzaeq);
        }
        if (zzbs.m4507z().m5100e(this.e.f5600c) && com_google_android_gms_internal_zzaeq != null) {
            zzaff z = zzbs.m4507z();
            Context context = this.e.f5600c;
            String i = zzbs.m4507z().m5104i(this.e.f5600c);
            String str = this.e.f5599b;
            String str2 = com_google_android_gms_internal_zzaeq.f17534a;
            int i2 = com_google_android_gms_internal_zzaeq.f17535b;
            if (z.m5090a(context)) {
                Bundle a = zzaff.m5082a(i, false);
                a.putString("_ai", str);
                a.putString("type", str2);
                a.putInt("value", i2);
                z.m5088a(context, "_ar", a);
                StringBuilder stringBuilder = new StringBuilder(75 + String.valueOf(str2).length());
                stringBuilder.append("Log a Firebase reward video event, reward type: ");
                stringBuilder.append(str2);
                stringBuilder.append(", reward value: ");
                stringBuilder.append(i2);
                zzagf.m13278a(stringBuilder.toString());
            }
        }
        m17453b(com_google_android_gms_internal_zzaeq);
    }
}
