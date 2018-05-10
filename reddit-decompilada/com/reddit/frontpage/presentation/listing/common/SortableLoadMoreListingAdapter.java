package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0018*\b\b\u0000\u0010\u0001*\u0002H\u0002*\b\b\u0001\u0010\u0003*\u0002H\u0002*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u0018J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0018\u0010\u0005\u001a\u00028\u0001X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/SortableLoadMoreListingAdapter;", "Header", "Model", "Footer", "Lcom/reddit/frontpage/presentation/listing/common/ListingAdapter;", "footer", "getFooter", "()Ljava/lang/Object;", "setFooter", "(Ljava/lang/Object;)V", "footerIndex", "", "getFooterIndex", "()I", "header", "getHeader", "setHeader", "listingItemCount", "getListingItemCount", "getModelPosition", "position", "getUnadjustedLinkPosition", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SortableLoadMoreListingAdapter.kt */
public interface SortableLoadMoreListingAdapter<Header extends Model, Footer extends Model, Model> extends ListingAdapter<Model> {
    public static final Companion f28375d = Companion.f20592a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/SortableLoadMoreListingAdapter$Companion;", "", "()V", "FOOTER_COUNT", "", "HEADERS_COUNT", "HEADER_INDEX", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SortableLoadMoreListingAdapter.kt */
    public static final class Companion {
        static final /* synthetic */ Companion f20592a = new Companion();

        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: SortableLoadMoreListingAdapter.kt */
    public static final class DefaultImpls {
        public static <Header extends Model, Footer extends Model, Model> int m22940a(int i) {
            return i + 1;
        }

        public static <Header extends Model, Footer extends Model, Model> void m22943a(SortableLoadMoreListingAdapter<Header, Footer, Model> sortableLoadMoreListingAdapter, ViewHolder viewHolder, Function1<? super Integer, Unit> function1) {
            Intrinsics.m26847b(viewHolder, "holder");
            Intrinsics.m26847b(function1, "action");
            com.reddit.frontpage.presentation.listing.common.ListingAdapter.DefaultImpls.m22874a(sortableLoadMoreListingAdapter, viewHolder, function1);
        }

        public static <Header extends Model, Footer extends Model, Model> int m22942a(SortableLoadMoreListingAdapter<Header, Footer, Model> sortableLoadMoreListingAdapter) {
            return CollectionsKt__CollectionsKt.m26787a((List) sortableLoadMoreListingAdapter.mo6473i());
        }

        public static <Header extends Model, Footer extends Model, Model> int m22944b(SortableLoadMoreListingAdapter<Header, Footer, Model> sortableLoadMoreListingAdapter) {
            return (sortableLoadMoreListingAdapter.mo6473i().size() - 1) - 1;
        }

        public static <Header extends Model, Footer extends Model, Model> int m22941a(ViewHolder viewHolder) {
            Intrinsics.m26847b(viewHolder, "holder");
            viewHolder = viewHolder.d();
            return viewHolder == -1 ? viewHolder : viewHolder - 1;
        }
    }
}
