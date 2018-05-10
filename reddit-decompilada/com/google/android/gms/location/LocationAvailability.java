package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class LocationAvailability extends zzbfm implements ReflectedParcelable {
    public static final Creator<LocationAvailability> CREATOR = new zzv();
    @Deprecated
    private int f18375a;
    @Deprecated
    private int f18376b;
    private long f18377c;
    private int f18378d;
    private zzae[] f18379e;

    LocationAvailability(int i, int i2, int i3, long j, zzae[] com_google_android_gms_location_zzaeArr) {
        this.f18378d = i;
        this.f18375a = i2;
        this.f18376b = i3;
        this.f18377c = j;
        this.f18379e = com_google_android_gms_location_zzaeArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.f18375a == locationAvailability.f18375a && this.f18376b == locationAvailability.f18376b && this.f18377c == locationAvailability.f18377c && this.f18378d == locationAvailability.f18378d && Arrays.equals(this.f18379e, locationAvailability.f18379e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18378d), Integer.valueOf(this.f18375a), Integer.valueOf(this.f18376b), Long.valueOf(this.f18377c), this.f18379e});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f18375a);
        zzbfp.m5540a(parcel, 2, this.f18376b);
        zzbfp.m5541a(parcel, 3, this.f18377c);
        zzbfp.m5540a(parcel, 4, this.f18378d);
        zzbfp.m5549a(parcel, 5, this.f18379e, i);
        zzbfp.m5537a(parcel, a);
    }

    public final String toString() {
        boolean z = this.f18378d < 1000;
        StringBuilder stringBuilder = new StringBuilder(48);
        stringBuilder.append("LocationAvailability[isLocationAvailable: ");
        stringBuilder.append(z);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
