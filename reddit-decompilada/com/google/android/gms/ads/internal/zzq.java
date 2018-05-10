package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzya;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzzv
public final class zzq extends zzd implements zzot {
    private boolean f19553i;
    private zzafo f19554j;
    private boolean f19555k = false;

    public zzq(Context context, zzv com_google_android_gms_ads_internal_zzv, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd) {
        super(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv);
    }

    private final zzui m20898E() {
        return (this.e.f5607j == null || !this.e.f5607j.f6300m) ? null : this.e.f5607j.f6304q;
    }

    private static zzafo m20900a(zzafp com_google_android_gms_internal_zzafp, int i) {
        zzafp com_google_android_gms_internal_zzafp2 = com_google_android_gms_internal_zzafp;
        zzjj com_google_android_gms_internal_zzjj = com_google_android_gms_internal_zzafp2.f6314a.f17396c;
        List list = com_google_android_gms_internal_zzafp2.f6315b.f17443c;
        List list2 = com_google_android_gms_internal_zzafp2.f6315b.f17445e;
        List list3 = com_google_android_gms_internal_zzafp2.f6315b.f17449i;
        int i2 = com_google_android_gms_internal_zzafp2.f6315b.f17451k;
        long j = com_google_android_gms_internal_zzafp2.f6315b.f17450j;
        String str = com_google_android_gms_internal_zzafp2.f6314a.f17402i;
        boolean z = com_google_android_gms_internal_zzafp2.f6315b.f17447g;
        zzui com_google_android_gms_internal_zzui = com_google_android_gms_internal_zzafp2.f6316c;
        long j2 = com_google_android_gms_internal_zzafp2.f6315b.f17448h;
        zzjn com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzafp2.f6317d;
        long j3 = j2;
        zzui com_google_android_gms_internal_zzui2 = com_google_android_gms_internal_zzui;
        long j4 = com_google_android_gms_internal_zzafp2.f6315b.f17446f;
        long j5 = com_google_android_gms_internal_zzafp2.f6319f;
        long j6 = com_google_android_gms_internal_zzafp2.f6320g;
        String str2 = com_google_android_gms_internal_zzafp2.f6315b.f17454n;
        JSONObject jSONObject = com_google_android_gms_internal_zzafp2.f6321h;
        zzaeq com_google_android_gms_internal_zzaeq = com_google_android_gms_internal_zzafp2.f6315b.f17421A;
        List list4 = com_google_android_gms_internal_zzafp2.f6315b.f17422B;
        List list5 = com_google_android_gms_internal_zzafp2.f6315b.f17422B;
        boolean z2 = com_google_android_gms_internal_zzafp2.f6315b.f17424D;
        zzaaz com_google_android_gms_internal_zzaaz = com_google_android_gms_internal_zzafp2.f6315b.f17425E;
        List list6 = com_google_android_gms_internal_zzafp2.f6315b.f17428H;
        String str3 = com_google_android_gms_internal_zzafp2.f6315b.f17432L;
        long j7 = j6;
        zzis com_google_android_gms_internal_zzis = com_google_android_gms_internal_zzafp2.f6322i;
        String str4 = str3;
        zzaeq com_google_android_gms_internal_zzaeq2 = com_google_android_gms_internal_zzaeq;
        List list7 = list4;
        List list8 = list5;
        boolean z3 = z2;
        zzaaz com_google_android_gms_internal_zzaaz2 = com_google_android_gms_internal_zzaaz;
        List list9 = list6;
        zzanh com_google_android_gms_internal_zzanh = null;
        JSONObject jSONObject2 = jSONObject;
        int i3 = i;
        zzjn com_google_android_gms_internal_zzjn2 = com_google_android_gms_internal_zzjn;
        zzuh com_google_android_gms_internal_zzuh = null;
        String str5 = str2;
        zzva com_google_android_gms_internal_zzva = null;
        long j8 = j4;
        zzis com_google_android_gms_internal_zzis2 = com_google_android_gms_internal_zzis;
        String str6 = null;
        boolean z4 = com_google_android_gms_internal_zzafp2.f6315b.f17435O;
        return new zzafo(com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zzanh, list, i3, list2, list3, i2, j, str, z, com_google_android_gms_internal_zzuh, com_google_android_gms_internal_zzva, str6, com_google_android_gms_internal_zzui2, null, j3, com_google_android_gms_internal_zzjn2, j8, j5, j7, str5, jSONObject2, null, com_google_android_gms_internal_zzaeq2, list7, list8, z3, com_google_android_gms_internal_zzaaz2, null, list9, str4, com_google_android_gms_internal_zzis2, z4, com_google_android_gms_internal_zzafp2.f6323j);
    }

