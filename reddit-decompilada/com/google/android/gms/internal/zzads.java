package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardItem;

@zzzv
public final class zzads implements RewardItem {
    private final zzadh f14047a;

    public zzads(zzadh com_google_android_gms_internal_zzadh) {
        this.f14047a = com_google_android_gms_internal_zzadh;
    }

    public final String mo1681a() {
        if (this.f14047a == null) {
            return null;
        }
        try {
            return this.f14047a.mo1659a();
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int mo1682b() {
        if (this.f14047a == null) {
            return 0;
        }
        try {
            return this.f14047a.mo1660b();
        } catch (Throwable e) {
            zzakb.m5369c("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
