package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzn extends zzbfm {
    public static final Creator<zzn> CREATOR = new zzo();
    private final String f17355a;
    private final zzh f17356b;
    private final boolean f17357c;

    zzn(String str, IBinder iBinder, boolean z) {
        this.f17355a = str;
        this.f17356b = m17691a(iBinder);
        this.f17357c = z;
    }

    zzn(String str, zzh com_google_android_gms_common_zzh, boolean z) {
        this.f17355a = str;
        this.f17356b = com_google_android_gms_common_zzh;
        this.f17357c = z;
    }

    private static zzh m17691a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper a = zzau.m13098a(iBinder).mo1626a();
            byte[] bArr = a == null ? null : (byte[]) com.google.android.gms.dynamic.zzn.m17693a(a);
            if (bArr != null) {
                return new zzi(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (Throwable e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f17355a);
        if (this.f17356b == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = this.f17356b.asBinder();
        }
        zzbfp.m5543a(parcel, 2, iBinder);
        zzbfp.m5547a(parcel, 3, this.f17357c);
        zzbfp.m5537a(parcel, i);
    }
}
