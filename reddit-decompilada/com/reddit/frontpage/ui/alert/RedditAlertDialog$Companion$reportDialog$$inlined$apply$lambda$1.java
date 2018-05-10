package com.reddit.frontpage.ui.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$Companion$reportDialog$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ String[] f21103a;
    final /* synthetic */ Context f21104b;
    final /* synthetic */ String f21105c;
    final /* synthetic */ Function0 f21106d;

    RedditAlertDialog$Companion$reportDialog$$inlined$apply$lambda$1(String[] strArr, Context context, String str, Function0 function0) {
        this.f21103a = strArr;
        this.f21104b = context;
        this.f21105c = str;
        this.f21106d = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == ((Object[]) this.f21103a).length - 1) {
            dialogInterface = RedditAlertDialog.f21112b;
            Context context = this.f21104b;
            dialogInterface = this.f21105c;
            i = this.f21106d;
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(dialogInterface, "kindWithId");
            Intrinsics.m26847b(i, "onLinkReported");
            Function1 redditAlertDialog$Companion$reportOtherDialog$1 = new RedditAlertDialog$Companion$reportOtherDialog$1(dialogInterface, i);
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(redditAlertDialog$Companion$reportOtherDialog$1, "onTextSubmitted");
            String string = context.getString(C1761R.string.action_report);
            Intrinsics.m26843a((Object) string, "context.getString(titleResId)");
            String string2 = context.getString(C1761R.string.hint_report_custom);
            Intrinsics.m26843a((Object) string2, "context.getString(hintResId)");
            Companion.m23285a(context, 100, string, string2, null, redditAlertDialog$Companion$reportOtherDialog$1).show();
            return;
        }
        dialogInterface = RedditAlertDialog.f21112b;
        dialogInterface = this.f21105c;
        Object obj = this.f21103a[i];
        Intrinsics.m26843a(obj, "reasons[which]");
        Companion.m23303a(dialogInterface, obj, null, this.f21106d);
    }
}
