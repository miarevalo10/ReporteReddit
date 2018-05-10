package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzz extends zzbfm {
    public static final Creator<zzz> CREATOR = new zzaa();
    private final String f18402a;
    private final String f18403b;
    private final int f18404c;
    private final boolean f18405d;
    private final String f18406e;

    zzz(String str, String str2, String str3, int i, boolean z) {
        this.f18406e = str;
        this.f18402a = str2;
        this.f18403b = str3;
        this.f18404c = i;
        this.f18405d = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f18402a);
        zzbfp.m5545a(parcel, 2, this.f18403b);
        zzbfp.m5540a(parcel, 3, this.f18404c);
        zzbfp.m5547a(parcel, 4, this.f18405d);
        zzbfp.m5545a(parcel, 5, this.f18406e);
        zzbfp.m5537a(parcel, i);
    }
}
