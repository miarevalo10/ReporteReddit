package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzb implements Creator<ProxyResponse> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundle = pendingIntent;
        byte[] bArr = bundle;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 != 1000) {
                switch (i4) {
                    case 1:
                        i2 = zzbfn.m5520d(parcel, readInt);
                        break;
                    case 2:
                        pendingIntent = (PendingIntent) zzbfn.m5512a(parcel, readInt, PendingIntent.CREATOR);
                        break;
                    case 3:
                        i3 = zzbfn.m5520d(parcel, readInt);
                        break;
                    case 4:
                        bundle = zzbfn.m5529m(parcel, readInt);
                        break;
                    case 5:
                        bArr = zzbfn.m5530n(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            i = zzbfn.m5520d(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        return new ProxyResponse(i, i2, pendingIntent, i3, bundle, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
