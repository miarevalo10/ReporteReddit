package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C0436R;

public final class zzca {
    private final Resources f5906a;
    private final String f5907b = this.f5906a.getResourcePackageName(C0436R.string.common_google_play_services_unknown_issue);

    public zzca(Context context) {
        zzbq.m4808a((Object) context);
        this.f5906a = context.getResources();
    }

    public final String m4822a(String str) {
        int identifier = this.f5906a.getIdentifier(str, "string", this.f5907b);
        return identifier == 0 ? null : this.f5906a.getString(identifier);
    }
}
