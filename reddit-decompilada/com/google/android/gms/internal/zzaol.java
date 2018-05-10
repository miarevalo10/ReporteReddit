package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

final class zzaol implements OnClickListener {
    private /* synthetic */ JsResult f6670a;

    zzaol(JsResult jsResult) {
        this.f6670a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f6670a.confirm();
    }
}
