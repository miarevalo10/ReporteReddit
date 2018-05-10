package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzak;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@zzzv
public final class zztl extends zzkt {
    private final String f18300a;
    private boolean f18301b;
    private final zzsd f18302c;
    private zzak f18303d;
    private final zztd f18304e;

    public zztl(Context context, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, zzv com_google_android_gms_ads_internal_zzv) {
        this(str, new zzsd(context, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_ads_internal_zzv));
    }

    public final String mo1985A() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final zzkx mo1986B() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzkh mo1987C() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final void mo1988D() throws RemoteException {
        if (this.f18303d != null) {
            this.f18303d.mo2004c(this.f18301b);
            this.f18303d.mo1988D();
            return;
        }
        zzakb.m5371e("Interstitial ad must be loaded before showInterstitial().");
    }

    public final String mo1989a() throws RemoteException {
        return this.f18303d != null ? this.f18303d.mo1989a() : null;
    }

    public final void mo1990a(zzadp com_google_android_gms_internal_zzadp) {
        this.f18304e.f8001e = com_google_android_gms_internal_zzadp;
        if (this.f18303d != null) {
            this.f18304e.m6639a(this.f18303d);
        }
    }

    public final void mo1991a(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
        if (this.f18303d != null) {
            this.f18303d.mo1991a(com_google_android_gms_internal_zzjn);
        }
    }

    public final void mo1992a(zzke com_google_android_gms_internal_zzke) throws RemoteException {
        this.f18304e.f8000d = com_google_android_gms_internal_zzke;
        if (this.f18303d != null) {
            this.f18304e.m6639a(this.f18303d);
        }
    }

    public final void mo1993a(zzkh com_google_android_gms_internal_zzkh) throws RemoteException {
        this.f18304e.f7997a = com_google_android_gms_internal_zzkh;
        if (this.f18303d != null) {
            this.f18304e.m6639a(this.f18303d);
        }
    }

    public final void mo1994a(zzkx com_google_android_gms_internal_zzkx) throws RemoteException {
        this.f18304e.f7998b = com_google_android_gms_internal_zzkx;
        if (this.f18303d != null) {
            this.f18304e.m6639a(this.f18303d);
        }
    }

    public final void mo1995a(zzld com_google_android_gms_internal_zzld) throws RemoteException {
        m19003c();
        if (this.f18303d != null) {
            this.f18303d.mo1995a(com_google_android_gms_internal_zzld);
        }
    }

