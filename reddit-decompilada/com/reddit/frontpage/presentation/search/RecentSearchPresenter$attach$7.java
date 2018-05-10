package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.presentation.analytics.SearchAnalytics;
import com.reddit.frontpage.util.kotlin.MutableListsKt;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004 \u0007*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", "Lcom/reddit/frontpage/presentation/search/RecentSearchItem;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
final class RecentSearchPresenter$attach$7<T> implements Consumer<Pair<? extends List<? extends String>, ? extends List<? extends RecentSearchItem>>> {
    final /* synthetic */ RecentSearchPresenter f28789a;

    RecentSearchPresenter$attach$7(RecentSearchPresenter recentSearchPresenter) {
        this.f28789a = recentSearchPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Pair pair = (Pair) obj;
        Object obj2 = (List) pair.f25267a;
        List list = (List) pair.f25268b;
        List c = this.f28789a.f37077a;
        Intrinsics.m26843a(obj2, "queries");
        MutableListsKt.m24089a(c, obj2);
        MutableListsKt.m24089a(this.f28789a.f37080e, list);
        this.f28789a.f37081f.mo7428a(list);
        Iterable<String> c2 = this.f28789a.f37077a;
        SearchAnalytics a = this.f28789a.f37079c;
        int i = 0;
        for (String a2 : c2) {
            int i2 = i + 1;
            a.mo4778a(i, a2);
            i = i2;
        }
    }
}
