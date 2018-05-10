package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C0436R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;

@Deprecated
public final class zzbz {
    private static final Object f5800a = new Object();
    private static zzbz f5801b;
    private final String f5802c;
    private final Status f5803d;
    private final boolean f5804e;
    private final boolean f5805f;

    private zzbz(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C0436R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            if (resources.getInteger(identifier) == 0) {
                z = false;
            }
            this.f5805f = z ^ 1;
        } else {
            this.f5805f = false;
        }
        this.f5804e = z;
        Object a = zzbf.m4802a(context);
        if (a == null) {
            a = new zzca(context).m4822a("google_app_id");
        }
        if (TextUtils.isEmpty(a)) {
            this.f5803d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f5802c = null;
            return;
        }
        this.f5802c = a;
        this.f5803d = Status.f17263a;
    }

    public static Status m4734a(Context context) {
        Status status;
        zzbq.m4809a((Object) context, (Object) "Context must not be null.");
        synchronized (f5800a) {
            if (f5801b == null) {
                f5801b = new zzbz(context);
            }
            status = f5801b.f5803d;
        }
        return status;
    }

    private static zzbz m4735a(String str) {
        zzbz com_google_android_gms_common_api_internal_zzbz;
        synchronized (f5800a) {
            if (f5801b == null) {
                StringBuilder stringBuilder = new StringBuilder(34 + String.valueOf(str).length());
                stringBuilder.append("Initialize must be called before ");
                stringBuilder.append(str);
                stringBuilder.append(".");
                throw new IllegalStateException(stringBuilder.toString());
            }
            com_google_android_gms_common_api_internal_zzbz = f5801b;
        }
        return com_google_android_gms_common_api_internal_zzbz;
    }

    public static String m4736a() {
        return m4735a("getGoogleAppId").f5802c;
    }

    public static boolean m4737b() {
        return m4735a("isMeasurementExplicitlyDisabled").f5805f;
    }
}
