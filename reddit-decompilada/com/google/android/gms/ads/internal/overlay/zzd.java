package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzxb;
import com.google.android.gms.internal.zzxf;
import com.google.android.gms.internal.zzzv;
import java.util.Collections;
import org.jcodec.codecs.mpeg12.MPEGConst;

@zzzv
public final class zzd extends zzxf implements zzt {
    private static int f17103m = Color.argb(0, 0, 0, 0);
    public final Activity f17104a;
    AdOverlayInfoParcel f17105b;
    public zzo f17106c;
    public boolean f17107d = false;
    public FrameLayout f17108e;
    public CustomViewCallback f17109f;
    public zzh f17110g;
    public boolean f17111h = false;
    public final Object f17112i = new Object();
    public Runnable f17113j;
    public boolean f17114k;
    public boolean f17115l;
    private zzanh f17116n;
    private zzi f17117o;
    private boolean f17118p = false;
    private boolean f17119q = false;
    private int f17120r = 0;
    private boolean f17121s = false;
    private boolean f17122t = false;
    private boolean f17123u = true;

    public zzd(Activity activity) {
        this.f17104a = activity;
    }

    private final void m17400o() {
        if (this.f17104a.isFinishing() && !this.f17121s) {
            this.f17121s = true;
            if (this.f17116n != null) {
                this.f17116n.mo3977a(this.f17120r);
                synchronized (this.f17112i) {
                    if (this.f17114k || !this.f17116n.mo3969F()) {
                    } else {
                        this.f17113j = new zzf(this);
                        zzahn.f6379a.postDelayed(this.f17113j, ((Long) zzkb.m6350f().m6488a(zznh.aC)).longValue());
                        return;
                    }
                }
            }
            m17420m();
        }
    }

    public final void m17401a() {
        this.f17120r = 2;
        this.f17104a.finish();
    }

    public final void m17402a(int i) {
        this.f17104a.setRequestedOrientation(i);
    }

    public final void mo2277a(int i, int i2, Intent intent) {
    }

