package com.reddit.frontpage.presentation.onboarding;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.onboarding.OnboardingContract.Presenter;
import com.reddit.frontpage.presentation.onboarding.OnboardingContract.View;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u0017H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$View;", "categoryRepository", "Lcom/reddit/frontpage/domain/repository/CategoryRepository;", "subscriptionCountRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/SubscriptionCountRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$View;Lcom/reddit/frontpage/domain/repository/CategoryRepository;Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/SubscriptionCountRepository;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/common/rx/PostExecutionThread;)V", "categories", "", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "minSubscriptionCountReached", "", "selectedCategory", "subreddits", "Lcom/reddit/frontpage/domain/model/Subreddit;", "attach", "", "isSubscribedToAllSubreddits", "loadCategories", "loadSubredditsInCategory", "category", "newAnalyticsEventBuilder", "Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder;", "onCategorySelected", "onDoneButtonClick", "onSubscribeAllClick", "onUnsubscribeAllClick", "subscribeAllEventBuilder", "updateSubscribeButton", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingPresenter.kt */
public final class OnboardingPresenter extends DisposablePresenter implements Presenter {
    List<Subreddit> f34098a = CollectionsKt__CollectionsKt.m26790a();
    boolean f34099b;
    final View f34100c;
    private List<SubredditCategory> f34101d = CollectionsKt__CollectionsKt.m26790a();
    private SubredditCategory f34102e;
    private final CategoryRepository f34103f;
    private final SubscriptionCountRepository f34104g;
    private final BackgroundThread f34105h;
    private final PostExecutionThread f34106i;

    @Inject
    public OnboardingPresenter(View view, CategoryRepository categoryRepository, SubscriptionCountRepository subscriptionCountRepository, BackgroundThread backgroundThread, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(categoryRepository, "categoryRepository");
        Intrinsics.m26847b(subscriptionCountRepository, "subscriptionCountRepository");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f34100c = view;
        this.f34103f = categoryRepository;
        this.f34104g = subscriptionCountRepository;
        this.f34105h = backgroundThread;
        this.f34106i = postExecutionThread;
    }

    public final void m34822a(SubredditCategory subredditCategory) {
        Intrinsics.m26847b(subredditCategory, "category");
        this.f34102e = subredditCategory;
        this.f34098a = CollectionsKt__CollectionsKt.m26790a();
        this.f34100c.W_();
        Object subscribe = SinglesKt.m24094b(this.f34103f.m22405a(subredditCategory), this.f34106i).subscribe(new OnboardingPresenter$loadSubredditsInCategory$1(this, subredditCategory), new OnboardingPresenter$loadSubredditsInCategory$2(this, subredditCategory));
        Intrinsics.m26843a(subscribe, "categoryRepository.getSu…SubscribeAll()\n        })");
        handleDispose(subscribe);
    }

    public final void attach() {
        Object subscribe;
        if (this.f34101d.isEmpty()) {
            this.f34100c.mo7409a();
            subscribe = SinglesKt.m24094b(this.f34103f.m22404a(), this.f34106i).subscribe(new OnboardingPresenter$loadCategories$1(this), new OnboardingPresenter$loadCategories$2(this));
            Intrinsics.m26843a(subscribe, "categoryRepository.getCa…oryLoadError()\n        })");
            handleDispose(subscribe);
        } else {
            this.f34100c.mo7413a(this.f34101d);
        }
        subscribe = ObservablesKt.m24092b(ObservablesKt.m24090a(this.f34104g.a(), (Thread) this.f34105h), this.f34106i).subscribe((Consumer) new OnboardingPresenter$attach$1(this));
        Intrinsics.m26843a(subscribe, "subscriptionCountReposit…NT)\n          }\n        }");
        handleDispose(subscribe);
    }

    final OnboardingEventBuilder m34821a() {
        return m34823b().m28959a(Source.ONBOARDING).m28957a(Noun.SUBSCRIBE_TO_ALL);
    }

    public final OnboardingEventBuilder m34823b() {
        return new OnboardingEventBuilder().m28958a(PageType.RECOMMENDATIONS).m28959a(Source.ONBOARDING).m28960a(this.f34102e);
    }

    public static final /* synthetic */ void m34815a(OnboardingPresenter onboardingPresenter) {
        Object obj;
        Iterable<Subreddit> iterable = onboardingPresenter.f34098a;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (Subreddit displayName : iterable) {
                if (!SubredditUtil.m23933d(displayName.getDisplayName())) {
                    obj = null;
                    break;
                }
            }
        }
        obj = 1;
        if (obj != null) {
            onboardingPresenter.f34100c.X_();
        } else {
            onboardingPresenter.f34100c.V_();
        }
    }
}
