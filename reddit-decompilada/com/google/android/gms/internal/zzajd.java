package com.google.android.gms.internal;

import com.facebook.stetho.server.http.HttpStatus;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;

public final class zzajd extends zzr<zzp> {
    private final zzalf<zzp> f14114m;
    private final Map<String, String> f14115n;
    private final zzajv f14116o;

    public zzajd(String str, zzalf<zzp> com_google_android_gms_internal_zzalf_com_google_android_gms_internal_zzp) {
        this(str, com_google_android_gms_internal_zzalf_com_google_android_gms_internal_zzp, (byte) 0);
    }

    private zzajd(String str, zzalf<zzp> com_google_android_gms_internal_zzalf_com_google_android_gms_internal_zzp, byte b) {
        super(0, str, new zzaje(com_google_android_gms_internal_zzalf_com_google_android_gms_internal_zzp));
        this.f14115n = null;
        this.f14114m = com_google_android_gms_internal_zzalf_com_google_android_gms_internal_zzp;
        this.f14116o = new zzajv();
        this.f14116o.m5357a(str, HttpRequest.METHOD_GET, null, null);
    }

    protected final zzw<zzp> mo1727a(zzp com_google_android_gms_internal_zzp) {
        return zzw.m6771a(com_google_android_gms_internal_zzp, zzao.m5466a(com_google_android_gms_internal_zzp));
    }

    protected final /* synthetic */ void mo1728a(Object obj) {
        zzp com_google_android_gms_internal_zzp = (zzp) obj;
        zzajv com_google_android_gms_internal_zzajv = this.f14116o;
        Map map = com_google_android_gms_internal_zzp.f7958c;
        int i = com_google_android_gms_internal_zzp.f7956a;
        if (zzajv.m5355c()) {
            com_google_android_gms_internal_zzajv.m5360a(map, i);
            if (i < HttpStatus.HTTP_OK || i >= 300) {
                com_google_android_gms_internal_zzajv.m5362b(null);
            }
        }
        com_google_android_gms_internal_zzajv = this.f14116o;
        byte[] bArr = com_google_android_gms_internal_zzp.f7957b;
        if (zzajv.m5355c() && bArr != null) {
            com_google_android_gms_internal_zzajv.m5361a(bArr);
        }
        this.f14114m.m13330b(com_google_android_gms_internal_zzp);
    }
}
