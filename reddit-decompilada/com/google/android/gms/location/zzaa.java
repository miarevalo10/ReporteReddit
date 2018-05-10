package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzaa implements Creator<zzz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = "";
        String str2 = "";
        String str3 = "";
        int i = 0;
        boolean z = true;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str2 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 2:
                    str3 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 3:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 4:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 5:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzz(str, str2, str3, i, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzz[i];
    }
}
