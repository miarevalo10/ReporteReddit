package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;

public final class zzavz extends zzbfm {
    public static final Creator<zzavz> CREATOR = new zzawa();
    private final Credential f17608a;

    public zzavz(Credential credential) {
        this.f17608a = credential;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 1, this.f17608a, i);
        zzbfp.m5537a(parcel, a);
    }
}
