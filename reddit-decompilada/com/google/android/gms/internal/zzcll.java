package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.zzd;

public final class zzcll extends zzcjl {
    private final AlarmManager f17897a = ((AlarmManager) mo1820l().getSystemService("alarm"));
    private final zzcgs f17898b;
    private Integer f17899c;

    protected zzcll(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
        this.f17898b = new zzclm(this, com_google_android_gms_internal_zzcim);
    }

    private final int m18473A() {
        if (this.f17899c == null) {
            String str = "measurement";
            String valueOf = String.valueOf(mo1820l().getPackageName());
            this.f17899c = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.f17899c.intValue();
    }

    private final PendingIntent m18474B() {
        Intent className = new Intent().setClassName(mo1820l(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo1820l(), 0, className, 0);
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
        this.f17897a.cancel(m18474B());
        if (VERSION.SDK_INT >= 24) {
            m18475z();
        }
        return false;
    }

    public final void m18500y() {
        m13545L();
        this.f17897a.cancel(m18474B());
        this.f17898b.m5666c();
        if (VERSION.SDK_INT >= 24) {
            m18475z();
        }
    }

    @TargetApi(24)
    private final void m18475z() {
        JobScheduler jobScheduler = (JobScheduler) mo1820l().getSystemService("jobscheduler");
        mo1828t().f17822g.m5694a("Cancelling job. JobID", Integer.valueOf(m18473A()));
        jobScheduler.cancel(m18473A());
    }

    public final void m18477a(long j) {
        m13545L();
        if (!zzcid.m5707a(mo1820l())) {
            mo1828t().f17821f.m5693a("Receiver not registered/enabled");
        }
        if (!zzcla.m5795a(mo1820l())) {
            mo1828t().f17821f.m5693a("Service not registered/enabled");
        }
        m18500y();
        long b = mo1819k().mo1633b() + j;
        if (j < Math.max(0, ((Long) zzchc.f6892z.f6893a).longValue()) && !this.f17898b.m5665b()) {
            mo1828t().f17822g.m5693a("Scheduling upload with DelayedRunnable");
            this.f17898b.m5664a(j);
        }
        if (VERSION.SDK_INT >= 24) {
            mo1828t().f17822g.m5693a("Scheduling upload with JobScheduler");
            JobScheduler jobScheduler = (JobScheduler) mo1820l().getSystemService("jobscheduler");
            Builder builder = new Builder(m18473A(), new ComponentName(mo1820l(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            j = new PersistableBundle();
            j.putString("action", "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(j);
            j = builder.build();
            mo1828t().f17822g.m5694a("Scheduling job. JobID", Integer.valueOf(m18473A()));
            jobScheduler.schedule(j);
            return;
        }
        mo1828t().f17822g.m5693a("Scheduling upload with AlarmManager");
        this.f17897a.setInexactRepeating(2, b, Math.max(((Long) zzchc.f6887u.f6893a).longValue(), j), m18474B());
    }
}
