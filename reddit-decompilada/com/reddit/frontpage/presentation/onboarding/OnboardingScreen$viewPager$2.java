package com.reddit.frontpage.presentation.onboarding;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/support/v4/view/ViewPager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
final class OnboardingScreen$viewPager$2 extends Lambda implements Function0<ViewPager> {
    final /* synthetic */ OnboardingScreen f37018a;

    OnboardingScreen$viewPager$2(OnboardingScreen onboardingScreen) {
        this.f37018a = onboardingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View e = this.f37018a.K;
        if (e == null) {
            Intrinsics.m26842a();
        }
        return (ViewPager) e.findViewById(C1761R.id.content_pager);
    }
}
