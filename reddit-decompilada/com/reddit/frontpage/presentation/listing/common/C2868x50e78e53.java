package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/model/Link;", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "it", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class C2868x50e78e53 extends Lambda implements Function1<Link, Link> {
    final /* synthetic */ RedditModeratorLinkActions f36578a;
    final /* synthetic */ ListingView f36579b;
    final /* synthetic */ List f36580c;
    final /* synthetic */ List f36581d;
    final /* synthetic */ Map f36582e;
    final /* synthetic */ LinkPresentationModel f36583f;
    final /* synthetic */ Link f36584g;

    C2868x50e78e53(RedditModeratorLinkActions redditModeratorLinkActions, ListingView listingView, List list, List list2, Map map, LinkPresentationModel linkPresentationModel, Link link) {
        this.f36578a = redditModeratorLinkActions;
        this.f36579b = listingView;
        this.f36580c = list;
        this.f36581d = list2;
        this.f36582e = map;
        this.f36583f = linkPresentationModel;
        this.f36584g = link;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((Link) obj, "it");
        return this.f36584g;
    }
}
