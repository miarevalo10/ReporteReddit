package com.reddit.frontpage.presentation.search;

import io.reactivex.functions.Predicate;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "Lcom/reddit/frontpage/presentation/search/RecentSearchItem;", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
final class RecentSearchPresenter$attach$6<T> implements Predicate<Pair<? extends List<? extends String>, ? extends List<? extends RecentSearchItem>>> {
    public static final RecentSearchPresenter$attach$6 f28788a = new RecentSearchPresenter$attach$6();

    RecentSearchPresenter$attach$6() {
    }

    public final /* synthetic */ boolean test(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "it");
        obj = pair.f25267a;
        Intrinsics.m26843a(obj, "it.first");
        return ((Collection) obj).isEmpty() == null ? true : null;
    }
}
