package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class IdToken extends zzbfm implements ReflectedParcelable {
    public static final Creator<IdToken> CREATOR = new zzi();
    private final String f17214a;
    private final String f17215b;

    public IdToken(String str, String str2) {
        zzbq.m4818b(TextUtils.isEmpty(str) ^ 1, "account type string cannot be null or empty");
        zzbq.m4818b(TextUtils.isEmpty(str2) ^ 1, "id token string cannot be null or empty");
        this.f17214a = str;
        this.f17215b = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f17214a);
        zzbfp.m5545a(parcel, 2, this.f17215b);
        zzbfp.m5537a(parcel, i);
    }
}
