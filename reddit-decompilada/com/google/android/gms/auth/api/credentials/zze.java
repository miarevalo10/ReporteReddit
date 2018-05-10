package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zze implements Creator<CredentialRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        boolean z = i;
        boolean z2 = z;
        boolean z3 = z2;
        String[] strArr = null;
        CredentialPickerConfig credentialPickerConfig = strArr;
        CredentialPickerConfig credentialPickerConfig2 = credentialPickerConfig;
        String str = credentialPickerConfig2;
        String str2 = str;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 != 1000) {
                switch (i2) {
                    case 1:
                        z = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 2:
                        strArr = zzbfn.m5531o(parcel, readInt);
                        break;
                    case 3:
                        credentialPickerConfig = (CredentialPickerConfig) zzbfn.m5512a(parcel, readInt, CredentialPickerConfig.CREATOR);
                        break;
                    case 4:
                        credentialPickerConfig2 = (CredentialPickerConfig) zzbfn.m5512a(parcel, readInt, CredentialPickerConfig.CREATOR);
                        break;
                    case 5:
                        z2 = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 6:
                        str = zzbfn.m5527k(parcel, readInt);
                        break;
                    case 7:
                        str2 = zzbfn.m5527k(parcel, readInt);
                        break;
                    case 8:
                        z3 = zzbfn.m5516b(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            i = zzbfn.m5520d(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        return new CredentialRequest(i, z, strArr, credentialPickerConfig, credentialPickerConfig2, z2, str, str2, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
