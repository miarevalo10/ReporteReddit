package com.reddit.frontpage.ui.alert;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.support.v7.app.AlertDialog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$create$$inlined$apply$lambda$1 implements OnShowListener {
    final /* synthetic */ AlertDialog f21110a;
    final /* synthetic */ RedditAlertDialog f21111b;

    RedditAlertDialog$create$$inlined$apply$lambda$1(AlertDialog alertDialog, RedditAlertDialog redditAlertDialog) {
        this.f21110a = alertDialog;
        this.f21111b = redditAlertDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        this.f21111b.m23317a(this.f21110a);
    }
}
