package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzn extends zzbfm {
    public static final Creator<zzn> CREATOR = new zzm();
    public int f17252a;
    private int f17253b;
    private Bundle f17254c;

    zzn(int i, int i2, Bundle bundle) {
        this.f17253b = i;
        this.f17252a = i2;
        this.f17254c = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17253b);
        zzbfp.m5540a(parcel, 2, this.f17252a);
        zzbfp.m5542a(parcel, 3, this.f17254c);
        zzbfp.m5537a(parcel, i);
    }
}
