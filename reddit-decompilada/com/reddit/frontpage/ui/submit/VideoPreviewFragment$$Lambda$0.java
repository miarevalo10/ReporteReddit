package com.reddit.frontpage.ui.submit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.reddit.frontpage.FrontpageApplication;

final /* synthetic */ class VideoPreviewFragment$$Lambda$0 implements OnCheckedChangeListener {
    private final VideoPreviewFragment f21633a;

    VideoPreviewFragment$$Lambda$0(VideoPreviewFragment videoPreviewFragment) {
        this.f21633a = videoPreviewFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton = this.f21633a;
        z = compoundButton.gifSwitch.isChecked();
        compoundButton.clippingBarView.setSpanLimit(z ? 60 : 0);
        compoundButton.f39356b.m24362a(z);
        if (z) {
            compoundButton.f39356b.m24366c();
            if (!compoundButton.f39356b.f22223e) {
                FrontpageApplication.m28873i().mo5025a().m23652a();
            }
        }
        compoundButton.simpleExoPlayerView.m24331a(z);
    }
}
