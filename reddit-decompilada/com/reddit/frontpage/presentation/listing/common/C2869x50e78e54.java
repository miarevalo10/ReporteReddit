package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "it", "invoke", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;)Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class C2869x50e78e54 extends Lambda implements Function1<T, T> {
    final /* synthetic */ RedditModeratorLinkActions f36585a;
    final /* synthetic */ ListingView f36586b;
    final /* synthetic */ List f36587c;
    final /* synthetic */ List f36588d;
    final /* synthetic */ Map f36589e;
    final /* synthetic */ LinkPresentationModel f36590f;
    final /* synthetic */ Link f36591g;

    C2869x50e78e54(RedditModeratorLinkActions redditModeratorLinkActions, ListingView listingView, List list, List list2, Map map, LinkPresentationModel linkPresentationModel, Link link) {
        this.f36585a = redditModeratorLinkActions;
        this.f36586b = listingView;
        this.f36587c = list;
        this.f36588d = list2;
        this.f36589e = map;
        this.f36590f = linkPresentationModel;
        this.f36591g = link;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((Listable) obj, "it");
        obj = this.f36590f;
        if (obj != null) {
            return (Listable) obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }
}
