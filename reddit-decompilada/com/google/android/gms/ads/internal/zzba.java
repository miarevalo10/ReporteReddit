package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzakv;
import com.google.android.gms.internal.zzalf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzxl;
import com.google.android.gms.internal.zzya;
import com.google.android.gms.internal.zzzb;
import com.google.android.gms.internal.zzzf;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

@zzzv
public final class zzba extends zzd implements zzot {
    zzalf<zzou> f19544i;
    public zzanh f19545j;
    int f19546k;
    public final String f19547l;
    private final Object f19548n;
    private boolean f19549o;
    private boolean f19550p;
    private zzzb f19551q;

    public zzba(Context context, zzv com_google_android_gms_ads_internal_zzv, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd) {
        this(context, com_google_android_gms_ads_internal_zzv, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, false);
    }

    public zzba(Context context, zzv com_google_android_gms_ads_internal_zzv, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, boolean z) {
        super(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv);
        this.f19548n = new Object();
        this.f19544i = new zzalf();
        this.f19546k = 1;
        this.f19547l = UUID.randomUUID().toString();
        this.f19549o = z;
    }

    private final zzui m20855V() {
        return (this.e.f5607j == null || !this.e.f5607j.f6300m) ? null : this.e.f5607j.f6304q;
    }

    private final void m20856W() {
        zzzb E = m20862E();
        if (E != null) {
            E.mo3576a();
        }
    }

    private final void m20858a(zzoj com_google_android_gms_internal_zzoj) {
        zzahn.f6379a.post(new zzbe(this, com_google_android_gms_internal_zzoj));
    }

    private final void m20859a(zzol com_google_android_gms_internal_zzol) {
        zzahn.f6379a.post(new zzbf(this, com_google_android_gms_internal_zzol));
    }

    public final String mo1985A() {
        return this.e.f5599b;
    }

    public final void mo1988D() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public final zzzb m20862E() {
        zzzb com_google_android_gms_internal_zzzb;
        synchronized (this.f19548n) {
            com_google_android_gms_internal_zzzb = this.f19551q;
        }
        return com_google_android_gms_internal_zzzb;
    }

    public final SimpleArrayMap<String, zzqz> m20865H() {
        zzbq.m4816b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.e.f5617t;
    }

    public final void mo4262I() {
        if (this.f19545j != null) {
            this.f19545j.destroy();
            this.f19545j = null;
        }
    }

    public final void m20867J() {
        if (this.f19545j != null && this.f19545j.mo3464b() != null && this.e.f5618u != null && this.e.f5618u.f18243f != null) {
            this.f19545j.mo3464b().m17882a(this.e.f5618u.f18243f);
        }
    }

    public final boolean mo4263K() {
        return m20855V() != null ? m20855V().f8079o : false;
    }

    public final boolean mo4264L() {
        return m20855V() != null ? m20855V().f8080p : false;
    }

