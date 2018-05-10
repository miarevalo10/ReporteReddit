package com.reddit.frontpage.presentation.onboarding;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
final class OnboardingScreen$onCreateView$4 implements OnClickListener {
    final /* synthetic */ OnboardingScreen f20943a;

    OnboardingScreen$onCreateView$4(OnboardingScreen onboardingScreen) {
        this.f20943a = onboardingScreen;
    }

    public final void onClick(View view) {
        Noun noun;
        view = this.f20943a.m40889w();
        view.f34100c.mo7418i();
        if (view.f34099b) {
            noun = Noun.DONE;
        } else {
            noun = Noun.SKIP;
        }
        view.m34823b().m28956a(Action.CLICK).m28957a(noun).m21891a();
    }
}
