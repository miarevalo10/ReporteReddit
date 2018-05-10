package com.reddit.frontpage.ui.alert;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$Companion$forceUpdate$$inlined$apply$lambda$2 implements OnDismissListener {
    final /* synthetic */ AppConfiguration f21101a;
    final /* synthetic */ Activity f21102b;

    RedditAlertDialog$Companion$forceUpdate$$inlined$apply$lambda$2(AppConfiguration appConfiguration, Activity activity) {
        this.f21101a = appConfiguration;
        this.f21102b = activity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface = RedditAlertDialog.f21112b;
        Activity activity = this.f21102b;
        AppConfiguration appConfiguration = this.f21101a;
        Intrinsics.m26843a((Object) appConfiguration, "appConfig");
        Companion.m23302a(activity, appConfiguration);
    }
}
