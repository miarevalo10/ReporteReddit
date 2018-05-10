package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends zzbfm implements ReflectedParcelable {
    public static final Creator<LocationResult> CREATOR = new zzx();
    static final List<Location> f18380a = Collections.emptyList();
    private final List<Location> f18381b;

    LocationResult(List<Location> list) {
        this.f18381b = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f18381b.size() != this.f18381b.size()) {
            return false;
        }
        Iterator it = this.f18381b.iterator();
        for (Location time : locationResult.f18381b) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 17;
        for (Location time : this.f18381b) {
            long time2 = time.getTime();
            i = (i * 31) + ((int) (time2 ^ (time2 >>> 32)));
        }
        return i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f18381b);
        StringBuilder stringBuilder = new StringBuilder(27 + String.valueOf(valueOf).length());
        stringBuilder.append("LocationResult[locations: ");
        stringBuilder.append(valueOf);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5559c(parcel, 1, this.f18381b);
        zzbfp.m5537a(parcel, i);
    }
}
