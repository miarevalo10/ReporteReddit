package com.reddit.frontpage.presentation.onboarding;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.util.SubredditUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
final class OnboardingScreen$onCreateView$6 implements OnClickListener {
    final /* synthetic */ OnboardingScreen f20945a;

    OnboardingScreen$onCreateView$6(OnboardingScreen onboardingScreen) {
        this.f20945a = onboardingScreen;
    }

    public final void onClick(View view) {
        view = this.f20945a.m40889w();
        view.f34100c.W_();
        for (Subreddit subreddit : view.f34098a) {
            Object b = SessionManager.b();
            Intrinsics.m26843a(b, "SessionManager.getInstance()");
            b.c();
            SubredditUtil.m23927b(subreddit, PageType.RECOMMENDATIONS.value);
        }
        view.f34100c.V_();
        view.m34821a().m28956a(Action.DESELECT).m21891a();
    }
}
