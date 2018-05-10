package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import java.util.Map;

public final class zzcgd extends zzcjk {
    private final Map<String, Long> f14227a = new ArrayMap();
    private final Map<String, Integer> f14228b = new ArrayMap();
    private long f14229c;

    public zzcgd(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final void m13459b(long j) {
        for (String put : this.f14227a.keySet()) {
            this.f14227a.put(put, Long.valueOf(j));
        }
        if (!this.f14227a.isEmpty()) {
            this.f14229c = j;
        }
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final void m13462a(long j) {
        zzb y = mo1818j().m18393y();
        for (String str : this.f14227a.keySet()) {
            m13458a(str, j - ((Long) this.f14227a.get(str)).longValue(), y);
        }
        if (!this.f14227a.isEmpty()) {
            m13455a(j - this.f14229c, y);
        }
        m13459b(j);
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

    private final void m13455a(long j, zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        if (com_google_android_gms_measurement_AppMeasurement_zzb == null) {
            mo1828t().f17822g.m5693a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            mo1828t().f17822g.m5694a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzckc.m18366a(com_google_android_gms_measurement_AppMeasurement_zzb, bundle);
            mo1814f().m18332a("am", "_xa", bundle);
        }
    }

    private final void m13458a(String str, long j, zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        if (com_google_android_gms_measurement_AppMeasurement_zzb == null) {
            mo1828t().f17822g.m5693a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            mo1828t().f17822g.m5694a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzckc.m18366a(com_google_android_gms_measurement_AppMeasurement_zzb, bundle);
            mo1814f().m18332a("am", "_xu", bundle);
        }
    }

    static /* synthetic */ void m13457a(zzcgd com_google_android_gms_internal_zzcgd, String str, long j) {
        com_google_android_gms_internal_zzcgd.mo1811c();
        zzbq.m4810a(str);
        if (com_google_android_gms_internal_zzcgd.f14228b.isEmpty()) {
            com_google_android_gms_internal_zzcgd.f14229c = j;
        }
        Integer num = (Integer) com_google_android_gms_internal_zzcgd.f14228b.get(str);
        if (num != null) {
            com_google_android_gms_internal_zzcgd.f14228b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (com_google_android_gms_internal_zzcgd.f14228b.size() >= 100) {
            com_google_android_gms_internal_zzcgd.mo1828t().f17818c.m5693a("Too many ads visible");
        } else {
            com_google_android_gms_internal_zzcgd.f14228b.put(str, Integer.valueOf(1));
            com_google_android_gms_internal_zzcgd.f14227a.put(str, Long.valueOf(j));
        }
    }

    static /* synthetic */ void m13460b(zzcgd com_google_android_gms_internal_zzcgd, String str, long j) {
        com_google_android_gms_internal_zzcgd.mo1811c();
        zzbq.m4810a(str);
        Integer num = (Integer) com_google_android_gms_internal_zzcgd.f14228b.get(str);
        if (num != null) {
            zzb y = com_google_android_gms_internal_zzcgd.mo1818j().m18393y();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                com_google_android_gms_internal_zzcgd.f14228b.remove(str);
                Long l = (Long) com_google_android_gms_internal_zzcgd.f14227a.get(str);
                if (l == null) {
                    com_google_android_gms_internal_zzcgd.mo1828t().f17816a.m5693a("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    com_google_android_gms_internal_zzcgd.f14227a.remove(str);
                    com_google_android_gms_internal_zzcgd.m13458a(str, longValue, y);
                }
                if (com_google_android_gms_internal_zzcgd.f14228b.isEmpty() != null) {
                    if (com_google_android_gms_internal_zzcgd.f14229c == 0) {
                        com_google_android_gms_internal_zzcgd.mo1828t().f17816a.m5693a("First ad exposure time was never set");
                        return;
                    } else {
                        com_google_android_gms_internal_zzcgd.m13455a(j - com_google_android_gms_internal_zzcgd.f14229c, y);
                        com_google_android_gms_internal_zzcgd.f14229c = 0;
                    }
                }
                return;
            }
            com_google_android_gms_internal_zzcgd.f14228b.put(str, Integer.valueOf(intValue));
            return;
        }
        com_google_android_gms_internal_zzcgd.mo1828t().f17816a.m5694a("Call to endAdUnitExposure for unknown ad unit id", str);
    }
}
