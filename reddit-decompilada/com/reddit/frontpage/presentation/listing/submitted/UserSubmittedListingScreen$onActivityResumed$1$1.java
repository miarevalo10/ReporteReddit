package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.frontpage.presentation.listing.ui.viewholder.VideoPlayable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoPlayable;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$onActivityResumed$1$1 extends Lambda implements Function1<VideoPlayable, Unit> {
    public static final UserSubmittedListingScreen$onActivityResumed$1$1 f36770a = new UserSubmittedListingScreen$onActivityResumed$1$1();

    UserSubmittedListingScreen$onActivityResumed$1$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        VideoPlayable videoPlayable = (VideoPlayable) obj;
        Intrinsics.m26847b(videoPlayable, "it");
        videoPlayable.mo6961H();
        return Unit.f25273a;
    }
}
