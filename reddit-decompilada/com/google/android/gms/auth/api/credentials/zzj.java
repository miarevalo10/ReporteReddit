package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzj implements Creator<PasswordSpecification> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        int i2 = i;
        String str = null;
        List list = str;
        List list2 = list;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 2:
                    list = zzbfn.m5533q(parcel, readInt);
                    break;
                case 3:
                    list2 = zzbfn.m5532p(parcel, readInt);
                    break;
                case 4:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 5:
                    i2 = zzbfn.m5520d(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new PasswordSpecification(str, list, list2, i, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
