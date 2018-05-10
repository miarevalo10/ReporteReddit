package com.reddit.frontpage.presentation.listing.history;

import com.reddit.frontpage.domain.model.Link;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingPresenter.kt */
final class HistoryListingPresenter$onSubscribeSelected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HistoryListingPresenter f36661a;
    final /* synthetic */ Link f36662b;

    HistoryListingPresenter$onSubscribeSelected$1(HistoryListingPresenter historyListingPresenter, Link link) {
        this.f36661a = historyListingPresenter;
        this.f36662b = link;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f36661a.f36663a.mo7663a(this.f36662b.getSubredditNamePrefixed());
        return Unit.f25273a;
    }
}
