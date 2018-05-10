package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.model.SearchType;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0001\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003 \u0006*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u0002 \u0006*B\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003 \u0006*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "", "Lcom/reddit/frontpage/presentation/search/RecentSearchItem;", "kotlin.jvm.PlatformType", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
final class RecentSearchPresenter$attach$4<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ RecentSearchPresenter f28786a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "it", "apply"}, k = 3, mv = {1, 1, 9})
    /* compiled from: RecentSearchPresenter.kt */
    static final class C23171<T, R> implements Function<T, R> {
        public static final C23171 f28784a = new C23171();

        C23171() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            Intrinsics.m26847b(list, "it");
            return CollectionsKt___CollectionsKt.m41415a((Iterable) list, 5);
        }
    }

    RecentSearchPresenter$attach$4(RecentSearchPresenter recentSearchPresenter) {
        this.f28786a = recentSearchPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((String) obj, "it");
        return this.f28786a.f37082g.m22488a(SearchType.SUBREDDIT).map(C23171.f28784a).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                List list = (List) obj;
                Intrinsics.m26847b(list, "queries");
                return TuplesKt.m26780a(list, RecentSearchPresenter.m37457a(list));
            }
        }).toObservable();
    }
}
