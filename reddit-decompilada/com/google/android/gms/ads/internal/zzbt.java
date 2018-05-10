package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzafq;
import com.google.android.gms.internal.zzafz;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzaif;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzzv;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@zzzv
public final class zzbt implements OnGlobalLayoutListener, OnScrollChangedListener {
    zzadp f5584A;
    public String f5585B;
    List<String> f5586C;
    public zzafz f5587D;
    View f5588E;
    public int f5589F;
    boolean f5590G;
    HashSet<zzafq> f5591H;
    boolean f5592I;
    boolean f5593J;
    boolean f5594K;
    private int f5595L;
    private int f5596M;
    private zzaji f5597N;
    final String f5598a;
    public String f5599b;
    public final Context f5600c;
    final zzcv f5601d;
    public final zzakd f5602e;
    zzbu f5603f;
    public zzagb f5604g;
    public zzaif f5605h;
    public zzjn f5606i;
    public zzafo f5607j;
    public zzafp f5608k;
    public zzafq f5609l;
    zzke f5610m;
    zzkh f5611n;
    zzkx f5612o;
    zzld f5613p;
    zzqq f5614q;
    zzqt f5615r;
    SimpleArrayMap<String, zzqw> f5616s;
    SimpleArrayMap<String, zzqz> f5617t;
    zzpe f5618u;
    zzmr f5619v;
    zzlr f5620w;
    zzrf f5621x;
    List<Integer> f5622y;
    zzoa f5623z;

    public zzbt(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzakd com_google_android_gms_internal_zzakd) {
        this(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzakd, (byte) 0);
    }

    private final void m4508b(boolean z) {
        if (this.f5603f != null && this.f5607j != null && this.f5607j.f6289b != null && this.f5607j.f6289b.mo4019w() != null) {
            if (!z || this.f5597N.m5301a()) {
                if (this.f5607j.f6289b.mo4019w().m5450a()) {
                    int[] iArr = new int[2];
                    this.f5603f.getLocationOnScreen(iArr);
                    zzkb.m6345a();
                    int b = zzajr.m5329b(this.f5600c, iArr[0]);
                    zzkb.m6345a();
                    int b2 = zzajr.m5329b(this.f5600c, iArr[1]);
                    if (!(b == this.f5595L && b2 == this.f5596M)) {
                        this.f5595L = b;
                        this.f5596M = b2;
                        this.f5607j.f6289b.mo4019w().m5442a(this.f5595L, this.f5596M, z ^ true);
                    }
                }
                if (this.f5603f != null) {
                    View findViewById = this.f5603f.getRootView().findViewById(16908290);
                    if (findViewById != null) {
                        Rect rect = new Rect();
                        Rect rect2 = new Rect();
                        this.f5603f.getGlobalVisibleRect(rect);
                        findViewById.getGlobalVisibleRect(rect2);
                        if (rect.top != rect2.top) {
                            this.f5592I = false;
                        }
                        if (rect.bottom != rect2.bottom) {
                            this.f5593J = false;
                        }
                    }
                }
            }
        }
    }

    public final void m4509a() {
        if (this.f5607j != null && this.f5607j.f6289b != null) {
            this.f5607j.f6289b.destroy();
        }
    }

    public final void m4511a(boolean z) {
        if (!(this.f5589F != 0 || this.f5607j == null || this.f5607j.f6289b == null)) {
            this.f5607j.f6289b.stopLoading();
        }
        if (this.f5604g != null) {
            this.f5604g.mo1644d();
        }
        if (this.f5605h != null) {
            this.f5605h.mo1644d();
        }
        if (z) {
            this.f5607j = null;
        }
    }

    public final void m4512b() {
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
        r1 = this;
        r0 = r1.f5607j;
        if (r0 == 0) goto L_0x0017;
    L_0x0004:
        r0 = r1.f5607j;
        r0 = r0.f6302o;
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = r1.f5607j;	 Catch:{ RemoteException -> 0x0012 }
        r0 = r0.f6302o;	 Catch:{ RemoteException -> 0x0012 }
        r0.mo2183c();	 Catch:{ RemoteException -> 0x0012 }
        return;
    L_0x0012:
        r0 = "Could not destroy mediation adapter.";
        com.google.android.gms.internal.zzakb.m5371e(r0);
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzbt.b():void");
    }

    public final boolean m4513c() {
        return this.f5589F == 0;
    }

    public final boolean m4514d() {
        return this.f5589F == 1;
    }

    public final void onGlobalLayout() {
        m4508b(false);
    }

    public final void onScrollChanged() {
        m4508b(true);
        this.f5594K = true;
    }

    private zzbt(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzakd com_google_android_gms_internal_zzakd, byte b) {
        this.f5587D = null;
        this.f5588E = null;
        this.f5589F = 0;
        this.f5590G = false;
        this.f5591H = null;
        this.f5595L = -1;
        this.f5596M = -1;
        this.f5592I = true;
        this.f5593J = true;
        this.f5594K = false;
        zznh.m6490a(context);
        if (zzbs.m4490i().m13257e() != null) {
            Iterable b2 = zznh.m6492b();
            if (com_google_android_gms_internal_zzakd.f17552b != 0) {
                b2.add(Integer.toString(com_google_android_gms_internal_zzakd.f17552b));
            }
            zznk e = zzbs.m4490i().m13257e();
            if (!(b2 == null || b2.isEmpty())) {
                e.f7924a.put("e", TextUtils.join(",", b2));
            }
        }
        this.f5598a = UUID.randomUUID().toString();
        if (!com_google_android_gms_internal_zzjn.f18155d) {
            if (!com_google_android_gms_internal_zzjn.f18159h) {
                this.f5603f = new zzbu(context, str, com_google_android_gms_internal_zzakd.f17551a, this, this);
                this.f5603f.setMinimumWidth(com_google_android_gms_internal_zzjn.f18157f);
                this.f5603f.setMinimumHeight(com_google_android_gms_internal_zzjn.f18154c);
                this.f5603f.setVisibility(4);
                this.f5606i = com_google_android_gms_internal_zzjn;
                this.f5599b = str;
                this.f5600c = context;
                this.f5602e = com_google_android_gms_internal_zzakd;
                this.f5601d = new zzcv(new zzaf(this));
                this.f5597N = new zzaji(200);
                this.f5617t = new SimpleArrayMap();
            }
        }
        this.f5603f = null;
        this.f5606i = com_google_android_gms_internal_zzjn;
        this.f5599b = str;
        this.f5600c = context;
        this.f5602e = com_google_android_gms_internal_zzakd;
        this.f5601d = new zzcv(new zzaf(this));
        this.f5597N = new zzaji(200);
        this.f5617t = new SimpleArrayMap();
    }

    final void m4510a(View view) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bt)).booleanValue()) {
            zzcr com_google_android_gms_internal_zzcr = this.f5601d.f7187b;
            if (com_google_android_gms_internal_zzcr != null) {
                com_google_android_gms_internal_zzcr.mo1522a(view);
            }
        }
    }
}
