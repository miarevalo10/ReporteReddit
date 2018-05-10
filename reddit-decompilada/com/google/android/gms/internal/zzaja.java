package com.google.android.gms.internal;

import java.util.Map;

final class zzaja extends zzau {
    private /* synthetic */ byte[] f17546m;
    private /* synthetic */ Map f17547n;
    private /* synthetic */ zzajv f17548o;

    zzaja(int i, String str, zzy com_google_android_gms_internal_zzy, zzx com_google_android_gms_internal_zzx, byte[] bArr, Map map, zzajv com_google_android_gms_internal_zzajv) {
        this.f17546m = bArr;
        this.f17547n = map;
        this.f17548o = com_google_android_gms_internal_zzajv;
        super(i, str, com_google_android_gms_internal_zzy, com_google_android_gms_internal_zzx);
    }

    protected final /* synthetic */ void mo1728a(Object obj) {
        mo3443a((String) obj);
    }

    protected final void mo3443a(String str) {
        this.f17548o.m5356a(str);
        super.mo3443a(str);
    }

    public final byte[] mo3444a() throws zza {
        return this.f17546m == null ? super.mo3444a() : this.f17546m;
    }

    public final Map<String, String> mo3445b() throws zza {
        return this.f17547n == null ? super.mo3445b() : this.f17547n;
    }
}
