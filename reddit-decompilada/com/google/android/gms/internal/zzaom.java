package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

final class zzaom implements OnCancelListener {
    private /* synthetic */ JsPromptResult f6671a;

    zzaom(JsPromptResult jsPromptResult) {
        this.f6671a = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f6671a.cancel();
    }
}
