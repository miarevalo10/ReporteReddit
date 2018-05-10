package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

final class zzaok implements OnClickListener {
    private /* synthetic */ JsResult f6669a;

    zzaok(JsResult jsResult) {
        this.f6669a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f6669a.cancel();
    }
}
