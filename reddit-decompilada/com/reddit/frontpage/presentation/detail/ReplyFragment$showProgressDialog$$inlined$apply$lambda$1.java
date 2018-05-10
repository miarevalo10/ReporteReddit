package com.reddit.frontpage.presentation.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k = 3, mv = {1, 1, 9})
/* compiled from: ReplyFragment.kt */
final class ReplyFragment$showProgressDialog$$inlined$apply$lambda$1 implements OnDismissListener {
    final /* synthetic */ ReplyFragment f20503a;

    ReplyFragment$showProgressDialog$$inlined$apply$lambda$1(ReplyFragment replyFragment) {
        this.f20503a = replyFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f20503a.f39099i = null;
        this.f20503a.m38934m().setError(null);
    }
}
