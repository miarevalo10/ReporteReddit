package com.reddit.frontpage.presentation.postoption;

import android.content.Context;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/postoption/RedditPostOptionsNavigator;", "Lcom/reddit/frontpage/presentation/postoption/PostOptionsNavigator;", "context", "Lkotlin/Lazy;", "Landroid/content/Context;", "(Lkotlin/Lazy;)V", "navigateToImageSubmit", "", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "navigateToLinkSubmit", "navigateToTextSubmit", "navigateToVideoSubmit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PostOptionsNavigator.kt */
public final class RedditPostOptionsNavigator implements PostOptionsNavigator {
    private final Lazy<Context> f28736a;

    @Inject
    public RedditPostOptionsNavigator(Lazy<? extends Context> lazy) {
        Intrinsics.m26847b(lazy, "context");
        this.f28736a = lazy;
    }

    public final void mo4921a(Subreddit subreddit) {
        Routing.m22619a((Context) this.f28736a.mo5678b(), Nav.m22578e(subreddit));
    }

    public final void mo4922b(Subreddit subreddit) {
        Routing.m22619a((Context) this.f28736a.mo5678b(), Nav.m22539a(0, subreddit));
    }

    public final void mo4923c(Subreddit subreddit) {
        Routing.m22619a((Context) this.f28736a.mo5678b(), Nav.m22539a(2, subreddit));
    }

    public final void mo4924d(Subreddit subreddit) {
        Routing.m22619a((Context) this.f28736a.mo5678b(), Nav.m22574d(subreddit));
    }
}
