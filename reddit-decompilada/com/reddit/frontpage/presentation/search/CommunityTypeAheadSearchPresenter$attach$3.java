package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.presentation.search.CommunityTypeAheadSearchPresenter.Result.Error;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result$Error;", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunityTypeAheadSearchPresenter.kt */
final class CommunityTypeAheadSearchPresenter$attach$3<T, R> implements Function<Throwable, Result> {
    public static final CommunityTypeAheadSearchPresenter$attach$3 f28777a = new CommunityTypeAheadSearchPresenter$attach$3();

    CommunityTypeAheadSearchPresenter$attach$3() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((Throwable) obj, "it");
        return Error.f28770a;
    }
}
