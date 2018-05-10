package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzzv
public final class zzrk extends zzqr {
    private final OnAppInstallAdLoadedListener f18278a;

    public zzrk(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f18278a = onAppInstallAdLoadedListener;
    }

    public final void mo2151a(zzqe com_google_android_gms_internal_zzqe) {
        this.f18278a.mo1264a(new zzqh(com_google_android_gms_internal_zzqe));
    }
}
