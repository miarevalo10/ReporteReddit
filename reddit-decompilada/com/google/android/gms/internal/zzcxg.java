package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzcxg extends zzbfm implements Result {
    public static final Creator<zzcxg> CREATOR = new zzcxh();
    private int f18027a;
    private int f18028b;
    private Intent f18029c;

    public zzcxg() {
        this((byte) 0);
    }

    private zzcxg(byte b) {
        this(2, 0, null);
    }

    zzcxg(int i, int i2, Intent intent) {
        this.f18027a = i;
        this.f18028b = i2;
        this.f18029c = intent;
    }

    public final Status k_() {
        return this.f18028b == 0 ? Status.f17263a : Status.f17267e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f18027a);
        zzbfp.m5540a(parcel, 2, this.f18028b);
        zzbfp.m5544a(parcel, 3, this.f18029c, i);
        zzbfp.m5537a(parcel, a);
    }
}
