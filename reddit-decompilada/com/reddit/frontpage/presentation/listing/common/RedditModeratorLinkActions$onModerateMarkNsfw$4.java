package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class RedditModeratorLinkActions$onModerateMarkNsfw$4<T> implements Consumer<Throwable> {
    final /* synthetic */ RedditModeratorLinkActions f28321a;
    final /* synthetic */ ListingView f28322b;
    final /* synthetic */ int f28323c;
    final /* synthetic */ int f28324d;
    final /* synthetic */ Link f28325e;
    final /* synthetic */ List f28326f;
    final /* synthetic */ Map f28327g;
    final /* synthetic */ LinkPresentationModel f28328h;
    final /* synthetic */ List f28329i;

    RedditModeratorLinkActions$onModerateMarkNsfw$4(RedditModeratorLinkActions redditModeratorLinkActions, ListingView listingView, int i, int i2, Link link, List list, Map map, LinkPresentationModel linkPresentationModel, List list2) {
        this.f28321a = redditModeratorLinkActions;
        this.f28322b = listingView;
        this.f28323c = i;
        this.f28324d = i2;
        this.f28325e = link;
        this.f28326f = list;
        this.f28327g = map;
        this.f28328h = linkPresentationModel;
        this.f28329i = list2;
    }

    public final /* synthetic */ void accept(Object obj) {
        RedditModeratorLinkActions.m29616a(this.f28321a, this.f28322b, this.f28323c, this.f28324d, this.f28325e, this.f28326f, this.f28327g, this.f28328h, this.f28329i);
    }
}
