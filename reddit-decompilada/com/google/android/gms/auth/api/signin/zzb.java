package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzb implements Creator<GoogleSignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        Uri uri = str4;
        String str5 = uri;
        String str6 = str5;
        List list = str6;
        String str7 = list;
        String str8 = str7;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 2:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 3:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 4:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 5:
                    str4 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 6:
                    uri = (Uri) zzbfn.m5512a(parcel2, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 8:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 9:
                    str6 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 10:
                    list = zzbfn.m5518c(parcel2, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 12:
                    str8 = zzbfn.m5527k(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
