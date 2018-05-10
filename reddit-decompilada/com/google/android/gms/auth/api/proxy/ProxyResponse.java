package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class ProxyResponse extends zzbfm {
    public static final Creator<ProxyResponse> CREATOR = new zzb();
    public final int f17225a;
    public final PendingIntent f17226b;
    public final int f17227c;
    public final byte[] f17228d;
    private int f17229e;
    private Bundle f17230f;

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.f17229e = i;
        this.f17225a = i2;
        this.f17227c = i3;
        this.f17230f = bundle;
        this.f17228d = bArr;
        this.f17226b = pendingIntent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17225a);
        zzbfp.m5544a(parcel, 2, this.f17226b, i);
        zzbfp.m5540a(parcel, 3, this.f17227c);
        zzbfp.m5542a(parcel, 4, this.f17230f);
        zzbfp.m5548a(parcel, 5, this.f17228d);
        zzbfp.m5540a(parcel, 1000, this.f17229e);
        zzbfp.m5537a(parcel, a);
    }
}
