package com.google.android.gms.internal;

import com.instabug.library.model.State;
import org.json.JSONObject;

@zzzv
public class zzxb {
    private final String f8140a;
    final zzanh f8141s;

    public zzxb(zzanh com_google_android_gms_internal_zzanh) {
        this(com_google_android_gms_internal_zzanh, "");
    }

    public zzxb(zzanh com_google_android_gms_internal_zzanh, String str) {
        this.f8141s = com_google_android_gms_internal_zzanh;
        this.f8140a = str;
    }

    public final void m6782a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f8141s.mo3463a("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put(State.KEY_DENSITY, (double) f).put("rotation", i5));
        } catch (Throwable e) {
            zzakb.m5367b("Error occured while obtaining screen information.", e);
        }
    }

    public final void m6783a(String str) {
        try {
            this.f8141s.mo3463a("onError", new JSONObject().put("message", str).put("action", this.f8140a));
        } catch (Throwable e) {
            zzakb.m5367b("Error occurred while dispatching error event.", e);
        }
    }

    public final void m6784b(String str) {
        try {
            this.f8141s.mo3463a("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            zzakb.m5367b("Error occured while dispatching state change.", e);
        }
    }
}
