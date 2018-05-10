package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanr;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzxc;
import com.google.android.gms.internal.zzya;
import com.google.android.gms.internal.zzzv;

@zzzv
public class zzi extends zzd implements zzae, zzxc {
    private boolean f19552i;

    public zzi(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, zzv com_google_android_gms_ads_internal_zzv) {
        super(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv);
    }

    public final void mo4274G() {
        m17475u();
    }

    public final void mo4275H() {
        mo4286s();
    }

    protected zzanh mo4379a(zzafp com_google_android_gms_internal_zzafp, zzw com_google_android_gms_ads_internal_zzw, zzafb com_google_android_gms_internal_zzafb) throws zzanv {
        View nextView = this.e.f5603f.getNextView();
        if (nextView instanceof zzanh) {
            ((zzanh) nextView).destroy();
        }
        if (nextView != null) {
            this.e.f5603f.removeView(nextView);
        }
        zzbs.m4487f();
        zzanh a = zzanr.m5464a(this.e.f5600c, zzapa.m5486a(this.e.f5606i), this.e.f5606i.f18152a, false, false, this.e.f5601d, this.e.f5602e, this.a, this, this.h, com_google_android_gms_internal_zzafp.f6322i);
        if (this.e.f5606i.f18158g == null) {
            if (a == null) {
                throw null;
            }
            m17432a((View) a);
        }
        a.mo4019w().m5445a(this, this, this, this, false, null, com_google_android_gms_ads_internal_zzw, this, com_google_android_gms_internal_zzafb);
        m20893a(a);
        a.mo3991b(com_google_android_gms_internal_zzafp.f6314a.f17415v);
        return a;
    }

    protected void mo4267a(zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu) {
        if (com_google_android_gms_internal_zzafp.f6318e != -2) {
            zzahn.f6379a.post(new zzk(this, com_google_android_gms_internal_zzafp));
            return;
        }
        if (com_google_android_gms_internal_zzafp.f6317d != null) {
            this.e.f5606i = com_google_android_gms_internal_zzafp.f6317d;
        }
        if (!com_google_android_gms_internal_zzafp.f6315b.f17447g || com_google_android_gms_internal_zzafp.f6315b.f17466z) {
            zzahn.f6379a.post(new zzl(this, com_google_android_gms_internal_zzafp, this.h.f5651c.mo1709a(this.e.f5600c, this.e.f5602e, com_google_android_gms_internal_zzafp.f6315b), com_google_android_gms_internal_zznu));
            return;
        }
        this.e.f5589F = 0;
        zzbt com_google_android_gms_ads_internal_zzbt = this.e;
        zzbs.m4485d();
        com_google_android_gms_ads_internal_zzbt.f5605h = zzya.m6803a(this.e.f5600c, this, com_google_android_gms_internal_zzafp, this.e.f5601d, null, this.m, this, com_google_android_gms_internal_zznu);
    }

    protected final void m20893a(zzanh com_google_android_gms_internal_zzanh) {
        com_google_android_gms_internal_zzanh.mo3984a("/trackActiveViewUnit", new zzj(this));
    }

    public final void mo1998a(zzoa com_google_android_gms_internal_zzoa) {
        zzbq.m4816b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.e.f5623z = com_google_android_gms_internal_zzoa;
    }

    public final void a_(View view) {
        this.e.f5588E = view;
        mo3389b(new zzafo(this.e.f5608k));
    }

    final void m20896b(zzanh com_google_android_gms_internal_zzanh) {
        if (this.e.f5607j != null) {
            zzfs com_google_android_gms_internal_zzfs = this.g;
            zzjn com_google_android_gms_internal_zzjn = this.e.f5606i;
            zzafo com_google_android_gms_internal_zzafo = this.e.f5607j;
            if (com_google_android_gms_internal_zzanh == null) {
                throw null;
            }
            com_google_android_gms_internal_zzfs.m13919a(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzafo, (View) com_google_android_gms_internal_zzanh, com_google_android_gms_internal_zzanh);
            this.f19552i = false;
            return;
        }
        this.f19552i = true;
        zzakb.m5371e("Request to enable ActiveView before adState is available.");
    }

    public final void e_() {
        mo1263e();
    }

    public final void f_() {
        m20151U();
        mo2010m();
    }

    protected void mo4273v() {
        super.mo4273v();
        if (this.f19552i) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bS)).booleanValue()) {
                m20896b(this.e.f5607j.f6289b);
            }
        }
    }

    protected boolean mo3951a(com.google.android.gms.internal.zzafo r3, com.google.android.gms.internal.zzafo r4) {
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
        r2 = this;
        r0 = r2.e;
        r0 = r0.m4513c();
        if (r0 == 0) goto L_0x0018;
    L_0x0008:
        r0 = r2.e;
        r0 = r0.f5603f;
        if (r0 == 0) goto L_0x0018;
    L_0x000e:
        r0 = r2.e;
        r0 = r0.f5603f;
        r0 = r0.f5624a;
        r1 = r4.f6313z;
        r0.f6394a = r1;
    L_0x0018:
        r0 = r4.f6289b;	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 == 0) goto L_0x0067;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x001c:
        r0 = r4.f6300m;	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 != 0) goto L_0x0067;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0020:
        r0 = r4.f6284J;	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 == 0) goto L_0x0067;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0024:
        r0 = com.google.android.gms.internal.zznh.cP;	 Catch:{ RuntimeException -> 0x0062 }
        r1 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ RuntimeException -> 0x0062 }
        r0 = r1.m6488a(r0);	 Catch:{ RuntimeException -> 0x0062 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = r0.booleanValue();	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 == 0) goto L_0x0067;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0036:
        r0 = r4.f6288a;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = r0.f18150q;	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 == 0) goto L_0x0047;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x003c:
        r1 = "com.google.ads.mediation.AbstractAdViewAdapter";	 Catch:{ RuntimeException -> 0x0062 }
        r0 = r1.equals(r0);	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0044:
        goto L_0x0047;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0045:
        r0 = 0;	 Catch:{ RuntimeException -> 0x0062 }
        goto L_0x0048;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0047:
        r0 = 1;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x0048:
        if (r0 == 0) goto L_0x0067;	 Catch:{ RuntimeException -> 0x0062 }
    L_0x004a:
        r0 = r4.f6288a;	 Catch:{ RuntimeException -> 0x0062 }
        r0 = r0.f18136c;	 Catch:{ RuntimeException -> 0x0062 }
        r1 = "sdk_less_server_data";	 Catch:{ RuntimeException -> 0x0062 }
        r0 = r0.containsKey(r1);	 Catch:{ RuntimeException -> 0x0062 }
        if (r0 != 0) goto L_0x0067;
    L_0x0056:
        r0 = r4.f6289b;	 Catch:{ Throwable -> 0x005c }
        r0.mo3975L();	 Catch:{ Throwable -> 0x005c }
        goto L_0x0067;
    L_0x005c:
        r0 = "Could not render test Ad label.";	 Catch:{ RuntimeException -> 0x0062 }
        com.google.android.gms.internal.zzagf.m13278a(r0);	 Catch:{ RuntimeException -> 0x0062 }
        goto L_0x0067;
    L_0x0062:
        r0 = "Could not render test AdLabel.";
        com.google.android.gms.internal.zzagf.m13278a(r0);
    L_0x0067:
        r3 = super.mo3951a(r3, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzi.a(com.google.android.gms.internal.zzafo, com.google.android.gms.internal.zzafo):boolean");
    }
}
