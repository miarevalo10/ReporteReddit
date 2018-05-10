package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzao;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzbfn;

public final class zzm implements Creator<AdOverlayInfoParcel> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        int i = z;
        int i2 = i;
        zzc com_google_android_gms_ads_internal_overlay_zzc = null;
        IBinder iBinder = com_google_android_gms_ads_internal_overlay_zzc;
        IBinder iBinder2 = iBinder;
        IBinder iBinder3 = iBinder2;
        IBinder iBinder4 = iBinder3;
        String str = iBinder4;
        String str2 = str;
        IBinder iBinder5 = str2;
        String str3 = iBinder5;
        zzakd com_google_android_gms_internal_zzakd = str3;
        String str4 = com_google_android_gms_internal_zzakd;
        zzao com_google_android_gms_ads_internal_zzao = str4;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    com_google_android_gms_ads_internal_overlay_zzc = (zzc) zzbfn.m5512a(parcel2, readInt, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = zzbfn.m5528l(parcel2, readInt);
                    break;
                case 4:
                    iBinder2 = zzbfn.m5528l(parcel2, readInt);
                    break;
                case 5:
                    iBinder3 = zzbfn.m5528l(parcel2, readInt);
                    break;
                case 6:
                    iBinder4 = zzbfn.m5528l(parcel2, readInt);
                    break;
                case 7:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 8:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 9:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 10:
                    iBinder5 = zzbfn.m5528l(parcel2, readInt);
                    break;
                case 11:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 12:
                    i2 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 13:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 14:
                    com_google_android_gms_internal_zzakd = (zzakd) zzbfn.m5512a(parcel2, readInt, zzakd.CREATOR);
                    break;
                case 16:
                    str4 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 17:
                    com_google_android_gms_ads_internal_zzao = (zzao) zzbfn.m5512a(parcel2, readInt, zzao.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new AdOverlayInfoParcel(com_google_android_gms_ads_internal_overlay_zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, com_google_android_gms_internal_zzakd, str4, com_google_android_gms_ads_internal_zzao);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
