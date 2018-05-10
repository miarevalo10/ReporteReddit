package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class zzag extends zzbfm {
    public static final Creator<zzag> CREATOR = new zzah();
    private final List<String> f18394a;
    private final PendingIntent f18395b;
    private final String f18396c;

    zzag(List<String> list, PendingIntent pendingIntent, String str) {
        this.f18394a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f18395b = pendingIntent;
        this.f18396c = str;
    }

    public static zzag m19192a(PendingIntent pendingIntent) {
        zzbq.m4809a((Object) pendingIntent, (Object) "PendingIntent can not be null.");
        return new zzag(null, pendingIntent, "");
    }

    public static zzag m19193a(List<String> list) {
        zzbq.m4809a((Object) list, (Object) "geofence can't be null.");
        zzbq.m4818b(list.isEmpty() ^ 1, "Geofences must contains at least one id.");
        return new zzag(list, null, "");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5557b(parcel, 1, this.f18394a);
        zzbfp.m5544a(parcel, 2, this.f18395b, i);
        zzbfp.m5545a(parcel, 3, this.f18396c);
        zzbfp.m5537a(parcel, a);
    }
}
