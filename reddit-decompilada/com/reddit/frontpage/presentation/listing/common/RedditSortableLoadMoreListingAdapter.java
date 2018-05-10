package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.model.SortHeaderPresentationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditSortableLoadMoreListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/SortableLoadMoreListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/common/ListableListingHeaderFooterAdapter;", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "geopopularText", "", "(Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;Ljava/lang/String;)V", "value", "footer", "getFooter", "()Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "setFooter", "(Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;)V", "header", "getHeader", "()Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "setHeader", "(Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;)V", "", "listing", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SortableLoadMoreListingAdapter.kt */
public final class RedditSortableLoadMoreListingAdapter implements SortableLoadMoreListingAdapter<SortHeaderPresentationModel, LoadingFooterPresentationModel, Listable> {
    public SortHeaderPresentationModel f33896a;
    public LoadingFooterPresentationModel f33897b;
    public List<Listable> f33898c;

    public RedditSortableLoadMoreListingAdapter(ListingViewMode listingViewMode, String str) {
        Intrinsics.m26847b(listingViewMode, "viewMode");
        this.f33896a = new SortHeaderPresentationModel(SortType.c, SortTimeFrame.c, listingViewMode, str);
        this.f33897b = new LoadingFooterPresentationModel((FooterState) null, 3);
        this.f33898c = CollectionsKt__CollectionsKt.m26797c(new Listable[]{(Listable) this.f33896a, (Listable) this.f33897b});
    }

    public final void m34715a(ViewHolder viewHolder, Function1<? super Integer, Unit> function1) {
        Intrinsics.m26847b(viewHolder, "holder");
        Intrinsics.m26847b(function1, "action");
        DefaultImpls.m22943a(this, viewHolder, function1);
    }

    public final int mo6471d(ViewHolder viewHolder) {
        Intrinsics.m26847b(viewHolder, "holder");
        return DefaultImpls.m22941a(viewHolder);
    }

    public final int mo6472h(int i) {
        return DefaultImpls.m22940a(i);
    }

    public final List<Listable> mo6473i() {
        return this.f33898c;
    }

    public final void m34717a(SortHeaderPresentationModel sortHeaderPresentationModel) {
        Intrinsics.m26847b(sortHeaderPresentationModel, "value");
        this.f33898c.set(0, sortHeaderPresentationModel);
        this.f33896a = sortHeaderPresentationModel;
    }

    public final void m34716a(LoadingFooterPresentationModel loadingFooterPresentationModel) {
        Intrinsics.m26847b(loadingFooterPresentationModel, "value");
        this.f33898c.set(DefaultImpls.m22942a((SortableLoadMoreListingAdapter) this), loadingFooterPresentationModel);
        this.f33897b = loadingFooterPresentationModel;
    }

    public final void mo6470a(List<Listable> list) {
        Intrinsics.m26847b(list, "value");
        list.add(0, this.f33896a);
        list.add(this.f33897b);
        this.f33898c = list;
    }
}
