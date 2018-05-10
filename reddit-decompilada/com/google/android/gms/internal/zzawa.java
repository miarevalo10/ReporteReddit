package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;

public final class zzawa implements Creator<zzavz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                credential = (Credential) zzbfn.m5512a(parcel, readInt, Credential.CREATOR);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzavz(credential);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzavz[i];
    }
}
