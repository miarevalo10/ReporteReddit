package com.reddit.frontpage.ui.submit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import timber.log.Timber;

final /* synthetic */ class ReplyFragmentLegacy$$Lambda$4 implements OnCancelListener {
    private final ReplyFragmentLegacy f21624a;

    ReplyFragmentLegacy$$Lambda$4(ReplyFragmentLegacy replyFragmentLegacy) {
        this.f21624a = replyFragmentLegacy;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface = this.f21624a;
        Timber.b("CANCEL", new Object[0]);
        dialogInterface.getActivity().finish();
    }
}