    public final void mo3942M() {
        if (this.e.f5607j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f5607j.f6303p)) {
            super.mo3942M();
        } else {
            m17478x();
        }
    }

    public final void mo3943N() {
        if (this.e.f5607j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f5607j.f6303p)) {
            super.mo3943N();
        } else {
            m17477w();
        }
    }

    public final void mo3944O() {
        zzafo com_google_android_gms_internal_zzafo = this.e.f5607j;
        if (com_google_android_gms_internal_zzafo.f6302o == null) {
            super.mo3944O();
            return;
        }
        try {
            zzva com_google_android_gms_internal_zzva = com_google_android_gms_internal_zzafo.f6302o;
            zzll com_google_android_gms_internal_zzll = null;
            zzvj h = com_google_android_gms_internal_zzva.mo2188h();
            if (h != null) {
                com_google_android_gms_internal_zzll = h.mo2223m();
            } else {
                zzvm i = com_google_android_gms_internal_zzva.mo2189i();
                if (i != null) {
                    com_google_android_gms_internal_zzll = i.mo2242l();
                } else {
                    zzqm n = com_google_android_gms_internal_zzva.mo2194n();
                    if (n != null) {
                        com_google_android_gms_internal_zzll = n.mo2144c();
                    }
                }
            }
            if (com_google_android_gms_internal_zzll != null) {
                zzlo h2 = com_google_android_gms_internal_zzll.mo2047h();
                if (h2 != null) {
                    h2.mo2054d();
                }
            }
        } catch (Throwable e) {
            zzakb.m5369c("Unable to call onVideoEnd()", e);
        }
    }

    protected final void mo4265a(int i) {
        mo4266a(i, false);
    }

    protected final void mo4266a(int i, boolean z) {
        m20856W();
        super.mo4266a(i, z);
    }

    public final void mo4267a(zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu) {
        if (com_google_android_gms_internal_zzafp.f6317d != null) {
            this.e.f5606i = com_google_android_gms_internal_zzafp.f6317d;
        }
        if (com_google_android_gms_internal_zzafp.f6318e != -2) {
            zzahn.f6379a.post(new zzbb(this, com_google_android_gms_internal_zzafp));
            return;
        }
        int i = com_google_android_gms_internal_zzafp.f6314a.f17392Y;
        int i2 = 0;
        if (i == 1) {
            this.e.f5589F = 0;
            zzbt com_google_android_gms_ads_internal_zzbt = this.e;
            zzbs.m4485d();
            com_google_android_gms_ads_internal_zzbt.f5605h = zzya.m6803a(this.e.f5600c, this, com_google_android_gms_internal_zzafp, this.e.f5601d, null, this.m, this, com_google_android_gms_internal_zznu);
            String str = "AdRenderer: ";
            String valueOf = String.valueOf(this.e.f5605h.getClass().getName());
            zzakb.m5366b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(com_google_android_gms_internal_zzafp.f6315b.f17442b).getJSONArray("slots");
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i3).getJSONArray("ads");
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    jSONArray.put(jSONArray3.get(i4));
                }
            }
            m20856W();
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
            List arrayList = new ArrayList();
            for (int i5 = 0; i5 < i; i5++) {
                arrayList.add(zzahh.m5149a(newFixedThreadPool, new zzbc(this, i5, jSONArray, i, com_google_android_gms_internal_zzafp)));
            }
            while (i2 < arrayList.size()) {
                try {
                    zzahn.f6379a.post(new zzbd(this, (zzou) ((zzakv) arrayList.get(i2)).get(((Long) zzkb.m6350f().m6488a(zznh.bn)).longValue(), TimeUnit.MILLISECONDS), i2, arrayList));
                } catch (Throwable e) {
                    zzakb.m5369c("Exception occurred while getting an ad response", e);
                    Thread.currentThread().interrupt();
                } catch (Throwable e2) {
                    zzakb.m5369c("Exception occurred while getting an ad response", e2);
                }
                i2++;
            }
        } catch (Throwable e22) {
            zzakb.m5369c("Malformed native ad response", e22);
            mo4265a(0);
        }
    }

    public final void mo1998a(zzoa com_google_android_gms_internal_zzoa) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public final void mo4268a(zzoq com_google_android_gms_internal_zzoq) {
        if (this.f19545j != null) {
            this.f19545j.mo3982a(com_google_android_gms_internal_zzoq);
        }
    }

    public final void mo1999a(zzxl com_google_android_gms_internal_zzxl) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    protected final boolean mo3951a(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        zzafo com_google_android_gms_internal_zzafo3 = com_google_android_gms_internal_zzafo2;
        List list = null;
        m20884b(null);
        if (this.e.m4513c()) {
            if (com_google_android_gms_internal_zzafo3.f6300m) {
                m20856W();
                try {
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
                        zzoj com_google_android_gms_internal_zzoj2 = com_google_android_gms_internal_zzoj;
                        com_google_android_gms_internal_zzoj2.mo3539a(new zzor(r7.e.f5600c, (zzot) r7, r7.e.f5601d, h, com_google_android_gms_internal_zzoj));
                        m20858a(com_google_android_gms_internal_zzoj2);
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
                        m20859a(com_google_android_gms_internal_zzol);
                    } else if (n == null || r7.e.f5617t == null || r7.e.f5617t.get(n.mo2149l()) == null) {
                        zzakb.m5371e("No matching mapper/listener for retrieved native ad template.");
                        mo4265a(0);
                        return false;
                    } else {
                        zzahn.f6379a.post(new zzbh(r7, n));
                    }
                } catch (Throwable e2) {
                    zzakb.m5369c("Failed to get native ad mapper", e2);
                }
            } else {
                zzou com_google_android_gms_internal_zzou = com_google_android_gms_internal_zzafo3.f6276B;
                if (r7.f19549o) {
                    r7.f19544i.m13330b(com_google_android_gms_internal_zzou);
                } else if ((com_google_android_gms_internal_zzou instanceof zzol) && r7.e.f5615r != null) {
                    m20859a((zzol) com_google_android_gms_internal_zzafo3.f6276B);
                } else if (!(com_google_android_gms_internal_zzou instanceof zzoj) || r7.e.f5614q == null) {
                    if ((com_google_android_gms_internal_zzou instanceof zzon) && r7.e.f5617t != null) {
                        zzon com_google_android_gms_internal_zzon = (zzon) com_google_android_gms_internal_zzou;
                        if (r7.e.f5617t.get(com_google_android_gms_internal_zzon.mo3541l()) != null) {
                            zzahn.f6379a.post(new zzbg(r7, com_google_android_gms_internal_zzon.mo3541l(), com_google_android_gms_internal_zzafo3));
                        }
                    }
                    zzakb.m5371e("No matching listener for retrieved native ad template.");
                    mo4265a(0);
                    return false;
                } else {
                    m20858a((zzoj) com_google_android_gms_internal_zzafo3.f6276B);
                }
            }
            return super.mo3951a(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzafo2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public final boolean mo3952a(zzjj com_google_android_gms_internal_zzjj, zznu com_google_android_gms_internal_zznu) {
        try {
            j_();
            return super.m20160a(com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zznu, this.f19546k);
        } catch (Throwable e) {
            String str = "Error initializing webview.";
            if (zzakb.m5365a(4)) {
                Log.i(AdRequest.LOGTAG, str, e);
            }
            return false;
        }
    }

    public final zzqw mo4271b(String str) {
        zzbq.m4816b("getOnCustomClickListener must be called on the main UI thread.");
        return this.e.f5616s == null ? null : (zzqw) this.e.f5616s.get(str);
    }

    public final void m20884b(List<String> list) {
        zzbq.m4816b("setNativeTemplates must be called on the main UI thread.");
        this.e.f5586C = list;
    }

    protected final void mo4272d(boolean z) {
        super.mo4272d(z);
        if (this.f19550p) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bS)).booleanValue()) {
                m20863F();
            }
        }
    }

    final void j_() throws zzanv {
        synchronized (this.f19548n) {
            zzagf.m13278a("Initializing webview native ads utills");
            this.f19551q = new zzzf(this.e.f5600c, this, this.f19547l, this.e.f5601d, this.e.f5602e);
        }
    }

    public final void mo2011n() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public final void mo2012o() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    protected final void mo4273v() {
        mo4272d(false);
    }

    protected final boolean mo4270a(zzjj com_google_android_gms_internal_zzjj, zzafo com_google_android_gms_internal_zzafo, boolean z) {
        return this.d.f5534b;
    }

    public final void mo4269a(zzos com_google_android_gms_internal_zzos) {
        if (this.e.f5607j.f6297j != null) {
            zzbs.m4490i().f14073b.m13920a(this.e.f5606i, this.e.f5607j, new zzfv(com_google_android_gms_internal_zzos), (zzanh) null);
        }
    }

    public final void m20863F() {
        if (this.e.f5607j == null || this.f19545j == null) {
            this.f19550p = true;
            zzakb.m5371e("Request to enable ActiveView before adState is available.");
            return;
        }
        zzfs com_google_android_gms_internal_zzfs = zzbs.m4490i().f14073b;
        zzjn com_google_android_gms_internal_zzjn = this.e.f5606i;
        zzafo com_google_android_gms_internal_zzafo = this.e.f5607j;
        zzanh com_google_android_gms_internal_zzanh = this.f19545j;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        com_google_android_gms_internal_zzfs.m13919a(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzafo, (View) com_google_android_gms_internal_zzanh, this.f19545j);
        this.f19550p = false;
    }

    public final void m20864G() {
        this.f19550p = false;
        if (this.e.f5607j == null || this.f19545j == null) {
            zzakb.m5371e("Request to enable ActiveView before adState is available.");
        } else {
            zzbs.m4490i().f14073b.m13915a(this.e.f5607j);
        }
    }

    static /* synthetic */ void m20857a(zzbt com_google_android_gms_ads_internal_zzbt, zzbt com_google_android_gms_ads_internal_zzbt2) {
        if (com_google_android_gms_ads_internal_zzbt2.f5614q == null) {
            com_google_android_gms_ads_internal_zzbt2.f5614q = com_google_android_gms_ads_internal_zzbt.f5614q;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5615r == null) {
            com_google_android_gms_ads_internal_zzbt2.f5615r = com_google_android_gms_ads_internal_zzbt.f5615r;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5616s == null) {
            com_google_android_gms_ads_internal_zzbt2.f5616s = com_google_android_gms_ads_internal_zzbt.f5616s;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5617t == null) {
            com_google_android_gms_ads_internal_zzbt2.f5617t = com_google_android_gms_ads_internal_zzbt.f5617t;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5619v == null) {
            com_google_android_gms_ads_internal_zzbt2.f5619v = com_google_android_gms_ads_internal_zzbt.f5619v;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5618u == null) {
            com_google_android_gms_ads_internal_zzbt2.f5618u = com_google_android_gms_ads_internal_zzbt.f5618u;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5586C == null) {
            com_google_android_gms_ads_internal_zzbt2.f5586C = com_google_android_gms_ads_internal_zzbt.f5586C;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5609l == null) {
            com_google_android_gms_ads_internal_zzbt2.f5609l = com_google_android_gms_ads_internal_zzbt.f5609l;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5587D == null) {
            com_google_android_gms_ads_internal_zzbt2.f5587D = com_google_android_gms_ads_internal_zzbt.f5587D;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5610m == null) {
            com_google_android_gms_ads_internal_zzbt2.f5610m = com_google_android_gms_ads_internal_zzbt.f5610m;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5611n == null) {
            com_google_android_gms_ads_internal_zzbt2.f5611n = com_google_android_gms_ads_internal_zzbt.f5611n;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5606i == null) {
            com_google_android_gms_ads_internal_zzbt2.f5606i = com_google_android_gms_ads_internal_zzbt.f5606i;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5607j == null) {
            com_google_android_gms_ads_internal_zzbt2.f5607j = com_google_android_gms_ads_internal_zzbt.f5607j;
        }
        if (com_google_android_gms_ads_internal_zzbt2.f5608k == null) {
            com_google_android_gms_ads_internal_zzbt2.f5608k = com_google_android_gms_ads_internal_zzbt.f5608k;
        }
    }
}
