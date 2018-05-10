package com.reddit.frontpage.presentation.onboarding.listing;

import android.content.Context;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen.OnboardingListingAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$OnboardingListingAdapter;", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingListingScreen.kt */
final class OnboardingListingScreen$adapter$2 extends Lambda implements Function0<OnboardingListingAdapter> {
    final /* synthetic */ OnboardingListingScreen f37032a;

    OnboardingListingScreen$adapter$2(OnboardingListingScreen onboardingListingScreen) {
        this.f37032a = onboardingListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        OnboardingListingScreen onboardingListingScreen = this.f37032a;
        Object am_ = this.f37032a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        OnboardingListingAdapter onboardingListingAdapter = new OnboardingListingAdapter(onboardingListingScreen, (Context) am_);
        onboardingListingAdapter.a(true);
        return onboardingListingAdapter;
    }
}
