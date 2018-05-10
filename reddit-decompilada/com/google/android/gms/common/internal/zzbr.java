package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzbr extends zzbfm {
    public static final Creator<zzbr> CREATOR = new zzbs();
    private int f17329a;
    private final Account f17330b;
    private final int f17331c;
    private final GoogleSignInAccount f17332d;

    zzbr(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f17329a = i;
        this.f17330b = account;
        this.f17331c = i2;
        this.f17332d = googleSignInAccount;
    }

    public zzbr(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17329a);
        zzbfp.m5544a(parcel, 2, this.f17330b, i);
        zzbfp.m5540a(parcel, 3, this.f17331c);
        zzbfp.m5544a(parcel, 4, this.f17332d, i);
        zzbfp.m5537a(parcel, a);
    }
}
