package com.reddit.frontpage.presentation.listing.popular;

import com.reddit.frontpage.domain.model.Link;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PopularListingPresenter.kt */
final class PopularListingPresenter$onSubscribeSelected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PopularListingPresenter f36707a;
    final /* synthetic */ Link f36708b;

    PopularListingPresenter$onSubscribeSelected$1(PopularListingPresenter popularListingPresenter, Link link) {
        this.f36707a = popularListingPresenter;
        this.f36708b = link;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f36707a.f36716f.mo7654a(this.f36708b.getSubredditNamePrefixed());
        return Unit.f25273a;
    }
}
