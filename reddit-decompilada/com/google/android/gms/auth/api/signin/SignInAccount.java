package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class SignInAccount extends zzbfm implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new zzf();
    public GoogleSignInAccount f17245a;
    @Deprecated
    private String f17246b;
    @Deprecated
    private String f17247c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f17245a = googleSignInAccount;
        this.f17246b = zzbq.m4811a(str, (Object) "8.3 and 8.4 SDKs require non-null email");
        this.f17247c = zzbq.m4811a(str2, (Object) "8.3 and 8.4 SDKs require non-null userId");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 4, this.f17246b);
        zzbfp.m5544a(parcel, 7, this.f17245a, i);
        zzbfp.m5545a(parcel, 8, this.f17247c);
        zzbfp.m5537a(parcel, a);
    }
}
