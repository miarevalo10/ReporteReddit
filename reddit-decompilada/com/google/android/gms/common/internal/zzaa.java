package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzbfn;

public final class zzaa implements Creator<zzz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        int i2 = i;
        int i3 = i2;
        String str = null;
        IBinder iBinder = str;
        Scope[] scopeArr = iBinder;
        Bundle bundle = scopeArr;
        Account account = bundle;
        zzc[] com_google_android_gms_common_zzcArr = account;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 3:
                    i3 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 4:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 5:
                    iBinder = zzbfn.m5528l(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) zzbfn.m5517b(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zzbfn.m5529m(parcel, readInt);
                    break;
                case 8:
                    account = (Account) zzbfn.m5512a(parcel, readInt, Account.CREATOR);
                    break;
                case 10:
                    com_google_android_gms_common_zzcArr = (zzc[]) zzbfn.m5517b(parcel, readInt, zzc.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzz(i, i2, i3, str, iBinder, scopeArr, bundle, account, com_google_android_gms_common_zzcArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzz[i];
    }
}
