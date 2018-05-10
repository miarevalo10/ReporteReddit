package com.reddit.frontpage.presentation.onboarding;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/reddit/frontpage/presentation/onboarding/OnboardingScreen$setCategories$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;I)V", "onGlobalLayout", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
public final class OnboardingScreen$setCategories$1 implements OnGlobalLayoutListener {
    final /* synthetic */ OnboardingScreen f20946a;
    final /* synthetic */ int f20947b;

    OnboardingScreen$setCategories$1(OnboardingScreen onboardingScreen, int i) {
        this.f20946a = onboardingScreen;
        this.f20947b = i;
    }

    public final void onGlobalLayout() {
        this.f20946a.m40848S().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f20946a.m40848S().scrollToPosition(this.f20947b);
        this.f20946a.ae();
    }
}
