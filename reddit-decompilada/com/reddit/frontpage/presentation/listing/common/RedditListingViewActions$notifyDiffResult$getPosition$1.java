package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0012\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "R", "Lcom/reddit/frontpage/presentation/listing/common/ListingAdapter;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "position", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ListingViewActions.kt */
final class RedditListingViewActions$notifyDiffResult$getPosition$1 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ CardLinkAdapter f36572a;

    RedditListingViewActions$notifyDiffResult$getPosition$1(CardLinkAdapter cardLinkAdapter) {
        this.f36572a = cardLinkAdapter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Integer.valueOf(((ListingAdapter) this.f36572a).mo6472h(((Number) obj).intValue()));
    }
}
