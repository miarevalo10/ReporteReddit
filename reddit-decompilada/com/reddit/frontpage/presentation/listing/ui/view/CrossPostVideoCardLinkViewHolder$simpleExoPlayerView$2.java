package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/widgets/video/SimpleExoPlayerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CrossPostVideoCardLinkViewHolder.kt */
final class CrossPostVideoCardLinkViewHolder$simpleExoPlayerView$2 extends Lambda implements Function0<SimpleExoPlayerView> {
    final /* synthetic */ View f36796a;

    CrossPostVideoCardLinkViewHolder$simpleExoPlayerView$2(View view) {
        this.f36796a = view;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return (SimpleExoPlayerView) this.f36796a.findViewById(C1761R.id.video_player);
    }
}
