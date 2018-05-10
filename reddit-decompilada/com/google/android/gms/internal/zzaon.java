package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

final class zzaon implements OnClickListener {
    private /* synthetic */ JsPromptResult f6672a;

    zzaon(JsPromptResult jsPromptResult) {
        this.f6672a = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f6672a.cancel();
    }
}
