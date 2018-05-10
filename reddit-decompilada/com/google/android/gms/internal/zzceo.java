package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzceo extends zzbfm implements Result {
    public static final Creator<zzceo> CREATOR = new zzcep();
    private static zzceo f17728b = new zzceo(Status.f17263a);
    final Status f17729a;

    public zzceo(Status status) {
        this.f17729a = status;
    }

    public final Status k_() {
        return this.f17729a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 1, this.f17729a, i);
        zzbfp.m5537a(parcel, a);
    }
}
