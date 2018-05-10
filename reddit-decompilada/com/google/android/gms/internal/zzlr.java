package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

@zzzv
public final class zzlr extends zzbfm {
    public static final Creator<zzlr> CREATOR = new zzls();
    public final int f18164a;

    public zzlr(int i) {
        this.f18164a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 2, this.f18164a);
        zzbfp.m5537a(parcel, i);
    }
}
