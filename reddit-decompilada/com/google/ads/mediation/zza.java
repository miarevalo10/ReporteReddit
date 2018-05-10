package com.google.ads.mediation;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

final class zza implements RewardedVideoAdListener {
    private /* synthetic */ AbstractAdViewAdapter f12755a;

    zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f12755a = abstractAdViewAdapter;
    }

    public final void mo1269a() {
        this.f12755a.zzgy.mo1697b(this.f12755a);
    }

    public final void mo1270a(int i) {
        this.f12755a.zzgy.mo1695a(this.f12755a, i);
    }

    public final void mo1271a(RewardItem rewardItem) {
        this.f12755a.zzgy.mo1696a(this.f12755a, rewardItem);
    }

    public final void mo1272b() {
        this.f12755a.zzgy.mo1698c(this.f12755a);
    }

    public final void mo1273c() {
        this.f12755a.zzgy.mo1699d(this.f12755a);
    }

    public final void mo1274d() {
        this.f12755a.zzgy.mo1700e(this.f12755a);
        this.f12755a.zzgx = null;
    }

    public final void mo1275e() {
        this.f12755a.zzgy.mo1701f(this.f12755a);
    }
}
