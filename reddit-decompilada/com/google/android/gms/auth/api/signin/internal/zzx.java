package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzbfn;

public final class zzx implements Creator<SignInConfiguration> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                str = zzbfn.m5527k(parcel, readInt);
            } else if (i != 5) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                googleSignInOptions = (GoogleSignInOptions) zzbfn.m5512a(parcel, readInt, GoogleSignInOptions.CREATOR);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
