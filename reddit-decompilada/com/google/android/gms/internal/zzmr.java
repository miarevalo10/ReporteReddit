package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.VideoOptions;

@zzzv
public final class zzmr extends zzbfm {
    public static final Creator<zzmr> CREATOR = new zzms();
    public final boolean f18171a;
    public final boolean f18172b;
    public final boolean f18173c;

    public zzmr(boolean z, boolean z2, boolean z3) {
        this.f18171a = z;
        this.f18172b = z2;
        this.f18173c = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 2, this.f18171a);
        zzbfp.m5547a(parcel, 3, this.f18172b);
        zzbfp.m5547a(parcel, 4, this.f18173c);
        zzbfp.m5537a(parcel, i);
    }

    public zzmr(VideoOptions videoOptions) {
        this(videoOptions.f5390a, videoOptions.f5391b, videoOptions.f5392c);
    }
}
