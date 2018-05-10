package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.presentation.listing.ui.viewholder.VideoPlayable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "it", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoPlayable;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ListingScreenActions.kt */
final class RedditListingScreenActions$onActivityPaused$1$1 extends Lambda implements Function1<VideoPlayable, Unit> {
    public static final RedditListingScreenActions$onActivityPaused$1$1 f36569a = new RedditListingScreenActions$onActivityPaused$1$1();

    RedditListingScreenActions$onActivityPaused$1$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        VideoPlayable videoPlayable = (VideoPlayable) obj;
        Intrinsics.m26847b(videoPlayable, "it");
        videoPlayable.mo6960G();
        return Unit.f25273a;
    }
}
