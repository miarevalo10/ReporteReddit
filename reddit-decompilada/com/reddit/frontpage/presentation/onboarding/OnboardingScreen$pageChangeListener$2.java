package com.reddit.frontpage.presentation.onboarding;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/reddit/frontpage/presentation/onboarding/OnboardingScreen$pageChangeListener$2$1", "invoke", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$pageChangeListener$2$1;"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
final class OnboardingScreen$pageChangeListener$2 extends Lambda implements Function0<C26791> {
    final /* synthetic */ OnboardingScreen f37007a;

    OnboardingScreen$pageChangeListener$2(OnboardingScreen onboardingScreen) {
        this.f37007a = onboardingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new SimpleOnPageChangeListener() {
            public final void m34825b(int i) {
                this.f37007a.m40848S().smoothScrollToPosition(i);
            }
        };
    }
}
