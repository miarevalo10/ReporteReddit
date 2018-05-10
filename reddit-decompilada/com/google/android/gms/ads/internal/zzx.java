package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafe;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzzv;
import java.lang.ref.WeakReference;
import java.util.List;

@zzzv
public final class zzx extends zzi implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean f19803i;
    private WeakReference<Object> f19804j = new WeakReference(null);

    public zzx(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, zzv com_google_android_gms_ads_internal_zzv) {
        super(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv);
    }

    private final boolean m21525b(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        if (com_google_android_gms_internal_zzafo2.f6300m) {
            View a = zzaq.m4459a(com_google_android_gms_internal_zzafo2);
            if (a == null) {
                zzakb.m5371e("Could not get mediation view");
                return false;
            }
            View nextView = this.e.f5603f.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzanh) {
                    ((zzanh) nextView).destroy();
                }
                this.e.f5603f.removeView(nextView);
            }
            if (!zzaq.m4468b(com_google_android_gms_internal_zzafo2)) {
                try {
                    if (zzbs.m4507z().m5095b(this.e.f5600c)) {
                        new zzgp(this.e.f5600c, a).m6265a(new zzafe(this.e.f5600c, this.e.f5599b));
                    }
                    if (com_google_android_gms_internal_zzafo2.f6307t != null) {
                        this.e.f5603f.setMinimumWidth(com_google_android_gms_internal_zzafo2.f6307t.f18157f);
                        this.e.f5603f.setMinimumHeight(com_google_android_gms_internal_zzafo2.f6307t.f18154c);
                    }
                    m17432a(a);
                } catch (Throwable e) {
                    zzbs.m4490i().m13246a(e, "BannerAdManager.swapViews");
                    zzakb.m5369c("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (!(com_google_android_gms_internal_zzafo2.f6307t == null || com_google_android_gms_internal_zzafo2.f6289b == null)) {
            com_google_android_gms_internal_zzafo2.f6289b.mo3981a(zzapa.m5486a(com_google_android_gms_internal_zzafo2.f6307t));
            this.e.f5603f.removeAllViews();
            this.e.f5603f.setMinimumWidth(com_google_android_gms_internal_zzafo2.f6307t.f18157f);
            this.e.f5603f.setMinimumHeight(com_google_android_gms_internal_zzafo2.f6307t.f18154c);
            zzanh com_google_android_gms_internal_zzanh = com_google_android_gms_internal_zzafo2.f6289b;
            if (com_google_android_gms_internal_zzanh == null) {
                throw null;
            }
            m17432a((View) com_google_android_gms_internal_zzanh);
        }
        if (this.e.f5603f.getChildCount() > 1) {
            this.e.f5603f.showNext();
        }
        if (com_google_android_gms_internal_zzafo != null) {
            View nextView2 = this.e.f5603f.getNextView();
            if (nextView2 instanceof zzanh) {
                ((zzanh) nextView2).destroy();
            } else if (nextView2 != null) {
                this.e.f5603f.removeView(nextView2);
            }
            this.e.m4512b();
        }
        this.e.f5603f.setVisibility(0);
        return true;
    }

    public final void mo1988D() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    protected final boolean mo4384P() {
        boolean z;
        zzbs.m4486e();
        if (zzahn.m5179a(this.e.f5600c, this.e.f5600c.getPackageName(), "android.permission.INTERNET")) {
            z = true;
        } else {
            zzkb.m6345a();
            zzajr.m5326a(this.e.f5603f, this.e.f5606i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        zzbs.m4486e();
        if (!zzahn.m5178a(this.e.f5600c)) {
            zzkb.m6345a();
            zzajr.m5326a(this.e.f5603f, this.e.f5606i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.e.f5603f == null)) {
            this.e.f5603f.setVisibility(0);
        }
        return z;
    }

    protected final zzanh mo4379a(zzafp com_google_android_gms_internal_zzafp, zzw com_google_android_gms_ads_internal_zzw, zzafb com_google_android_gms_internal_zzafb) throws zzanv {
        if (this.e.f5606i.f18158g == null && this.e.f5606i.f18160i) {
            zzjn com_google_android_gms_internal_zzjn;
            zzbt com_google_android_gms_ads_internal_zzbt = this.e;
            if (com_google_android_gms_internal_zzafp.f6315b.f17465y) {
                com_google_android_gms_internal_zzjn = this.e.f5606i;
            } else {
                AdSize adSize;
                String str = com_google_android_gms_internal_zzafp.f6315b.f17452l;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    adSize = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    adSize = this.e.f5606i.m18780c();
                }
                com_google_android_gms_internal_zzjn = new zzjn(this.e.f5600c, adSize);
            }
            com_google_android_gms_ads_internal_zzbt.f5606i = com_google_android_gms_internal_zzjn;
        }
        return super.mo4379a(com_google_android_gms_internal_zzafp, com_google_android_gms_ads_internal_zzw, com_google_android_gms_internal_zzafb);
    }

    protected final void mo4385a(zzafo com_google_android_gms_internal_zzafo, boolean z) {
        super.mo4385a(com_google_android_gms_internal_zzafo, z);
        if (zzaq.m4468b(com_google_android_gms_internal_zzafo)) {
            zzab com_google_android_gms_ads_internal_zzab = new zzab(this);
            if (com_google_android_gms_internal_zzafo != null && zzaq.m4468b(com_google_android_gms_internal_zzafo)) {
                Object obj;
                zzanh com_google_android_gms_internal_zzanh = com_google_android_gms_internal_zzafo.f6289b;
                if (com_google_android_gms_internal_zzanh == null) {
                    obj = null;
                } else if (com_google_android_gms_internal_zzanh == null) {
                    throw null;
                } else {
                    obj = (View) com_google_android_gms_internal_zzanh;
                }
                if (obj == null) {
                    zzakb.m5371e("AdWebView is null");
                    return;
                }
                try {
                    List list = com_google_android_gms_internal_zzafo.f6301n != null ? com_google_android_gms_internal_zzafo.f6301n.f8061p : null;
                    if (list != null) {
                        if (!list.isEmpty()) {
                            zzvj h = com_google_android_gms_internal_zzafo.f6302o != null ? com_google_android_gms_internal_zzafo.f6302o.mo2188h() : null;
                            zzvm i = com_google_android_gms_internal_zzafo.f6302o != null ? com_google_android_gms_internal_zzafo.f6302o.mo2189i() : null;
                            if (list.contains("2") && h != null) {
                                h.mo2211b(zzn.m17692a(obj));
                                if (!h.mo2220j()) {
                                    h.mo2219i();
                                }
                                com_google_android_gms_internal_zzanh.mo4019w().m5446a("/nativeExpressViewClicked", zzaq.m4460a(h, null, com_google_android_gms_ads_internal_zzab));
                                return;
                            } else if (!list.contains("1") || i == null) {
                                zzakb.m5371e("No matching template id and mapper");
                                return;
                            } else {
                                i.mo2231b(zzn.m17692a(obj));
                                if (!i.mo2238h()) {
                                    i.mo2237g();
                                }
                                com_google_android_gms_internal_zzanh.mo4019w().m5446a("/nativeExpressViewClicked", zzaq.m4460a(null, i, com_google_android_gms_ads_internal_zzab));
                                return;
                            }
                        }
                    }
                    zzakb.m5371e("No template ids present in mediation response");
                } catch (Throwable e) {
                    zzakb.m5369c("Error occurred while recording impression and registering for clicks", e);
                }
            }
        }
    }

    public final void mo2002b(boolean z) {
        zzbq.m4816b("setManualImpressionsEnabled must be called from the main thread.");
        this.f19803i = z;
    }

    public final boolean mo2003b(zzjj com_google_android_gms_internal_zzjj) {
        zzi com_google_android_gms_ads_internal_zzi;
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        if (com_google_android_gms_internal_zzjj2.f18141h != this.f19803i) {
            boolean z;
            boolean z2;
            String str;
            zzmn com_google_android_gms_internal_zzmn;
            Location location;
            Location location2;
            int i = com_google_android_gms_internal_zzjj2.f18134a;
            long j = com_google_android_gms_internal_zzjj2.f18135b;
            Bundle bundle = com_google_android_gms_internal_zzjj2.f18136c;
            int i2 = com_google_android_gms_internal_zzjj2.f18137d;
            List list = com_google_android_gms_internal_zzjj2.f18138e;
            boolean z3 = com_google_android_gms_internal_zzjj2.f18139f;
            int i3 = com_google_android_gms_internal_zzjj2.f18140g;
            if (!com_google_android_gms_internal_zzjj2.f18141h) {
                if (!com_google_android_gms_ads_internal_zzi.f19803i) {
                    z = false;
                    z2 = z;
                    str = com_google_android_gms_internal_zzjj2.f18142i;
                    com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzjj2.f18143j;
                    location = com_google_android_gms_internal_zzjj2.f18144k;
                    location2 = location;
                    com_google_android_gms_internal_zzjj2 = new zzjj(i, j, bundle, i2, list, z3, i3, z2, str, com_google_android_gms_internal_zzmn, location2, com_google_android_gms_internal_zzjj2.f18145l, com_google_android_gms_internal_zzjj2.f18146m, com_google_android_gms_internal_zzjj2.f18147n, com_google_android_gms_internal_zzjj2.f18148o, com_google_android_gms_internal_zzjj2.f18149p, com_google_android_gms_internal_zzjj2.f18150q, com_google_android_gms_internal_zzjj2.f18151r);
                    com_google_android_gms_ads_internal_zzi = this;
                }
            }
            z = true;
            z2 = z;
            str = com_google_android_gms_internal_zzjj2.f18142i;
            com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzjj2.f18143j;
            location = com_google_android_gms_internal_zzjj2.f18144k;
            location2 = location;
            com_google_android_gms_internal_zzjj2 = new zzjj(i, j, bundle, i2, list, z3, i3, z2, str, com_google_android_gms_internal_zzmn, location2, com_google_android_gms_internal_zzjj2.f18145l, com_google_android_gms_internal_zzjj2.f18146m, com_google_android_gms_internal_zzjj2.f18147n, com_google_android_gms_internal_zzjj2.f18148o, com_google_android_gms_internal_zzjj2.f18149p, com_google_android_gms_internal_zzjj2.f18150q, com_google_android_gms_internal_zzjj2.f18151r);
            com_google_android_gms_ads_internal_zzi = this;
        }
        return super.mo2003b(com_google_android_gms_internal_zzjj2);
    }

    public final void onGlobalLayout() {
        m21533d(this.e.f5607j);
    }

    public final void onScrollChanged() {
        m21533d(this.e.f5607j);
    }

    public final zzll mo2015r() {
        zzbq.m4816b("getVideoController must be called from the main thread.");
        return (this.e.f5607j == null || this.e.f5607j.f6289b == null) ? null : this.e.f5607j.f6289b.mo3464b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo3951a(com.google.android.gms.internal.zzafo r5, com.google.android.gms.internal.zzafo r6) {
        /*
        r4 = this;
        r0 = super.mo3951a(r5, r6);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r4.e;
        r0 = r0.m4513c();
        if (r0 == 0) goto L_0x0025;
    L_0x0010:
        r5 = r4.m21525b(r5, r6);
        if (r5 != 0) goto L_0x0025;
    L_0x0016:
        r5 = r6.f6282H;
        if (r5 == 0) goto L_0x0021;
    L_0x001a:
        r5 = r6.f6282H;
        r6 = com.google.android.gms.internal.zziu.zza.zzb.AD_FAILED_TO_LOAD;
        r5.m6326a(r6);
    L_0x0021:
        r4.mo4265a(r1);
        return r1;
    L_0x0025:
        r5 = r6.f6298k;
        r0 = 0;
        if (r5 == 0) goto L_0x0060;
    L_0x002a:
        r4.m21533d(r6);
        com.google.android.gms.ads.internal.zzbs.m4506y();
        r5 = r4.e;
        r5 = r5.f5603f;
        com.google.android.gms.internal.zzaln.m5398a(r5, r4);
        com.google.android.gms.ads.internal.zzbs.m4506y();
        r5 = r4.e;
        r5 = r5.f5603f;
        com.google.android.gms.internal.zzaln.m5399a(r5, r4);
        r5 = r6.f6299l;
        if (r5 != 0) goto L_0x007d;
    L_0x0045:
        r5 = new com.google.android.gms.ads.internal.zzy;
        r5.<init>(r4);
        r1 = r6.f6289b;
        if (r1 == 0) goto L_0x0055;
    L_0x004e:
        r1 = r6.f6289b;
        r1 = r1.mo4019w();
        goto L_0x0056;
    L_0x0055:
        r1 = r0;
    L_0x0056:
        if (r1 == 0) goto L_0x007d;
    L_0x0058:
        r2 = new com.google.android.gms.ads.internal.zzz;
        r2.<init>(r6, r5);
        r1.f6625l = r2;
        goto L_0x007d;
    L_0x0060:
        r5 = r4.e;
        r5 = r5.m4514d();
        if (r5 == 0) goto L_0x007a;
    L_0x0068:
        r5 = com.google.android.gms.internal.zznh.bJ;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r5 = r2.m6488a(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x007d;
    L_0x007a:
        r4.mo4385a(r6, r1);
    L_0x007d:
        r5 = r6.f6289b;
        if (r5 == 0) goto L_0x00a1;
    L_0x0081:
        r5 = r6.f6289b;
        r5 = r5.mo3464b();
        r1 = r6.f6289b;
        r1 = r1.mo4019w();
        if (r1 == 0) goto L_0x0092;
    L_0x008f:
        r1.m5456g();
    L_0x0092:
        r1 = r4.e;
        r1 = r1.f5619v;
        if (r1 == 0) goto L_0x00a1;
    L_0x0098:
        if (r5 == 0) goto L_0x00a1;
    L_0x009a:
        r1 = r4.e;
        r1 = r1.f5619v;
        r5.m17882a(r1);
    L_0x00a1:
        r5 = r4.e;
        r5 = r5.m4513c();
        if (r5 == 0) goto L_0x0115;
    L_0x00a9:
        r5 = r6.f6289b;
        if (r5 == 0) goto L_0x0130;
    L_0x00ad:
        r5 = r6.f6297j;
        if (r5 == 0) goto L_0x00ba;
    L_0x00b1:
        r5 = r4.g;
        r1 = r4.e;
        r1 = r1.f5606i;
        r5.m13917a(r1, r6);
    L_0x00ba:
        r5 = r6.f6289b;
        if (r5 != 0) goto L_0x00bf;
    L_0x00be:
        throw r0;
    L_0x00bf:
        r0 = r5;
        r0 = (android.view.View) r0;
        r5 = new com.google.android.gms.internal.zzgp;
        r1 = r4.e;
        r1 = r1.f5600c;
        r5.<init>(r1, r0);
        r1 = com.google.android.gms.ads.internal.zzbs.m4507z();
        r2 = r4.e;
        r2 = r2.f5600c;
        r1 = r1.m5095b(r2);
        if (r1 == 0) goto L_0x00fb;
    L_0x00d9:
        r1 = r6.f6288a;
        r1 = com.google.android.gms.ads.internal.zza.m17424a(r1);
        if (r1 == 0) goto L_0x00fb;
    L_0x00e1:
        r1 = r4.e;
        r1 = r1.f5599b;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00fb;
    L_0x00eb:
        r1 = new com.google.android.gms.internal.zzafe;
        r2 = r4.e;
        r2 = r2.f5600c;
        r3 = r4.e;
        r3 = r3.f5599b;
        r1.<init>(r2, r3);
        r5.m6265a(r1);
    L_0x00fb:
        r1 = r6.m5110a();
        if (r1 == 0) goto L_0x0107;
    L_0x0101:
        r1 = r6.f6289b;
        r5.m6265a(r1);
        goto L_0x0130;
    L_0x0107:
        r1 = r6.f6289b;
        r1 = r1.mo4019w();
        r2 = new com.google.android.gms.ads.internal.zzaa;
        r2.<init>(r5, r6);
        r1.f6619f = r2;
        goto L_0x0130;
    L_0x0115:
        r5 = r4.e;
        r5 = r5.f5588E;
        if (r5 == 0) goto L_0x0130;
    L_0x011b:
        r5 = r6.f6297j;
        if (r5 == 0) goto L_0x0130;
    L_0x011f:
        r5 = r4.g;
        r0 = r4.e;
        r0 = r0.f5606i;
        r1 = r4.e;
        r1 = r1.f5588E;
        r5.m13918a(r0, r6, r1);
        r5 = r4.e;
        r0 = r5.f5588E;
    L_0x0130:
        r5 = r6.f6300m;
        if (r5 != 0) goto L_0x0139;
    L_0x0134:
        r5 = r4.e;
        r5.m4510a(r0);
    L_0x0139:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzx.a(com.google.android.gms.internal.zzafo, com.google.android.gms.internal.zzafo):boolean");
    }

    final void m21533d(zzafo com_google_android_gms_internal_zzafo) {
        if (!(com_google_android_gms_internal_zzafo == null || com_google_android_gms_internal_zzafo.f6299l || this.e.f5603f == null)) {
            zzbs.m4486e();
            if (zzahn.m5180a(this.e.f5603f, this.e.f5600c) && this.e.f5603f.getGlobalVisibleRect(new Rect(), null)) {
                if (!(com_google_android_gms_internal_zzafo == null || com_google_android_gms_internal_zzafo.f6289b == null || com_google_android_gms_internal_zzafo.f6289b.mo4019w() == null)) {
                    com_google_android_gms_internal_zzafo.f6289b.mo4019w().f6625l = null;
                }
                mo4385a(com_google_android_gms_internal_zzafo, false);
                com_google_android_gms_internal_zzafo.f6299l = true;
            }
        }
    }
}
