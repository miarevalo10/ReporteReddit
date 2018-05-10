package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;

@zzzv
public final class zzxd extends zzp<zzxh> {
    public zzxd() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzxe m14433a(Activity activity) {
        try {
            IBinder a = ((zzxh) m4950a((Context) activity)).mo2290a(zzn.m17692a((Object) activity));
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return queryLocalInterface instanceof zzxe ? (zzxe) queryLocalInterface : new zzxg(a);
        } catch (Throwable e) {
            zzakb.m5369c("Could not create remote AdOverlay.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object mo1683a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return queryLocalInterface instanceof zzxh ? (zzxh) queryLocalInterface : new zzxi(iBinder);
    }
}
