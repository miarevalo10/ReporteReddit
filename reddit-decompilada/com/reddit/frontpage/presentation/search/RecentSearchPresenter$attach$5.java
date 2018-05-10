package com.reddit.frontpage.presentation.search;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/reddit/frontpage/presentation/search/RecentSearchItem;", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
final class RecentSearchPresenter$attach$5<T, R> implements Function<Throwable, Pair<? extends List<? extends String>, ? extends List<? extends RecentSearchItem>>> {
    public static final RecentSearchPresenter$attach$5 f28787a = new RecentSearchPresenter$attach$5();

    RecentSearchPresenter$attach$5() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((Throwable) obj, "it");
        return TuplesKt.m26780a(CollectionsKt__CollectionsKt.m26790a(), CollectionsKt__CollectionsKt.m26790a());
    }
}
