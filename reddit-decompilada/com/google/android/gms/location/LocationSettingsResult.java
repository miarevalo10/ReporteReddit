package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class LocationSettingsResult extends zzbfm implements Result {
    public static final Creator<LocationSettingsResult> CREATOR = new zzac();
    private final Status f18382a;
    private final LocationSettingsStates f18383b;

    public LocationSettingsResult(Status status) {
        this(status, null);
    }

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f18382a = status;
        this.f18383b = locationSettingsStates;
    }

    public final Status k_() {
        return this.f18382a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 1, this.f18382a, i);
        zzbfp.m5544a(parcel, 2, this.f18383b, i);
        zzbfp.m5537a(parcel, a);
    }
}
