package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.zzd;

public final class zzclf extends zzcjl {
    private Handler f17893a;
    private long f17894b = mo1819k().mo1633b();
    private final zzcgs f17895c = new zzclg(this, this.s);
    private final zzcgs f17896d = new zzclh(this, this.s);

    zzclf(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final void m18448y() {
        synchronized (this) {
            if (this.f17893a == null) {
                this.f17893a = new Handler(Looper.getMainLooper());
            }
        }
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
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

    public final boolean m18450a(boolean z) {
        mo1811c();
        m13545L();
        long b = mo1819k().mo1633b();
        mo1829u().f17843p.m5703a(mo1819k().mo1632a());
        long j = b - this.f17894b;
        if (z || j >= 1000) {
            mo1829u().f17844q.m5703a(j);
            mo1828t().f17822g.m5694a("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzckc.m18366a(mo1818j().m18393y(), bundle);
            mo1814f().m18332a("auto", "_e", bundle);
            this.f17894b = b;
            this.f17896d.m5666c();
            this.f17896d.m5664a(Math.max(0, 3600000 - mo1829u().f17844q.m5702a()));
            return true;
        }
        mo1828t().f17822g.m5694a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    static /* synthetic */ void m18445a(zzclf com_google_android_gms_internal_zzclf) {
        com_google_android_gms_internal_zzclf.mo1811c();
        com_google_android_gms_internal_zzclf.m18450a(false);
        com_google_android_gms_internal_zzclf.mo1812d().m13462a(com_google_android_gms_internal_zzclf.mo1819k().mo1633b());
    }

    static /* synthetic */ void m18446a(zzclf com_google_android_gms_internal_zzclf, long j) {
        long a;
        com_google_android_gms_internal_zzclf.mo1811c();
        com_google_android_gms_internal_zzclf.m18448y();
        com_google_android_gms_internal_zzclf.f17895c.m5666c();
        com_google_android_gms_internal_zzclf.f17896d.m5666c();
        com_google_android_gms_internal_zzclf.mo1828t().f17822g.m5694a("Activity resumed, time", Long.valueOf(j));
        com_google_android_gms_internal_zzclf.f17894b = j;
        if (com_google_android_gms_internal_zzclf.mo1819k().mo1632a() - com_google_android_gms_internal_zzclf.mo1829u().f17841n.m5702a() > com_google_android_gms_internal_zzclf.mo1829u().f17843p.m5702a()) {
            com_google_android_gms_internal_zzclf.mo1829u().f17842o.m5701a(true);
            com_google_android_gms_internal_zzclf.mo1829u().f17844q.m5703a(0);
        }
        j = com_google_android_gms_internal_zzclf.mo1829u().f17842o;
        if (!j.f6924c) {
            j.f6924c = true;
            j.f6925d = j.f6926e.m18211D().getBoolean(j.f6922a, j.f6923b);
        }
        if (j.f6925d != null) {
            j = com_google_android_gms_internal_zzclf.f17895c;
            a = com_google_android_gms_internal_zzclf.mo1829u().f17840m.m5702a();
        } else {
            j = com_google_android_gms_internal_zzclf.f17896d;
            a = 3600000;
        }
        j.m5664a(Math.max(0, a - com_google_android_gms_internal_zzclf.mo1829u().f17844q.m5702a()));
    }

    static /* synthetic */ void m18447b(zzclf com_google_android_gms_internal_zzclf, long j) {
        com_google_android_gms_internal_zzclf.mo1811c();
        com_google_android_gms_internal_zzclf.m18448y();
        com_google_android_gms_internal_zzclf.f17895c.m5666c();
        com_google_android_gms_internal_zzclf.f17896d.m5666c();
        com_google_android_gms_internal_zzclf.mo1828t().f17822g.m5694a("Activity paused, time", Long.valueOf(j));
        if (com_google_android_gms_internal_zzclf.f17894b != 0) {
            com_google_android_gms_internal_zzclf.mo1829u().f17844q.m5703a(com_google_android_gms_internal_zzclf.mo1829u().f17844q.m5702a() + (j - com_google_android_gms_internal_zzclf.f17894b));
        }
    }
}