    private final boolean m20901b(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        zzafo com_google_android_gms_internal_zzafo3 = com_google_android_gms_internal_zzafo2;
        List list = null;
        m20916b(null);
        if (this.e.m4513c()) {
            try {
                Handler handler;
                Runnable com_google_android_gms_ads_internal_zzs;
                zzvj h = com_google_android_gms_internal_zzafo3.f6302o != null ? com_google_android_gms_internal_zzafo3.f6302o.mo2188h() : null;
                zzvm i = com_google_android_gms_internal_zzafo3.f6302o != null ? com_google_android_gms_internal_zzafo3.f6302o.mo2189i() : null;
                zzqm n = com_google_android_gms_internal_zzafo3.f6302o != null ? com_google_android_gms_internal_zzafo3.f6302o.mo2194n() : null;
                String c = zzd.m20141c(com_google_android_gms_internal_zzafo2);
                String a;
                List b;
                String c2;
                zzpq d;
                String e;
                if (h != null && r7.e.f5614q != null) {
                    a = h.mo2208a();
                    b = h.mo2210b();
                    c2 = h.mo2212c();
                    d = h.mo2214d() != null ? h.mo2214d() : null;
                    e = h.mo2215e();
                    double f = h.mo2216f();
                    String g = h.mo2217g();
                    String h2 = h.mo2218h();
                    Bundle l = h.mo2222l();
                    zzll m = h.mo2223m();
                    if (h.mo2226p() != null) {
                        list = (View) zzn.m17693a(h.mo2226p());
                    }
                    zzou com_google_android_gms_internal_zzoj = new zzoj(a, b, c2, d, e, f, g, h2, null, l, m, list, h.mo2227q(), c);
                    zzou com_google_android_gms_internal_zzou = com_google_android_gms_internal_zzoj;
                    com_google_android_gms_internal_zzou.mo3539a(new zzor(r7.e.f5600c, (zzot) r7, r7.e.f5601d, h, com_google_android_gms_internal_zzoj));
                    handler = zzahn.f6379a;
                    com_google_android_gms_ads_internal_zzs = new zzs(r7, com_google_android_gms_internal_zzou);
                } else if (i != null && r7.e.f5615r != null) {
                    a = i.mo2228a();
                    b = i.mo2230b();
                    c2 = i.mo2232c();
                    d = i.mo2234d() != null ? i.mo2234d() : null;
                    e = i.mo2235e();
                    String f2 = i.mo2236f();
                    Bundle j = i.mo2240j();
                    zzll l2 = i.mo2242l();
                    if (i.mo2244n() != null) {
                        list = (View) zzn.m17693a(i.mo2244n());
                    }
                    zzol com_google_android_gms_internal_zzol = new zzol(a, b, c2, d, e, f2, null, j, l2, list, i.mo2245o(), c);
                    com_google_android_gms_internal_zzol.mo3539a(new zzor(r7.e.f5600c, (zzot) r7, r7.e.f5601d, i, (zzou) com_google_android_gms_internal_zzol));
                    handler = zzahn.f6379a;
                    com_google_android_gms_ads_internal_zzs = new zzt(r7, com_google_android_gms_internal_zzol);
                } else if (n == null || r7.e.f5617t == null || r7.e.f5617t.get(n.mo2149l()) == null) {
                    zzakb.m5371e("No matching mapper/listener for retrieved native ad template.");
                    mo4265a(0);
                    return false;
                } else {
                    zzahn.f6379a.post(new zzu(r7, n));
                    return super.mo3951a(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzafo2);
                }
                handler.post(com_google_android_gms_ads_internal_zzs);
                return super.mo3951a(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzafo2);
            } catch (Throwable e2) {
                zzakb.m5369c("Failed to get native ad mapper", e2);
            }
        } else {
            zzakb.m5371e("Native ad does not have custom rendering mode.");
        }
        mo4265a(0);
        return false;
    }

