package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzc implements Creator<CredentialPickerConfig> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        boolean z = i;
        boolean z2 = z;
        boolean z3 = z2;
        int i2 = z3;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1000) {
                switch (i3) {
                    case 1:
                        z = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 2:
                        z2 = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 3:
                        z3 = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 4:
                        i2 = zzbfn.m5520d(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            i = zzbfn.m5520d(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        return new CredentialPickerConfig(i, z, z2, z3, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
