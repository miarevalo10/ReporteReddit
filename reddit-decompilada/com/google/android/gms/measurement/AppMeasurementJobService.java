package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.zzchm;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.internal.zzcla;
import com.google.android.gms.internal.zzclc;
import com.google.android.gms.internal.zzcle;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzcle {
    private zzcla<AppMeasurementJobService> f14809a;

    private final zzcla<AppMeasurementJobService> m14502a() {
        if (this.f14809a == null) {
            this.f14809a = new zzcla(this);
        }
        return this.f14809a;
    }

    @TargetApi(24)
    public final void mo2302a(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public final void mo2303a(Intent intent) {
    }

    public final boolean mo2304a(int i) {
        throw new UnsupportedOperationException();
    }

    public final void onCreate() {
        super.onCreate();
        m14502a().m5796a();
    }

    public final void onDestroy() {
        m14502a().m5799b();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        m14502a().m5800b(intent);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        return m14502a().m5798a(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        zzcla a = m14502a();
        zzchm e = zzcim.m5720a(a.f7159a).m5754e();
        String string = jobParameters.getExtras().getString("action");
        e.f17822g.m5694a("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            a.m5797a(new zzclc(a, e, jobParameters));
        }
        return true;
    }
}
