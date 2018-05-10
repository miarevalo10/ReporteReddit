package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class LocationSettingsStates extends zzbfm {
    public static final Creator<LocationSettingsStates> CREATOR = new zzad();
    private final boolean f18384a;
    private final boolean f18385b;
    private final boolean f18386c;
    private final boolean f18387d;
    private final boolean f18388e;
    private final boolean f18389f;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f18384a = z;
        this.f18385b = z2;
        this.f18386c = z3;
        this.f18387d = z4;
        this.f18388e = z5;
        this.f18389f = z6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 1, this.f18384a);
        zzbfp.m5547a(parcel, 2, this.f18385b);
        zzbfp.m5547a(parcel, 3, this.f18386c);
        zzbfp.m5547a(parcel, 4, this.f18387d);
        zzbfp.m5547a(parcel, 5, this.f18388e);
        zzbfp.m5547a(parcel, 6, this.f18389f);
        zzbfp.m5537a(parcel, i);
    }
}
