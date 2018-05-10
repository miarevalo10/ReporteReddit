package com.reddit.frontpage.presentation.onboarding;

import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingPresenter.kt */
final class OnboardingPresenter$loadSubredditsInCategory$2<T> implements Consumer<Throwable> {
    final /* synthetic */ OnboardingPresenter f28711a;
    final /* synthetic */ SubredditCategory f28712b;

    OnboardingPresenter$loadSubredditsInCategory$2(OnboardingPresenter onboardingPresenter, SubredditCategory subredditCategory) {
        this.f28711a = onboardingPresenter;
        this.f28712b = subredditCategory;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        StringBuilder stringBuilder = new StringBuilder("Failed to load subreddits for category: ");
        stringBuilder.append(this.f28712b.getId());
        Timber.c(th, stringBuilder.toString(), new Object[0]);
        this.f28711a.f34100c.mo7411a(this.f28712b);
        this.f28711a.f34100c.mo7417e();
    }
}
