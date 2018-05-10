package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class RedditModeratorLinkActions$onModerateDistinguish$4<T> implements Consumer<Throwable> {
    final /* synthetic */ RedditModeratorLinkActions f28301a;
    final /* synthetic */ ListingView f28302b;
    final /* synthetic */ int f28303c;
    final /* synthetic */ int f28304d;
    final /* synthetic */ Link f28305e;
    final /* synthetic */ List f28306f;
    final /* synthetic */ Map f28307g;
    final /* synthetic */ LinkPresentationModel f28308h;
    final /* synthetic */ List f28309i;

    RedditModeratorLinkActions$onModerateDistinguish$4(RedditModeratorLinkActions redditModeratorLinkActions, ListingView listingView, int i, int i2, Link link, List list, Map map, LinkPresentationModel linkPresentationModel, List list2) {
        this.f28301a = redditModeratorLinkActions;
        this.f28302b = listingView;
        this.f28303c = i;
        this.f28304d = i2;
        this.f28305e = link;
        this.f28306f = list;
        this.f28307g = map;
        this.f28308h = linkPresentationModel;
        this.f28309i = list2;
    }

    public final /* synthetic */ void accept(Object obj) {
        RedditModeratorLinkActions.m29616a(this.f28301a, this.f28302b, this.f28303c, this.f28304d, this.f28305e, this.f28306f, this.f28307g, this.f28308h, this.f28309i);
    }
}
