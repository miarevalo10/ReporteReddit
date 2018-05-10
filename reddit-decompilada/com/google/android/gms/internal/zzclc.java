package com.google.android.gms.internal;

import android.app.job.JobParameters;

public final /* synthetic */ class zzclc implements Runnable {
    private final zzcla f7164a;
    private final zzchm f7165b;
    private final JobParameters f7166c;

    public zzclc(zzcla com_google_android_gms_internal_zzcla, zzchm com_google_android_gms_internal_zzchm, JobParameters jobParameters) {
        this.f7164a = com_google_android_gms_internal_zzcla;
        this.f7165b = com_google_android_gms_internal_zzchm;
        this.f7166c = jobParameters;
    }

    public final void run() {
        zzcla com_google_android_gms_internal_zzcla = this.f7164a;
        zzchm com_google_android_gms_internal_zzchm = this.f7165b;
        JobParameters jobParameters = this.f7166c;
        com_google_android_gms_internal_zzchm.f17822g.m5693a("AppMeasurementJobService processed last upload request.");
        ((zzcle) com_google_android_gms_internal_zzcla.f7159a).mo2302a(jobParameters);
    }
}
