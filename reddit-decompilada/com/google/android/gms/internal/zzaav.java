package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class zzaav implements Creator<zzaat> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        long j = 0;
        long j2 = j;
        float f = 0.0f;
        float f2 = f;
        int i = 0;
        int i2 = i;
        boolean z = i2;
        int i3 = z;
        int i4 = i3;
        boolean z2 = i4;
        int i5 = z2;
        int i6 = i5;
        boolean z3 = i6;
        boolean z4 = z3;
        boolean z5 = z4;
        int i7 = z5;
        boolean z6 = i7;
        boolean z7 = z6;
        int i8 = z7;
        boolean z8 = i8;
        boolean z9 = z8;
        boolean z10 = z9;
        Bundle bundle = null;
        zzjj com_google_android_gms_internal_zzjj = bundle;
        zzjn com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjj;
        String str = com_google_android_gms_internal_zzjn;
        ApplicationInfo applicationInfo = str;
        PackageInfo packageInfo = applicationInfo;
        String str2 = packageInfo;
        String str3 = str2;
        String str4 = str3;
        zzakd com_google_android_gms_internal_zzakd = str4;
        Bundle bundle2 = com_google_android_gms_internal_zzakd;
        List list = bundle2;
        Bundle bundle3 = list;
        String str5 = bundle3;
        String str6 = str5;
        List list2 = str6;
        String str7 = list2;
        zzpe com_google_android_gms_internal_zzpe = str7;
        List list3 = com_google_android_gms_internal_zzpe;
        String str8 = list3;
        String str9 = str8;
        String str10 = str9;
        Bundle bundle4 = str10;
        String str11 = bundle4;
        zzlr com_google_android_gms_internal_zzlr = str11;
        Bundle bundle5 = com_google_android_gms_internal_zzlr;
        String str12 = bundle5;
        String str13 = str12;
        String str14 = str13;
        List list4 = str14;
        String str15 = list4;
        List list5 = str15;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 2:
                    bundle = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 3:
                    com_google_android_gms_internal_zzjj = (zzjj) zzbfn.m5512a(parcel2, readInt, zzjj.CREATOR);
                    break;
                case 4:
                    com_google_android_gms_internal_zzjn = (zzjn) zzbfn.m5512a(parcel2, readInt, zzjn.CREATOR);
                    break;
                case 5:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zzbfn.m5512a(parcel2, readInt, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zzbfn.m5512a(parcel2, readInt, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 9:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 10:
                    str4 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 11:
                    com_google_android_gms_internal_zzakd = (zzakd) zzbfn.m5512a(parcel2, readInt, zzakd.CREATOR);
                    break;
                case 12:
                    bundle2 = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 13:
                    i2 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 14:
                    list = zzbfn.m5533q(parcel2, readInt);
                    break;
                case 15:
                    bundle3 = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 16:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 18:
                    i3 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 19:
                    i4 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 20:
                    f = zzbfn.m5523g(parcel2, readInt);
                    break;
                case 21:
                    str5 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 25:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 26:
                    str6 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 27:
                    list2 = zzbfn.m5533q(parcel2, readInt);
                    break;
                case 28:
                    str7 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 29:
                    com_google_android_gms_internal_zzpe = (zzpe) zzbfn.m5512a(parcel2, readInt, zzpe.CREATOR);
                    break;
                case 30:
                    list3 = zzbfn.m5533q(parcel2, readInt);
                    break;
                case 31:
                    j2 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 33:
                    str8 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 34:
                    f2 = zzbfn.m5523g(parcel2, readInt);
                    break;
                case 35:
                    i5 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 36:
                    i6 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 37:
                    z3 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 38:
                    z4 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 39:
                    str9 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 40:
                    z2 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 41:
                    str10 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 42:
                    z5 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 43:
                    i7 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 44:
                    bundle4 = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 45:
                    str11 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 46:
                    com_google_android_gms_internal_zzlr = (zzlr) zzbfn.m5512a(parcel2, readInt, zzlr.CREATOR);
                    break;
                case 47:
                    z6 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 48:
                    bundle5 = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 49:
                    str12 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 50:
                    str13 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 51:
                    str14 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 52:
                    z7 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 53:
                    list4 = zzbfn.m5532p(parcel2, readInt);
                    break;
                case 54:
                    str15 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 55:
                    list5 = zzbfn.m5533q(parcel2, readInt);
                    break;
                case 56:
                    i8 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 57:
                    z8 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 58:
                    z9 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 59:
                    z10 = zzbfn.m5516b(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzaat(i, bundle, com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zzjn, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzakd, bundle2, i2, list, bundle3, z, i3, i4, f, str5, j, str6, list2, str7, com_google_android_gms_internal_zzpe, list3, j2, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, com_google_android_gms_internal_zzlr, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i8, z8, z9, z10);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaat[i];
    }
}
