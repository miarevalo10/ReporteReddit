package com.reddit.frontpage.presentation.onboarding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapter;", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
final class OnboardingScreen$tabAdapter$2 extends Lambda implements Function0<TabAdapter> {
    final /* synthetic */ OnboardingScreen f37014a;

    OnboardingScreen$tabAdapter$2(OnboardingScreen onboardingScreen) {
        this.f37014a = onboardingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        TabAdapter tabAdapter = new TabAdapter(this.f37014a);
        tabAdapter.a(true);
        return tabAdapter;
    }
}