    private final boolean m20902c(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        View a = zzaq.m4459a(com_google_android_gms_internal_zzafo2);
        if (a == null) {
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
                m17432a(a);
            } catch (Throwable th) {
                zzbs.m4490i().m13246a(th, "AdLoaderManager.swapBannerViews");
                zzakb.m5369c("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.e.f5603f.getChildCount() > 1) {
            this.e.f5603f.showNext();
        }
        if (com_google_android_gms_internal_zzafo != null) {
            View nextView2 = this.e.f5603f.getNextView();
            if (nextView2 != null) {
                this.e.f5603f.removeView(nextView2);
            }
            this.e.m4512b();
        }
        this.e.f5603f.setMinimumWidth(mo2008k().f18157f);
        this.e.f5603f.setMinimumHeight(mo2008k().f18154c);
        this.e.f5603f.requestLayout();
        this.e.f5603f.setVisibility(0);
        return true;
    }

    public final void mo1988D() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    public final void mo4262I() {
        zzakb.m5371e("Unexpected call to AdLoaderManager method");
    }

    public final boolean mo4263K() {
        return m20898E() != null ? m20898E().f8079o : false;
    }

    public final boolean mo4264L() {
        return m20898E() != null ? m20898E().f8080p : false;
    }

    public final void mo3942M() {
        if (this.e.f5607j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f5607j.f6303p) || this.e.f5607j.f6301n == null || !this.e.f5607j.f6301n.m6671b()) {
            super.mo3942M();
        } else {
            m17478x();
        }
    }

