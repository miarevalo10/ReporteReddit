package com.reddit.frontpage.ui.listing;

import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnModQueueCommentSelectedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "onCommentSelected"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModQueueListingScreen.kt */
final class ModQueueListingScreen$onCreateView$3 implements OnModQueueCommentSelectedListener {
    final /* synthetic */ ModQueueListingScreen f29062a;

    ModQueueListingScreen$onCreateView$3(ModQueueListingScreen modQueueListingScreen) {
        this.f29062a = modQueueListingScreen;
    }

    public final void mo4988a(Comment comment) {
        if (comment != null) {
            Object j = comment.j();
            Intrinsics.m26843a(j, "comment.linkId");
            this.f29062a.m29359a(Nav.m22557a(ThingUtil.b(j), comment.getId(), "3"));
        }
    }
}
