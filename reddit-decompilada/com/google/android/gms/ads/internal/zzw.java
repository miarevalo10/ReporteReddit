package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzw {
    boolean f5653a;
    private final Context f5654b;
    private zzafb f5655c;
    private zzaaz f5656d;

    public zzw(Context context, zzafb com_google_android_gms_internal_zzafb, zzaaz com_google_android_gms_internal_zzaaz) {
        this.f5654b = context;
        this.f5655c = com_google_android_gms_internal_zzafb;
        this.f5656d = com_google_android_gms_internal_zzaaz;
        if (this.f5656d == null) {
            this.f5656d = new zzaaz();
        }
    }

    private final boolean m4518b() {
        return (this.f5655c != null && this.f5655c.mo1702a().f17541f) || this.f5656d.f17467a;
    }

    public final void m4519a(String str) {
        if (m4518b()) {
            if (str == null) {
                str = "";
            }
            if (this.f5655c != null) {
                this.f5655c.mo1705a(str, null, 3);
                return;
            }
            if (this.f5656d.f17467a && this.f5656d.f17468b != null) {
                for (String str2 : this.f5656d.f17468b) {
                    String str22;
                    if (!TextUtils.isEmpty(str22)) {
                        str22 = str22.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzbs.m4486e();
                        zzahn.m5192b(this.f5654b, "", str22);
                    }
                }
            }
        }
    }

    public final boolean m4520a() {
        if (m4518b()) {
            if (!this.f5653a) {
                return false;
            }
        }
        return true;
    }
}
