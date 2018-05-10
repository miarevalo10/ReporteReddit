package com.reddit.frontpage.presentation.onboarding.listing;

import android.view.View;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen.OnboardingListingAdapter;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingListingScreen.kt */
final class OnboardingListingScreen$OnboardingListingAdapter$configure$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ OnboardingListingAdapter f37024a;
    final /* synthetic */ LinkViewHolder f37025b;

    OnboardingListingScreen$OnboardingListingAdapter$configure$1(OnboardingListingAdapter onboardingListingAdapter, LinkViewHolder linkViewHolder) {
        this.f37024a = onboardingListingAdapter;
        this.f37025b = linkViewHolder;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        this.f37025b.mo6969w();
        this.f37024a.f34142b.m40627a(null);
        this.f37024a.f34142b.mo7641w().mo6483a(this.f37024a.mo6471d(this.f37025b));
        if ((this.f37025b instanceof VisibilityDependent) != null) {
            ((VisibilityDependent) this.f37025b).aq();
        }
        return Unit.f25273a;
    }
}
