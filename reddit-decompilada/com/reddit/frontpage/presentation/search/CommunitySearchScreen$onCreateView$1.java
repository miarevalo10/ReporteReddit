package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.model.SearchType;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitySearchScreen.kt */
final class CommunitySearchScreen$onCreateView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CommunitySearchScreen f37064a;

    CommunitySearchScreen$onCreateView$1(CommunitySearchScreen communitySearchScreen) {
        this.f37064a = communitySearchScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        CommunitySearchResultsPresenter y = this.f37064a.m40918y();
        if (!(y.f37050b == null || y.f37052d)) {
            y.f37052d = true;
            Disposable disposable = y.f37053e;
            if (disposable != null) {
                disposable.mo5626a();
            }
            SearchRepository searchRepository = y.f37055g;
            String str = y.f37049a;
            if (str == null) {
                Intrinsics.m26844a("query");
            }
            Object onErrorReturn = searchRepository.m22489a(str, y.f37050b, SetsKt__SetsKt.m26800a((Object) SearchType.SUBREDDIT)).map(new CommunitySearchResultsPresenter$mapToResult$1(y)).onErrorReturn(CommunitySearchResultsPresenter$mapToResult$2.f28755a);
            Intrinsics.m26843a(onErrorReturn, "this.map { searchResult …orReturn { Result.Error }");
            y.f37053e = SinglesKt.m24094b(onErrorReturn, y.f37056h).subscribe((Consumer) new CommunitySearchResultsPresenter$onLoadMoreMore$1(y));
        }
        return Unit.f25273a;
    }
}
