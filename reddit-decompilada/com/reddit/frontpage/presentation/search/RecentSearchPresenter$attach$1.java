package com.reddit.frontpage.presentation.search;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "query", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
final class RecentSearchPresenter$attach$1<T, R> implements Function<T, R> {
    final /* synthetic */ RecentSearchPresenter f28781a;

    RecentSearchPresenter$attach$1(RecentSearchPresenter recentSearchPresenter) {
        this.f28781a = recentSearchPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "query");
        this.f28781a.f37079c.mo4780a(str);
        return str;
    }
}
