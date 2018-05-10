package com.reddit.frontpage.ui.alert;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$Companion$dialog$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ String f21091a;
    final /* synthetic */ View f21092b;
    final /* synthetic */ Function1 f21093c;
    final /* synthetic */ EditText f21094d;

    RedditAlertDialog$Companion$dialog$$inlined$apply$lambda$1(String str, View view, Function1 function1, EditText editText) {
        this.f21091a = str;
        this.f21092b = view;
        this.f21093c = function1;
        this.f21094d = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f21093c;
        Object obj = this.f21094d;
        Intrinsics.m26843a(obj, "inputView");
        dialogInterface.mo6492a(obj.getText().toString());
    }
}
