package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.model.Link;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/model/Link;", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "it", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class RedditModeratorLinkActions$onModerateMarkNsfw$1 extends Lambda implements Function1<Link, Link> {
    final /* synthetic */ boolean f36599a;

    RedditModeratorLinkActions$onModerateMarkNsfw$1(boolean z) {
        this.f36599a = z;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Link link = (Link) obj;
        Intrinsics.m26847b(link, "it");
        return Link.copy$default(link, null, null, 0, null, null, null, 0, null, 0, 0, 0, null, null, null, null, null, null, null, null, null, false, 0, this.f36599a, false, null, null, null, null, null, null, null, null, false, null, null, null, false, false, false, false, false, false, false, false, false, null, null, false, false, false, null, false, false, null, null, null, null, null, false, false, null, null, null, false, -4194305, -1, null);
    }
}
