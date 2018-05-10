package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;

@zzzv
public final class zzaep implements MediationRewardedVideoAdListener {
    private final zzaem f14048a;

    public zzaep(zzaem com_google_android_gms_internal_zzaem) {
        this.f14048a = com_google_android_gms_internal_zzaem;
    }

    public final void mo1694a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.m4816b("onInitializationSucceeded must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onInitializationSucceeded.");
        try {
            this.f14048a.mo1684a(zzn.m17692a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onInitializationSucceeded.", e);
        }
    }

    public final void mo1695a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzbq.m4816b("onAdFailedToLoad must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdFailedToLoad.");
        try {
            this.f14048a.mo1688b(zzn.m17692a((Object) mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void mo1696a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        zzbq.m4816b("onRewarded must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.f14048a.mo1686a(zzn.m17692a((Object) mediationRewardedVideoAdAdapter), new zzaeq(rewardItem));
                return;
            } catch (Throwable e) {
                zzakb.m5369c("Could not call onRewarded.", e);
                return;
            }
        }
        this.f14048a.mo1686a(zzn.m17692a((Object) mediationRewardedVideoAdAdapter), new zzaeq("", 1));
    }

    public final void mo1697b(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.m4816b("onAdLoaded must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLoaded.");
        try {
            this.f14048a.mo1687b(zzn.m17692a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLoaded.", e);
        }
    }

    public final void mo1698c(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.m4816b("onAdOpened must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdOpened.");
        try {
            this.f14048a.mo1689c(zzn.m17692a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdOpened.", e);
        }
    }

    public final void mo1699d(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.m4816b("onVideoStarted must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onVideoStarted.");
        try {
            this.f14048a.mo1690d(zzn.m17692a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onVideoStarted.", e);
        }
    }

    public final void mo1700e(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.m4816b("onAdClosed must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdClosed.");
        try {
            this.f14048a.mo1691e(zzn.m17692a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdClosed.", e);
        }
    }

    public final void mo1701f(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.m4816b("onAdLeftApplication must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLeftApplication.");
        try {
            this.f14048a.mo1693g(zzn.m17692a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLeftApplication.", e);
        }
    }
}