    public final void mo2278a(Bundle bundle) {
        this.f17104a.requestWindowFeature(1);
        this.f17118p = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.f17105b = AdOverlayInfoParcel.m17396a(this.f17104a.getIntent());
            if (this.f17105b == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (this.f17105b.f17092m.f17553c > 7500000) {
                this.f17120r = 3;
            }
            if (this.f17104a.getIntent() != null) {
                this.f17123u = this.f17104a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f17105b.f17094o != null) {
                this.f17119q = this.f17105b.f17094o.f17171a;
            } else {
                this.f17119q = false;
            }
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bE)).booleanValue() && this.f17119q && this.f17105b.f17094o.f17175e != -1) {
                new zzj().m13277h();
            }
            if (bundle == null) {
                if (this.f17105b.f17082c != null && this.f17123u) {
                    this.f17105b.f17082c.mo1756f();
                }
                if (!(this.f17105b.f17090k == 1 || this.f17105b.f17081b == null)) {
                    this.f17105b.f17081b.mo1263e();
                }
            }
            this.f17110g = new zzh(this.f17104a, this.f17105b.f17093n, this.f17105b.f17092m.f17551a);
            this.f17110g.setId(1000);
            switch (this.f17105b.f17090k) {
                case 1:
                    m17399b(false);
                    return;
                case 2:
                    this.f17117o = new zzi(this.f17105b.f17083d);
                    m17399b(false);
                    return;
                case 3:
                    m17399b(true);
                    return;
                case 4:
                    if (this.f17118p) {
                        this.f17120r = 3;
                        this.f17104a.finish();
                        return;
                    }
                    zzbs.m4483b();
                    if (!zza.m4449a(this.f17104a, this.f17105b.f17080a, this.f17105b.f17088i)) {
                        this.f17120r = 3;
                        this.f17104a.finish();
                    }
                    return;
                default:
                    throw new zzg("Could not determine ad overlay type.");
            }
        } catch (zzg e) {
            zzakb.m5371e(e.getMessage());
            this.f17120r = 3;
            this.f17104a.finish();
        }
    }

    public final void mo2279a(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.cG)).booleanValue() && zzq.m4916h()) {
            Configuration configuration = (Configuration) zzn.m17693a(iObjectWrapper);
            zzbs.m4486e();
            if (zzahn.m5177a(this.f17104a, configuration)) {
                this.f17104a.getWindow().addFlags(1024);
                this.f17104a.getWindow().clearFlags(MPEGConst.CODE_END);
                return;
            }
            this.f17104a.getWindow().addFlags(MPEGConst.CODE_END);
            this.f17104a.getWindow().clearFlags(1024);
        }
    }

    public final void m17406a(boolean z) {
        int intValue = ((Integer) zzkb.m6350f().m6488a(zznh.cI)).intValue();
        zzp com_google_android_gms_ads_internal_overlay_zzp = new zzp();
        com_google_android_gms_ads_internal_overlay_zzp.f5495e = 50;
        com_google_android_gms_ads_internal_overlay_zzp.f5491a = z ? intValue : 0;
        com_google_android_gms_ads_internal_overlay_zzp.f5492b = z ? 0 : intValue;
        com_google_android_gms_ads_internal_overlay_zzp.f5493c = 0;
        com_google_android_gms_ads_internal_overlay_zzp.f5494d = intValue;
        this.f17106c = new zzo(this.f17104a, com_google_android_gms_ads_internal_overlay_zzp, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        m17407a(z, this.f17105b.f17086g);
        this.f17110g.addView(this.f17106c, layoutParams);
    }

    public final void m17408b() {
        if (this.f17105b != null && this.f17107d) {
            m17402a(this.f17105b.f17089j);
        }
        if (this.f17108e != null) {
            this.f17104a.setContentView(this.f17110g);
            this.f17115l = true;
            this.f17108e.removeAllViews();
            this.f17108e = null;
        }
        if (this.f17109f != null) {
            this.f17109f.onCustomViewHidden();
            this.f17109f = null;
        }
        this.f17107d = false;
    }

    public final void mo2280b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f17118p);
    }

    public final void mo3383c() {
        this.f17120r = 1;
        this.f17104a.finish();
    }

    public final void mo2281d() {
        this.f17120r = 0;
    }

    public final boolean mo2282e() {
        this.f17120r = 0;
        if (this.f17116n == null) {
            return true;
        }
        boolean D = this.f17116n.mo3967D();
        if (!D) {
            this.f17116n.mo3462a("onbackblocked", Collections.emptyMap());
        }
        return D;
    }

    public final void mo2283f() {
    }

    public final void mo2284g() {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.cH)).booleanValue()) {
            if (this.f17116n == null || this.f17116n.mo3965B()) {
                zzakb.m5371e("The webview does not exist. Ignoring action.");
            } else {
                zzbs.m4488g();
                zzaht.m5233b(this.f17116n);
            }
        }
    }

    public final void mo2285h() {
        if (this.f17105b != null && this.f17105b.f17090k == 4) {
            if (this.f17118p) {
                this.f17120r = 3;
                this.f17104a.finish();
            } else {
                this.f17118p = true;
            }
        }
        if (this.f17105b.f17082c != null) {
            this.f17105b.f17082c.mo1755d();
        }
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.cH)).booleanValue()) {
            if (this.f17116n == null || this.f17116n.mo3965B()) {
                zzakb.m5371e("The webview does not exist. Ignoring action.");
            } else {
                zzbs.m4488g();
                zzaht.m5233b(this.f17116n);
            }
        }
    }

    public final void mo2286i() {
        m17408b();
        if (this.f17105b.f17082c != null) {
            this.f17105b.f17082c.mo1754c();
        }
        if (!(((Boolean) zzkb.m6350f().m6488a(zznh.cH)).booleanValue() || this.f17116n == null || (this.f17104a.isFinishing() && this.f17117o != null))) {
            zzbs.m4488g();
            zzaht.m5232a(this.f17116n);
        }
        m17400o();
    }

    public final void mo2287j() {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.cH)).booleanValue() && this.f17116n != null && (!this.f17104a.isFinishing() || this.f17117o == null)) {
            zzbs.m4488g();
            zzaht.m5232a(this.f17116n);
        }
        m17400o();
    }

    public final void mo2288k() {
        if (this.f17116n != null) {
            zzh com_google_android_gms_ads_internal_overlay_zzh = this.f17110g;
            zzanh com_google_android_gms_internal_zzanh = this.f17116n;
            if (com_google_android_gms_internal_zzanh == null) {
                throw null;
            }
            com_google_android_gms_ads_internal_overlay_zzh.removeView((View) com_google_android_gms_internal_zzanh);
        }
        m17400o();
    }

    public final void mo2289l() {
        this.f17115l = true;
    }

    final void m17420m() {
        if (!this.f17122t) {
            this.f17122t = true;
            if (this.f17116n != null) {
                zzh com_google_android_gms_ads_internal_overlay_zzh = this.f17110g;
                zzanh com_google_android_gms_internal_zzanh = this.f17116n;
                if (com_google_android_gms_internal_zzanh == null) {
                    throw null;
                }
                com_google_android_gms_ads_internal_overlay_zzh.removeView((View) com_google_android_gms_internal_zzanh);
                if (this.f17117o != null) {
                    this.f17116n.mo3978a(this.f17117o.f5486d);
                    this.f17116n.mo3993b(false);
                    ViewGroup viewGroup = this.f17117o.f5485c;
                    com_google_android_gms_internal_zzanh = this.f17116n;
                    if (com_google_android_gms_internal_zzanh == null) {
                        throw null;
                    }
                    viewGroup.addView((View) com_google_android_gms_internal_zzanh, this.f17117o.f5483a, this.f17117o.f5484b);
                    this.f17117o = null;
                } else if (this.f17104a.getApplicationContext() != null) {
                    this.f17116n.mo3978a(this.f17104a.getApplicationContext());
                }
                this.f17116n = null;
            }
            if (!(this.f17105b == null || this.f17105b.f17082c == null)) {
                this.f17105b.f17082c.mo1753b();
            }
        }
    }

    public final void m17421n() {
        this.f17116n.mo4008p();
    }

    public final void m17407a(boolean z, boolean z2) {
        int i = 1;
        int i2 = (!((Boolean) zzkb.m6350f().m6488a(zznh.aE)).booleanValue() || this.f17105b == null || this.f17105b.f17094o == null || !this.f17105b.f17094o.f17177g) ? 0 : 1;
        if (z && z2 && i2 != 0) {
            new zzxb(this.f17116n, "useCustomClose").m6783a("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.f17106c != null) {
            zzo com_google_android_gms_ads_internal_overlay_zzo = this.f17106c;
            if (!z2 || i2 != 0) {
                i = 0;
            }
            if (i != 0) {
                if (z) {
                    z = com_google_android_gms_ads_internal_overlay_zzo.f5489a;
                    z2 = true;
                } else {
                    z = com_google_android_gms_ads_internal_overlay_zzo.f5489a;
                    z2 = true;
                }
                z.setVisibility(z2);
                return;
            }
            com_google_android_gms_ads_internal_overlay_zzo.f5489a.setVisibility(0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m17399b(boolean r20) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
        r19 = this;
        r1 = r19;
        r3 = r1.f17115l;
        r4 = 1;
        if (r3 != 0) goto L_0x000c;
    L_0x0007:
        r3 = r1.f17104a;
        r3.requestWindowFeature(r4);
    L_0x000c:
        r3 = r1.f17104a;
        r3 = r3.getWindow();
        if (r3 != 0) goto L_0x001c;
    L_0x0014:
        r2 = new com.google.android.gms.ads.internal.overlay.zzg;
        r3 = "Invalid activity, no window available.";
        r2.<init>(r3);
        throw r2;
    L_0x001c:
        r5 = com.google.android.gms.common.util.zzq.m4916h();
        if (r5 == 0) goto L_0x0048;
    L_0x0022:
        r5 = com.google.android.gms.internal.zznh.cG;
        r6 = com.google.android.gms.internal.zzkb.m6350f();
        r5 = r6.m6488a(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x0048;
    L_0x0034:
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r5 = r1.f17104a;
        r6 = r1.f17104a;
        r6 = r6.getResources();
        r6 = r6.getConfiguration();
        r5 = com.google.android.gms.internal.zzahn.m5177a(r5, r6);
        goto L_0x0049;
    L_0x0048:
        r5 = r4;
    L_0x0049:
        r6 = r1.f17105b;
        r6 = r6.f17094o;
        r7 = 0;
        if (r6 == 0) goto L_0x005a;
    L_0x0050:
        r6 = r1.f17105b;
        r6 = r6.f17094o;
        r6 = r6.f17172b;
        if (r6 == 0) goto L_0x005a;
    L_0x0058:
        r6 = r4;
        goto L_0x005b;
    L_0x005a:
        r6 = r7;
    L_0x005b:
        r8 = r1.f17119q;
        if (r8 == 0) goto L_0x0061;
    L_0x005f:
        if (r6 == 0) goto L_0x0097;
    L_0x0061:
        if (r5 == 0) goto L_0x0097;
    L_0x0063:
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3.setFlags(r5, r5);
        r5 = com.google.android.gms.internal.zznh.aD;
        r6 = com.google.android.gms.internal.zzkb.m6350f();
        r5 = r6.m6488a(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x0097;
    L_0x007a:
        r5 = com.google.android.gms.common.util.zzq.m4913e();
        if (r5 == 0) goto L_0x0097;
    L_0x0080:
        r5 = r1.f17105b;
        r5 = r5.f17094o;
        if (r5 == 0) goto L_0x0097;
    L_0x0086:
        r5 = r1.f17105b;
        r5 = r5.f17094o;
        r5 = r5.f17176f;
        if (r5 == 0) goto L_0x0097;
    L_0x008e:
        r5 = r3.getDecorView();
        r6 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
        r5.setSystemUiVisibility(r6);
    L_0x0097:
        r5 = r1.f17105b;
        r5 = r5.f17083d;
        r6 = 0;
        if (r5 == 0) goto L_0x00a7;
    L_0x009e:
        r5 = r1.f17105b;
        r5 = r5.f17083d;
        r5 = r5.mo4019w();
        goto L_0x00a8;
    L_0x00a7:
        r5 = r6;
    L_0x00a8:
        if (r5 == 0) goto L_0x00af;
    L_0x00aa:
        r5 = r5.m5450a();
        goto L_0x00b0;
    L_0x00af:
        r5 = r7;
    L_0x00b0:
        r1.f17111h = r7;
        if (r5 == 0) goto L_0x00f2;
    L_0x00b4:
        r8 = r1.f17105b;
        r8 = r8.f17089j;
        r9 = com.google.android.gms.ads.internal.zzbs.m4488g();
        r9 = r9.mo1720a();
        if (r8 != r9) goto L_0x00d4;
    L_0x00c2:
        r8 = r1.f17104a;
        r8 = r8.getResources();
        r8 = r8.getConfiguration();
        r8 = r8.orientation;
        if (r8 != r4) goto L_0x00d1;
    L_0x00d0:
        r7 = r4;
    L_0x00d1:
        r1.f17111h = r7;
        goto L_0x00f2;
    L_0x00d4:
        r8 = r1.f17105b;
        r8 = r8.f17089j;
        r9 = com.google.android.gms.ads.internal.zzbs.m4488g();
        r9 = r9.mo1722b();
        if (r8 != r9) goto L_0x00f2;
    L_0x00e2:
        r8 = r1.f17104a;
        r8 = r8.getResources();
        r8 = r8.getConfiguration();
        r8 = r8.orientation;
        r9 = 2;
        if (r8 != r9) goto L_0x00d1;
    L_0x00f1:
        goto L_0x00d0;
    L_0x00f2:
        r7 = r1.f17111h;
        r8 = 46;
        r9 = new java.lang.StringBuilder;
        r9.<init>(r8);
        r8 = "Delay onShow to next orientation change: ";
        r9.append(r8);
        r9.append(r7);
        r7 = r9.toString();
        com.google.android.gms.internal.zzakb.m5366b(r7);
        r7 = r1.f17105b;
        r7 = r7.f17089j;
        r1.m17402a(r7);
        r7 = com.google.android.gms.ads.internal.zzbs.m4488g();
        r3 = r7.mo3439a(r3);
        if (r3 == 0) goto L_0x0120;
    L_0x011b:
        r3 = "Hardware acceleration on the AdActivity window enabled.";
        com.google.android.gms.internal.zzakb.m5366b(r3);
    L_0x0120:
        r3 = r1.f17119q;
        if (r3 != 0) goto L_0x012c;
    L_0x0124:
        r3 = r1.f17110g;
        r7 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
    L_0x0128:
        r3.setBackgroundColor(r7);
        goto L_0x0131;
    L_0x012c:
        r3 = r1.f17110g;
        r7 = f17103m;
        goto L_0x0128;
    L_0x0131:
        r3 = r1.f17104a;
        r7 = r1.f17110g;
        r3.setContentView(r7);
        r1.f17115l = r4;
        if (r20 == 0) goto L_0x020f;
    L_0x013c:
        com.google.android.gms.ads.internal.zzbs.m4487f();	 Catch:{ Exception -> 0x0200 }
        r8 = r1.f17104a;	 Catch:{ Exception -> 0x0200 }
        r3 = r1.f17105b;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.f17083d;	 Catch:{ Exception -> 0x0200 }
        if (r3 == 0) goto L_0x0151;
    L_0x0147:
        r3 = r1.f17105b;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.f17083d;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.mo3474u();	 Catch:{ Exception -> 0x0200 }
        r9 = r3;
        goto L_0x0152;
    L_0x0151:
        r9 = r6;
    L_0x0152:
        r3 = r1.f17105b;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.f17083d;	 Catch:{ Exception -> 0x0200 }
        if (r3 == 0) goto L_0x0162;
    L_0x0158:
        r3 = r1.f17105b;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.f17083d;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.mo4018v();	 Catch:{ Exception -> 0x0200 }
        r10 = r3;
        goto L_0x0163;
    L_0x0162:
        r10 = r6;
    L_0x0163:
        r11 = 1;
        r13 = 0;
        r3 = r1.f17105b;	 Catch:{ Exception -> 0x0200 }
        r14 = r3.f17092m;	 Catch:{ Exception -> 0x0200 }
        r15 = 0;
        r16 = 0;
        r3 = r1.f17105b;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.f17083d;	 Catch:{ Exception -> 0x0200 }
        if (r3 == 0) goto L_0x017d;
    L_0x0172:
        r3 = r1.f17105b;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.f17083d;	 Catch:{ Exception -> 0x0200 }
        r3 = r3.mo3468e();	 Catch:{ Exception -> 0x0200 }
        r17 = r3;
        goto L_0x017f;
    L_0x017d:
        r17 = r6;
    L_0x017f:
        r18 = com.google.android.gms.internal.zzis.m6322a();	 Catch:{ Exception -> 0x0200 }
        r12 = r5;
        r3 = com.google.android.gms.internal.zzanr.m5464a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);	 Catch:{ Exception -> 0x0200 }
        r1.f17116n = r3;	 Catch:{ Exception -> 0x0200 }
        r3 = r1.f17116n;
        r7 = r3.mo4019w();
        r8 = 0;
        r9 = 0;
        r3 = r1.f17105b;
        r10 = r3.f17084e;
        r3 = r1.f17105b;
        r11 = r3.f17088i;
        r12 = 1;
        r13 = 0;
        r3 = r1.f17105b;
        r3 = r3.f17083d;
        if (r3 == 0) goto L_0x01ae;
    L_0x01a2:
        r3 = r1.f17105b;
        r3 = r3.f17083d;
        r3 = r3.mo4019w();
        r3 = r3.f6623j;
        r14 = r3;
        goto L_0x01af;
    L_0x01ae:
        r14 = r6;
    L_0x01af:
        r15 = 0;
        r16 = 0;
        r7.m5445a(r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r3 = r1.f17116n;
        r3 = r3.mo4019w();
        r7 = new com.google.android.gms.ads.internal.overlay.zze;
        r7.<init>();
        r3.f6617d = r7;
        r3 = r1.f17105b;
        r3 = r3.f17091l;
        if (r3 == 0) goto L_0x01d2;
    L_0x01c8:
        r3 = r1.f17116n;
        r7 = r1.f17105b;
        r7 = r7.f17091l;
        r3.loadUrl(r7);
        goto L_0x01ea;
    L_0x01d2:
        r3 = r1.f17105b;
        r3 = r3.f17087h;
        if (r3 == 0) goto L_0x01f8;
    L_0x01d8:
        r7 = r1.f17116n;
        r3 = r1.f17105b;
        r8 = r3.f17085f;
        r3 = r1.f17105b;
        r9 = r3.f17087h;
        r10 = "text/html";
        r11 = "UTF-8";
        r12 = 0;
        r7.loadDataWithBaseURL(r8, r9, r10, r11, r12);
    L_0x01ea:
        r3 = r1.f17105b;
        r3 = r3.f17083d;
        if (r3 == 0) goto L_0x021c;
    L_0x01f0:
        r3 = r1.f17105b;
        r3 = r3.f17083d;
        r3.mo3990b(r1);
        goto L_0x021c;
    L_0x01f8:
        r2 = new com.google.android.gms.ads.internal.overlay.zzg;
        r3 = "No URL or HTML to display in ad overlay.";
        r2.<init>(r3);
        throw r2;
    L_0x0200:
        r0 = move-exception;
        r2 = r0;
        r3 = "Error obtaining webview.";
        com.google.android.gms.internal.zzakb.m5367b(r3, r2);
        r2 = new com.google.android.gms.ads.internal.overlay.zzg;
        r3 = "Could not obtain webview for the overlay.";
        r2.<init>(r3);
        throw r2;
    L_0x020f:
        r3 = r1.f17105b;
        r3 = r3.f17083d;
        r1.f17116n = r3;
        r3 = r1.f17116n;
        r7 = r1.f17104a;
        r3.mo3978a(r7);
    L_0x021c:
        r3 = r1.f17116n;
        r3.mo3980a(r1);
        r3 = r1.f17116n;
        r3 = r3.getParent();
        if (r3 == 0) goto L_0x0239;
    L_0x0229:
        r7 = r3 instanceof android.view.ViewGroup;
        if (r7 == 0) goto L_0x0239;
    L_0x022d:
        r3 = (android.view.ViewGroup) r3;
        r7 = r1.f17116n;
        if (r7 != 0) goto L_0x0234;
    L_0x0233:
        throw r6;
    L_0x0234:
        r7 = (android.view.View) r7;
        r3.removeView(r7);
    L_0x0239:
        r3 = r1.f17119q;
        if (r3 == 0) goto L_0x0242;
    L_0x023d:
        r3 = r1.f17116n;
        r3.mo3974K();
    L_0x0242:
        r3 = r1.f17110g;
        r7 = r1.f17116n;
        if (r7 != 0) goto L_0x0249;
    L_0x0248:
        throw r6;
    L_0x0249:
        r7 = (android.view.View) r7;
        r6 = -1;
        r3.addView(r7, r6, r6);
        if (r20 != 0) goto L_0x0258;
    L_0x0251:
        r2 = r1.f17111h;
        if (r2 != 0) goto L_0x0258;
    L_0x0255:
        r19.m17421n();
    L_0x0258:
        r1.m17406a(r5);
        r2 = r1.f17116n;
        r2 = r2.mo4020x();
        if (r2 == 0) goto L_0x0266;
    L_0x0263:
        r1.m17407a(r5, r4);
    L_0x0266:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzd.b(boolean):void");
    }
}
