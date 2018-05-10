package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Map;
import java.util.Map.Entry;

@zzzv
public final class zzrr extends zzbfm {
    public static final Creator<zzrr> CREATOR = new zzrs();
    private String f18282a;
    private String[] f18283b;
    private String[] f18284c;

    zzrr(String str, String[] strArr, String[] strArr2) {
        this.f18282a = str;
        this.f18283b = strArr;
        this.f18284c = strArr2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f18282a);
        zzbfp.m5550a(parcel, 2, this.f18283b);
        zzbfp.m5550a(parcel, 3, this.f18284c);
        zzbfp.m5537a(parcel, i);
    }

    public static zzrr m18978a(zzr com_google_android_gms_internal_zzr) throws zza {
        Map b = com_google_android_gms_internal_zzr.mo3445b();
        int size = b.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Entry entry : b.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        return new zzrr(com_google_android_gms_internal_zzr.f7967b, strArr, strArr2);
    }
}
