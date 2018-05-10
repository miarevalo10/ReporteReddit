package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "after", "", "<anonymous parameter 1>", "recentIds", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
final class LinkPagerLoadData$getHistoryResultFunction$1 extends Lambda implements Function3<String, String, String, Single<Listing<? extends Link>>> {
    final /* synthetic */ LinkPagerLoadData f36335a;
    final /* synthetic */ HistoryParams f36336b;

    LinkPagerLoadData$getHistoryResultFunction$1(LinkPagerLoadData linkPagerLoadData, HistoryParams historyParams) {
        this.f36335a = linkPagerLoadData;
        this.f36336b = historyParams;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        obj = this.f36335a.f28011b.m22416a(this.f36336b.f33743c, this.f36336b.f33744d, (String) obj, (String) obj3).map((Function) new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                List list;
                Listing listing = (Listing) obj;
                Intrinsics.m26847b(listing, "it");
                if ((Intrinsics.m26845a(this.f36336b.f33744d, HistorySortType.f28411d) ^ 1) != 0) {
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
        Intrinsics.m26843a(obj, "linkRepository.getHistor…it.before\n      )\n      }");
        return obj;
    }
}
