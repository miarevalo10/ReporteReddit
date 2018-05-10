package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.Arrays;

public final class zze extends zzbfm {
    public static final Creator<zze> CREATOR = new zzf();
    private boolean f18397a;
    private long f18398b;
    private float f18399c;
    private long f18400d;
    private int f18401e;

    public zze() {
        this(true, 50, 0.0f, Long.MAX_VALUE, RedditJobManager.f10810d);
    }

    zze(boolean z, long j, float f, long j2, int i) {
        this.f18397a = z;
        this.f18398b = j;
        this.f18399c = f;
        this.f18400d = j2;
        this.f18401e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze com_google_android_gms_location_zze = (zze) obj;
        return this.f18397a == com_google_android_gms_location_zze.f18397a && this.f18398b == com_google_android_gms_location_zze.f18398b && Float.compare(this.f18399c, com_google_android_gms_location_zze.f18399c) == 0 && this.f18400d == com_google_android_gms_location_zze.f18400d && this.f18401e == com_google_android_gms_location_zze.f18401e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f18397a), Long.valueOf(this.f18398b), Float.valueOf(this.f18399c), Long.valueOf(this.f18400d), Integer.valueOf(this.f18401e)});
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceOrientationRequest[mShouldUseMag=");
        stringBuilder.append(this.f18397a);
        stringBuilder.append(" mMinimumSamplingPeriodMs=");
        stringBuilder.append(this.f18398b);
        stringBuilder.append(" mSmallestAngleChangeRadians=");
        stringBuilder.append(this.f18399c);
        if (this.f18400d != Long.MAX_VALUE) {
            long elapsedRealtime = this.f18400d - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime);
            stringBuilder.append("ms");
        }
        if (this.f18401e != RedditJobManager.f10810d) {
            stringBuilder.append(" num=");
            stringBuilder.append(this.f18401e);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 1, this.f18397a);
        zzbfp.m5541a(parcel, 2, this.f18398b);
        zzbfp.m5539a(parcel, 3, this.f18399c);
        zzbfp.m5541a(parcel, 4, this.f18400d);
        zzbfp.m5540a(parcel, 5, this.f18401e);
        zzbfp.m5537a(parcel, i);
    }
}
