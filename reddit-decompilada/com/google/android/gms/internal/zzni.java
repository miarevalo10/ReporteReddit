package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.zzp;
import java.util.concurrent.Callable;

final class zzni implements Callable<Void> {
    private /* synthetic */ Context f7918a;

    zzni(Context context) {
        this.f7918a = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zznf f = zzkb.m6350f();
        Context context = this.f7918a;
        if (!f.f7860c) {
            synchronized (f.f7858a) {
                if (!f.f7860c) {
                    f.f7862e = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    try {
                        Context remoteContext = zzp.getRemoteContext(context);
                        if (remoteContext == null && context != null) {
                            remoteContext = context.getApplicationContext();
                            if (remoteContext == null) {
                                remoteContext = context;
                            }
                        }
                        if (remoteContext != null) {
                            zzkb.m6348d();
                            f.f7861d = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            f.f7860c = true;
                            f.f7859b.open();
                        }
                    } finally {
                        f.f7859b.open();
                    }
                }
            }
        }
        return null;
    }
}
