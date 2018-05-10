package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.formats.NativeAdOptions;

@zzzv
public final class zzpe extends zzbfm {
    public static final Creator<zzpe> CREATOR = new zzpf();
    public final int f18238a;
    public final boolean f18239b;
    public final int f18240c;
    public final boolean f18241d;
    public final int f18242e;
    public final zzmr f18243f;

    public zzpe(int i, boolean z, int i2, boolean z2, int i3, zzmr com_google_android_gms_internal_zzmr) {
        this.f18238a = i;
        this.f18239b = z;
        this.f18240c = i2;
        this.f18241d = z2;
        this.f18242e = i3;
        this.f18243f = com_google_android_gms_internal_zzmr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f18238a);
        zzbfp.m5547a(parcel, 2, this.f18239b);
        zzbfp.m5540a(parcel, 3, this.f18240c);
        zzbfp.m5547a(parcel, 4, this.f18241d);
        zzbfp.m5540a(parcel, 5, this.f18242e);
        zzbfp.m5544a(parcel, 6, this.f18243f, i);
        zzbfp.m5537a(parcel, a);
    }

    public zzpe(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.f5400a, nativeAdOptions.f5401b, nativeAdOptions.f5402c, nativeAdOptions.f5403d, nativeAdOptions.f5404e != null ? new zzmr(nativeAdOptions.f5404e) : null);
    }
}
