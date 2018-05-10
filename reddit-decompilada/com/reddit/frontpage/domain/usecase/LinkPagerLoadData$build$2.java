package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadData;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "", "listing", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
final class LinkPagerLoadData$build$2<T, R> implements Function<T, R> {
    final /* synthetic */ LinkPagerLoadDataParams f27999a;

    LinkPagerLoadData$build$2(LinkPagerLoadDataParams linkPagerLoadDataParams) {
        this.f27999a = linkPagerLoadDataParams;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Listing listing = (Listing) obj;
        Intrinsics.m26847b(listing, "listing");
        Collection arrayList = new ArrayList();
        for (Object next : listing.getChildren()) {
            if (!((Link) next).isBlankAd()) {
                arrayList.add(next);
            }
        }
        List<Link> list = (List) arrayList;
        obj = this.f27999a;
        int i = 0;
        if (obj instanceof LoadData) {
            for (Link id : list) {
                if (!Intrinsics.m26845a(id.getId(), ((LoadData) this.f27999a).f33745b)) {
                    i++;
                }
            }
            obj = -1;
            return TuplesKt.m26780a(Listing.copy$default(listing, list, null, null, null, 14, null), Integer.valueOf(obj));
        }
        if ((obj instanceof HistoryParams.LoadData) != null) {
            for (Link id2 : list) {
                if (!Intrinsics.m26845a(id2.getId(), ((HistoryParams.LoadData) this.f27999a).f33742b)) {
                    i++;
                }
            }
        }
        obj = -1;
        return TuplesKt.m26780a(Listing.copy$default(listing, list, null, null, null, 14, null), Integer.valueOf(obj));
        obj = i;
        return TuplesKt.m26780a(Listing.copy$default(listing, list, null, null, null, 14, null), Integer.valueOf(obj));
    }
}
