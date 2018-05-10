package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzap extends zzeu implements zzan {
    zzap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account mo1625a() throws RemoteException {
        Parcel a = m5934a(2, o_());
        Account account = (Account) zzew.m5937a(a, Account.CREATOR);
        a.recycle();
        return account;
    }
}
