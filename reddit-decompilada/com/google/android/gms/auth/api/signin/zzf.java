package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzf implements Creator<SignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = "";
        String str2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i != 4) {
                switch (i) {
                    case 7:
                        googleSignInAccount = (GoogleSignInAccount) zzbfn.m5512a(parcel, readInt, GoogleSignInAccount.CREATOR);
                        break;
                    case 8:
                        str2 = zzbfn.m5527k(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            str = zzbfn.m5527k(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
