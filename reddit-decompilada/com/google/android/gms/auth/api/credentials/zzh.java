package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzh implements Creator<HintRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArr = credentialPickerConfig;
        String str = strArr;
        String str2 = str;
        int i = 0;
        boolean z = i;
        boolean z2 = z;
        boolean z3 = z2;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 != 1000) {
                switch (i2) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) zzbfn.m5512a(parcel, readInt, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        z = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 3:
                        z2 = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 4:
                        strArr = zzbfn.m5531o(parcel, readInt);
                        break;
                    case 5:
                        z3 = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 6:
                        str = zzbfn.m5527k(parcel, readInt);
                        break;
                    case 7:
                        str2 = zzbfn.m5527k(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            i = zzbfn.m5520d(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        return new HintRequest(i, credentialPickerConfig, z, z2, strArr, z3, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new HintRequest[i];
    }
}
