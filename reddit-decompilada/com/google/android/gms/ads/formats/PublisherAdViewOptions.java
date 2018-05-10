package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class PublisherAdViewOptions extends zzbfm {
    public static final Creator<PublisherAdViewOptions> CREATOR = new zzc();
    public final boolean f17071a;
    public final zzkx f17072b;

    PublisherAdViewOptions(boolean z, IBinder iBinder) {
        this.f17071a = z;
        this.f17072b = iBinder != null ? zzky.m14053a(iBinder) : null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 1, this.f17071a);
        zzbfp.m5543a(parcel, 2, this.f17072b == null ? null : this.f17072b.asBinder());
        zzbfp.m5537a(parcel, i);
    }
}
