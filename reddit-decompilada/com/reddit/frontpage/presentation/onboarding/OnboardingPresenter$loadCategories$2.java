package com.reddit.frontpage.presentation.onboarding;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingPresenter.kt */
final class OnboardingPresenter$loadCategories$2<T> implements Consumer<Throwable> {
    final /* synthetic */ OnboardingPresenter f28708a;

    OnboardingPresenter$loadCategories$2(OnboardingPresenter onboardingPresenter) {
        this.f28708a = onboardingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.c((Throwable) obj, "Failed to load onboarding subreddit categories", new Object[0]);
        this.f28708a.f34100c.mo7416d();
    }
}
