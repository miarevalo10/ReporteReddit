package com.reddit.frontpage.presentation.onboarding;

import com.reddit.frontpage.presentation.onboarding.OnboardingContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingPresenter.kt */
final class OnboardingPresenter$attach$1<T> implements Consumer<Integer> {
    final /* synthetic */ OnboardingPresenter f28706a;

    OnboardingPresenter$attach$1(OnboardingPresenter onboardingPresenter) {
        this.f28706a = onboardingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Integer) obj;
        OnboardingPresenter.m34815a(this.f28706a);
        this.f28706a.f34099b = Intrinsics.m26838a(obj.intValue(), 3) >= 0;
        if (this.f28706a.f34099b) {
            this.f28706a.f34100c.mo7415c();
            return;
        }
        View c = this.f28706a.f34100c;
        Intrinsics.m26843a(obj, "it");
        c.mo7410a(obj.intValue());
    }
}
