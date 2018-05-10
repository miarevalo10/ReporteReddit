package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

final class zzage extends zzagb {
    private Context f17544a;

    zzage(Context context) {
        this.f17544a = context;
    }

    public final void mo3384a() {
        boolean isAdIdFakeForDebugLogging;
        try {
            isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.f17544a);
        } catch (Throwable e) {
            zzakb.m5367b("Fail to get isAdIdFakeForDebugLogging", e);
            isAdIdFakeForDebugLogging = false;
        }
        zzajv.m5349a(isAdIdFakeForDebugLogging);
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Update ad debug logging enablement as ");
        stringBuilder.append(isAdIdFakeForDebugLogging);
        zzakb.m5371e(stringBuilder.toString());
    }

    public final void mo3385b() {
    }
}
