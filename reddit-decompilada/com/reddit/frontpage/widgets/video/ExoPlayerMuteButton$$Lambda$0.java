package com.reddit.frontpage.widgets.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.FrontpageApplication;

final /* synthetic */ class ExoPlayerMuteButton$$Lambda$0 implements OnClickListener {
    private final ExoPlayerMuteButton f22107a;

    ExoPlayerMuteButton$$Lambda$0(ExoPlayerMuteButton exoPlayerMuteButton) {
        this.f22107a = exoPlayerMuteButton;
    }

    public final void onClick(View view) {
        view = this.f22107a;
        if (view.f34561a != null) {
            view = VideoPlayer.m24337a(view.f34561a);
            if (view != null) {
                view.m24363b();
                if (view.f22223e != null) {
                    FrontpageApplication.m28873i().mo5025a().m23653b();
                    return;
                }
                FrontpageApplication.m28873i().mo5025a().m23652a();
            }
        }
    }
}
