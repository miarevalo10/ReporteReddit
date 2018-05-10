package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzb implements Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        Intent intent = str7;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 4:
                    str3 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 5:
                    str4 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 6:
                    str5 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 7:
                    str6 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 8:
                    str7 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 9:
                    intent = (Intent) zzbfn.m5512a(parcel, readInt, Intent.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzc(str, str2, str3, str4, str5, str6, str7, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
