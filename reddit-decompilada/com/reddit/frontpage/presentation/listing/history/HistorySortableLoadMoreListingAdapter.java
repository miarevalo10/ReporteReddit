package com.reddit.frontpage.presentation.listing.history;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR$\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistorySortableLoadMoreListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/SortableLoadMoreListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingHeaderFooterAdapter;", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "(Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)V", "value", "footer", "getFooter", "()Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "setFooter", "(Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;)V", "header", "getHeader", "()Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;", "setHeader", "(Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;)V", "", "listing", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistorySortableLoadMoreListingAdapter.kt */
public final class HistorySortableLoadMoreListingAdapter implements SortableLoadMoreListingAdapter<HistorySortHeaderPresentationModel, LoadingFooterPresentationModel, Listable> {
    HistorySortHeaderPresentationModel f33929a;
    LoadingFooterPresentationModel f33930b = new LoadingFooterPresentationModel(null, 3);
    List<Listable> f33931c = CollectionsKt__CollectionsKt.m26797c(new Listable[]{this.f33929a, this.f33930b});

    public HistorySortableLoadMoreListingAdapter(ListingViewMode listingViewMode) {
        Intrinsics.m26847b(listingViewMode, "viewMode");
        HistorySortOptions historySortOptions = HistorySortOptions.f20601a;
        this.f33929a = new HistorySortHeaderPresentationModel(HistorySortOptions.m22956a(), listingViewMode);
    }

    public final int mo6471d(ViewHolder viewHolder) {
        Intrinsics.m26847b(viewHolder, "holder");
        return DefaultImpls.m22941a(viewHolder);
    }

    public final int mo6472h(int i) {
        return DefaultImpls.m22940a(i);
    }

    public final List<Listable> mo6473i() {
        return this.f33931c;
    }

    public final void mo6470a(List<Listable> list) {
        Intrinsics.m26847b(list, "value");
        list.add(0, this.f33929a);
        list.add(this.f33930b);
        this.f33931c = list;
    }
}
