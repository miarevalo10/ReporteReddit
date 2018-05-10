package com.google.android.gms.internal;

import org.json.JSONObject;

@zzzv
public final class zzwx {
    private final boolean f8130a;
    private final boolean f8131b;
    private final boolean f8132c;
    private final boolean f8133d;
    private final boolean f8134e;

    private zzwx(zzwz com_google_android_gms_internal_zzwz) {
        this.f8130a = com_google_android_gms_internal_zzwz.f8135a;
        this.f8131b = com_google_android_gms_internal_zzwz.f8136b;
        this.f8132c = com_google_android_gms_internal_zzwz.f8137c;
        this.f8133d = com_google_android_gms_internal_zzwz.f8138d;
        this.f8134e = com_google_android_gms_internal_zzwz.f8139e;
    }

    public final JSONObject m6775a() {
        try {
            return new JSONObject().put("sms", this.f8130a).put("tel", this.f8131b).put("calendar", this.f8132c).put("storePicture", this.f8133d).put("inlineVideo", this.f8134e);
        } catch (Throwable e) {
            zzakb.m5367b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
