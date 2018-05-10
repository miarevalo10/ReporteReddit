package com.reddit.frontpage.presentation.onboarding.listing;

import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$onCreateView$listener$1", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "(Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen;)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingListingScreen.kt */
public final class OnboardingListingScreen$onCreateView$listener$1 implements OnChildAttachStateChangeListener {
    final /* synthetic */ OnboardingListingScreen f28731a;

    public final void m29842b(View view) {
        Intrinsics.m26847b(view, "view");
    }

    OnboardingListingScreen$onCreateView$listener$1(OnboardingListingScreen onboardingListingScreen) {
        this.f28731a = onboardingListingScreen;
    }

    public final void m29841a(View view) {
        Intrinsics.m26847b(view, "view");
        view = this.f28731a.af().getChildViewHolder(view);
        if (view instanceof LinkViewHolder) {
            view = this.f28731a.m42129P().mo6471d(view);
            if (this.f28731a.f40595M) {
                this.f28731a.mo7641w().m34845h(view);
                return;
            }
            this.f28731a.f40596N.add(Integer.valueOf(view));
        }
    }
}
