package com.reddit.frontpage.ui.alert;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$Companion$dialog$1 implements OnShowListener {
    final /* synthetic */ AlertDialog f21095a;

    RedditAlertDialog$Companion$dialog$1(AlertDialog alertDialog) {
        this.f21095a = alertDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        Object a = this.f21095a.a(-1);
        Intrinsics.m26843a(a, "reportDialog\n           …rtDialog.BUTTON_POSITIVE)");
        a.setEnabled(false);
    }
}
