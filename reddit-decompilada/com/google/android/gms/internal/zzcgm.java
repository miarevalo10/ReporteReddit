package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcgm implements Creator<zzcgl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        boolean z = i;
        long j = 0;
        long j2 = j;
        long j3 = j2;
        String str = null;
        String str2 = str;
        zzcln com_google_android_gms_internal_zzcln = str2;
        String str3 = com_google_android_gms_internal_zzcln;
        zzcha com_google_android_gms_internal_zzcha = str3;
        zzcha com_google_android_gms_internal_zzcha2 = com_google_android_gms_internal_zzcha;
        zzcha com_google_android_gms_internal_zzcha3 = com_google_android_gms_internal_zzcha2;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 2:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 3:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 4:
                    com_google_android_gms_internal_zzcln = (zzcln) zzbfn.m5512a(parcel2, readInt, zzcln.CREATOR);
                    break;
                case 5:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 6:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 7:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 8:
                    com_google_android_gms_internal_zzcha = (zzcha) zzbfn.m5512a(parcel2, readInt, zzcha.CREATOR);
                    break;
                case 9:
                    j2 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 10:
                    com_google_android_gms_internal_zzcha2 = (zzcha) zzbfn.m5512a(parcel2, readInt, zzcha.CREATOR);
                    break;
                case 11:
                    j3 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 12:
                    com_google_android_gms_internal_zzcha3 = (zzcha) zzbfn.m5512a(parcel2, readInt, zzcha.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzcgl(i, str, str2, com_google_android_gms_internal_zzcln, j, z, str3, com_google_android_gms_internal_zzcha, j2, com_google_android_gms_internal_zzcha2, j3, com_google_android_gms_internal_zzcha3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcgl[i];
    }
}
