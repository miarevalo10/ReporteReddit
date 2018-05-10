package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/SortHeaderViewHolder;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "itemView", "Landroid/view/View;", "viewHolderType", "", "(Landroid/view/View;I)V", "getViewHolderType", "()I", "bind", "", "model", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "getCategory", "setGeopopularOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnSortClickListener", "sortClickListener", "setOnViewModeClickListener", "viewModeClickListener", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SortHeaderViewHolder.kt */
public final class SortHeaderViewHolder extends ListingViewHolder {
    public static final Companion f34054a = new Companion();
    private final int f34055b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/SortHeaderViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/SortHeaderViewHolder;", "parent", "Landroid/view/ViewGroup;", "type", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SortHeaderViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static SortHeaderViewHolder m23064a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new SortHeaderViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.widget_sort_bar, false), i);
        }
    }

    public static final SortHeaderViewHolder m34789a(ViewGroup viewGroup, int i) {
        return Companion.m23064a(viewGroup, i);
    }

    private SortHeaderViewHolder(View view, int i) {
        super(view);
        this.f34055b = i;
    }

    public final void m34791a(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "sortClickListener");
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        ((ListingFilterBarView) obj.findViewById(C1761R.id.listing_filter_bar)).setOnSortClickListener(onClickListener);
    }

    public final void m34792b(OnClickListener onClickListener) {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        ((ListingFilterBarView) obj.findViewById(C1761R.id.listing_filter_bar)).setOnViewModeClickListener(onClickListener);
    }

    public final int mo6480Q() {
        return this.f34055b;
    }
}
