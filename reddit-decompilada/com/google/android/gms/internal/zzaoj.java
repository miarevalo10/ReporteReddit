package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

final class zzaoj implements OnCancelListener {
    private /* synthetic */ JsResult f6668a;

    zzaoj(JsResult jsResult) {
        this.f6668a = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f6668a.cancel();
    }
}
