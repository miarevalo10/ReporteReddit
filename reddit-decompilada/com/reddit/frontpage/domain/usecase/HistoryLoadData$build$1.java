package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "recentIdsWrapper", "Lcom/reddit/frontpage/domain/usecase/RecentIds;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryLoadData.kt */
final class HistoryLoadData$build$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ HistoryLoadData f27988a;
    final /* synthetic */ HistoryLoadDataParams f27989b;

    HistoryLoadData$build$1(HistoryLoadData historyLoadData, HistoryLoadDataParams historyLoadDataParams) {
        this.f27988a = historyLoadData;
        this.f27989b = historyLoadDataParams;
    }

    public final /* synthetic */ Object apply(Object obj) {
        RecentIds recentIds = (RecentIds) obj;
        Intrinsics.m26847b(recentIds, "recentIdsWrapper");
        return this.f27988a.f27991a.m22416a(this.f27989b.f27993a, this.f27989b.f27994b, this.f27989b.f27995c, recentIds.f20290a).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                List list;
                Listing listing = (Listing) obj;
                Intrinsics.m26847b(listing, "it");
                if ((Intrinsics.m26845a(this.f27989b.f27994b, HistorySortType.f28411d) ^ 1) != 0) {
                    Collection arrayList = new ArrayList();
                    for (Object next : listing.getChildren()) {
                        if ((((Link) next).getHidden() ^ 1) != 0) {
                            arrayList.add(next);
                        }
                    }
                    list = (List) arrayList;
                } else {
                    list = listing.getChildren();
                }
                return new Listing(list, listing.getAfter(), listing.getBefore(), null, 8, null);
            }
        });
    }
}
