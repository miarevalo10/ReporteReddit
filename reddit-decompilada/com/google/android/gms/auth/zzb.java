package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzb implements Creator<AccountChangeEventsRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        String str = null;
        Account account = str;
        int i2 = 0;
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
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 4:
                    account = (Account) zzbfn.m5512a(parcel, readInt, Account.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new AccountChangeEventsRequest(i, i2, str, account);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
