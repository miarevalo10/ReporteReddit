package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.zzp;

@zzzv
public final class zzakd extends zzbfm {
    public static final Creator<zzakd> CREATOR = new zzake();
    public String f17551a;
    public int f17552b;
    public int f17553c;
    public boolean f17554d;
    public boolean f17555e;

    public zzakd(int i, int i2, boolean z) {
        this(i, i2, z, false);
    }

    private zzakd(int i, int i2, boolean z, boolean z2) {
        String str = "afma-sdk-a-v";
        String str2 = z ? "0" : "1";
        StringBuilder stringBuilder = new StringBuilder((24 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(i);
        stringBuilder.append(".");
        stringBuilder.append(i2);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        this(stringBuilder.toString(), i, i2, z, z2);
    }

    public zzakd(int i, boolean z) {
        this(zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE, i, true, z);
    }

    zzakd(String str, int i, int i2, boolean z, boolean z2) {
        this.f17551a = str;
        this.f17552b = i;
        this.f17553c = i2;
        this.f17554d = z;
        this.f17555e = z2;
    }

    public static zzakd m17801a() {
        return new zzakd(11910208, 11910208, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17551a);
        zzbfp.m5540a(parcel, 3, this.f17552b);
        zzbfp.m5540a(parcel, 4, this.f17553c);
        zzbfp.m5547a(parcel, 5, this.f17554d);
        zzbfp.m5547a(parcel, 6, this.f17555e);
        zzbfp.m5537a(parcel, i);
    }
}
