package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;

@zzzv
public final class zzri extends zzp<zzpx> {
    public zzri() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final zzpu m14234a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder a = ((zzpx) m4950a(context)).mo2102a(zzn.m17692a((Object) context), zzn.m17692a((Object) frameLayout), zzn.m17692a((Object) frameLayout2));
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return queryLocalInterface instanceof zzpu ? (zzpu) queryLocalInterface : new zzpw(a);
        } catch (Throwable e) {
            zzakb.m5369c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object mo1683a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return queryLocalInterface instanceof zzpx ? (zzpx) queryLocalInterface : new zzpy(iBinder);
    }
}
