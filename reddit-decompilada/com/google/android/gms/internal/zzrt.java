package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

@zzzv
public final class zzrt extends zzbfm {
    public static final Creator<zzrt> CREATOR = new zzru();
    public final boolean f18285a;
    public final String f18286b;
    public final int f18287c;
    public final byte[] f18288d;
    public final String[] f18289e;
    public final String[] f18290f;
    public final boolean f18291g;
    public final long f18292h;

    zzrt(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.f18285a = z;
        this.f18286b = str;
        this.f18287c = i;
        this.f18288d = bArr;
        this.f18289e = strArr;
        this.f18290f = strArr2;
        this.f18291g = z2;
        this.f18292h = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 1, this.f18285a);
        zzbfp.m5545a(parcel, 2, this.f18286b);
        zzbfp.m5540a(parcel, 3, this.f18287c);
        zzbfp.m5548a(parcel, 4, this.f18288d);
        zzbfp.m5550a(parcel, 5, this.f18289e);
        zzbfp.m5550a(parcel, 6, this.f18290f);
        zzbfp.m5547a(parcel, 7, this.f18291g);
        zzbfp.m5541a(parcel, 8, this.f18292h);
        zzbfp.m5537a(parcel, i);
    }
}
