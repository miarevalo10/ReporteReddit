package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

public final class zze implements Creator<GoogleSignInOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        boolean z = i;
        boolean z2 = z;
        boolean z3 = z2;
        ArrayList arrayList = null;
        Account account = arrayList;
        String str = account;
        String str2 = str;
        ArrayList arrayList2 = str2;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    arrayList = zzbfn.m5518c(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zzbfn.m5512a(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 6:
                    z3 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 7:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 8:
                    str2 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 9:
                    arrayList2 = zzbfn.m5518c(parcel, readInt, zzn.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new GoogleSignInOptions(i, arrayList, account, z, z2, z3, str, str2, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
