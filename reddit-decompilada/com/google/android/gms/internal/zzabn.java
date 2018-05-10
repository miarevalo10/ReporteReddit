package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class zzabn implements Creator<zzabm> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        Bundle bundle = null;
        zzakd com_google_android_gms_internal_zzakd = bundle;
        ApplicationInfo applicationInfo = com_google_android_gms_internal_zzakd;
        String str = applicationInfo;
        List list = str;
        PackageInfo packageInfo = list;
        String str2 = packageInfo;
        String str3 = str2;
        boolean z = false;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bundle = zzbfn.m5529m(parcel, readInt);
                    break;
                case 2:
                    com_google_android_gms_internal_zzakd = (zzakd) zzbfn.m5512a(parcel, readInt, zzakd.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) zzbfn.m5512a(parcel, readInt, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 5:
                    list = zzbfn.m5533q(parcel, readInt);
                    break;
                case 6:
                    packageInfo = (PackageInfo) zzbfn.m5512a(parcel, readInt, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 9:
                    str3 = zzbfn.m5527k(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzabm(bundle, com_google_android_gms_internal_zzakd, applicationInfo, str, list, packageInfo, str2, z, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzabm[i];
    }
}
