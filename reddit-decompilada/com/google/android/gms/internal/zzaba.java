package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class zzaba implements Creator<zzaaz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        List list = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 3:
                    list = zzbfn.m5533q(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzaaz(z, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaaz[i];
    }
}
