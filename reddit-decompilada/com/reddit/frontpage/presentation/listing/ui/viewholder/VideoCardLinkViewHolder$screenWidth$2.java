package com.reddit.frontpage.presentation.listing.ui.viewholder;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: VideoCardLinkViewHolder.kt */
final class VideoCardLinkViewHolder$screenWidth$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ VideoCardLinkViewHolder f36923a;

    VideoCardLinkViewHolder$screenWidth$2(VideoCardLinkViewHolder videoCardLinkViewHolder) {
        this.f36923a = videoCardLinkViewHolder;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object window = this.f36923a.ac().getWindow();
        Intrinsics.m26843a(window, "activity.window");
        window = window.getDecorView();
        Intrinsics.m26843a(window, "activity.window.decorView");
        return Integer.valueOf(window.getWidth());
    }
}
