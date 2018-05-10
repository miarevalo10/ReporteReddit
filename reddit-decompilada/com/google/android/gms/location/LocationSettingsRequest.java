package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends zzbfm {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzab();
    private final List<LocationRequest> zzhhm;
    private final boolean zzika;
    private final boolean zzikb;
    private zzz zzikc;

    LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, zzz com_google_android_gms_location_zzz) {
        this.zzhhm = list;
        this.zzika = z;
        this.zzikb = z2;
        this.zzikc = com_google_android_gms_location_zzz;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5559c(parcel, 1, Collections.unmodifiableList(this.zzhhm));
        zzbfp.m5547a(parcel, 2, this.zzika);
        zzbfp.m5547a(parcel, 3, this.zzikb);
        zzbfp.m5544a(parcel, 5, this.zzikc, i);
        zzbfp.m5537a(parcel, a);
    }
}
