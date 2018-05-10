package com.reddit.frontpage.ui.submit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final /* synthetic */ class ReplyFragmentLegacy$$Lambda$3 implements OnDismissListener {
    private final ReplyFragmentLegacy f21623a;

    ReplyFragmentLegacy$$Lambda$3(ReplyFragmentLegacy replyFragmentLegacy) {
        this.f21623a = replyFragmentLegacy;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface = this.f21623a;
        dialogInterface.f39353a = null;
        dialogInterface.replyText.setError(null);
    }
}
