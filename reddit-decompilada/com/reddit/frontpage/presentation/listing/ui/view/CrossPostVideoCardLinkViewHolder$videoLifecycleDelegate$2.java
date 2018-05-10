package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listing.newcard.video.VideoLifecycleDelegate;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/newcard/video/VideoLifecycleDelegate;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CrossPostVideoCardLinkViewHolder.kt */
final class CrossPostVideoCardLinkViewHolder$videoLifecycleDelegate$2 extends Lambda implements Function0<VideoLifecycleDelegate> {
    final /* synthetic */ CrossPostVideoCardLinkViewHolder f36798a;
    final /* synthetic */ Consumer f36799b;
    final /* synthetic */ Consumer f36800c;

    CrossPostVideoCardLinkViewHolder$videoLifecycleDelegate$2(CrossPostVideoCardLinkViewHolder crossPostVideoCardLinkViewHolder, Consumer consumer, Consumer consumer2) {
        this.f36798a = crossPostVideoCardLinkViewHolder;
        this.f36799b = consumer;
        this.f36800c = consumer2;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        int a = this.f36798a.aa();
        Object window = this.f36798a.ab().getWindow();
        Intrinsics.m26843a(window, "activity.window");
        window = window.getDecorView();
        Intrinsics.m26843a(window, "activity.window.decorView");
        VideoLifecycleDelegate videoLifecycleDelegate = new VideoLifecycleDelegate(a, window.getHeight(), this.f36798a, ((View) this.f36798a.f36807A.mo5678b()), ((SimpleExoPlayerView) this.f36798a.f36812z.mo5678b()));
        videoLifecycleDelegate.m23520a(this.f36799b);
        videoLifecycleDelegate.m23524b(this.f36800c);
        return videoLifecycleDelegate;
    }
}
