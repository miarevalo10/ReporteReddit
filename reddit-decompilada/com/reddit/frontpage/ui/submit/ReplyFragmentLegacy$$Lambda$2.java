package com.reddit.frontpage.ui.submit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final /* synthetic */ class ReplyFragmentLegacy$$Lambda$2 implements OnClickListener {
    private final ReplyFragmentLegacy f21622a;

    ReplyFragmentLegacy$$Lambda$2(ReplyFragmentLegacy replyFragmentLegacy) {
        this.f21622a = replyFragmentLegacy;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f21622a.getActivity().finish();
    }
}
