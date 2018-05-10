package com.reddit.frontpage.ui.alert;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialogKt$sam$OnClickListener$4ed99a24 implements OnClickListener {
    private final /* synthetic */ Function2 f21115a;

    RedditAlertDialogKt$sam$OnClickListener$4ed99a24(Function2 function2) {
        this.f21115a = function2;
    }

    public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i) {
        Intrinsics.m26843a(this.f21115a.mo6497a(dialogInterface, Integer.valueOf(i)), "invoke(...)");
    }
}