    public final void mo3943N() {
        if (this.e.f5607j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f5607j.f6303p) || this.e.f5607j.f6301n == null || !this.e.f5607j.f6301n.m6671b()) {
            super.mo3943N();
        } else {
            m17477w();
        }
    }

    public final void mo4267a(zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu) {
        zzafo a;
        this.f19554j = null;
        if (com_google_android_gms_internal_zzafp.f6318e != -2) {
            a = m20900a(com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzafp.f6318e);
        } else {
            if (!com_google_android_gms_internal_zzafp.f6315b.f17447g) {
                zzakb.m5371e("partialAdState is not mediation");
                a = m20900a(com_google_android_gms_internal_zzafp, 0);
            }
            if (this.f19554j == null) {
                zzahn.f6379a.post(new zzr(this));
            }
            if (com_google_android_gms_internal_zzafp.f6317d != null) {
                this.e.f5606i = com_google_android_gms_internal_zzafp.f6317d;
            }
            this.e.f5589F = 0;
            zzbt com_google_android_gms_ads_internal_zzbt = this.e;
            zzbs.m4485d();
            com_google_android_gms_ads_internal_zzbt.f5605h = zzya.m6803a(this.e.f5600c, this, com_google_android_gms_internal_zzafp, this.e.f5601d, null, this.m, this, com_google_android_gms_internal_zznu);
            return;
        }
        this.f19554j = a;
        if (this.f19554j == null) {
            if (com_google_android_gms_internal_zzafp.f6317d != null) {
                this.e.f5606i = com_google_android_gms_internal_zzafp.f6317d;
            }
            this.e.f5589F = 0;
            zzbt com_google_android_gms_ads_internal_zzbt2 = this.e;
            zzbs.m4485d();
            com_google_android_gms_ads_internal_zzbt2.f5605h = zzya.m6803a(this.e.f5600c, this, com_google_android_gms_internal_zzafp, this.e.f5601d, null, this.m, this, com_google_android_gms_internal_zznu);
            return;
        }
        zzahn.f6379a.post(new zzr(this));
    }

    public final void mo1998a(zzoa com_google_android_gms_internal_zzoa) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    public final void mo4268a(zzoq com_google_android_gms_internal_zzoq) {
        zzakb.m5371e("Unexpected call to AdLoaderManager method");
    }

    public final void mo4269a(zzos com_google_android_gms_internal_zzos) {
        zzakb.m5371e("Unexpected call to AdLoaderManager method");
    }

    protected final boolean mo4270a(zzjj com_google_android_gms_internal_zzjj, zzafo com_google_android_gms_internal_zzafo, boolean z) {
        return false;
    }

    public final zzqw mo4271b(String str) {
        zzbq.m4816b("getOnCustomClickListener must be called on the main UI thread.");
        return (zzqw) this.e.f5616s.get(str);
    }

    public final void m20916b(List<String> list) {
        zzbq.m4816b("setNativeTemplates must be called on the main UI thread.");
        this.e.f5586C = list;
    }

    public final void mo2002b(boolean z) {
        zzbq.m4816b("setManualImpressionsEnabled must be called from the main thread.");
        this.f19553i = z;
    }

    public final boolean mo2003b(zzjj com_google_android_gms_internal_zzjj) {
        zzd com_google_android_gms_ads_internal_zzd;
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        boolean z = this.e.f5622y != null && com_google_android_gms_ads_internal_zzd.e.f5622y.size() == 1 && ((Integer) com_google_android_gms_ads_internal_zzd.e.f5622y.get(0)).intValue() == 2;
        if (z) {
            zzakb.m5368c("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            mo4265a(0);
            return false;
        } else if (com_google_android_gms_ads_internal_zzd.e.f5621x == null) {
            return super.mo2003b(com_google_android_gms_internal_zzjj);
        } else {
            if (com_google_android_gms_internal_zzjj2.f18141h != com_google_android_gms_ads_internal_zzd.f19553i) {
                boolean z2;
                String str;
                zzmn com_google_android_gms_internal_zzmn;
                int i = com_google_android_gms_internal_zzjj2.f18134a;
                long j = com_google_android_gms_internal_zzjj2.f18135b;
                Bundle bundle = com_google_android_gms_internal_zzjj2.f18136c;
                int i2 = com_google_android_gms_internal_zzjj2.f18137d;
                List list = com_google_android_gms_internal_zzjj2.f18138e;
                boolean z3 = com_google_android_gms_internal_zzjj2.f18139f;
                int i3 = com_google_android_gms_internal_zzjj2.f18140g;
                if (!com_google_android_gms_internal_zzjj2.f18141h) {
                    if (!com_google_android_gms_ads_internal_zzd.f19553i) {
                        z2 = false;
                        str = com_google_android_gms_internal_zzjj2.f18142i;
                        com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzjj2.f18143j;
                        com_google_android_gms_internal_zzjj2 = new zzjj(i, j, bundle, i2, list, z3, i3, z2, str, com_google_android_gms_internal_zzmn, com_google_android_gms_internal_zzjj2.f18144k, com_google_android_gms_internal_zzjj2.f18145l, com_google_android_gms_internal_zzjj2.f18146m, com_google_android_gms_internal_zzjj2.f18147n, com_google_android_gms_internal_zzjj2.f18148o, com_google_android_gms_internal_zzjj2.f18149p, com_google_android_gms_internal_zzjj2.f18150q, com_google_android_gms_internal_zzjj2.f18151r);
                        com_google_android_gms_ads_internal_zzd = this;
                    }
                }
                z2 = true;
                str = com_google_android_gms_internal_zzjj2.f18142i;
                com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzjj2.f18143j;
                com_google_android_gms_internal_zzjj2 = new zzjj(i, j, bundle, i2, list, z3, i3, z2, str, com_google_android_gms_internal_zzmn, com_google_android_gms_internal_zzjj2.f18144k, com_google_android_gms_internal_zzjj2.f18145l, com_google_android_gms_internal_zzjj2.f18146m, com_google_android_gms_internal_zzjj2.f18147n, com_google_android_gms_internal_zzjj2.f18148o, com_google_android_gms_internal_zzjj2.f18149p, com_google_android_gms_internal_zzjj2.f18150q, com_google_android_gms_internal_zzjj2.f18151r);
                com_google_android_gms_ads_internal_zzd = this;
            }
            return super.mo2003b(com_google_android_gms_internal_zzjj2);
        }
    }

    public final void m20919c(List<Integer> list) {
        zzbq.m4816b("setAllowedAdTypes must be called on the main UI thread.");
        this.e.f5622y = list;
    }

    public final void mo2011n() {
        if (this.f19555k) {
            super.mo2011n();
            return;
        }
        throw new IllegalStateException("Native Ad does not support pause().");
    }

    public final void mo2012o() {
        if (this.f19555k) {
            super.mo2012o();
            return;
        }
        throw new IllegalStateException("Native Ad does not support resume().");
    }

    public final zzll mo2015r() {
        return null;
    }

    protected final void mo4273v() {
        super.mo4273v();
        zzafo com_google_android_gms_internal_zzafo = this.e.f5607j;
        if (!(com_google_android_gms_internal_zzafo == null || com_google_android_gms_internal_zzafo.f6301n == null || !com_google_android_gms_internal_zzafo.f6301n.m6670a() || this.e.f5621x == null)) {
            try {
                this.e.f5621x.mo2155a(this, zzn.m17692a(this.e.f5600c));
            } catch (Throwable e) {
                zzakb.m5369c("Could not call PublisherAdViewLoadedListener.onPublisherAdViewLoaded().", e);
            }
        }
    }

    protected final boolean mo3951a(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        if (!this.e.m4513c()) {
            throw new IllegalStateException("AdLoader API does not support custom rendering.");
        } else if (com_google_android_gms_internal_zzafo2.f6300m) {
            if (com_google_android_gms_internal_zzafo2.f6301n != null && com_google_android_gms_internal_zzafo2.f6301n.m6670a()) {
                if (this.e.m4513c() && this.e.f5603f != null) {
                    this.e.f5603f.f5624a.f6394a = com_google_android_gms_internal_zzafo2.f6313z;
                }
                if (super.mo3951a(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzafo2)) {
                    if (this.e.m4513c() && m20902c(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzafo2) == null) {
                        mo4265a(0);
                    } else {
                        if (this.e.m4514d() == null) {
                            super.mo4385a(com_google_android_gms_internal_zzafo2, false);
                        }
                        com_google_android_gms_internal_zzafo = 1;
                        if (com_google_android_gms_internal_zzafo == null) {
                            return false;
                        }
                        this.f19555k = true;
                    }
                }
                com_google_android_gms_internal_zzafo = null;
                if (com_google_android_gms_internal_zzafo == null) {
                    return false;
                }
                this.f19555k = true;
            } else if (com_google_android_gms_internal_zzafo2.f6301n == null || !com_google_android_gms_internal_zzafo2.f6301n.m6671b()) {
                mo4265a(0);
                zzakb.m5371e("Response is neither banner nor native.");
                return false;
            } else if (m20901b(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzafo2) == null) {
                return false;
            }
            m20919c(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
            return true;
        } else {
            mo4265a(0);
            zzakb.m5371e("newState is not mediation.");
            return false;
        }
    }
}
