package com.reddit.frontpage.presentation.onboarding.listing;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingListingPresenter.kt */
final class OnboardingListingPresenter$loadLinks$3<T> implements Consumer<Throwable> {
    final /* synthetic */ OnboardingListingPresenter f28725a;
    final /* synthetic */ Function0 f28726b;

    OnboardingListingPresenter$loadLinks$3(OnboardingListingPresenter onboardingListingPresenter, Function0 function0) {
        this.f28725a = onboardingListingPresenter;
        this.f28726b = function0;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        this.f28726b.invoke();
        StringBuilder stringBuilder = new StringBuilder("Failed to load links. Category ");
        stringBuilder.append(this.f28725a.f34119b.f27972a.getId());
        Timber.c(th, stringBuilder.toString(), new Object[0]);
        OnboardingListingPresenter.m34835d(this.f28725a);
    }
}
