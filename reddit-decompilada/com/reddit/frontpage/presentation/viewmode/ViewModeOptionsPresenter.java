package com.reddit.frontpage.presentation.viewmode;

import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsContract.View;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsPresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsContract$View;", "(Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsContract$View;)V", "attach", "", "detach", "onCardOptionSelected", "onCompactOptionSelected", "onGalleryOptionSelected", "updateViewMode", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ViewModeOptionsPresenter.kt */
public final class ViewModeOptionsPresenter implements BasePresenter {
    final View f28833a;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20999a;

        static {
            int[] iArr = new int[ListingViewMode.values().length];
            f20999a = iArr;
            iArr[ListingViewMode.f20612a.ordinal()] = 1;
            f20999a[ListingViewMode.f20613b.ordinal()] = 2;
            f20999a[ListingViewMode.f20614c.ordinal()] = 3;
        }
    }

    public final void destroy() {
    }

    public final void detach() {
    }

    @Inject
    public ViewModeOptionsPresenter(View view) {
        Intrinsics.m26847b(view, "view");
        this.f28833a = view;
    }

    public final void attach() {
        this.f28833a.mo7196e();
        switch (WhenMappings.f20999a[this.f28833a.mo7192a().ordinal()]) {
            case 1:
                this.f28833a.mo7176b();
                return;
            case 2:
                this.f28833a.mo7194c();
                return;
            case 3:
                this.f28833a.mo7195d();
                break;
            default:
                break;
        }
    }

    final void m29904a(ListingViewMode listingViewMode) {
        this.f28833a.mo7193a(listingViewMode);
    }
}
