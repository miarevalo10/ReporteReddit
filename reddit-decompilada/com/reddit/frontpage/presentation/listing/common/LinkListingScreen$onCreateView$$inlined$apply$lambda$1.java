package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/reddit/frontpage/presentation/listing/common/LinkListingScreen$onCreateView$2$2", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "(Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen$onCreateView$2;Landroid/support/v7/widget/RecyclerView;)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkListingScreen.kt */
public final class LinkListingScreen$onCreateView$$inlined$apply$lambda$1 implements OnChildAttachStateChangeListener {
    final /* synthetic */ RecyclerView f28267a;
    final /* synthetic */ LinkListingScreen f28268b;

    LinkListingScreen$onCreateView$$inlined$apply$lambda$1(RecyclerView recyclerView, LinkListingScreen linkListingScreen) {
        this.f28267a = recyclerView;
        this.f28268b = linkListingScreen;
    }

    public final void m29556b(View view) {
        Intrinsics.m26847b(view, "view");
        view = this.f28268b.af().getChildViewHolder(view);
        if (view instanceof VisibilityDependent) {
            ((VisibilityDependent) view).aq();
        }
    }

    public final void m29555a(View view) {
        Intrinsics.m26847b(view, "view");
        LinkListingScreen.m40618a(this.f28267a, view);
    }
}
