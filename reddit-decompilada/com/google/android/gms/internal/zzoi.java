package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzv
public final class zzoi extends zzpr {
    private final Drawable f18191a;
    private final Uri f18192b;
    private final double f18193c;

    public zzoi(Drawable drawable, Uri uri, double d) {
        this.f18191a = drawable;
        this.f18192b = uri;
        this.f18193c = d;
    }

    public final IObjectWrapper mo2091a() throws RemoteException {
        return zzn.m17692a(this.f18191a);
    }

    public final Uri mo2092b() throws RemoteException {
        return this.f18192b;
    }

    public final double mo2093c() {
        return this.f18193c;
    }
}
