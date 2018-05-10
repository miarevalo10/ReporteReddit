package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "it", "invoke", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;)Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
final class RedditModeratorLinkActions$onModerateApprove$2 extends Lambda implements Function1<T, T> {
    final /* synthetic */ boolean f36594a;

    RedditModeratorLinkActions$onModerateApprove$2(boolean z) {
        this.f36594a = z;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Listable listable = (Listable) obj;
        Intrinsics.m26847b(listable, "it");
        return LinkPresentationModel.m34743a((LinkPresentationModel) listable, null, null, null, 0, null, 0, null, null, null, 0, null, null, null, null, false, null, false, 0, null, false, null, null, false, this.f36594a, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, null, false, null, null, 0, false, 0, null, false, 0, null, null, false, false, false, false, false, null, null, null, null, null, null, null, false, false, null, null, null, false, null, false, false, false, null, null, null, -8388609, -1, 8191, null);
    }
}
