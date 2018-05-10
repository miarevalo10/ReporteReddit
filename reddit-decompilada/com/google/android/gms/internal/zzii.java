package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import java.io.InputStream;

@zzzv
public final class zzii extends zzbfm {
    public static final Creator<zzii> CREATOR = new zzij();
    private ParcelFileDescriptor f18113a;

    public zzii() {
        this(null);
    }

    public zzii(ParcelFileDescriptor parcelFileDescriptor) {
        this.f18113a = parcelFileDescriptor;
    }

    private synchronized ParcelFileDescriptor m18748c() {
        return this.f18113a;
    }

    public final synchronized boolean m18749a() {
        return this.f18113a != null;
    }

    public final synchronized InputStream m18750b() {
        if (this.f18113a == null) {
            return null;
        }
        InputStream autoCloseInputStream = new AutoCloseInputStream(this.f18113a);
        this.f18113a = null;
        return autoCloseInputStream;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 2, m18748c(), i);
        zzbfp.m5537a(parcel, a);
    }
}
