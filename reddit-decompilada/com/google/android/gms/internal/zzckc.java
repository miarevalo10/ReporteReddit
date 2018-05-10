package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.zza;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzckc extends zzcjl {
    protected zzckf f17877a;
    public volatile zzb f17878b;
    zzb f17879c;
    long f17880d;
    public final Map<Activity, zzckf> f17881e = new ArrayMap();
    public final CopyOnWriteArrayList<zza> f17882f = new CopyOnWriteArrayList();
    public boolean f17883g;
    private zzb f17884h;
    private String f17885i;

    public zzckc(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    public static String m18364a(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return str.substring(0, 36);
        }
        str = split[split.length - 1];
        if (str.length() > 36) {
            str = str.substring(0, 36);
        }
        return str;
    }

    public static void m18366a(zzb com_google_android_gms_measurement_AppMeasurement_zzb, Bundle bundle) {
        if (bundle != null && com_google_android_gms_measurement_AppMeasurement_zzb != null && !bundle.containsKey("_sc")) {
            if (com_google_android_gms_measurement_AppMeasurement_zzb.f8208b != null) {
                bundle.putString("_sn", com_google_android_gms_measurement_AppMeasurement_zzb.f8208b);
            }
            bundle.putString("_sc", com_google_android_gms_measurement_AppMeasurement_zzb.f8209c);
            bundle.putLong("_si", com_google_android_gms_measurement_AppMeasurement_zzb.f8210d);
        }
    }

    final zzckf m18367a(Activity activity) {
        zzbq.m4808a((Object) activity);
        zzckf com_google_android_gms_internal_zzckf = (zzckf) this.f17881e.get(activity);
        if (com_google_android_gms_internal_zzckf != null) {
            return com_google_android_gms_internal_zzckf;
        }
        zzckf com_google_android_gms_internal_zzckf2 = new zzckf(null, m18364a(activity.getClass().getCanonicalName()), mo1824p().m18583y());
        this.f17881e.put(activity, com_google_android_gms_internal_zzckf2);
        return com_google_android_gms_internal_zzckf2;
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final void m18370a(String str, zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        mo1811c();
        synchronized (this) {
            if (this.f17885i == null || this.f17885i.equals(str) || com_google_android_gms_measurement_AppMeasurement_zzb != null) {
                this.f17885i = str;
                this.f17884h = com_google_android_gms_measurement_AppMeasurement_zzb;
            }
        }
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    public final /* bridge */ /* synthetic */ void mo1811c() {
        super.mo1811c();
    }

    public final /* bridge */ /* synthetic */ zzcgd mo1812d() {
        return super.mo1812d();
    }

    public final /* bridge */ /* synthetic */ zzcgk mo1813e() {
        return super.mo1813e();
    }

    public final /* bridge */ /* synthetic */ zzcjn mo1814f() {
        return super.mo1814f();
    }

    public final /* bridge */ /* synthetic */ zzchh mo1815g() {
        return super.mo1815g();
    }

    public final /* bridge */ /* synthetic */ zzcgu mo1816h() {
        return super.mo1816h();
    }

    public final /* bridge */ /* synthetic */ zzckg mo1817i() {
        return super.mo1817i();
    }

    public final /* bridge */ /* synthetic */ zzckc mo1818j() {
        return super.mo1818j();
    }

    public final /* bridge */ /* synthetic */ zzd mo1819k() {
        return super.mo1819k();
    }

    public final /* bridge */ /* synthetic */ Context mo1820l() {
        return super.mo1820l();
    }

    public final /* bridge */ /* synthetic */ zzchi mo1821m() {
        return super.mo1821m();
    }

    public final /* bridge */ /* synthetic */ zzcgo mo1822n() {
        return super.mo1822n();
    }

    public final /* bridge */ /* synthetic */ zzchk mo1823o() {
        return super.mo1823o();
    }

    public final /* bridge */ /* synthetic */ zzclq mo1824p() {
        return super.mo1824p();
    }

    public final /* bridge */ /* synthetic */ zzcig mo1825q() {
        return super.mo1825q();
    }

    public final /* bridge */ /* synthetic */ zzclf mo1826r() {
        return super.mo1826r();
    }

    public final /* bridge */ /* synthetic */ zzcih mo1827s() {
        return super.mo1827s();
    }

    public final /* bridge */ /* synthetic */ zzchm mo1828t() {
        return super.mo1828t();
    }

    public final /* bridge */ /* synthetic */ zzchx mo1829u() {
        return super.mo1829u();
    }

    public final /* bridge */ /* synthetic */ zzcgn mo1830v() {
        return super.mo1830v();
    }

    protected final boolean mo3490w() {
        return false;
    }

    public final zzckf m18393y() {
        m13545L();
        mo1811c();
        return this.f17877a;
    }

    public final zzb m18394z() {
        zzb com_google_android_gms_measurement_AppMeasurement_zzb = this.f17878b;
        return com_google_android_gms_measurement_AppMeasurement_zzb == null ? null : new zzb(com_google_android_gms_measurement_AppMeasurement_zzb);
    }

    public final void m18369a(Activity activity, zzckf com_google_android_gms_internal_zzckf, boolean z) {
        zzb com_google_android_gms_measurement_AppMeasurement_zzb;
        zzb com_google_android_gms_measurement_AppMeasurement_zzb2 = this.f17878b != null ? this.f17878b : (this.f17879c == null || Math.abs(mo1819k().mo1633b() - this.f17880d) >= 1000) ? null : this.f17879c;
        if (com_google_android_gms_measurement_AppMeasurement_zzb2 != null) {
            com_google_android_gms_measurement_AppMeasurement_zzb = new zzb(com_google_android_gms_measurement_AppMeasurement_zzb2);
        }
        int i = 1;
        this.f17883g = true;
        try {
            Iterator it = this.f17882f.iterator();
            while (it.hasNext()) {
                try {
                    i &= ((zza) it.next()).m6846a();
                } catch (Exception e) {
                    mo1828t().f17816a.m5694a("onScreenChangeCallback threw exception", e);
                }
            }
        } catch (Exception e2) {
            mo1828t().f17816a.m5694a("onScreenChangeCallback loop threw exception", e2);
        } finally {
            this.f17883g = false;
        }
        com_google_android_gms_measurement_AppMeasurement_zzb = this.f17878b == null ? this.f17879c : this.f17878b;
        if (i != 0) {
            if (com_google_android_gms_internal_zzckf.c == null) {
                com_google_android_gms_internal_zzckf.c = m18364a(activity.getClass().getCanonicalName());
            }
            activity = new zzckf(com_google_android_gms_internal_zzckf);
            this.f17879c = this.f17878b;
            this.f17880d = mo1819k().mo1633b();
            this.f17878b = activity;
            mo1827s().m18271a(new zzckd(this, z, com_google_android_gms_measurement_AppMeasurement_zzb, activity));
        }
    }

    static /* synthetic */ void m18365a(zzckc com_google_android_gms_internal_zzckc, zzckf com_google_android_gms_internal_zzckf) {
        com_google_android_gms_internal_zzckc.mo1812d().m13462a(com_google_android_gms_internal_zzckc.mo1819k().mo1633b());
        if (com_google_android_gms_internal_zzckc.mo1826r().m18450a(com_google_android_gms_internal_zzckf.f14243a) != null) {
            com_google_android_gms_internal_zzckf.f14243a = null;
        }
    }
}
