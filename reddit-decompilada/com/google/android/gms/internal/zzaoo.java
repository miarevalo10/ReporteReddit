package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzaoo implements OnClickListener {
    private /* synthetic */ JsPromptResult f6673a;
    private /* synthetic */ EditText f6674b;

    zzaoo(JsPromptResult jsPromptResult, EditText editText) {
        this.f6673a = jsPromptResult;
        this.f6674b = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f6673a.confirm(this.f6674b.getText().toString());
    }
}
