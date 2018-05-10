package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zza implements Creator<Credential> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        String str2 = str;
        Uri uri = str2;
        List list = uri;
        String str3 = list;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 2:
                    str2 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 3:
                    uri = (Uri) zzbfn.m5512a(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    list = zzbfn.m5518c(parcel, readInt, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 6:
                    str4 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 7:
                    str5 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 8:
                    str6 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 9:
                    str7 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 10:
                    str8 = zzbfn.m5527k(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new Credential(str, str2, uri, list, str3, str4, str5, str6, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Credential[i];
    }
}
