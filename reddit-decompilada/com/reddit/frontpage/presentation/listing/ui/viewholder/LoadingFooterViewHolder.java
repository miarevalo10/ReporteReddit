package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.widgets.ListingFooterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LoadingFooterViewHolder;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "footerView", "Lcom/reddit/frontpage/widgets/ListingFooterView;", "(Lcom/reddit/frontpage/widgets/ListingFooterView;)V", "bind", "", "model", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "getCategory", "", "setOnErrorClickListener", "listener", "Landroid/view/View$OnClickListener;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadingFooterViewHolder.kt */
public final class LoadingFooterViewHolder extends ListingViewHolder {
    public static final Companion f34052b = new Companion();
    public final ListingFooterView f34053a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LoadingFooterViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LoadingFooterViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LoadingFooterViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LoadingFooterViewHolder m23058a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new LoadingFooterViewHolder(new ListingFooterView(viewGroup.getContext()));
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20846a;

        static {
            int[] iArr = new int[FooterState.values().length];
            f20846a = iArr;
            iArr[FooterState.LOADING.ordinal()] = 1;
            f20846a[FooterState.NONE.ordinal()] = 2;
            f20846a[FooterState.ERROR.ordinal()] = 3;
        }
    }

    public static final LoadingFooterViewHolder m34786a(ViewGroup viewGroup) {
        return Companion.m23058a(viewGroup);
    }

    public final int mo6480Q() {
        return 6;
    }

    private LoadingFooterViewHolder(ListingFooterView listingFooterView) {
        super(listingFooterView);
        this.f34053a = listingFooterView;
    }

    public final void m34788a(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        this.f34053a.setErrorOnClickListener(onClickListener);
    }
}
