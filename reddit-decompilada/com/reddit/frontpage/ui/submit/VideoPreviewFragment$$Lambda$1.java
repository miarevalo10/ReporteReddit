package com.reddit.frontpage.ui.submit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final /* synthetic */ class VideoPreviewFragment$$Lambda$1 implements OnClickListener {
    private final VideoPreviewFragment f21634a;

    VideoPreviewFragment$$Lambda$1(VideoPreviewFragment videoPreviewFragment) {
        this.f21634a = videoPreviewFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f21634a;
        dialogInterface.getActivity().setResult(0);
        dialogInterface.getActivity().finish();
    }
}
