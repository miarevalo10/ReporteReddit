package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.zzp;

@zzzv
public final class zzadt extends zzp<zzadn> {
    public zzadt() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    protected final /* synthetic */ Object mo1683a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return queryLocalInterface instanceof zzadn ? (zzadn) queryLocalInterface : new zzado(iBinder);
    }
}