    public final void mo1996a(zzlr com_google_android_gms_internal_zzlr) {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1997a(zzmr com_google_android_gms_internal_zzmr) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public final void mo1998a(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
        this.f18304e.f7999c = com_google_android_gms_internal_zzoa;
        if (this.f18303d != null) {
            this.f18304e.m6639a(this.f18303d);
        }
    }

    public final void mo1999a(zzxl com_google_android_gms_internal_zzxl) throws RemoteException {
        zzakb.m5371e("setInAppPurchaseListener is deprecated and should not be called.");
    }

    public final void mo2000a(zzxr com_google_android_gms_internal_zzxr, String str) throws RemoteException {
        zzakb.m5371e("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    public final void mo2001a(String str) {
    }

    public final void mo2002b(boolean z) throws RemoteException {
        m19003c();
        if (this.f18303d != null) {
            this.f18303d.mo2002b(z);
        }
    }

    public final void mo2004c(boolean z) {
        this.f18301b = z;
    }

    public final String g_() throws RemoteException {
        return this.f18303d != null ? this.f18303d.g_() : null;
    }

    public final void mo2006i() throws RemoteException {
        if (this.f18303d != null) {
            this.f18303d.mo2006i();
        }
    }

    public final IObjectWrapper mo2007j() throws RemoteException {
        return this.f18303d != null ? this.f18303d.mo2007j() : null;
    }

    public final zzjn mo2008k() throws RemoteException {
        return this.f18303d != null ? this.f18303d.mo2008k() : null;
    }

    public final boolean mo2009l() throws RemoteException {
        return this.f18303d != null && this.f18303d.mo2009l();
    }

    public final void mo2010m() throws RemoteException {
        if (this.f18303d != null) {
            this.f18303d.mo2010m();
        } else {
            zzakb.m5371e("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public final void mo2011n() throws RemoteException {
        if (this.f18303d != null) {
            this.f18303d.mo2011n();
        }
    }

    public final void mo2012o() throws RemoteException {
        if (this.f18303d != null) {
            this.f18303d.mo2012o();
        }
    }

    public final void mo2013p() throws RemoteException {
        if (this.f18303d != null) {
            this.f18303d.mo2013p();
        }
    }

    public final boolean mo2014q() throws RemoteException {
        return this.f18303d != null && this.f18303d.mo2014q();
    }

    public final zzll mo2015r() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    private zztl(String str, zzsd com_google_android_gms_internal_zzsd) {
        this.f18300a = str;
        this.f18302c = com_google_android_gms_internal_zzsd;
        this.f18304e = new zztd();
        str = zzbs.m4498q();
        if (str.f8005c == null) {
            str.f8005c = new zzsd(com_google_android_gms_internal_zzsd.f7990a.getApplicationContext(), com_google_android_gms_internal_zzsd.f7991b, com_google_android_gms_internal_zzsd.f7992c, com_google_android_gms_internal_zzsd.f7993d);
            if (str.f8005c != null) {
                int i = 0;
                com_google_android_gms_internal_zzsd = str.f8005c.f7990a.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (str.f8004b.size() > 0) {
                    zzth com_google_android_gms_internal_zzth = (zzth) str.f8004b.remove();
                    zzti com_google_android_gms_internal_zzti = (zzti) str.f8003a.get(com_google_android_gms_internal_zzth);
                    zztg.m6642a("Flushing interstitial queue for %s.", com_google_android_gms_internal_zzth);
                    while (com_google_android_gms_internal_zzti.f8007a.size() > 0) {
                        com_google_android_gms_internal_zzti.m6653a(null).f8012a.m21511F();
                    }
                    str.f8003a.remove(com_google_android_gms_internal_zzth);
                }
                try {
                    Map hashMap = new HashMap();
                    for (Entry entry : com_google_android_gms_internal_zzsd.getAll().entrySet()) {
                        if (!((String) entry.getKey()).equals("PoolKeys")) {
                            zztm a = zztm.m6657a((String) entry.getValue());
                            zzth com_google_android_gms_internal_zzth2 = new zzth(a.f8025a, a.f8026b, a.f8027c);
                            if (!str.f8003a.containsKey(com_google_android_gms_internal_zzth2)) {
                                str.f8003a.put(com_google_android_gms_internal_zzth2, new zzti(a.f8025a, a.f8026b, a.f8027c));
                                hashMap.put(com_google_android_gms_internal_zzth2.toString(), com_google_android_gms_internal_zzth2);
                                zztg.m6642a("Restored interstitial queue for %s.", com_google_android_gms_internal_zzth2);
                            }
                        }
                    }
                    com_google_android_gms_internal_zzsd = zztg.m6643a(com_google_android_gms_internal_zzsd.getString("PoolKeys", ""));
                    int length = com_google_android_gms_internal_zzsd.length;
                    while (i < length) {
                        zzth com_google_android_gms_internal_zzth3 = (zzth) hashMap.get(com_google_android_gms_internal_zzsd[i]);
                        if (str.f8003a.containsKey(com_google_android_gms_internal_zzth3)) {
                            str.f8004b.add(com_google_android_gms_internal_zzth3);
                        }
                        i++;
                    }
                } catch (Throwable e) {
                    zzbs.m4490i().m13246a(e, "InterstitialAdPool.restore");
                    zzakb.m5369c("Malformed preferences value for InterstitialAdPool.", e);
                    str.f8003a.clear();
                    str.f8004b.clear();
                }
            }
        }
    }

    public final boolean mo2003b(zzjj com_google_android_gms_internal_zzjj) throws RemoteException {
        if (!zztg.m6640a(com_google_android_gms_internal_zzjj).contains("gw")) {
            m19003c();
        }
        if (zztg.m6640a(com_google_android_gms_internal_zzjj).contains("_skipMediation")) {
            m19003c();
        }
        if (com_google_android_gms_internal_zzjj.f18143j != null) {
            m19003c();
        }
        if (this.f18303d != null) {
            return this.f18303d.mo2003b(com_google_android_gms_internal_zzjj);
        }
        String str;
        int i;
        zztj a;
        zztg q = zzbs.m4498q();
        if (zztg.m6640a(com_google_android_gms_internal_zzjj).contains("_ad")) {
            str = this.f18300a;
            if (q.f8005c != null) {
                i = new zzacp(q.f8005c.f7990a.getApplicationContext()).m5012a().f6175n;
                zzjj c = zztg.m6647c(com_google_android_gms_internal_zzjj);
                str = zztg.m6648c(str);
                zzth com_google_android_gms_internal_zzth = new zzth(c, str, i);
                zzti com_google_android_gms_internal_zzti = (zzti) q.f8003a.get(com_google_android_gms_internal_zzth);
                if (com_google_android_gms_internal_zzti == null) {
                    zztg.m6642a("Interstitial pool created at %s.", com_google_android_gms_internal_zzth);
                    com_google_android_gms_internal_zzti = new zzti(c, str, i);
                    q.f8003a.put(com_google_android_gms_internal_zzth, com_google_android_gms_internal_zzti);
                }
                com_google_android_gms_internal_zzti.f8007a.add(new zztj(com_google_android_gms_internal_zzti, q.f8005c, com_google_android_gms_internal_zzjj));
                com_google_android_gms_internal_zzti.f8011e = true;
                zztg.m6642a("Inline entry added to the queue at %s.", com_google_android_gms_internal_zzth);
            }
        }
        str = this.f18300a;
        if (!zztg.m6646b(str)) {
            i = new zzacp(q.f8005c.f7990a.getApplicationContext()).m5012a().f6175n;
            zzjj c2 = zztg.m6647c(com_google_android_gms_internal_zzjj);
            str = zztg.m6648c(str);
            zzth com_google_android_gms_internal_zzth2 = new zzth(c2, str, i);
            zzti com_google_android_gms_internal_zzti2 = (zzti) q.f8003a.get(com_google_android_gms_internal_zzth2);
            if (com_google_android_gms_internal_zzti2 == null) {
                zztg.m6642a("Interstitial pool created at %s.", com_google_android_gms_internal_zzth2);
                com_google_android_gms_internal_zzti2 = new zzti(c2, str, i);
                q.f8003a.put(com_google_android_gms_internal_zzth2, com_google_android_gms_internal_zzti2);
            }
            q.f8004b.remove(com_google_android_gms_internal_zzth2);
            q.f8004b.add(com_google_android_gms_internal_zzth2);
            com_google_android_gms_internal_zzti2.f8011e = true;
            while (true) {
                if (q.f8004b.size() <= ((Integer) zzkb.m6350f().m6488a(zznh.aJ)).intValue()) {
                    break;
                }
                zzth com_google_android_gms_internal_zzth3 = (zzth) q.f8004b.remove();
                zzti com_google_android_gms_internal_zzti3 = (zzti) q.f8003a.get(com_google_android_gms_internal_zzth3);
                zztg.m6642a("Evicting interstitial queue for %s.", com_google_android_gms_internal_zzth3);
                while (com_google_android_gms_internal_zzti3.f8007a.size() > 0) {
                    zztj a2 = com_google_android_gms_internal_zzti3.m6653a(null);
                    if (a2.f8016e) {
                        zztk a3 = zztk.m6655a();
                        a3.f8022c++;
                    }
                    a2.f8012a.m21511F();
                }
                q.f8003a.remove(com_google_android_gms_internal_zzth3);
            }
            while (com_google_android_gms_internal_zzti2.f8007a.size() > 0) {
                a = com_google_android_gms_internal_zzti2.m6653a(c2);
                if (a.f8016e) {
                    if (zzbs.m4492k().mo1632a() - a.f8015d > 1000 * ((long) ((Integer) zzkb.m6350f().m6488a(zznh.aL)).intValue())) {
                        zztg.m6642a("Expired interstitial at %s.", com_google_android_gms_internal_zzth2);
                        zztk a4 = zztk.m6655a();
                        a4.f8021b++;
                    }
                }
                str = a.f8013b != null ? " (inline) " : " ";
                StringBuilder stringBuilder = new StringBuilder(34 + String.valueOf(str).length());
                stringBuilder.append("Pooled interstitial");
                stringBuilder.append(str);
                stringBuilder.append("returned at %s.");
                zztg.m6642a(stringBuilder.toString(), com_google_android_gms_internal_zzth2);
                if (a == null) {
                    if (a.f8016e != null) {
                        a.m6654a();
                        zztk.m6655a().m6656b();
                    } else {
                        com_google_android_gms_internal_zzjj = zztk.m6655a();
                        com_google_android_gms_internal_zzjj.f8023d++;
                    }
                    this.f18303d = a.f8012a;
                    a.f8014c.m6635a(this.f18304e);
                    this.f18304e.m6639a(this.f18303d);
                    return a.f8017f;
                }
                m19003c();
                zztk.m6655a().m6656b();
                return this.f18303d.mo2003b(com_google_android_gms_internal_zzjj);
            }
        }
        a = null;
        if (a == null) {
            m19003c();
            zztk.m6655a().m6656b();
            return this.f18303d.mo2003b(com_google_android_gms_internal_zzjj);
        }
        if (a.f8016e != null) {
            com_google_android_gms_internal_zzjj = zztk.m6655a();
            com_google_android_gms_internal_zzjj.f8023d++;
        } else {
            a.m6654a();
            zztk.m6655a().m6656b();
        }
        this.f18303d = a.f8012a;
        a.f8014c.m6635a(this.f18304e);
        this.f18304e.m6639a(this.f18303d);
        return a.f8017f;
    }

    private final void m19003c() {
        if (this.f18303d == null) {
            zzsd com_google_android_gms_internal_zzsd = this.f18302c;
            this.f18303d = new zzak(com_google_android_gms_internal_zzsd.f7990a, new zzjn(), this.f18300a, com_google_android_gms_internal_zzsd.f7991b, com_google_android_gms_internal_zzsd.f7992c, com_google_android_gms_internal_zzsd.f7993d);
            this.f18304e.m6639a(this.f18303d);
        }
    }
}
