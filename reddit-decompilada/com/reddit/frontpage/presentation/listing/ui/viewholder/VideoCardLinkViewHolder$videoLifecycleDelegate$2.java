package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.View;
import com.reddit.frontpage.ui.listing.newcard.video.VideoLifecycleDelegate;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/newcard/video/VideoLifecycleDelegate;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: VideoCardLinkViewHolder.kt */
final class VideoCardLinkViewHolder$videoLifecycleDelegate$2 extends Lambda implements Function0<VideoLifecycleDelegate> {
    final /* synthetic */ VideoCardLinkViewHolder f36927a;

    VideoCardLinkViewHolder$videoLifecycleDelegate$2(VideoCardLinkViewHolder videoCardLinkViewHolder) {
        this.f36927a = videoCardLinkViewHolder;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        int c = this.f36927a.ab();
        Object window = this.f36927a.ac().getWindow();
        Intrinsics.m26843a(window, "activity.window");
        window = window.getDecorView();
        Intrinsics.m26843a(window, "activity.window.decorView");
        return new VideoLifecycleDelegate(c, window.getHeight(), this.f36927a, ((View) this.f36927a.f36939z.mo5678b()), ((SimpleExoPlayerView) this.f36927a.f36934A.mo5678b()));
    }
}
