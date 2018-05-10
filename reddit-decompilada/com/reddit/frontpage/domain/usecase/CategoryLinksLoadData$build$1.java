package com.reddit.frontpage.domain.usecase;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadDataParams.Refresh;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0001\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00020\u0002 \u0007*B\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "subreddits", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: CategoryLinksLoadData.kt */
final class CategoryLinksLoadData$build$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ CategoryLinksLoadData f27968a;
    final /* synthetic */ CategoryLinksLoadDataParams f27969b;

    CategoryLinksLoadData$build$1(CategoryLinksLoadData categoryLinksLoadData, CategoryLinksLoadDataParams categoryLinksLoadDataParams) {
        this.f27968a = categoryLinksLoadData;
        this.f27969b = categoryLinksLoadDataParams;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final List list = (List) obj;
        Intrinsics.m26847b(list, "subreddits");
        String a = CollectionsKt___CollectionsKt.m41412a((Iterable) list, (CharSequence) Operation.PLUS, null, null, 0, null, (Function1) CategoryLinksLoadData$build$1$multi$1.f36334a, 30);
        StringBuilder stringBuilder = new StringBuilder("r/");
        stringBuilder.append(a);
        stringBuilder.append('/');
        stringBuilder.append(SortType.c);
        stringBuilder.append('/');
        return this.f27968a.f27971b.m22418a(stringBuilder.toString(), this.f27969b.f27973b, this.f27969b instanceof Refresh).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Listing listing = (Listing) obj;
                Intrinsics.m26847b(listing, "listing");
                return TuplesKt.m26780a(list, listing);
            }
        });
    }
}
