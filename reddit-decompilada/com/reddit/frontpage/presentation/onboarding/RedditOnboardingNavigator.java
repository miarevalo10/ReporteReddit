package com.reddit.frontpage.presentation.onboarding;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/RedditOnboardingNavigator;", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingNavigator;", "context", "Lkotlin/Lazy;", "Landroid/content/Context;", "(Lkotlin/Lazy;)V", "navigateToLinkDetail", "", "link", "Lcom/reddit/frontpage/domain/model/Link;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "subscriberCount", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingNavigator.kt */
public final class RedditOnboardingNavigator implements OnboardingNavigator {
    private final Lazy<Context> f28721a;

    @Inject
    public RedditOnboardingNavigator(Lazy<? extends Context> lazy) {
        Intrinsics.m26847b(lazy, "context");
        this.f28721a = lazy;
    }

    public final void mo4920a(Link link, SubredditCategory subredditCategory, String str) {
        Intrinsics.m26847b(link, "link");
        Intrinsics.m26847b(subredditCategory, "category");
        Intrinsics.m26847b(str, "subscriberCount");
        Screen a = Routing.m22617a((Context) this.f28721a.mo5678b());
        link = Nav.m22542a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) new ClientLink(link), "onboarding");
        link.t_().putBoolean("com.reddit.arg.fromOnboarding", true);
        link.t_().putParcelable("com.reddit.arg.subredditCategory", subredditCategory);
        link.t_().putString("com.reddit.arg.subscriberCount", str);
        Routing.m22627b(a, link);
    }
}
