package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzbs;
import java.util.List;
import net.hockeyapp.android.UpdateFragment;

@zzzv
public final class zzil extends zzbfm {
    public static final Creator<zzil> CREATOR = new zzim();
    public final String f18114a;
    private long f18115b;
    private String f18116c;
    private String f18117d;
    private String f18118e;
    private Bundle f18119f;
    private boolean f18120g;
    private long f18121h;

    zzil(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2) {
        this.f18114a = str;
        this.f18115b = j;
        if (str2 == null) {
            str2 = "";
        }
        this.f18116c = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.f18117d = str3;
        if (str4 == null) {
            str4 = "";
        }
        this.f18118e = str4;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f18119f = bundle;
        this.f18120g = z;
        this.f18121h = j2;
    }

    public static zzil m18751a(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder stringBuilder = new StringBuilder(62);
                stringBuilder.append("Expected 2 path parts for namespace and id, found :");
                stringBuilder.append(size);
                zzakb.m5371e(stringBuilder.toString());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter(UpdateFragment.FRAGMENT_URL);
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str3 : zzbs.m4488g().mo3437a(uri)) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzil(queryParameter, parseLong, host, str, str2, bundle, equals, 0);
        } catch (Throwable e) {
            zzakb.m5369c("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public static zzil m18752a(String str) {
        return m18751a(Uri.parse(str));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f18114a);
        zzbfp.m5541a(parcel, 3, this.f18115b);
        zzbfp.m5545a(parcel, 4, this.f18116c);
        zzbfp.m5545a(parcel, 5, this.f18117d);
        zzbfp.m5545a(parcel, 6, this.f18118e);
        zzbfp.m5542a(parcel, 7, this.f18119f);
        zzbfp.m5547a(parcel, 8, this.f18120g);
        zzbfp.m5541a(parcel, 9, this.f18121h);
        zzbfp.m5537a(parcel, i);
    }
}
