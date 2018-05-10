package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&J3\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016R\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/ListingAdapter;", "Model", "", "listing", "", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "getModelPosition", "", "position", "getUnadjustedLinkPosition", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "withUnadjustedLinkPosition", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingAdapter.kt */
public interface ListingAdapter<Model> {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: ListingAdapter.kt */
    public static final class DefaultImpls {
        public static <Model> void m22874a(ListingAdapter<Model> listingAdapter, ViewHolder viewHolder, Function1<? super Integer, Unit> function1) {
            Intrinsics.m26847b(viewHolder, "holder");
            Intrinsics.m26847b(function1, "action");
            listingAdapter = listingAdapter.mo6471d(viewHolder);
            if (listingAdapter != -1) {
                function1.mo6492a(Integer.valueOf(listingAdapter));
            }
        }
    }

    void mo6470a(List<Model> list);

    int mo6471d(ViewHolder viewHolder);

    int mo6472h(int i);

    List<Model> mo6473i();
}
