package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class RedditModeratorLinkActions$onModerateRemove$4<T> implements Consumer<Throwable> {
    final /* synthetic */ RedditModeratorLinkActions f28351a;
    final /* synthetic */ ListingView f28352b;
    final /* synthetic */ int f28353c;
    final /* synthetic */ int f28354d;
    final /* synthetic */ Link f28355e;
    final /* synthetic */ List f28356f;
    final /* synthetic */ Map f28357g;
    final /* synthetic */ LinkPresentationModel f28358h;
    final /* synthetic */ List f28359i;

    RedditModeratorLinkActions$onModerateRemove$4(RedditModeratorLinkActions redditModeratorLinkActions, ListingView listingView, int i, int i2, Link link, List list, Map map, LinkPresentationModel linkPresentationModel, List list2) {
        this.f28351a = redditModeratorLinkActions;
        this.f28352b = listingView;
        this.f28353c = i;
        this.f28354d = i2;
        this.f28355e = link;
        this.f28356f = list;
        this.f28357g = map;
        this.f28358h = linkPresentationModel;
        this.f28359i = list2;
    }

    public final /* synthetic */ void accept(Object obj) {
        RedditModeratorLinkActions.m29616a(this.f28351a, this.f28352b, this.f28353c, this.f28354d, this.f28355e, this.f28356f, this.f28357g, this.f28358h, this.f28359i);
    }
}
