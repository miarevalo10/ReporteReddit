package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;

public final class zzawf extends zzbfm {
    public static final Creator<zzawf> CREATOR = new zzawg();
    private final Credential f17609a;

    public zzawf(Credential credential) {
        this.f17609a = credential;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 1, this.f17609a, i);
        zzbfp.m5537a(parcel, a);
    }
}
