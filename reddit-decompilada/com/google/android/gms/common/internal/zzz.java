package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzz extends zzbfm {
    public static final Creator<zzz> CREATOR = new zzaa();
    String f17343a;
    IBinder f17344b;
    Scope[] f17345c;
    Bundle f17346d;
    Account f17347e;
    zzc[] f17348f;
    private int f17349g;
    private int f17350h;
    private int f17351i;

    public zzz(int i) {
        this.f17349g = 3;
        this.f17351i = zzf.f5975b;
        this.f17350h = i;
    }

    zzz(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, zzc[] com_google_android_gms_common_zzcArr) {
        this.f17349g = i;
        this.f17350h = i2;
        this.f17351i = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f17343a = "com.google.android.gms";
        } else {
            this.f17343a = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                zzan com_google_android_gms_common_internal_zzap;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    com_google_android_gms_common_internal_zzap = queryLocalInterface instanceof zzan ? (zzan) queryLocalInterface : new zzap(iBinder);
                }
                account2 = zza.m17676a(com_google_android_gms_common_internal_zzap);
            }
            this.f17347e = account2;
        } else {
            this.f17344b = iBinder;
            this.f17347e = account;
        }
        this.f17345c = scopeArr;
        this.f17346d = bundle;
        this.f17348f = com_google_android_gms_common_zzcArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17349g);
        zzbfp.m5540a(parcel, 2, this.f17350h);
        zzbfp.m5540a(parcel, 3, this.f17351i);
        zzbfp.m5545a(parcel, 4, this.f17343a);
        zzbfp.m5543a(parcel, 5, this.f17344b);
        zzbfp.m5549a(parcel, 6, this.f17345c, i);
        zzbfp.m5542a(parcel, 7, this.f17346d);
        zzbfp.m5544a(parcel, 8, this.f17347e, i);
        zzbfp.m5549a(parcel, 10, this.f17348f, i);
        zzbfp.m5537a(parcel, a);
    }
}
