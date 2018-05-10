package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class Status extends zzbfm implements Result, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new zzg();
    public static final Status f17263a = new Status(0);
    public static final Status f17264b = new Status(14);
    public static final Status f17265c = new Status(8);
    public static final Status f17266d = new Status(15);
    public static final Status f17267e = new Status(16);
    public static final Status f17268f = new Status(17);
    private static Status f17269j = new Status(18);
    public final int f17270g;
    public final String f17271h;
    public final PendingIntent f17272i;
    private int f17273k;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f17273k = i;
        this.f17270g = i2;
        this.f17271h = str;
        this.f17272i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final boolean m17588b() {
        return this.f17270g <= 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f17273k == status.f17273k && this.f17270g == status.f17270g && zzbg.m4806a(this.f17271h, status.f17271h) && zzbg.m4806a(this.f17272i, status.f17272i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f17273k), Integer.valueOf(this.f17270g), this.f17271h, this.f17272i});
    }

    public final Status k_() {
        return this;
    }

    public final String toString() {
        return zzbg.m4805a(this).m4807a("statusCode", this.f17271h != null ? this.f17271h : CommonStatusCodes.m4633a(this.f17270g)).m4807a("resolution", this.f17272i).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17270g);
        zzbfp.m5545a(parcel, 2, this.f17271h);
        zzbfp.m5544a(parcel, 3, this.f17272i, i);
        zzbfp.m5540a(parcel, 1000, this.f17273k);
        zzbfp.m5537a(parcel, a);
    }
}
