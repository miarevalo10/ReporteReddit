package com.reddit.frontpage.ui.alert;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$Companion$forceUpdate$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ AppConfiguration f21099a;
    final /* synthetic */ Activity f21100b;

    RedditAlertDialog$Companion$forceUpdate$$inlined$apply$lambda$1(AppConfiguration appConfiguration, Activity activity) {
        this.f21099a = appConfiguration;
        this.f21100b = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = RedditAlertDialog.f21112b;
        Activity activity = this.f21100b;
        AppConfiguration appConfiguration = this.f21099a;
        Intrinsics.m26843a((Object) appConfiguration, "appConfig");
        Companion.m23302a(activity, appConfiguration);
    }
}
