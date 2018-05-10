package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential extends zzbfm implements ReflectedParcelable {
    public static final Creator<Credential> CREATOR = new zza();
    private final String f17199a;
    private final String f17200b;
    private final Uri f17201c;
    private final List<IdToken> f17202d;
    private final String f17203e;
    private final String f17204f;
    private final String f17205g;
    private final String f17206h;
    private final String f17207i;
    private final String f17208j;

    Credential(String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6, String str7, String str8) {
        str = ((String) zzbq.m4809a((Object) str, (Object) "credential identifier cannot be null")).trim();
        zzbq.m4811a(str, (Object) "credential identifier cannot be empty");
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                boolean z = false;
                if (!TextUtils.isEmpty(str4)) {
                    Uri parse = Uri.parse(str4);
                    if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme())) {
                        if (!TextUtils.isEmpty(parse.getAuthority())) {
                            if ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
                                z = true;
                            }
                        }
                    }
                }
                if (!Boolean.valueOf(z).booleanValue()) {
                    throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.f17200b = str2;
                this.f17201c = uri;
                this.f17202d = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
                this.f17199a = str;
                this.f17203e = str3;
                this.f17204f = str4;
                this.f17205g = str5;
                this.f17206h = str6;
                this.f17207i = str7;
                this.f17208j = str8;
                return;
            }
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        throw new IllegalArgumentException("Password must not be empty if set");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f17199a, credential.f17199a) && TextUtils.equals(this.f17200b, credential.f17200b) && zzbg.m4806a(this.f17201c, credential.f17201c) && TextUtils.equals(this.f17203e, credential.f17203e) && TextUtils.equals(this.f17204f, credential.f17204f) && TextUtils.equals(this.f17205g, credential.f17205g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17199a, this.f17200b, this.f17201c, this.f17203e, this.f17204f, this.f17205g});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f17199a);
        zzbfp.m5545a(parcel, 2, this.f17200b);
        zzbfp.m5544a(parcel, 3, this.f17201c, i);
        zzbfp.m5559c(parcel, 4, this.f17202d);
        zzbfp.m5545a(parcel, 5, this.f17203e);
        zzbfp.m5545a(parcel, 6, this.f17204f);
        zzbfp.m5545a(parcel, 7, this.f17205g);
        zzbfp.m5545a(parcel, 8, this.f17206h);
        zzbfp.m5545a(parcel, 9, this.f17207i);
        zzbfp.m5545a(parcel, 10, this.f17208j);
        zzbfp.m5537a(parcel, a);
    }
}
