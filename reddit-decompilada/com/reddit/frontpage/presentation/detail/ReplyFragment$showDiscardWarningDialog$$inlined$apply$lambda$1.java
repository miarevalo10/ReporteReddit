package com.reddit.frontpage.presentation.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ReplyFragment.kt */
final class ReplyFragment$showDiscardWarningDialog$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ ReplyFragment f20502a;

    ReplyFragment$showDiscardWarningDialog$$inlined$apply$lambda$1(ReplyFragment replyFragment) {
        this.f20502a = replyFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f20502a.getActivity();
        if (dialogInterface != null) {
            dialogInterface.finish();
        }
    }
}
