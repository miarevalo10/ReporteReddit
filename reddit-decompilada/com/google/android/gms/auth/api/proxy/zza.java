package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zza implements Creator<ProxyRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        int i2 = i;
        String str = null;
        byte[] bArr = str;
        Bundle bundle = bArr;
        long j = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1000) {
                switch (i3) {
                    case 1:
                        str = zzbfn.m5527k(parcel, readInt);
                        break;
                    case 2:
                        i2 = zzbfn.m5520d(parcel, readInt);
                        break;
                    case 3:
                        j = zzbfn.m5521e(parcel, readInt);
                        break;
                    case 4:
                        bArr = zzbfn.m5530n(parcel, readInt);
                        break;
                    case 5:
                        bundle = zzbfn.m5529m(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            i = zzbfn.m5520d(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        return new ProxyRequest(i, str, i2, j, bArr, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
