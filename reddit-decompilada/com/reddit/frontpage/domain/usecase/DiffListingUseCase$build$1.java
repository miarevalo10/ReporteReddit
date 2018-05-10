package com.reddit.frontpage.domain.usecase;

import android.support.v7.util.DiffUtil;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import com.reddit.frontpage.presentation.listing.model.LinkMapper;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/usecase/DiffListingResult;", "listing", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiffListingUseCase.kt */
final class DiffListingUseCase$build$1<T, R> implements Function<T, R> {
    final /* synthetic */ DiffListingUseCaseParams f27976a;

    DiffListingUseCase$build$1(DiffListingUseCaseParams diffListingUseCaseParams) {
        this.f27976a = diffListingUseCaseParams;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Listing listing = (Listing) obj;
        Intrinsics.m26847b(listing, "listing");
        Iterable<Listable> iterable = this.f27976a.f27978a;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        int i2 = 0;
        for (Listable a : iterable) {
            int i3 = i2 + 1;
            arrayList.add(TuplesKt.m26780a(Integer.valueOf(i2), a));
            i2 = i3;
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            if ((!(((Pair) next).f25268b instanceof LinkPresentationModel) ? 1 : 0) != 0) {
                arrayList2.add(next);
            }
        }
        Map a2 = MapsKt__MapsKt.m36117a((Iterable) (List) arrayList2);
        LinkMapper linkMapper = LinkMapper.f20611a;
        List c = CollectionsKt___CollectionsKt.m41428c(LinkMapper.m22970a(listing.getChildren()));
        for (Entry entry : a2.entrySet()) {
            if (((Number) entry.getKey()).intValue() < c.size()) {
                c.add(((Number) entry.getKey()).intValue(), entry.getValue());
            }
        }
        Object a3 = DiffUtil.a(new DiffListingUseCase$build$1$result$1(this, c));
        Iterable<Link> children = listing.getChildren();
        Collection arrayList3 = new ArrayList(CollectionsKt__IterablesKt.m32812b(children));
        for (Link uniqueId : children) {
            int i4 = i + 1;
            arrayList3.add(TuplesKt.m26780a(uniqueId.getUniqueId(), Integer.valueOf(i)));
            i = i4;
        }
        Map a4 = MapsKt__MapsKt.m36117a((Iterable) (List) arrayList3);
        List children2 = listing.getChildren();
        String after = listing.getAfter();
        String adDistance = listing.getAdDistance();
        Intrinsics.m26843a(a3, "result");
        return new DiffListingResult(children2, c, a4, after, adDistance, new ViewDiffResult(a3));
    }
}
