package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzru implements Creator<zzrt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        int i = z;
        boolean z2 = i;
        String str = null;
        byte[] bArr = str;
        String[] strArr = bArr;
        String[] strArr2 = strArr;
        long j = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 2:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 3:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 4:
                    bArr = zzbfn.m5530n(parcel2, readInt);
                    break;
                case 5:
                    strArr = zzbfn.m5531o(parcel2, readInt);
                    break;
                case 6:
                    strArr2 = zzbfn.m5531o(parcel2, readInt);
                    break;
                case 7:
                    z2 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 8:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzrt(z, str, i, bArr, strArr, strArr2, z2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzrt[i];
    }
}
