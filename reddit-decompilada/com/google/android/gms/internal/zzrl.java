package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

@zzzv
public final class zzrl extends zzqu {
    private final OnContentAdLoadedListener f18279a;

    public zzrl(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f18279a = onContentAdLoadedListener;
    }

    public final void mo2152a(zzqi com_google_android_gms_internal_zzqi) {
        this.f18279a.mo1265a(new zzql(com_google_android_gms_internal_zzqi));
    }
}
